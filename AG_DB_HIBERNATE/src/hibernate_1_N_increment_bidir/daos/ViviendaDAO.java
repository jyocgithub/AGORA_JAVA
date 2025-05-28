package hibernate_1_N_increment_bidir.daos;

import hibernate_1_N_increment_bidir.pojos.Vivienda;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class ViviendaDAO {
	SessionFactory factory;

	public ViviendaDAO() {
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}





	// ALTA Vivienda
	public boolean anadirVivienda(Vivienda per) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean exito = true;
		try {
			tx = session.beginTransaction();
			session.save(per);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			exito = false;
		} finally {
			session.close();
		}
		return exito;
	}

	// BORRAR Vivienda
	public boolean borrarVivienda(int id) {
		boolean sepudoborrar = false;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Vivienda objetoencontrado = session.get(Vivienda.class, id);
			if (objetoencontrado != null) {
				session.delete(objetoencontrado);
				tx.commit();
				sepudoborrar = true;
			}
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
		} finally {
			session.close();
		}
		return sepudoborrar;
	}

	// LISTADO DE Viviendas
	public ArrayList<Vivienda> listarViviendas() {
		ArrayList<Vivienda> lista = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM VIVIENDA" );
			lista = (ArrayList<Vivienda>) query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lista;
	}

	// RECUPERAR UNA Vivienda
	public Vivienda consultarVivienda(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Vivienda objetoencontrado = session.get(Vivienda.class, id);
			tx.commit();
			return objetoencontrado;
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	// ACTUALIZAR UNA Vivienda
	public boolean actualizarVivienda(Vivienda nuevo) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean exito = true;
		try {
			tx = session.beginTransaction();
			session.update(nuevo);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			exito = false;
		} finally {
			session.close();
		}
		return exito;
	}

	// BORRA UNA TABLA
	public int borrarTodo(String tabladestino) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE FROM " + tabladestino;
			Query query = session.createQuery(hql);
			int num = query.executeUpdate();
			tx.commit();
			return num;
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return -1;
	}
	
	
	
}
