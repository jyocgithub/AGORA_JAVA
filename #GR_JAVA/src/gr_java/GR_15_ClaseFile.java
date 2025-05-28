package gr_java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GR_15_ClaseFile {

    public static void crearFichero(String nombrefichero) throws IOException {
        File fich1 = new File(nombrefichero);
        fich1.createNewFile();
    }

    public static void crearDirectorio(String nombredir) throws IOException {
        File dir1 = new File(nombredir);
        dir1.mkdirs();
    }

    public static void crearDirectorio(File origen, String nombredir) throws IOException {
        File dir1 = new File(origen, nombredir);
        dir1.mkdirs();
    }

    public static boolean existe(String nombre) throws IOException {
        File fich2 = new File(nombre);
        return fich2.exists();
    }

    public static String pathCompleto(String nombre) throws IOException {
        File fich2 = new File(nombre);
        return fich2.getPath();
    }

    public static boolean borrarFichero(String nombre) throws IOException {
        File fich3 = new File(nombre);
        if (fich3.exists()) {
            fich3.delete();
            return true;
        }
        return false;
    }

    public static boolean renombrarFichero(String nombreoriginal, String nombrefinal) throws IOException {

        File fichInicial = new File(nombreoriginal);
        if (!fichInicial.exists()) {
            File fichNuevo = new File(nombrefinal);
            fichInicial.renameTo(fichNuevo);
            return true;
        }
        return false;
        // CUIDADO. el OBJETO fichInicial SE SIGUE LLAMANDO ficheroARenombrar.txt
        // (se puede ver ejecutando: System.out.println(fichInicial.getName()); )
        // pero el fichero EN EL DISCO, YA NO SE LLAMA ASI, ese SI ha cambiado
        // Para hacer referencia la fichero con su nombre nuevo,
        // usemos el objeto fichNuevo
    }

    public static boolean copiarFichero(String nombreoriginal, String nombrefinal) throws IOException {
        File fichOrigen = new File(nombreoriginal);
        if (!fichOrigen.exists()) {
            File fichDestino = new File(nombrefinal);
            fichOrigen.createNewFile(); // lo creamos primero
            Files.copy(fichOrigen.toPath(), fichDestino.toPath());
            return true;
        }
        return false;
    }

    public static boolean moverFichero(String nombreYPrimerSitio, String nombreYSegundoSitio) throws IOException {
        File fichPrimerSitio = new File(nombreYPrimerSitio);
        if (!fichPrimerSitio.exists()) {
            File fichSegundoSitio = new File(nombreYSegundoSitio);
            fichPrimerSitio.renameTo(fichSegundoSitio);
            return true;
        }
        return false;
    }


}
