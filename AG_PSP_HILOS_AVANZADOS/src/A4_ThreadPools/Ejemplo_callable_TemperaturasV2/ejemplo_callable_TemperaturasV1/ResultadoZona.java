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
public class ResultadoZona {
    private final String nombreZona;
    private final double media;
    private final long duracion; // en milisegundos

    public ResultadoZona(String nombreZona, double media, long duracion) {
        this.nombreZona = nombreZona;
        this.media = media;
        this.duracion = duracion;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public double getMedia() {
        return media;
    }

    public long getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "Zona: " + nombreZona + " - Media: " + String.format("%.2f", media) +
                "°C - Tiempo: " + duracion + " ms";
    }
}

