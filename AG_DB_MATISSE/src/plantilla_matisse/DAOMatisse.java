package plantilla_matisse;

import com.matisse.MtDatabase;
import com.matisse.MtException;
import com.matisse.MtObjectIterator;
import com.matisse.MtPackageObjectFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class DAOMatisse {
    private String host = "localhost";
    private String dbname = "BDEjemplo";

    private MtDatabase db;

    public void conectar() {
        try {
            db = new MtDatabase(host, dbname);
            db.open();
        } catch (MtException mte) {
            System.out.println("MtException: " + mte.getMessage());
        }
    }

    public void desconectar() {
        try {
            db.close();
        } catch (MtException mte) {
            System.out.println("MtException: " + mte.getMessage());
        }
    }

    public void agregarLibro(String titulo, String editorial, int paginas) {
        db.startTransaction();
        Libro libro = new Libro(db);
        libro.setTitulo(titulo);
        libro.setEditorial(editorial);
        libro.setPaginas(paginas);
        db.commit();
    }

    public void agregarAutor(String nombre, String apellidos, int edad) {
        db.startTransaction();
        Autor autor = new Autor(db);
        autor.setNombre(nombre);
        autor.setApellidos(apellidos);
        autor.setEdad(edad);
        db.commit();
    }


    public void consultarLibros() {
        System.out.println("\nHay" + Libro.getInstanceNumber(db) + " libros en la bbdd.");
        Iterator<Libro> iter = Libro.instanceIterator(db);
        while (iter.hasNext()) {
            Libro x = iter.next();
            System.out.println(x);
            System.out.println(" Es un " + x.getMtClass().getMtName());
        }
    }


//    public static void borraObjetos() {
//        MtDatabase db = new MtDatabase("localhost", "dam", new MtPackageObjectFactory("", "biblioteca"));
//        db.open();
//        db.startTransaction();
//
//        long numeroObras = Obra.getInstanceNumber(db);
//        System.out.println("El n�mero de obras es " + numeroObras);
//		/*MtObjectIterator<Obra> iterador = Obra.instanceIterator(db);
//		while (iterador.hasNext()) {
//			Obra obra = iterador.next();
//			if (obra.getTitulo().equals("nombre titulo"))
//			obra.deepRemove();
//		}
//		iterador.close();*/
//        //Eliminar todas las instancias de una clase
//        Obra.getClass(db).removeAllInstances();
//        db.commit();
//        db.close();
//
//
//    }

    public static void modificaObjeto(String nombre, int edad) {
        MtDatabase db = new MtDatabase("localhost", "dam", new MtPackageObjectFactory("", "biblioteca"));
        db.open();
        db.startTransaction();

        MtObjectIterator<Autor> iterador = Autor.instanceIterator(db);
        while (iterador.hasNext()) {
            Autor autor = iterador.next();
            if (autor.getNombre().equals(nombre)) {
                autor.setEdad(edad);
            }
        }

        iterador.close();
        db.commit();
        db.close();
    }

    public static void autoresDeMasDe50() {
        MtDatabase db = new MtDatabase("localhost", "dam", new MtPackageObjectFactory("", "biblioteca"));
        db.open();
        try {
            Statement stmt = db.createStatement();
            String consultaOQL = "select REF(a) from biblioteca.Autor a where a.edad > 50";
            ResultSet rs = stmt.executeQuery(consultaOQL);

            while (rs.next()) {
                Autor autor = (Autor) rs.getObject(1);
                System.out.println("Nombre: " + autor.getNombre());
                System.out.println("Apellidos: " + autor.getApellidos());
            }

            rs.close();
            stmt.close();
            db.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
