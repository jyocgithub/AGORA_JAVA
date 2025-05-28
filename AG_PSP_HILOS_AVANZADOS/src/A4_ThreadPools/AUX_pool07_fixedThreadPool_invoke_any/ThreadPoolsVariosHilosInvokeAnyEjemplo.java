package A4_ThreadPools.pool07_FixedThreadPool_invoke_any;
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

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolsVariosHilosInvokeAnyEjemplo {
    public static void main(String[] args) {
        // Se crea el ExecuteServices
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // Metemos en un set todos los objetos callable a pasar al pool
        Set<Callable<String>> listaObjetosCallables = new HashSet<>();
        listaObjetosCallables.add(new ThCuentaAtras("A"));
        listaObjetosCallables.add(new ThCuentaAtras("B"));
        listaObjetosCallables.add(new ThCuentaAtras("C"));
        listaObjetosCallables.add(new ThCuentaAtras("D"));
        try {
            // Metemos toda la coleccion en el pool
            // con  invokeAny() NO SE PASARA DE ESTA LINEA HASTA QUE SE DESTRUYA EL POOL
            String respuestaDelCallUnico = pool.invokeAny(listaObjetosCallables);
            // Fin, ya no se pueden meter mas hilos en el pool
            // Ver como han acabado los hilos
            // get() debe devolver lo que devuelve call()
            // Ademas, bloquea la ejecución del metodo llamante hasta que acabe
            // el hilo, con lo que no usamos ahora awaitTermination
            System.out.println(respuestaDelCallUnico);
            System.out.println("Esto está antes del shutdown");
            pool.shutdown();

        } catch (InterruptedException ex) {  }
        catch (ExecutionException ex) {  }
        System.out.println("Fin del programa principal");
    }
}

class ThCuentaAtras implements Callable<String> {
    private String nombreReloj;
    public ThCuentaAtras(String nombreReloj) { this.nombreReloj = nombreReloj; }
    public String call() {
        for (int i = 3; i > 0; i--) {
            System.out.println("Soy " + nombreReloj + " en la vuelta " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                System.out.println(" ---> Hilo " + nombreReloj + " interrumpido, y que SI finaliza");
                return nombreReloj + " acabó interrumpido";
            }
        }
        return nombreReloj + " acabó bien";
    }
}