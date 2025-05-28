import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        new File("manzanas.yep").delete();

        System.out.println("-------------------------------CREAR DAO");
        DAODb4O g = new DAODb4O("manzanas.yep");

        System.out.println("-------------------------------INSERTAR");
        g.insertarManzana(new Manzana(1,"Stark", 4));
        g.insertarManzana(new Manzana(2,"Reineta", 45));
        g.insertarManzana(new Manzana(3,"Golden", 21));
        g.insertarManzana(new Manzana(4,"Fuji", 5));
        g.insertarManzana(new Manzana(5,"Smith", 22));

        System.out.println("-------------------------------LEER TODAS");
        List<Manzana> listaManzanas1 = g.leerTodasLasManzanas();
        System.out.println(listaManzanas1);

        System.out.println("-------------------------------LEER UNA MANZANA POR ID");
        Manzana unamanzana = g.leerUnaManzanaPorId(1);
        System.out.println(unamanzana);

        System.out.println("-------------------------------LEER UNA MANZANA POR PRECIO");
        Manzana otramanzana = g.leerUnaManzanaPorPrecio(8);
        System.out.println(otramanzana);

        System.out.println("-------------------------------MODIFICAR");
        g.modificarNombreManzana(3,"ReyNeta");
        System.out.println(g.leerTodasLasManzanas());

        System.out.println("-------------------------------BORRAR");
        g.borrarUnaManzana(2);
        System.out.println(g.leerTodasLasManzanas());

        System.out.println("-------------------------------LEER UNA MANZANA DE UN PRECIO SUPERIOR A X");
        ArrayList<Manzana> listamanzanas = g.leerManzanasPorPrecioSuperiorAX(10);
        System.out.println(listamanzanas);



    }
}
