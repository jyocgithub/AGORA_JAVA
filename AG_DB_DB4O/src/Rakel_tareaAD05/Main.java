package Rakel_tareaAD05;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Main {

    // objeto que contiene la base de datos
    static ObjectContainer baseDatos;

    public static void main(String[] args) {

        crearBBDyDatos();

        consultarTodosLosJefes();

        System.out.println("----------------------------------");
        consultarMayores(55);

        System.out.println("----------------------------------");
        aumentarEdad("Miguel", 1);
        consultarTodosLosJefes();

        System.out.println("----------------------------------");
        borrarAntiguedad( 6);
        consultarTodosLosJefes();

        // cerramos al final
        baseDatos.close();

    }

    public static void consultarTodosLosJefes() {
        // query() consulta todos los objetos de la clase que se le indica (Jefe en este caso)
        // devuelve un List, una lita
        List<Jefe> lista = baseDatos.query(Jefe.class);
        // para recorrer una lista, lo mejor es usar Iterator.
        Iterator<Jefe> it = lista.iterator();
        while (it.hasNext()) {
            Jefe j = it.next();
            System.out.println(j);
        }
    }

    public static void crearBBDyDatos() {
        // si YA existia un fichero llamado BDJefeHijo, lo BORRAMOS para empezar desde cero
        File fichero = new File("BDJefeHijo");  // busco algo llamado BdJefeHijo
        fichero.delete();  // si esixte ese algo, lo borramos

        // COn esto abrimos el fichero BDJefeHijo, si ya existia, y si no existia, CREA el fichero
        // dicho fichero es ademas LA BBDD
        baseDatos = Db4oEmbedded.openFile("BDJefeHijo");

        // para dar de alta un registro, creo un objeto de la clase que sea (Jefe en este caso)...
        Jefe j = new Jefe("Ángel", 5, 53, new Hijo("Gustavo", 7));
        // ... y guardo el objeto con el metodo store()
        baseDatos.store(j);
        // igual con todos los demas
        baseDatos.store(new Jefe("Nieves", 3, 45, new Hijo("Iván", 3)));
        baseDatos.store(new Jefe("Jesús", 3, 5, new Hijo("Noelia", 3)));
        baseDatos.store(new Jefe("Dolores", 5, 63, new Hijo("Sergio", 7)));
        baseDatos.store(new Jefe("Vicki", 3, 5, null));
        baseDatos.store(new Jefe("Fátima", 5, 63, new Hijo("Lidia", 27)));
        baseDatos.store(new Jefe("Juan Luís", 3, 5, null));
        baseDatos.store(new Jefe("Elena", 1, 42, new Hijo("David", 19)));
        baseDatos.store(new Jefe("Miguel", 20, 45, new Hijo("Paula", 3)));
        baseDatos.store(new Jefe("Jesús", 19, 44, new Hijo("Rubén", 12)));
    }

    public static void consultarMayores(int edadminima) {
        // creo una consulta (vacia por ahora) en la bbdd
        Query q = baseDatos.query();
        // constrain en la consulta es decir que tabla voy a consultar
        q.constrain(Jefe.class);
        // descend() es el WHERE de la consulta, que indica el campo del where
        // detras del descend dices con contrain que valor y despues el operador (greater, smaller, equals)
        q.descend("edad").constrain(edadminima).greater();

        // ejecutamos la consulta con execute(), que nos devuelve un ObjetSet
        // qye es parecido a unas lista, y que ya es en si mismo un iterator,
        // esto es, que se puede usar hasnexte y next directamente en el ObjectSet
        ObjectSet<Object> resultado = q.execute();

        while (resultado.hasNext()) {
            Jefe j = (Jefe) resultado.next();
            System.out.println(j);
        }
    }

    public static void aumentarEdad(String nombre, int cantidad) {
        Query query = baseDatos.query();
        query.constrain(Jefe.class);
        query.descend("nombre").constrain(nombre);
        ObjectSet resultado = query.execute();
        // imaginamos que el nombre es como una clave primaria, que no hay dos jafes con el mismo nombre
        if (resultado.hasNext()) {
            Jefe jefeelegido = (Jefe) resultado.next();

            int edadactual = jefeelegido.getEdad();
            jefeelegido.setEdad(edadactual + cantidad);

            baseDatos.store(jefeelegido);
        } else {
            System.out.println("No existe jefe con ese nombre");
        }

    }


    public static void borrarAntiguedad(int minimo) {

        Query q = baseDatos.query();
        q.constrain(Jefe.class);
        q.descend("antiguedad").constrain(minimo).greater();
        ObjectSet<Object> resultado = q.execute();

        while (resultado.hasNext()) {
            Jefe j = (Jefe) resultado.next();
            // delete borra un objeto de la bbdd
            baseDatos.delete(j);
        }
    }



}


class Jefe {
    private String nombre;
    private int antiguedad;
    private int edad;
    private Hijo hijo;

    public Jefe(String nombre, int antiguedad, int edad, Hijo hijo) {
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.edad = edad;
        this.hijo = hijo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Hijo getHijo() {
        return hijo;
    }

    public void setHijo(Hijo hijo) {
        this.hijo = hijo;
    }

    @Override
    public String toString() {
        return "Jefe{" +
                "nombre='" + nombre + '\'' +
                ", antiguedad=" + antiguedad +
                ", edad=" + edad +
                ", hijo=" + hijo +
                '}';
    }
}

class Hijo {
    private String nombre;
    private int edad;

    public Hijo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Hijo{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}


//
//        System.out.println("-------------------------------CREAR DAO");
//        GestorDB4O g = new GestorDB4O("manzanas.yep");
//
//        System.out.println("-------------------------------INSERTAR");
//        g.insertarManzana(new Manzana(1,"Stark", 4));
//        g.insertarManzana(new Manzana(2,"Reineta", 45));
//        g.insertarManzana(new Manzana(3,"Golden", 21));
//        g.insertarManzana(new Manzana(4,"Fuji", 5));
//        g.insertarManzana(new Manzana(5,"Smith", 22));
//
//        System.out.println("-------------------------------LEER TODAS");
//        List<Manzana> listaManzanas1 = g.leerTodasLasManzanas();
//        System.out.println(listaManzanas1);
//
//        System.out.println("-------------------------------LEER UNA MANZANA POR ID");
//        Manzana unamanzana = g.leerUnaManzanaPorId(1);
//        System.out.println(unamanzana);
//
//        System.out.println("-------------------------------LEER UNA MANZANA POR PRECIO");
//        Manzana otramanzana = g.leerUnaManzanaPorPrecio(8);
//        System.out.println(otramanzana);
//
//        System.out.println("-------------------------------MODIFICAR");
//        g.modificarNombreManzana(3,"ReyNeta");
//        System.out.println(g.leerTodasLasManzanas());
//
//        System.out.println("-------------------------------BORRAR");
//        g.borrarUnaManzana(2);
//        System.out.println(g.leerTodasLasManzanas());
//
//        System.out.println("-------------------------------LEER UNA MANZANA DE UN PRECIO SUPERIOR A X");
//        ArrayList<Manzana> listamanzanas = g.leerManzanasPorPrecioSuperiorAX(10);
//        System.out.println(listamanzanas);

