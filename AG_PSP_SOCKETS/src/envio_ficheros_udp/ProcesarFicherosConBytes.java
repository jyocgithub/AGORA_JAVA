package envio_ficheros_udp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProcesarFicherosConBytes {

    public static byte[] leerArchivoEnBytes(String path, String nombre) {

        byte[] archivoEnBytes = null;
        Path ficheroorigen = Paths.get(path, nombre);
        try {
            archivoEnBytes = Files.readAllBytes(ficheroorigen);
        } catch (IOException ex) {
            System.out.println("Error al crear un array de bytes desde el archivo");
        }
        return archivoEnBytes;
    }

    public static boolean escribirArchivoConBytes(String path, String nombre, byte[] archivoEnBytes) {
        Path ficherodestino = Paths.get(path, nombre);
        try {
            Files.write(ficherodestino, archivoEnBytes);
        } catch (IOException ex) {
            System.out.println("Error al escribir un array de bytes en un archivo");
            return false;
        }
        return true;
    }

}
