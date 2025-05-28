package ftp_jorge;


//librerías de apache para FTP

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

/**
 * clase para recuperar un fichero de un Servidor FTP. El fichero se deposita en
 * el primer nivel de la carpeta del proyecto
 * <p>
 * ¡¡¡IMPORTANTE!!!
 * <p>
 * Para probar el ejemplo puede que tengas que deshabilitar cualquier
 * cortafuegos que tengas activado
 * <p>
 * ¡¡¡NO OLVIDARSE DE DESHACER LOS CAMBIOS!!! La seguridad del Sistema podría
 * verse comprometida
 *
 * @author IMCG
 */

public class EjercicioFTP {
//Puerto de Filezilla 14148


    //objeto de la clase FTPClient de Apache, con diversos métodos para
    //interactuar y recuperar un archivo de un servidor FTP
    private static FTPClient clienteFTP;
    //flujo de salida para la escritura de datos en un fichero
    private static FileOutputStream ficheroObtenido;
    //URL del servidor
    private static String servidorURL = "ftp.rediris.es";
    //ruta relativa (en Servidor FTP) de la carpeta que contiene
    //el fichero que vamos a descargar
    private static String rutaFichero = "debian/doc";
    //nombre del fichero (aunque carece de extensión, se trata de un fichero de
    //texto que puede abrise con el bloc de notas)
    private static String nombreFichero = "constitution.txt";
    //usuario
    private static String usuario = "anonymous";
    //contraseña
    private static String password = "";
    //array de carpetas disponibles
    private static String[] nombreCarpeta;

    /**
     * **************************************************************************
     * recupera el contenido de un fichero desde un Servidor FTP, y lo deposita en
     * un nuevo fichero en el directorio de nuestro proyecto
     *
     * @param args
     */

    static Scanner numero = new Scanner(System.in);
    static Scanner texto = new Scanner(System.in);
    static boolean fin = false;

    public static void login() {
        // Defino un nonbre y contraseña y los comparo con lo que recibo del cliente
        String nombre1 = "Jorge";
        String contra1 = "12345";

        while (fin == false) {
            System.out.println("Introduzca su nombre:");
            String nombre2 = texto.nextLine();

            System.out.println("Introduzca si contraseña:");
            String contra2 = texto.nextLine();

            //comparo y sino son iguales simplemente envía un false para informar de que es incorrecto
            if ((!nombre1.equalsIgnoreCase(nombre2)) || (!contra1.equalsIgnoreCase(contra2))) {
                System.out.println("Login incorrecto");

            } else {
                fin = true;
            }
        }
    }

    public static void menu() {
        boolean estado = false;
        int entradanum;

                    File dirActual = new File(".");

        while (estado == false) {
            System.out.println("1. Listar contenido.");
            System.out.println("2. Entrar en directorio.");
            System.out.println("3. Subir fichero.");
            System.out.println("4. Volver a directorio Home.");
            System.out.println("5. Salir.");

            entradanum = numero.nextInt();

            switch (entradanum) {
                case 1:
                    String[] ficheros = dirActual.list();

                    for (String fichero : ficheros) {
                        System.out.println(fichero);
                    }

                    break;

                case 2:
                    System.out.println("Nombre del directorio al que quiere acceder: ");
                    String dir = texto.nextLine();

                    File directorio = new File(dir);

                    if (directorio.exists()) {
                         dirActual =directorio;
                         System.out.println("Directorio actual: " + dirActual.getAbsolutePath());
                    } else {
                        System.out.println("Directorio no encontrado.");
                    }

                    break;
                case 3:
//                    System.out.println("Nombre del fichero a subir:");
//                    String arch = texto.nextLine();
//
//                    File archivo = new File(directorio, arch);
//
//                    if (archivo.exists()) {
//
//                    } else {
//                        System.out.println("Archivo no encontrado");
//                    }
                    break;
                case 4:
                    dirActual = new File(".");
                    System.out.println("Directorio actual: " + dirActual.getAbsolutePath());
                    break;
                case 5:
                    estado = true;
                    break;
            }
        }

    }

    public static void main(String[] args) {
        try {
            int reply;
            //creación del objeto cliente FTP
            clienteFTP = new FTPClient();
            //conexión del cliente al servidor FTP
            clienteFTP.connect(servidorURL);
            //Respuesta del servidor FTP rediris
            System.out.println(clienteFTP.getReplyString());
            //omprobación de la conexión
            reply = clienteFTP.getReplyCode();
            //si la conexión  es satisfactoria
            if (FTPReply.isPositiveCompletion(reply)) {
                //abre una sesión con el usuario anónimo
                clienteFTP.login(usuario, password);
                clienteFTP.enterLocalPassiveMode(); //Para entrar desde mi máquina virtual he tenido que hacerlo así
                System.out.println(clienteFTP.getReplyString());
                //lista las carpetas de primer nivel del servidor FTP
                System.out.println("Carpetas disponibles en el Servidor:");
                nombreCarpeta = clienteFTP.listNames();
                for (int i = 0; i < nombreCarpeta.length; i++) {
                    System.out.println(nombreCarpeta[i]);
                }


                // DESCARGAR ===============================================
                String nombreFichero = "cosas.txt";


                //nombre que el que va a recuperarse
                FileOutputStream ficheroObtenido = new FileOutputStream(nombreFichero);
                //mensaje
                System.out.println("\nDescargando el fichero " + nombreFichero );
                //recupera el contenido del fichero en el Servidor, y lo escribe en el
                //nuevo fichero del directorio del proyecto
                clienteFTP.retrieveFile("/" +  nombreFichero, ficheroObtenido);
                System.out.println(clienteFTP.getReplyString());  // mostramos el mensaje de respuesta del servidor
                //cierra el nuevo fichero
                ficheroObtenido.close();
                //cierra la conexión con el Servidor
                clienteFTP.disconnect();
                //
                System.out.println("Descarga finalizada correctamente");











            } else {
                //desconecta
                clienteFTP.disconnect();
                System.err.println("FTP ha rechazado la conexión esblecida");
                System.exit(1);
            }
        } catch (SocketException ex) {
            //error de Socket
            System.out.println(ex.toString());
        } catch (IOException ex) {
            //error de fichero
            System.out.println(ex.toString());
        }
    }
}
