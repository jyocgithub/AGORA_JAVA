package crear_y_lanzar_proceso;

import java.io.File;
import java.io.IOException;

public class CrearYLanzarProcesoSimple_ConRuntimeExec {

    public static void main(String[] args) throws IOException {
        // -- Encierro toda la logica con un try-catch y controlo los errores
        try {
            // -- Creo un proceso nuevo, y lo lanzo, en un solo paso:
            Process obProcesoHijo = Runtime.getRuntime().exec("ls -l");

            // waitFor() obliga a que nuestro programa quede esperando a que el proceso obProcesoHijo acabe,
            // y cuando acaba, waitFor() devuelve el codigo exit que emite el proceso
            // Normalmente, se devuelve un 0 si la ejecucion del proceso ha sido correcta.
            int codExit = obProcesoHijo.waitFor();

            // -- Escribimos el resultado de la ejecucion.
            // En este caso, lo que escrib es : "La ejecución de [ls, -l] devuelve 0"
            System.out.println("La ejecución de 'ls' y '-l' devuelve " + codExit);

        } catch (IOException ex) {
            System.err.println("Excepción de E/S!!");
            ex.printStackTrace();

            // -- Con esta instruccion hacemos que termine nuestro programa (que es tb un proceso)
            // e indicamos el código de salida que damos al acabar.
            // Es el mismo código que antes veiamos que devolvia el método waitFor(), solo que aqui
            // vemos como se provoca un código de salida específico.
            // Si este proceso nuestro hubiera sido llamado por otro, podría ver que con un -1
            // de valor de salida, habia habido un error.
            System.exit(-1);
        } catch (InterruptedException ex) {
            System.err.println("El proceso hijo finalizo de forma incorrecta");
        }


        System.exit(0);


    }

}
