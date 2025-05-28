package A4_ThreadPools.pool06_fixedThreadPool_submit_callable;
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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolsVariosHilosConSubmitCallableEjemplo {
  public static void main(String[] args) {
    // El list de Future es genérico, se tipa con el tipo de dato
    // que devuelve el call() del Callable que usará
    List<Future<String>> listaFutures = new ArrayList<>();
    ExecutorService pool = Executors.newFixedThreadPool(2);
    // Recogemos en un Future lo que nos devuelve cada submit
    listaFutures.add(pool.submit(new ThCuentaAtras("A")));
    listaFutures.add(pool.submit(new ThCuentaAtras("B")));
    listaFutures.add(pool.submit(new ThCuentaAtras("C")));
    listaFutures.add(pool.submit(new ThCuentaAtras("D")));
    // Fin, ya no se pueden meter mas hilos en el pool
    pool.shutdown();
    // Ahora se esperará 1 segundo antes de forzar el cierre de los hilos
    try {
      if (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
        pool.shutdownNow();
      }
    } catch (InterruptedException ex) {
    }
    // Ver como han acabado los hilos
    for (Future<String> fut : listaFutures) {
      try {
        // get() debe devolver lo que devuelve call()
        System.out.println(fut.get());
      } catch (InterruptedException e) { }
      catch (ExecutionException e) { }
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
      try { Thread.sleep(300);
      } catch (InterruptedException ex) {
        System.out.println(" ---> Hilo " + nombreReloj + " interrumpido, y que SI finaliza");
        return nombreReloj + " acabó interrumpido";
      }
    }
    return nombreReloj + " acabó bien";
  }
}