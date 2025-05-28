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

import java.util.concurrent.Callable;
import java.util.List;

public class CalculaMediaZona implements Callable<ResultadoZona> {
    private final ZonaTemperatura zona;

    public CalculaMediaZona(ZonaTemperatura zona) {
        this.zona = zona;
    }

    @Override
    public ResultadoZona call() {
        List<Double> temps = zona.getTemperaturas();
        double suma = 0;
        for (double temp : temps) {
            suma += temp;
        }
        double media = temps.isEmpty() ? 0 : suma / temps.size();

        System.out.println("Zona " + zona.getNombre() + " procesada por " + Thread.currentThread().getName());

        return new ResultadoZona(zona.getNombre(), media);
    }
}
