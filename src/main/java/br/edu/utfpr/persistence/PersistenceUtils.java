package br.edu.utfpr.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtils {
	
	private static EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("charity_show");
	public static EntityManagerFactory getEntityManagerFactoryInstance() {
		return emfInstance;
	}
	
	private static EntityManager entityManager = emfInstance.createEntityManager();
	public static EntityManager getEntityManager(){
		return entityManager;
	}

	
	public static void startTransaction() {
		entityManager.getTransaction().begin();
	}

	public static void commit() {
		entityManager.getTransaction().commit();
	}

	public static void rollback() {
		entityManager.getTransaction().rollback();
	}

	public static void close() {
		entityManager.close();
	}
	
	public static void save(Object entity) {
		entityManager.persist(entity);
	}
}
