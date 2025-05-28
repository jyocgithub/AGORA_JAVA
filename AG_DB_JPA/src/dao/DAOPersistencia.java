package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOPersistencia {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("actividad3parte2");
	private static EntityManager em = emf.createEntityManager();

	public static EntityManager getEntityManager() {
		return em;
	}

	public static void closeEntityManager() {
		em.close();
		emf.close();
	}

}
