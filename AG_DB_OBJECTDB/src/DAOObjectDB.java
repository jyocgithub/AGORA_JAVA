import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAOObjectDB {

    EntityManager em;
    EntityManagerFactory emf;

    public void añadirLibro(Libro unlibro) {
        try {
            em.getTransaction().begin();
            em.persist(unlibro);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en el alta de un registro: " + e.getMessage());
        }
    }

//    public void borrarTodosLosLibros() {
//        try {
//            String sql= "delete from libros";
//            em.getTransaction().begin();
//            em.createQuery(sql);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println("Error en el borrado de registros: " + e.getMessage());
//        }
//    }
    public void borrarLibroPorID(int id) {
        try {
            em.getTransaction().begin();

            TypedQuery<Libro> query = em.createQuery("SELECT c FROM Libro c WHERE c.id = :id", Libro.class);

            Libro lib = query.setParameter("id", id).getSingleResult();

            em.remove(lib);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en el borrado de registros: " + e.getMessage());
        }
    }


    public List<Libro> leerTodosLosLibros() {
        TypedQuery<Libro> query = em.createQuery("SELECT b FROM Libro b", Libro.class);
        List<Libro> resultado = query.getResultList();
        return resultado;
    }
    public List<Libro> leerTodosLosLibrosCaros(int minimo) {
        TypedQuery<Libro> query = em.createNamedQuery("Libro.buscarLibrosCaros", Libro.class);
        List<Libro> resultado = query.setParameter("preciominimo", minimo).getResultList();
        return resultado;
    }


    public Libro leerUnLibro(int idbuscado) {
        TypedQuery<Libro> query = em.createQuery("SELECT c FROM Libro c WHERE c.id = :id", Libro.class);

        Libro lib = query.setParameter("id", idbuscado).getSingleResult();

        return lib;
    }


    public void conectar() {
//        emf = Persistence.createEntityManagerFactory("libreria.odb");
        emf = Persistence.createEntityManagerFactory("objectdb:misbbdd/libreriamoderna.odb;drop");
        em = emf.createEntityManager();
    }

    public void desconectar() {
        em.close();
        emf.close();
    }

}
