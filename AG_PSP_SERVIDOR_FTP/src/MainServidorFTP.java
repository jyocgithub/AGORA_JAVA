


// NECESITA librerías de APACHE COMMONS para FTP

import java.io.File;

import org.apache.commons.net.ftp.FTPReply;

//librerías de java

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
 */

//Puerto de Filezilla 14148

public class MainServidorFTP {


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
    static    GUT_FTPJava gutFtpJava;
    public static void main(String[] args) {
        int reply;
        gutFtpJava = new GUT_FTPJava();
        //creación del objeto cliente FTP
        if(gutFtpJava.conectar()>=0) {

            //Comprobación de la conexión
            int codigoconexion = gutFtpJava.getCodigoConexion();
            //si la conexión  es satisfactoria
            if (FTPReply.isPositiveCompletion(codigoconexion)) {
                if (gutFtpJava.login()) {
                    menu();
                }
            }
        }
    }

    public static void menu() {
        boolean salir = false;
        int entradanum;
        File dirActual = new File(".");

        while (salir == false) {
            System.out.println("\nMENU =============================================");
            System.out.println("1. Listar informacion y contenido del directorio actual.");
            System.out.println("2. Cambiar de directorio.");
            System.out.println("3. Subir fichero.");
            System.out.println("4. Bajar fichero.");
            System.out.println("5. Volver a directorio Home.");
            System.out.println("0. Salir.");

            entradanum = numero.nextInt();

            switch (entradanum) {
                case 1:
                    gutFtpJava.listaContenidoActual();
                    break;

                case 2:
                    System.out.println("Nombre del directorio al que quiere acceder: ");
                    String dir = texto.nextLine();
                    gutFtpJava.cambiarDirectorio(dir);
//                    File directorio = new File(dir);
//
//                    if (directorio.exists()) {
//
//                        System.out.println("Directorio " + directorio.isDirectory());
//                        System.out.println("Directorio actual: " + directorio.getAbsolutePath());
//                        dirActual = directorio;
//                    } else {
//                        System.out.println("Direcotorio no encontrado.");
//                    }

                    break;
                case 3:
                    System.out.println("Nombre del fichero a subir:");
                    String archori = texto.nextLine();
                    System.out.println("Nombre del fichero cuando se haya enviado:");
                    String archdes = texto.nextLine();
                    gutFtpJava.subirFichero(archori, archdes);

                    break;
                case 4:
                    System.out.println("Nombre del fichero a bajar:");
                    String archori2 = texto.nextLine();
                    System.out.println("Nombre del fichero cuando haya descargado:");
                    String archdes2 = texto.nextLine();
                    gutFtpJava.bajarFichero(archori2, archdes2);
                    break;
                case 5:
                    System.out.println("Directorio actual: " + dirActual.getAbsolutePath());
                    System.out.println("Volviendo al directorio raiz...");
                    dirActual = new File(".");
                    System.out.println("Directorio actual: " + dirActual.getAbsolutePath());
                    break;
                case 0:
                    salir = true;
                    break;
            }
        }

    }


}
