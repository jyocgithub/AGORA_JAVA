package patron_observer;
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

import java.util.Observable;
import java.util.Observer;

public class ProductoVigilado extends Observable {
    private String nombre;
    private int precio;

    private Observer observer;

    public ProductoVigilado(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }



    @Override
    public void addObserver(Observer observer) {
        this.observer = observer;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
        notifyObservers("Producto-Cambio de precio");
    }

    public void enRebajas(int porcentaje) {
        this.precio = precio - (precio / 100 * porcentaje);
        notifyObservers("Producto-En rebajas");
    }

    @Override
    public void notifyObservers(Object opcion) {
        if (observer != null) {
            String opcionstring = (String) opcion;
            observer.update(this, opcionstring);
        }
    }


}
