package dao;

import model.Arma;

import javax.persistence.*;
import java.util.List;
class Coche{
	String marca;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
}
public class DAOArma {
	public void altaArma(Arma x) {
	Coche micoche = new Coche();


		EntityManager em = Persistence.createEntityManagerFactory("Naves").createEntityManager();
		EntityTransaction et = em.getTransaction();


		et.begin();
		em.persist(micoche);
		micoche.setMarca("Opel");
		et.commit();


		et.begin();
		em.merge(micoche);
		micoche.setMarca("Opel");
		et.commit();

		et.begin();
		Coche esteEsOtroCoche = em.merge(micoche);
		esteEsOtroCoche.setMarca("Opel");
		et.commit();














		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		DAOPersistencia.getEntityManager().persist(x);
		et.commit();
		System.out.println("Arma creada con id: " + x.getIdarma());
	}

	public void modifArma(Arma x) {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		DAOPersistencia.getEntityManager().merge(x);
		et.commit();
		System.out.println("Arma modificada con id: " + x.getIdarma());
	}

	public void borrarTodasLasArmas() {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		Query query = DAOPersistencia.getEntityManager().createQuery("delete from Arma");
		query.executeUpdate();
		et.commit();
	}

	public List<Arma> consularTodasLasArmas() {
		EntityTransaction et = DAOPersistencia.getEntityManager().getTransaction();
		et.begin();
		TypedQuery<Arma> query = DAOPersistencia.getEntityManager().createNamedQuery("Arma.findAll", Arma.class);
		List<Arma> lista = query.getResultList();
		et.commit();
		return lista;
	}

}
