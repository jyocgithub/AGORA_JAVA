package A4_ThreadPools;
// Recogemos en un Future lo que nos devuelve cada submit

import java.util.*;
import java.util.concurrent.*;

public class ThreadPoolsEjemplo {
    public static void main(String[] args) {
        // Se crea el ExecuteServices
//        ExecutorService pool = Executors.newSingleThreadExecutor();
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
            pool.shutdown();
        } catch (InterruptedException ex) {
        } catch (ExecutionException e) {
        }
        System.out.println("Fin del programa principal");
    }
}

class ThCuentaAtras implements Callable<String> {
    private String nombreReloj;

    public ThCuentaAtras(String nombreReloj) {
        this.nombreReloj = nombreReloj;
    }

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