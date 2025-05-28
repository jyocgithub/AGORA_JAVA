package patron_fachada;
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


/*
En pocas palabras, una fachada encapsula un subsistema complejo
detrás de una interfaz simple. Oculta gran parte de la complejidad
y hace que el subsistema sea fácil de usar.

Además, si necesitamos usar el subsistema complejo directamente,
aún podemos hacerlo; no estamos obligados a usar la fachada todos el tiempo.
 */


public class MainFachada {



    public static void main(String[] args) {


        // --------------------------------------------
        // SIN usar un patron FACHADA (FACADE)

        //-- arrancamos el coche
        Coche coche = new Coche();
        coche.revisarInjectores();
        coche.abrirBombasCombustible();
        coche.abrirRefrigeracion();
        coche.motor.checkeoInicial();
        coche.motor.arrancar();
        coche.motor.injector.encender();

        //-- apagar el coche
        coche.motor.injector.apagar();
        coche.motor.parar();
        coche.motor.enfriar();
        coche.cerrarBombasCombustible();
        coche.cerrarRefrigeracion();


        // --------------------------------------------
        // CON un patron FACHADA (FACADE)

        FachadaCoche coche1 = new FachadaCoche();
        //-- arrancamos el coche
        coche1.arrancarCoche();
        //-- apagar el coche
        coche1.pararCoche();

    }


}


class Coche{
    Motor motor;
    public void revisarInjectores(){}
    public void abrirRefrigeracion(){}
    public void abrirBombasCombustible(){}
    public void cerrarRefrigeracion(){}
    public void cerrarBombasCombustible(){}
}


class Motor{
    Injector injector;
    public void checkeoInicial(){}
    public void arrancar(){}
    public void enfriar(){}
    public void parar(){}
}

class Injector{
    public void encender(){}
    public void apagar(){}
}
class FachadaCoche{
    Coche coche;

    public void arrancarCoche(){
        coche = new Coche();
        coche.revisarInjectores();
        coche.abrirBombasCombustible();
        coche.abrirRefrigeracion();
        coche.motor.checkeoInicial();
        coche.motor.arrancar();
        coche.motor.injector.encender();
    }

    public void pararCoche(){
        coche.motor.injector.apagar();
        coche.motor.parar();
        coche.motor.enfriar();
        coche.cerrarBombasCombustible();
        coche.cerrarRefrigeracion();
    }

}
