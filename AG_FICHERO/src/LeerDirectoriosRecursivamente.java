import java.io.*;

public class LeerDirectoriosRecursivamente {
    public static void main(String[] args) {
        File fi = new File(".");
        leerDirectorioConNivel(fi, 1);
    }

    public static void leerDirectorio(File origen) {
        if (origen.exists()) {
            if (origen.isDirectory()) {
                System.out.println("---> DIR : " + origen.getName());
                File[] elementos = origen.listFiles();
                for (int i = 0; i < elementos.length; i++) {
                    if (elementos[i].isFile()) {
                        System.out.println("-> FICHERO : " + elementos[i].getName());
                    } else {
                        // es un directorio
                        leerDirectorio(elementos[i]);
                    }
                }
            }
        }
    }

    public static void leerDirectorioConNivel(File origen, int nivel) {
        if (origen.exists()) {
            if (origen.isDirectory()) {
                String tabulador = new String(new char[nivel]).replace("\0", "--");
                File[] elementos = origen.listFiles();
                for (int i = 0; i < elementos.length; i++) {
                    if (elementos[i].isFile()) {
                        System.out.println(tabulador + "-> FICHERO : " + elementos[i].getName());
                    } else {
                        System.out.println(tabulador + "-> DIR : " + elementos[i].getName());
                        // es un directorio
                        leerDirectorioConNivel(elementos[i], ++nivel);
                    }
                }
            }
        }
    }
}