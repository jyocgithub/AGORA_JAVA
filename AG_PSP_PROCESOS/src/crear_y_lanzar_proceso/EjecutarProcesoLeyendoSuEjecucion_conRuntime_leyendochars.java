package crear_y_lanzar_proceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EjecutarProcesoLeyendoSuEjecucion_conRuntime_leyendochars {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.err.println("No has especificado par叩metros");
            return;
        }
        else if (args.length > 1) {
            // La instruccion ha de ser un solo argumento, si tiene mas de una palabrta
            System.err.println("No indicar mas de un parámetro, si es un String, ponerlo entre comillas");
            return;
        }
        try {

            // Lanzamos el proceso usando exec().
            Process proc = Runtime.getRuntime().exec(args[0]);
            InputStream is = proc.getInputStream();
            byte[] buffer = new byte[1024*16];
            int leidos;
            while( (leidos = is.read(buffer)) != -1) {
                System.out.write(buffer, 0, leidos);
            }

            // Al acabar de leer, es normal que el canal este cerrado. Lo mas probable es
            // Por si acaso seguimos usando proc.waitFor(), para obtener asi ademas el resultado de la ejecucion
            // que nos responde el S.O.
            int result = proc.waitFor();

            is.close();  // deberia estar mejor en un finally, lo dejo aqui por simplicidad

            System.out.println("Resultado devuelto por el sistema: " + result);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
