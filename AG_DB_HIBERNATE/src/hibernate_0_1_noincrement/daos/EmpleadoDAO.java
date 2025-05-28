package hibernate_0_1_noincrement.daos;

import hibernate_0_1_noincrement.pojos.Empleado;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;

public class EmpleadoDAO {
	SessionFactory factory;

	public EmpleadoDAO() {
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	// ALTA EMPLEADO
	public boolean anadirEmpleado(Empleado emp) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean exito = true;
		try {
			tx = session.beginTransaction();
			session.save(emp);
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

	// BORRAR EMPLEADO
	public boolean borrarEmpleado(int id) {
		boolean sepudoborrar = false;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Empleado emp_encontrado = session.get(Empleado.class, id);
			if (emp_encontrado != null) {
				session.delete(emp_encontrado);
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

	// LISTADO DE EMPLEADOS
	public ArrayList<Empleado> listarEmpleados() {
		ArrayList<Empleado> listaempleados = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("FROM Empleado where id > :idminimo");
			query.setParameter("idminimo", 100);
			listaempleados = (ArrayList<Empleado>) query.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return listaempleados;
	}

	// RECUPERAR UN EMPLEADO
	public Empleado consultarEmpleado(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		Empleado resultado = null;
		try {
			tx = session.beginTransaction();
			resultado = (Empleado) session.load(Empleado.class, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultado;
	}

	// ACTUALIZAR UN EMPLEADO
	public boolean actualizarEmpleado(Empleado nuevo) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean exito = true;
		try {
			tx = session.beginTransaction();
			Empleado antiguo = session.get(Empleado.class, nuevo.getId());
			antiguo.setNombre(nuevo.getNombre());
			antiguo.setApellidos(nuevo.getApellidos());
			session.update(antiguo);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			exito = false;
		} finally {
			session.close();
		}
		return exito;
	}

	// LISTADO DE EMPLEADOS
	public ArrayList<String> listarNombresEmpleados() {
		ArrayList<String> lista = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("Select nombre, apellidos FROM Empleado");
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

}
