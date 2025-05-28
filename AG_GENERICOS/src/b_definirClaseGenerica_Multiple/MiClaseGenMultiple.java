package b_definirClaseGenerica_Multiple;
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

public class MiClaseGenMultiple<T,N,S> {    // Estas t,n,s indican que luego al crear objetos se dirá qué tipo de dato es T, N y S
    private T informacion;          // Ese tipo de dato T será el que tendrá mi atributo “informacion”
    private N origen;               // Ese tipo de dato T será el que tendrá mi atributo “origen”
    private S destino;              // Ese tipo de dato T será el que tendrá mi atributo “destino”

    // Los parámetroa del constructor seran, claro, de tipo T, N y S
    public MiClaseGenMultiple(T informacion, N origen, S destino) {
        this.informacion = informacion;
        this.origen = origen;
        this.destino = destino;
    }

    public T getInformacion() {
        return informacion;
    }

    public void setInformacion(T informacion) {
        this.informacion = informacion;
    }

    public N getOrigen() {
        return origen;
    }

    public void setOrigen(N origen) {
        this.origen = origen;
    }

    public S getDestino() {
        return destino;
    }

    public void setDestino(S destino) {
        this.destino = destino;
    }
}

