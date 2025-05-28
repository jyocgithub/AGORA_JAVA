package A4_ThreadPools.Ejemplo_callable_TemperaturasV1;
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
import java.util.concurrent.*;
import java.util.*;
/*
🎯 Enunciado:
Imaginar un sistema meteorológico que recopila temperaturas de diferentes zonas (regiones).
Cada zona tiene una lista de temperaturas, y queremos calcular la media de cada una de
ellas en paralelo.
Clases del proyecto:
    - ZonaTemperatura: clase que representa una zona con su nombre y lista de temperaturas.
    - ResultadoTemperatura: clase que almacena una zona y su temperatura maxima
    - CalculaMediaZona: una clase Callable<Double> que calcula la media de temperaturas de una zona.
    - Main: crea varias zonas, lanza tareas con un ExecutorService,
            espera los resultados, y los muestra.
*/
public class Main {
  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(3);
    List<ZonaTemperatura> zonas = List.of(
            new ZonaTemperatura("Norte", Arrays.asList(15.0, 16.5, 14.2, 15.6)),
            new ZonaTemperatura("Sur", Arrays.asList(30.1, 29.8, 31.0, 32.2)),
            new ZonaTemperatura("Este", Arrays.asList(22.0, 21.5, 23.3)),
            new ZonaTemperatura("Oeste", Arrays.asList(18.5, 19.2, 17.8, 20.1, 18.9))
    );

    List<Future<ResultadoZona>> resultados = new ArrayList<>();

    for (ZonaTemperatura zona : zonas) {
      resultados.add(executor.submit(new CalculaMediaZona(zona)));
    }

    executor.shutdown();

    try {
      if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
        System.out.println("\n--- Resultados finales ---");
        for (Future<ResultadoZona> futuro : resultados) {
          try {
            System.out.println(futuro.get());
          } catch (ExecutionException e) {
            System.out.println("Error al procesar zona: " + e.getMessage());
          }
        }
      } else {
        System.out.println("No se completaron todas las tareas en el tiempo dado.");
      }
    } catch (InterruptedException e) {
      System.out.println("Proceso interrumpido.");
    }
  }
}
