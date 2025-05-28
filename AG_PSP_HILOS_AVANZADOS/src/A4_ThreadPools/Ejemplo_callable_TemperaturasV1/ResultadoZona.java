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

public class ResultadoZona {
    private final String nombreZona;
    private final double media;

    public ResultadoZona(String nombreZona, double media) {
        this.nombreZona = nombreZona;
        this.media = media;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public double getMedia() {
        return media;
    }

    @Override
    public String toString() {
        return "Zona: " + nombreZona + " - Media: " + String.format("%.2f", media) + "°C";
    }
}
