package prog09_tarea;

import java.time.LocalDate;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author angerine martinez del corral Clase donde empieza a correr el
 * programa.
 */
public class Principal {

    // inicializo las variables que uso en toda la clase
    static private Scanner respuesta = new Scanner(System.in);
    static private Scanner respuestaString = new Scanner(System.in);
    static private Concesionario conce = new Concesionario();
    static private File ficheros;

    /**
     * Método princial donde empieza a correr mi programa.
     *
     * @param args
     */
    public static void main(String[] args) {

        // inicializo las variables que uso solo dentro del main
        int respuestaMenu = 0;

        ficheros = devuelveFichero();

        leerFicheroConArrayVehiculos(conce, ficheros);
        for (Vehiculo v : conce.getVeh()) {

        }
        for (Vehiculo v : conce.getVeh()) {
            System.out.println(v.mostrarDescripcion());
        }

        System.out.println("");//Lista de vehiculos almacenados en el fichero.
        // pintar menu y dentro de un bucle 
        do {
            System.out.println("1:Nuevo Vehículo.\n"
                    + "2:Listar Vehiculos.\n"
                    + "3:Buscar Vehiculo.\n"
                    + "4:Modificar kms Vehículo.\n"
                    + "5 Eliminar Vehiculo.\n"
                    + "6:Salir.");

            respuestaMenu = respuesta.nextInt();

            switch (respuestaMenu) {
                case 1:
                    nuevoVehiculo();
                    break;
                case 2:

                    if (conce.hayVehiculos()) {
                        conce.listaVehículos();
                    } else {
                        System.out.println("No hay vehículos");
                    }

                    break;

                case 3:
                    System.out.println("Introduce matrícula");
                    String matri = respuestaString.nextLine();
                    String descripcion = conce.consultarDescripcion(matri);
                    if (descripcion == null) {
                        System.out.println("No existe vehículo con la matrícula introducida");
                    } else {
                        System.out.println(descripcion);
                    }
                    break;
                case 4:
                    System.out.println("Introduce matricula");
                    String matricula = respuestaString.nextLine();
                    System.out.println("Introduce número de km");
                    int km = respuesta.nextInt();

                    boolean solucion = conce.actualizaKms(matricula, km);
                    if (solucion == false) {
                        System.out.println("El coche no existe");
                    }
                    break;
                case 5:
                    System.out.println("Introduce matricula");
                    matricula = respuestaString.nextLine();
                    solucion = conce.eliminarVehiculo(matricula);
                    if (solucion == false) {
                        System.out.println("El coche no puede ser eliminado porque no existe");
                    } else {
                        System.out.println("Coche eliminado");
                    }
                    break;
                case 6:
                    guardarFicheroConArrayVehiculos(conce, ficheros);

                    System.out.println("Fin del programa");

                    break;
            }

        } while (respuestaMenu != 6);

    }
//     Método que solicita información para crear nuevo vehiculo.
//    Se creará este siempre y cuando todos los datos sean correctos

