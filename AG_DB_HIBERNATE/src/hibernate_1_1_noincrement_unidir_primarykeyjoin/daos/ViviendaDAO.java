package hibernate_1_1_noincrement_unidir_primarykeyjoin.daos;

import hibernate_1_1_noincrement_unidir_primarykeyjoin.pojos.Vivienda;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class ViviendaDAO {
	SessionFactory factory;

	public ViviendaDAO() {
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	// ALTA VIVIENDA
	public boolean anadirVivienda(Vivienda viv) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean exito = true;
		try {
			tx = session.beginTransaction();
			session.save(viv);
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

	// BORRAR VIVIENDA
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

	// LISTADO DE VIVIENDAS
	public ArrayList<Vivienda> listarViviendas() {
		ArrayList<Vivienda> lista = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM VIVIENDA");
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

	// RECUPERAR UNA VIVIENDA
	public Vivienda consultarVivienda(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		//		Vivienda resultado = null;
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

	// ACTUALIZAR UNA VIVIENDA
//	public boolean actualizarVivienda(Vivienda nuevo) {
//		Session session = factory.openSession();
//		Transaction tx = null;
//		boolean exito = true;
//		try {
//			tx = session.beginTransaction();
//			Vivienda antiguo = session.get(Vivienda.class, nuevo.getId_vivienda());
//			antiguo.setTipo(nuevo.getTipo());
//			session.update(antiguo);
//			tx.commit();
//		} catch (HibernateException e) {
//			if (tx != null) tx.rollback();
//			exito = false;
//		} finally {
//			session.close();
//		}
//		return exito;
//	}
	public boolean actualizarVivienda(Vivienda nuevo) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean exito = true;
		try {
			tx = session.beginTransaction();
//			Vivienda antiguo = session.get(Vivienda.class, nuevo.getId_vivienda());
//			antiguo.setTipo(nuevo.getTipo());
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

	// LISTADO DE TIPOS DE VIVIENDA
	public ArrayList<String> listarTiposVivienda() {
		ArrayList<String> lista = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("SELECT TIPO FROM VIVIENDA");
			lista = (ArrayList<String>) query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lista;
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
