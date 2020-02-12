package it.beije.cilacap.tools;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBtools {
	
	public static void insertContatto(Contatto contatto) throws ClassNotFoundException {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CilacapWeb");
		EntityManager entityManager = factory.createEntityManager();
		
		entityManager.getTransaction().begin();
		System.out.println("contatto id : " + contatto.getId());
		entityManager.persist(contatto);
		System.out.println("contatto id : " + contatto.getId());
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}
