package A4_ThreadPools.pool09_ScheduledThreadPool;
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

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Principal {

    private static final int NUMERO_SENSORS = 3;

    public static void main(String[] args) {

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(NUMERO_SENSORS);

        // Programem cada sensor amb diferents intervals
        for (int i = 0; i < NUMERO_SENSORS; i++) {
            executor.scheduleAtFixedRate(
                    new SensorTemperatura(i),
                    0,                          // delay inicial
                    2 + i,                      // per鱈ode (diferent per cada sensor)
                    TimeUnit.SECONDS
            );
        }

        // Programem una tasca per mostrar estad鱈stiques cada 10 segons
        executor.scheduleAtFixedRate(
                new TascaEstadistiques(),
                10,     // delay inicial
                10,     // per鱈ode
                TimeUnit.SECONDS
        );

        // Executem el programa durant 30 segons
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //aturar
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}



