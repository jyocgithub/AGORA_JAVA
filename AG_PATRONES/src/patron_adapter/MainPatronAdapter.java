package patron_adapter;
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

// El patrón Adapter actúa como envoltorio entre dos objetos.
// Atrapa las llamadas a un objeto y las transforma a un formato y una
// interfaz reconocible para el segundo objeto.
// Adapter es un patrón de diseño estructural.
// Se utiliza cuando tenemos dos elementos de una aplicación
// los cuales necesitamos que trabajen juntos,
// pero sus interfaces de comunicación no son compatibles.
// Para esos casos creamos una clase intermedia que facilita la comunicación
// entre ambas. Así, Adapter servirá como puente entre ambos elementos.

interface Conexiones{
    void encender();
    void apagar();
    boolean estaEncendida();
}

class LamparaEuropea implements Conexiones {
    private boolean encendida;

    public boolean estaEncendida() {
        return encendida;
    }

    public void encender() {
        encendida=true;
    }
    public void apagar() {
        encendida=false;
    }
}

// no tiene los mismos métodos que la lampara europea.. aunque hace lo mismo !
class LampYankee{
    private boolean isOn;

    public boolean isOn() {
        return isOn;
    }
    public void on () {
        isOn=true;
    }

    public void off() {
        isOn=false;
    }
}

// asi que creamos y usamos el adaptador
 class AdaptadorLampara implements Conexiones{
    private LampYankee lampara= new LampYankee();
    public boolean estaEncendida() {
        return lampara.isOn();
    }
    public void encender() {
        lampara.on();
    }
    public void apagar() {
        lampara.off();
    }
}

// y ahora finalmente, creamos lamparas europeas con la clase LamparaEuropea,
// pero creamos lamparas yankees con el adaptador !!!!!!!!
public class MainPatronAdapter {
    public static void main(String[] args) {

        // esto va bien, normal....
        LamparaEuropea le1= new LamparaEuropea();
        le1.encender();
        System.out.println(le1.estaEncendida());

        // esto, claro, NO VA
//        LampYankee ly1= new LampYankee();
//        ly1.encender();
//        System.out.println(ly1.estaEncendida());

        // pero esto SI VA !!!
        AdaptadorLampara ly1= new AdaptadorLampara();
        ly1.encender();
        System.out.println(ly1.estaEncendida());

    }
}