package A4_ThreadPools.pool04_fixedThreadPool_interrrumpidos;
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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolsVariosHilosInterrumpidosEjemplo {
  public static void main(String[] args) {
    ExecutorService pool = Executors.newFixedThreadPool(2);
    pool.execute(new Thread(new ThCuentaAtras("A")));
    pool.execute(new Thread(new ThCuentaAtras("B")));
    pool.execute(new Thread(new ThCuentaAtras("C")));
    pool.execute(new Thread(new ThCuentaAtras("D")));
    // Fin, ya no se pueden meter mas hilos en el pool
    pool.shutdown();
    // Ahora se esperará 1 segundo a que se acaben los hilos
    // y si no se intenta forzar a que se cierren
    try {
      if (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
        pool.shutdownNow();
      }
    } catch (InterruptedException ex) {
      // Cuidado que se puede llegar aqui si se recibe una interrupcion
      // mientras se esta en el awaitTermination()
      pool.shutdownNow();
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
    String threadName = Thread.currentThread().getName();
    for (int i = 3; i > 0; i--) {
      System.out.println("Soy " + nombreReloj + " en la vuelta " + i);
      try {
        Thread.sleep(300);
      } catch (InterruptedException ex) {
        System.out.println(" ---> Hilo " + nombreReloj + " interrumpido, y que finaliza");
        return;
      }
    }
  }
}