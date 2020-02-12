package it.beije.cilacap.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPDBtools {

	public static void insertInJPADB(Contatto contatto) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapWeb");
		EntityManager entityManager = factory.createEntityManager();
		
		System.out.println("is open?" + entityManager.isOpen());
		
		entityManager.getTransaction().begin();
		entityManager.persist(contatto);
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}

}
