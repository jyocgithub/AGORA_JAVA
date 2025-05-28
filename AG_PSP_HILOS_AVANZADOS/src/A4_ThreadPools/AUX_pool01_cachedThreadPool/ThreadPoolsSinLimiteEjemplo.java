package A4_ThreadPools.pool01_newCachedThreadPool;
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

/*
Pool sin límite de hilos: newCachedThreadPool()
SI se controla el fin de la ejecución de los hilos
Los cuatro hilos se ejecutan concurrentemente
El mensaje de fin sale sin acabar los hilos
 */
public class ThreadPoolsSinLimiteEjemplo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(new Thread(new ThCuentaAtras("A")));
        pool.execute(new Thread(new ThCuentaAtras("B")));
        pool.execute(new Thread(new ThCuentaAtras("C")));
        pool.execute(new Thread(new ThCuentaAtras("D")));
        // Fin, ya no se pueden meter mas hilos en el pool
        pool.shutdown();
        // Ahora SI que se espera a que se acaben todos los hilos
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("Fin del programa principal");
    }
}


class ThCuentaAtras implements Runnable {
    private String nombreReloj;
    public ThCuentaAtras(String nombreReloj) {
        this.nombreReloj = nombreReloj;
    }
    public void run() {
        for (int i = 3; i > 0; i--) {
            System.out.println("Soy "+nombreReloj+" en la vuelta "+ i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
