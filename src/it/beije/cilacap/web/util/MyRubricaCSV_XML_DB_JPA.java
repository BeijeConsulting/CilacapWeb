package it.beije.cilacap.web.util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import it.beije.cilacap.web.rubrica.Contatto;


public class MyRubricaCSV_XML_DB_JPA {

	@SuppressWarnings("unchecked")
	public static List<Contatto> leggiContatti() { // preleva da DB tutti i contatti. [Hibernate]

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
	
		// esempio query JPQL
		String jpql = "SELECT c FROM Contatto as c";
		Query query = entityManager.createQuery(jpql);
		List<Contatto> listaContatti = query.getResultList();
		System.out.println(listaContatti.size());
		return listaContatti;
	}	
	
	@SuppressWarnings("unchecked")
	public static Contatto leggiContatto(int id) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
	
		// esempio query JPQL
		String jpql = "SELECT c FROM Contatto as c WHERE c.id=:id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		List<Contatto> listaContatti = query.getResultList();
		return listaContatti.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public static int inserisciContatto(Contatto c) {
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(c);
		entityManager.getTransaction().commit();
		String jpql = "SELECT c FROM Contatto as c WHERE c.nome=:nome AND c.cognome=:cognome AND c.telefono=:telefono AND c.email=:email";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("nome", c.getNome());
		query.setParameter("cognome", c.getCognome());
		query.setParameter("telefono", c.getTelefono());
		query.setParameter("email", c.getEmail());
		List<Contatto> listaContatti = query.getResultList();
		int idContatto = listaContatti.get(0).getId();
		entityManager.clear();
		return idContatto;
	}
	
	public static void readFromDBWriteInCSV() throws Exception {
		List<Contatto> listaContatti = MyRubricaCSV_XML_DB_JPA.leggiContatti();
		MyRubricaCSV_XML_General.esportaRubricaInCSV(Utility.choosePath(false), listaContatti);
		System.out.println("### Scrittura In File CSV effettuata con Successo ! ! !");
	}

	public static void readFromDBWriteInXML() throws Exception {
		List<Contatto> listaContatti = MyRubricaCSV_XML_DB_JPA.leggiContatti();
		MyRubricaCSV_XML_General.esportaRubricaInXML(Utility.choosePath(true), listaContatti);
		System.out.println("### Scrittura In File XML effettuata con Successo ! ! !");
	}

	public static void writeInDBFromCSV() throws Exception {
		List<Contatto> listaContatti = MyRubricaCSV_XML_General.caricaContattiDaCSV(Utility.choosePath(false));
		// INSERT
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		
		for (Contatto c : listaContatti) {
			entityManager.persist(c);
		}
		entityManager.getTransaction().commit();
		entityManager.close();

		System.out.println("### Scrittura In DB effettuata con Successo ! ! !");

	}

	public static void writeInDBFromXML() throws Exception {
		List<Contatto> listaContatti = MyRubricaCSV_XML_General.caricaContattiDaXML(Utility.choosePath(true));

		// INSERT
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapUnit");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		
		for (Contatto c : listaContatti) {
			entityManager.persist(c);
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		System.out.println("### Scrittura In DB effettuata con Successo ! ! !");
	}
}
