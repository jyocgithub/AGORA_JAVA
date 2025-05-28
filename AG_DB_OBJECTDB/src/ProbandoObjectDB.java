
import java.util.List;

public class ProbandoObjectDB {
    public static void main(String[] args) {

        DAOObjectDB dao = new DAOObjectDB();
        dao.conectar();

        Libro l1 = new Libro(0, "Las Ratas", "M Delibes", 12);
        Libro l2 = new Libro(0, "La Colmena", "CJ Cela", 11);
        dao.añadirLibro(l1);
        dao.añadirLibro(l2);

        List<Libro> libros = dao.leerTodosLosLibros();

        for (Libro l : libros) {
            System.out.println(l);
        }

        System.out.println(dao.leerUnLibro(2));

        dao.borrarLibroPorID(7);

        System.out.println("------------------------------------------------");
        List<Libro> libroscaros = dao.leerTodosLosLibrosCaros(11);

        for (Libro l : libroscaros) {
            System.out.println(l);
        }

        dao.desconectar();

    }
}
