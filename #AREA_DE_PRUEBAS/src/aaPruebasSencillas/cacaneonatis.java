package aaPruebasSencillas;
/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */

public class cacaneonatis {

    public static void main(String[] args) {
        new cacaneonatis();
    }
//
//    public cacaneonatis() {
//
//
////Instancias de paises para almacenar en la DB:
//        Paises pais1 = new Paises(1, "España");
//        Paises pais2 = new Paises(2, "Italia");
//        Paises pais3 = new Paises(3, "Suiza");
//        Paises pais4 = new Paises(4, "EEUU");
////instancias de jugadores para almacenar en BD
//        Jugadores j1 = new Jugadores("Maria", "voleibol", pais1, 14);
//        Jugadores j2 = new Jugadores("Miguel", "tenis", pais2, 15);
//        Jugadores j3 = new Jugadores("Mario", "baloncesto", pais3, 15);
//        Jugadores j4 = new Jugadores("Alicia", "tenis", pais4, 14);
///*La conexión la realizo con un objeto de clase ODB,
//en la que indico la ruta donde tengo la base de datos.
//Esto sirve para abrirla como para crear una nueva*/
//        ODB odb = ODBFactory.open("d:\\EQUIPOS.DB");
////Almaceno los objetos en la BD
//        odb.store(j1);
//        odb.store(j2);
//        odb.store(j3);
//        odb.store(j4);
////recupero todos los objetos
//        Objects objectsJug = odb.getObjects(Jugadores.class);
//        System.out.println("Hay " + objectsJug.size() + " Jugadores en la BD:");
//        int i = 1; //contador para mostrar listados los objetos
//                    //visualizar los objetos
//        while (objectsJug.hasNext()) {
//// Creo un objeto Jugadores y almaceno ahí el objeto que recupero de la BD
//            Jugadores jug = objectsJug.next();
//// Imprimo las propiedades que me interesan de ese objeto
//            System.out.println((i++) + " - " + "Nombre: " + jug.getNombre() + ", Deporte: " + jug.getDeporte() + ", Pais: " + jug.getPais().getNombrePais() + ", Edad: " + jug.getEdad());
//        }
//
//
////recupero todos los objetos Paises de la BD
//        Objects objectsPaises = odb.getObjects(Paises.class);
//        System.out.println("Hay " + objectsPaises.size() + " Paises en la BD:");
//        int j = 1; //contador para mostrar listados los objetos
////visualizar los objetos
//        while (objectsPaises.hasNext()) {
//// Creo un objeto Paises y almaceno ahí el objeto que recupero de la BD
//            Paises pais = objectsPaises.next();
//// Imprimo las propiedades que me interesan de ese objeto
//            System.out.println((j++) + " - " + "ID: " + pais.getId() + ", Pais: " + pais.getNombrePais());
//        }
//        odb.close(); //Cerrar BD
//
//    }


}
