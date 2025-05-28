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
import java.util.concurrent.Callable;
import java.util.List;

public class CalculaMediaZona implements Callable<ResultadoZona> {
    private final ZonaTemperatura zona;

    public CalculaMediaZona(ZonaTemperatura zona) {
        this.zona = zona;
    }

    @Override
    public ResultadoZona call() {
        long inicio = System.currentTimeMillis();

        List<Double> temps = zona.getTemperaturas();
        double suma = 0;
        for (double temp : temps) {
            suma += temp;
            // simulamos una carga mínima
            try { Thread.sleep(10); } catch (InterruptedException ignored) {}
        }

        double media = temps.isEmpty() ? 0 : suma / temps.size();
        long fin = System.currentTimeMillis();

        long duracion = fin - inicio;

        System.out.println("Zona " + zona.getNombre() + " procesada por " + Thread.currentThread().getName() +
                " en " + duracion + " ms");

        return new ResultadoZona(zona.getNombre(), media, duracion);
    }
}

