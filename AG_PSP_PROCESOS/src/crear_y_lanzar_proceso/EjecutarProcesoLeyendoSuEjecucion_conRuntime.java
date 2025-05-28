package crear_y_lanzar_proceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EjecutarProcesoLeyendoSuEjecucion_conRuntime {
    public static void main(String[] args) throws IOException {
        // Creamos un objeto Runtime
        Runtime builder = Runtime.getRuntime();

        // Creamos el string que contiene la instruccion a ejecutar
        // EN LINUX
        String cmd = "ls -l";
        // EN WINDOWS
//         String cmd = "cmd.exe /C dir";
//        -- Explicacion: En Windows, la llamada a "dir" no puede hacerse directamente,
//        sino que hay que llamar realmente a la consola de Windows (cmd.exe) y pasarle la instrucción.
//        En definitiva, el proceso que se lanza es "cmd.exe /C dir".
//        La parte /C indica que la instrucción "termine" cuando acabe su ejecución, si no,
//        no se devuelve el control al proceso pues nunca "termina"
        try {
            // Ejecutamos el proceso y creamos un objeto donde  almacenarlo
            Process out = builder.exec(cmd);

            // Creamos un lector que lea de la salida del proceso
            BufferedReader bf = new BufferedReader(new InputStreamReader(out.getInputStream()));

            // vamos leyendo lo que el proceso va emitiendo, leyendo de su salida
            String linea;
            while( (linea=bf.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
