package it.beije.cilacap.web.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class MyRubricaCSV_XML_DB_Hibernate {

	@SuppressWarnings("unchecked")
	public static List<Contatto> leggiContatti() { // preleva da DB tutti i contatti. [Hibernate]

		Configuration configuration = DBManager.getHibernateConfigurationRubrica();

		SessionFactory factory = configuration.buildSessionFactory();

		// query HQL
		String hql = "SELECT c FROM Contatto as c";
		// apro una sessione
		Session session = factory.openSession();

		Query<Contatto> query = session.createQuery(hql);
		List<Contatto> listaContatti = query.list();
		return listaContatti;
	}

	public static void readFromDBWriteInCSV() throws Exception {
		List<Contatto> listaContatti = MyRubricaCSV_XML_DB_Hibernate.leggiContatti();
		MyRubricaCSV_XML_General.esportaRubricaInCSV(Utility.choosePath(false), listaContatti);
		System.out.println("### Scrittura In File CSV effettuata con Successo ! ! !");
	}

	public static void readFromDBWriteInXML() throws Exception {
		List<Contatto> listaContatti = MyRubricaCSV_XML_DB_Hibernate.leggiContatti();
		MyRubricaCSV_XML_General.esportaRubricaInXML(Utility.choosePath(true), listaContatti);
		System.out.println("### Scrittura In File XML effettuata con Successo ! ! !");
	}

	public static void writeInDBFromCSV() throws Exception {
		List<Contatto> listaContatti = MyRubricaCSV_XML_General.caricaContattiDaCSV(Utility.choosePath(false));
		// INSERT
		Configuration configuration = DBManager.getHibernateConfigurationRubrica();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		for (Contatto c : listaContatti) {

			session.save(c);
			Transaction transaction = session.beginTransaction();
			transaction.commit();

		}
		session.close(); // chiudo la sessione
		System.out.println("### Scrittura In DB effettuata con Successo ! ! !");

	}

	public static void writeInDBFromXML() throws Exception {
		List<Contatto> listaContatti = MyRubricaCSV_XML_General.caricaContattiDaXML(Utility.choosePath(true));

		Configuration configuration = DBManager.getHibernateConfigurationRubrica();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		for (Contatto c : listaContatti) {

			session.save(c);
			Transaction transaction = session.beginTransaction();
			transaction.commit();

		}
		session.close(); // chiudo la sessione
		System.out.println("### Scrittura In DB effettuata con Successo ! ! !");
	}

}
