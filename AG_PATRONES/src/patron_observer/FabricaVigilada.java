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

public class FabricaVigilada extends Observable {

    private int stock;

    private Observer observer;

    public FabricaVigilada(int stock, Observer observer) {
        this.stock = stock;
        this.observer = observer;
    }

    @Override
    public void addObserver(Observer observer) {
        this.observer = observer;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        notifyObservers("Fabrica-Cambio de stock");
    }

    @Override
    public void notifyObservers(Object opcion) {
        if (observer != null) {
            String opcionstring = (String) opcion;
            observer.update(this, opcionstring);
        }
    }


}
