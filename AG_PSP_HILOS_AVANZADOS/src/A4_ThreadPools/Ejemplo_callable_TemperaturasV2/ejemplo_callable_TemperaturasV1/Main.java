package A4_ThreadPools.Ejemplo_callable_TemperaturasV2.ejemplo_callable_TemperaturasV1;
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
Mejorar a el ejercicio Temperaturasv1 para que cada hilo registre cuánto tiempo tarda en
calcular la media de su zona, y luego el programa principal muestre cuál hilo fue el más rápido.
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
      if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
        System.out.println("\n--- Resultados finales ---");
        ResultadoZona masRapido = null;

        for (Future<ResultadoZona> futuro : resultados) {
          try {
            ResultadoZona res = futuro.get();
            System.out.println(res);

            if (masRapido == null || res.getDuracion() < masRapido.getDuracion()) {
              masRapido = res;
            }

          } catch (ExecutionException e) {
            System.out.println("Error al procesar zona: " + e.getMessage());
          }
        }

        if (masRapido != null) {
          System.out.println("\n🚀 La zona que se procesó más rápido fue: " +
                  masRapido.getNombreZona() + " (" + masRapido.getDuracion() + " ms)");
        }
      } else {
        System.out.println("No se completaron todas las tareas en el tiempo dado.");
      }
    } catch (InterruptedException e) {
      System.out.println("Proceso interrumpido.");
    }
  }
}
