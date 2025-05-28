package A4_ThreadPools.pool05_fixedThreadPool_submit_runnable;
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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolsVariosHilosConSubmitRunnableEjemplo {
  public static void main(String[] args) {
    List<Future> listaFutures = new ArrayList<>();
    ExecutorService pool = Executors.newFixedThreadPool(2);
    // Recogemos en un Future lo que nos devuelve el submit
    Future unfuture = pool.submit(new Thread(new ThCuentaAtras("A")));
    listaFutures.add(unfuture);
    // ahora añadimos los futures segun se ejecuta submit directamente
    listaFutures.add(pool.submit(new Thread(new ThCuentaAtras("B"))));
    listaFutures.add(pool.submit(new Thread(new ThCuentaAtras("C"))));
    listaFutures.add(pool.submit(new Thread(new ThCuentaAtras("D"))));
    // Fin, ya no se pueden meter mas hilos en el pool
    pool.shutdown();
    // Ver como han acabado los hilos
    for (Future fut : listaFutures) {
      try {
        // get() debe devolver null si el hilo ha acabado bien
        // Ademas, bloquea la ejecución del metodo llamante hasta que acabe
        // el hilo, con lo que no usamos ahora awaitTermination
        System.out.println(fut.get());
      } catch (InterruptedException e) { e.printStackTrace(); }
      catch (ExecutionException e) { e.printStackTrace(); }
    }
    System.out.println("Fin del programa principal");
  }
}

class ThCuentaAtras implements Runnable{
  private String nombreReloj;
  public ThCuentaAtras(String nombreReloj) {
    this.nombreReloj = nombreReloj;
  }
  public void run() {
    for (int i = 3; i > 0; i--) {
      System.out.println("Soy " + nombreReloj + " en la vuelta " + i);
      try {
        Thread.sleep(300);
      } catch (InterruptedException ex) {  ex.printStackTrace(); }
    }
  }
}