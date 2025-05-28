package plantilla_matisse;

import com.matisse.MtDatabase;
import com.matisse.MtPackageObjectFactory;


// NO FUNCIONA EN MAC

public class PruebasPlantillaMatisse {

    public static void main(String[] args) {
        System.setProperty("java.library.path", "/usr/local/matisse/lib");
//        System.setProperty("java.library.path", "/Users/inaki/Workspaces/@AGORAS/$AG_JAVA/librerias/lib_matisse");
        System.out.println(System.getProperty("java.library.path"));
//        System.loadLibrary("matisse");


        DAOMatisse mdao = new DAOMatisse();

//        MtDatabase db = new MtDatabase("172.16.87.5", "ims", new MtPackageObjectFactory("", "biblioteca"));
        MtDatabase db = new MtDatabase("localhost", "dam", new MtPackageObjectFactory("", "biblioteca"));
        db.open();

        mdao.agregarLibro("Baila", "Anaya", 200);
        mdao.agregarLibro("ET", "Mike Munniss", 300);
        mdao.agregarLibro("Dune", "Brian Poulson", 865);

        mdao.consultarLibros();


//        Obra obras[] = new Obra[2];
//        obras[0] = libro;
//        obras[1] = libro2;
//
//        autor.setObras(obras);
//

        db.close();
    }
}