    public static void nuevoVehiculo() {

        String marc, matri, desc, nombrePropietario, dniPropietario;
        int km, agno, numKM, mes, dia;
        double precio;
        LocalDate fechamat, hoy;

        do {
            System.out.println("Introduce marca");
            marc = respuestaString.nextLine();
            if (marc.isEmpty()) {
                System.out.println("Marca no puede estar vacia");
            }
        } while (marc.isEmpty());

        boolean repite = false;
        do {
            System.out.println("Introduce mátricula");
            matri = respuestaString.nextLine();
            boolean res = validarMatricula(matri);
            if (res == false) {
                System.out.println("Matricula sin formato correcto");
                repite = true;
            } else {
                repite = false;
            }
        } while (repite == true);

        do {
            System.out.println("Introduce km");
            numKM = respuesta.nextInt();
            if (numKM <= 0) {
                System.out.println("Los km no pueden ser 0 o menores.");
            }
        } while (numKM <= 0);

        do {
            System.out.println("Introduce año matriculación");
            agno = respuesta.nextInt();
            System.out.println("Introduce mes matriculación");
            mes = respuesta.nextInt();
            System.out.println("Introduce dia matriculación");
            dia = respuesta.nextInt();
            fechamat = LocalDate.of(agno, mes, dia);

            hoy = LocalDate.now();
            if (fechamat.isAfter(hoy)) {
                System.out.println("La fecha no puede ser anterior a la actual");
            }
        } while (fechamat.isAfter(hoy));

        do {
            System.out.println("Introduce descripción");
            desc = respuestaString.nextLine();
            if ((desc.isEmpty())) {
                System.out.println("La descripción no puede estar vacia");
            }
        } while (desc.isEmpty());

        System.out.println("Introduce precio");
        precio = respuesta.nextDouble();
        boolean repetirNombre = false;
        do {
            repetirNombre = false;
            System.out.println("Introduce nombre y apellidos del propietario");
            nombrePropietario = respuestaString.nextLine();
            if (validarNombreyApellido(nombrePropietario) == false) {
                System.out.println("El nombre no tiene el formato adecuado");
                repetirNombre = true;
            }

        } while (repetirNombre == true);

        boolean repetir;
        do {
            System.out.println("Introduce dni del propietario");
            dniPropietario = respuestaString.nextLine();
            repetir = false;
            if (validarDni(dniPropietario) == false) {
                repetir = true;
            }

        } while (repetir == true);

        if (repetir == false) {
            int resultado = conce.insertarVehiculo(marc, matri, numKM, fechamat, desc, precio, nombrePropietario, dniPropietario);
            if (resultado == -1) {
                System.out.println("El concesionario esta lleno, no puedo meter mas coches");
            } else if (resultado == -2) {
                System.out.println("El concesionario ya tiene un coche con esa matricula, coche no añadido");
            } else {
                System.out.println("Coche añadido");

            }

        }
    }

    public static boolean validarDni(String dni) {
        return dni.matches("^[0-9]{8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$");
    }

    public static boolean validarMatricula(String matricula) {
        if (matricula.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$")) {

            return true;

        } else {

            return false;
        }

    }
//Sin expresiones regulares (utilizando métodos de la clase String):
//Que el nombre del propietario contenga al menos un nombre
//y dos apellidos (no tratar nombres compuestos) y su longitud no excede de 40 caracteres.

    public static boolean validarNombreyApellido(String nombre) {
        boolean valido = false;
        int espacios = 0;
        for (int i = 0; i < nombre.length(); i++) {
            if (nombre.charAt(i) == ' ') {
                espacios++;
            }
        }
        if (espacios == 2 && nombre.length() <= 40) {
            valido = true;
        }
        return valido;
    }

    public static File devuelveFichero() {

        String fichero = "";

        System.out.println("Introduce nombre del fichero");
        fichero = respuesta.nextLine();
        ficheros = new File(fichero);

        try {

            if (!ficheros.exists()) {
                ficheros.createNewFile();
            }

        } catch (IOException e)//Lanzo la excepción en caso de que no encuentre el fichero
        {
            e.printStackTrace();

        }

        return ficheros;

    }

    public static void guardarFicheroConArrayVehiculos(Concesionario conces, File nombrefichero) {
        ObjectOutputStream escribiendo_fichero = null;
        try {
            escribiendo_fichero = new ObjectOutputStream(new FileOutputStream(nombrefichero));
            for (Vehiculo v : conces.getVeh()) {
                escribiendo_fichero.writeObject(v);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                escribiendo_fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void leerFicheroConArrayVehiculos(Concesionario conces, File nombrefichero) {
        ObjectInputStream leer_fichero = null;
        ArrayList<Vehiculo> listav = new ArrayList<Vehiculo>();
        try {
            leer_fichero = new ObjectInputStream(new FileInputStream(nombrefichero));
            while (true) {
                Vehiculo v = (Vehiculo) leer_fichero.readObject();
                listav.add(v);
            }
        } catch (EOFException ex) {
            System.out.println("Fin de fichero controlado, todo bien");


        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (leer_fichero != null) {
                    leer_fichero.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        conces.setVeh(listav);

    }

}
