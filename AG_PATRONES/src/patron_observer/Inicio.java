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

public class Inicio {

    public static void main(String[] args) {
        new Inicio();
    }

    public Inicio() {

        ClaseObservadora cotilla1 = new ClaseObservadora();

        ProductoVigilado objetoProductoQueSeEstaVigilando = new ProductoVigilado("LAPIZ", 12);
        objetoProductoQueSeEstaVigilando.addObserver(cotilla1);
        objetoProductoQueSeEstaVigilando.setPrecio(12);
        objetoProductoQueSeEstaVigilando.enRebajas(5);

        // en este caso, el observador no se añade con addObserver, sino en el propio constructor
        FabricaVigilada objetoFabricaQueSeEstaVigilando = new FabricaVigilada( 1000,cotilla1);
        objetoFabricaQueSeEstaVigilando.setStock(1100);




    }


}
