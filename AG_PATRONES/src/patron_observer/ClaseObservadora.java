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

public class ClaseObservadora implements Observer {


    public ClaseObservadora() {

    }
    private String nombre;
    // Método que se ejecuta cuando se producen cambios
    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("Producto-Cambio de precio")) {
            System.out.println("Soy el cotilla, y ya se que el producto ha cambiado de precio!! ");
            ProductoVigilado pp = (ProductoVigilado)o;
            System.out.println("y el nuevo precio es …"+pp.getPrecio());
        }
        if (arg.equals("Producto-En rebajas")) {
            System.out.println("Soy el cotilla, y ya se que el producto ha entrado en rebajas ");
        }

        if (arg.equals("Fabrica-Cambio de stock")) {
            System.out.println("Soy el cotilla, y ya se que en la fabrica se ha cambiado el stock !! ");
            FabricaVigilada cof = (FabricaVigilada)o;
            System.out.println("y el nuevo stock es …"+cof.getStock());
        }
    }


}
