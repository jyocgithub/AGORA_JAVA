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

import java.util.List;


public class ZonaTemperatura {
    private final String nombre;
    private final List<Double> temperaturas;

    public ZonaTemperatura(String nombre, List<Double> temperaturas) {
        this.nombre = nombre;
        this.temperaturas = temperaturas;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Double> getTemperaturas() {
        return temperaturas;
    }
}
