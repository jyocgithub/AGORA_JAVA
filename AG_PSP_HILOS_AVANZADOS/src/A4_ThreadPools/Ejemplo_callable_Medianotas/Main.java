package A4_ThreadPools.Ejemplo_callable_Medianotas;
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

import java.util.*;
import java.util.concurrent.*;
/*
Tenemos una lista de grupos de alumnos.
Cada grupo tiene un nombre y una lista de calificaciones (enteros entre 0 y 10).

Se han de usar hilos Callable, que se metan en un fixedThreadPool
y se recueperen en una lista de Futures,
analizando las respuesas tras un awaitTermination

 */
public class Main {
  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(2);

    List<GrupoAlumnos> grupos = List.of(
            new GrupoAlumnos("1A", Arrays.asList(7, 8, 9, 6, 7)),
            new GrupoAlumnos("1B", Arrays.asList(5, 6, 4, 5)),
            new GrupoAlumnos("2A", Arrays.asList(9, 8, 9, 10, 9, 9)),
            new GrupoAlumnos("2B", Arrays.asList(6, 7, 8, 5, 6))
    );

    List<Future<String>> resultados = new ArrayList<>();

    for (GrupoAlumnos grupo : grupos) {
      resultados.add(executor.submit(new CalculaMediaGrupo(grupo)));
    }

    executor.shutdown();

    try {
      if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
        System.out.println("--- Resultados por grupo ---");
        for (Future<String> futuro : resultados) {
          System.out.println(futuro.get());
        }
      } else {
        System.out.println("Las tareas no terminaron a tiempo.");
      }
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
