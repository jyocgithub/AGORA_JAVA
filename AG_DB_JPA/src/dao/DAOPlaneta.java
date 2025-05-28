package dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Planeta;

public class DAOPlaneta {
//	private EntityManagerFactory emf;
//	private EntityManager em;

//	public DAOPlaneta() {
//		emf = Persistence.createEntityManagerFactory("actividad3parte2");
//		em = emf.createEntityManager();
//	}
//
//	public void close() {
//		em.close();
//		emf.close();
//	}

	public void altaPlaneta(Planeta planeta) {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		DAOPersistencia.getEntityManager().persist(planeta);
		et.commit();
		System.out.println("Planeta creado con id: " + planeta.getIdplaneta());

	}

	public void modifNave(Planeta nave) {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		DAOPersistencia.getEntityManager().merge(nave);// con este metodo, modificamos el objeto
		et.commit();
		System.out.println("Planeta modificado con id: " + nave.getIdplaneta());
	}

	public void borrarTodosLasPlanetas() {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		Query query = DAOPersistencia.getEntityManager().createQuery("delete from Planeta");
		query.executeUpdate();
		et.commit();
	}

	public List<Planeta> consularTodosLasPlanetas() {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		TypedQuery<Planeta> query = DAOPersistencia.getEntityManager().createNamedQuery("Planeta.findAll",
				Planeta.class);
		List<Planeta> lista = query.getResultList();
		et.commit();
		return lista;
	}
}
