package ejemplos_HQL;

import hibernate_0_1_incremental.inicio.Tablapeliculas;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class EjemplosHQL {


    public void leerTodasLasPelis() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List pelis = session.createQuery("FROM Tablapeliculas").list();
            for (Iterator iterator = pelis.iterator(); iterator.hasNext(); ) {
                Tablapeliculas peli = (Tablapeliculas) iterator.next();
                System.out.print("Actor principal: " + peli.getActorprincipal());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }











    
}
