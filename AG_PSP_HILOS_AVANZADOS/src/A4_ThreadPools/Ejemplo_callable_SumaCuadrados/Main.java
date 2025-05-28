package A4_ThreadPools.Ejemplo_callable_SumaCuadrados;
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
/*
Crear 5 tareas que calculan el cuadrado de un número que tu eliges.
Ejecutarlas en paralelo usando un thread pool fijo, y luego imprimir los resultados.


Se han de usar hilos Callable, que se metan en un fixedThreadPool
y se recueperen en una lista de Futures,
analizando las respuesas tras un awaitTermination
 */
public class Main {
    public static void main(String[] args) {
        // Crea un pool fijo de 3 hilos
        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<Future<Integer>> resultados = new ArrayList<>();

        // Enviar 5 tareas al pool
        for (int i = 1; i <= 5; i++) {
            Callable<Integer> tarea = new CalculaCuadrado(i);
            Future<Integer> future = pool.submit(tarea);
            resultados.add(future);
        }

        // Cerramos el pool para que no acepte más tareas
        pool.shutdown();

        try {
            // Esperamos hasta 5 segundos a que terminen todas las tareas
            if (pool.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("\nTodos los hilos han terminado. Resultados:");
                for (Future<Integer> f : resultados) {
                    try {
                        System.out.println("Resultado: " + f.get());
                    } catch (ExecutionException e) {
                        System.out.println("Error en la ejecución: " + e.getMessage());
                    }
                }
            } else {
                System.out.println("El tiempo de espera ha terminado y algunas tareas no finalizaron.");
            }
        } catch (InterruptedException e) {
            System.out.println("Interrumpido mientras esperaba la finalización.");
        }
    }
}
