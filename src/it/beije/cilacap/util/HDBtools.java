package it.beije.cilacap.util;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import it.beije.cilacap.web.rubrica.Contatto;


public class HDBtools {
	
	private static Log logger = LogFactory.getLog(HDBtools.class);
	
	public static List<Contatto> getContactFromHDB() {
		
		logger.debug("INIZIO");
		
		//Configuration opener 
		Configuration configuration = new Configuration();
		configuration = configuration.configure("it/beije/cilacap/rubrica/hibernate.cfg3.xml")
				.addAnnotatedClass(Contatto.class); // Specification of the used object
		
		//Session generator 
		SessionFactory factory = configuration.buildSessionFactory();
		System.out.println("Is it open? " + factory.isOpen());
		
		//Session opener
		Session session = factory.openSession();
		
		//Creation of the string with command in HQL dialect
		String hql = "SELECT c FROM Contatto as c";
		
		//Query creation
		Query<Contatto> query = session.createQuery(hql);
		
		return query.list();
		
	}
	
	public static void insertInHDB(List<Contatto> contatti) {
		
		logger.debug("INIZIO");
		
		//Configuration opener 
		Configuration configuration = new Configuration();
		configuration = configuration.configure("it/beije/cilacap/rubrica/hibernate.cfg3.xml")
				.addAnnotatedClass(Contatto.class); // Specification of object used
		
		//Session generator 
		SessionFactory factory = configuration.buildSessionFactory();
		System.out.println("Is it open? " + factory.isOpen());
		
		//Session opener
		Session session = factory.openSession();	
		
		//Transaction opener
		Transaction transaction = session.beginTransaction();
		
		//Example INSERT
		Contatto contatto = new Contatto();
		contatto.setNome("Marco");
		contatto.setCognome("Polo");
		contatto.setEmail("marco@polo.it");
		contatto.setTelefono("34553567");
		session.save(contatto);
		
		//Saving each contact
//		for (Contatto c : contatti) {
//			session.save(c);
//		}
		
		//Confirmation of insertion in DB	
		transaction.commit();
		
		//Session Closer
		session.close();
		System.out.println("Is session open? " + session.isOpen());
		factory.close();
		
		logger.debug("FINE");
		
	}
	
	public static void updateHDB(List<Contatto> contatti) {
		
		logger.debug("INIZIO");
		
		//Configuration opener 
		Configuration configuration = new Configuration();
		configuration = configuration.configure("it/beije/cilacap/rubrica/hibernate.cfg3.xml")
				.addAnnotatedClass(Contatto.class); // Specification of object used
		
		//Session generator 
		SessionFactory factory = configuration.buildSessionFactory();
		System.out.println("Is it open? " + factory.isOpen());
		
		//Session opener
		Session session = factory.openSession();	
		
		//Transaction opener
		Transaction transaction = session.beginTransaction();
		
		//Example UPDATE
		Contatto contatto = session.get(Contatto.class, 3);
		System.out.println(contatto);
		contatto.setTelefono("777777777");
		System.out.println(contatto);
		session.save(contatto);
		
		
		//Confirm of update in DB
		transaction.commit();
		
		//Cancel update in DB
//		transaction.rollback();
		
		//Session close
		session.close();

		System.out.println("Is session open? " + session.isOpen());

		logger.debug("FINE");

	}
	
}
