package con_criteria;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;
//import org.hibernate.query.Query;


public class GestionDBHibernateCriteria {

	SessionFactory factory;

	public GestionDBHibernateCriteria() {
		factory = new Configuration().configure().buildSessionFactory();
	}

	// LISTADO REGISTROs
	public ArrayList<TPeliculas> listapelis() {
		List listapelis = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(TPeliculas.class);
			listapelis = criteria.list();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {

			session.close();

		}
		return (ArrayList<TPeliculas>) listapelis;
	}

	// LISTADO REGISTROS CON RESTRICTION
	public ArrayList<TPeliculas> listaPelisDeDuracionMinima(int minimaDuracion) {
		List listapelis = null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			// esto seria sin Criteria
//			String sql = "FROM  crud_pelis.inicio.Tablapeliculas  where duracion > :duracionminima";
//			Query query = session.createQuery(sql);
//			query.setParameter("duracionminima", minimaDuracion);
//			listapelis = (ArrayList<String>) query.list();

			Criteria criteria = session.createCriteria(TPeliculas.class);
			Criterion criterion1 = Restrictions.gt("duracion", minimaDuracion);
			criteria.add(criterion1);

			// podemos añadir mas restricciones
			Criterion criterion2 =Restrictions.gt("duracion", minimaDuracion);
			criteria.add(criterion2);

			listapelis =  (ArrayList<TPeliculas>) criteria.list();

			// haciendo ordenacion
			criteria.addOrder(Order.asc("titulo"));

			// usando un OR
			String titulobuscado = "ET";
			Criterion cr1 = Restrictions.eq("titulo", titulobuscado);
			Criterion cr2 =Restrictions.gt("duracion", minimaDuracion);
			LogicalExpression orCondition = Restrictions.or(cr1, cr2);
			criteria.add(orCondition);
			listapelis =  (ArrayList<TPeliculas>) criteria.list();

			// USANDO UNIQUE RESULT
			Criteria criteria3 = session.createCriteria(TPeliculas.class);
			TPeliculas peli = (TPeliculas) criteria3.uniqueResult();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {

			session.close();

		}
		return (ArrayList<TPeliculas>) listapelis;
	}

	// RECUPERAR UN REGISTRO USANDO UNIQUERESULT
	public TPeliculas consultaPelicula(String titulobuscado) {
		Session session = factory.openSession();
		Transaction tx = null;
		TPeliculas peli = null;
		try {
			tx = session.beginTransaction();

//			peli = (TPeliculas) session.get(TPeliculas.class, titulobuscado);

			Criteria criteria = session.createCriteria(TPeliculas.class);
			peli = (TPeliculas) criteria.uniqueResult();

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return peli;
	}

}
