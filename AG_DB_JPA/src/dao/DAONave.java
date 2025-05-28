package dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Nave;

public class DAONave {
	public void altaNave(Nave x) {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		DAOPersistencia.getEntityManager().persist(x);
		et.commit();
		System.out.println("Nave creada con id: " + x.getIdnave());
	}

	public void modifNave(Nave x) {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		DAOPersistencia.getEntityManager().merge(x);
		et.commit();
		System.out.println("Nave modificada con id: " + x.getIdnave());
	}

	public void borrarTodasLasNaves() {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		Query query = DAOPersistencia.getEntityManager().createQuery("delete from Nave");
		query.executeUpdate();
		et.commit();
	}

	public List<Nave> consularTodasLasNaves() {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		TypedQuery<Nave> query = DAOPersistencia.getEntityManager().createNamedQuery("Nave.findAll", Nave.class);
		List<Nave> lista = query.getResultList();
		et.commit();
		return lista;
	}
}
