package dao;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Piloto;

public class DAOPiloto {

	public void altaPiloto(Piloto x) {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		DAOPersistencia.getEntityManager().persist(x);
		et.commit();
		System.out.println("Piloto creado con id: " + x.getIdpiloto());
	}

	public void bajaPiloto(Piloto x) {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		DAOPersistencia.getEntityManager().remove(x);
		et.commit();
		System.out.println("Piloto eliminado con id: " + x.getIdpiloto());
	}

	public void modifPiloto(Piloto x) {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		DAOPersistencia.getEntityManager().merge(x);// con este metodo, modificamos el objeto
		et.commit();
		System.out.println("Piloto modificado con id: " + x.getIdpiloto());
	}

	public void borrarTodosLosPilotos() {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		Query query = DAOPersistencia.getEntityManager().createQuery("delete from Piloto");
		query.executeUpdate();
		et.commit();
	}

	public List<Piloto> consularTodosLosPilotos() {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		TypedQuery<Piloto> query = DAOPersistencia.getEntityManager().createNamedQuery("Piloto.findAll", Piloto.class);
		List<Piloto> lista = query.getResultList();
		et.commit();
		return lista;
	}

}
