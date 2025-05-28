package A4_ThreadPools.pool08_FixedThreadPool_invoke_all;
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
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ThreadPoolsVariosHilosInvokeAllEjemplo {

    public static void main(String[] args) {
        // Se crea el ExecuteService
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // Metemos en un set todos los objetos callable a pasar al pool
        Set< Callable<String>> listaObjetosCallables = new HashSet<>();
        listaObjetosCallables.add(new ThCuentaAtras("A"));
        listaObjetosCallables.add(new ThCuentaAtras("B"));
        listaObjetosCallables.add(new ThCuentaAtras("C"));
        listaObjetosCallables.add(new ThCuentaAtras("D"));
        try {
            // Metemos toda la coleccion en el pool
            // con  invokeAll() NO SE PASARA DE ESTA LINEA HASTA QUE ACABEN TODOS LOS HILOS
            List<Future<String>> listaFutures = pool.invokeAll(listaObjetosCallables);
            // Fin, ya no se pueden meter mas hilos en el pool
            pool.shutdown();
            // Ver como han acabado los hilos
            for (Future<String> fut : listaFutures) {
                // get() debe devolver lo que devuelve call()
                // Ademas, bloquea la ejecución del metodo llamante hasta que acabe
                // el hilo, con lo que no usamos ahora awaitTermination
                System.out.println(fut.get());
            }
        } catch (InterruptedException ex) {
        } catch (ExecutionException e) {
        }
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