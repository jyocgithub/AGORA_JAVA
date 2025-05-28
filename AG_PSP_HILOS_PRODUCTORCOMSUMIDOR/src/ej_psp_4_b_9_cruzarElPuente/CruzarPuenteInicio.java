package ej_psp_4_b_9_cruzarElPuente;
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

import java.util.ArrayList;
import java.util.Random;

public class CruzarPuenteInicio {

    public static void main(String[] args) {
        Random random = new Random();

        Puente puente = new Puente();
        for (int i = 0; i < 20; i++) {
            int direccion = random.nextInt(2);
            HiloCoche h = new HiloCoche("("+direccion+")-" + i , puente, direccion);
            h.start();
        }


    }


}


class HiloCoche extends Thread {
    String nombre;
    Puente puente;
    int sentido;

    public HiloCoche(String nombre, Puente puente, int sentido) {
        this.nombre = nombre;
        this.puente = puente;
        this.sentido = sentido;
    }

    private Random random = new Random();
    public void run() {
        try {
            Thread.sleep(random.nextInt(4000) + 200 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        puente.llegar(nombre, sentido);
        puente.cruzar(nombre, sentido);
        puente.salir(nombre, sentido);
    }

}

class Puente {
    private Random random = new Random();
    public static final int SENTIDO_DERECHA = 0;
    public static final int SENTIDO_IZQUIERDA = 1;

    private ArrayList<String> cochesEnElPuente = new ArrayList<>();

    public synchronized void llegar(String nombre, int sentido) {
        int sentidoContrario = sentido == 0 ? 1 : 0;
        boolean hayContrarios = cochesEnElPuente.contains(sentidoContrario + "");
        boolean hayMuchoscoches  = cochesEnElPuente.size() > 2;
//        System.out.println("    " +nombre + " intenta entrar en el puente ");
        while (hayContrarios || hayMuchoscoches) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hayContrarios = cochesEnElPuente.contains(sentidoContrario + "");
            hayMuchoscoches  = cochesEnElPuente.size() > 2;
        }
        cochesEnElPuente.add(sentido + "");
        System.out.println(nombre + " entró en el puente       PUENTE:" + cochesEnElPuente.toString());
    }

    public  void cruzar(String nombre, int sentido) {
        try {
            Thread.sleep( 200 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized  void salir(String nombre, int sentido) {

        cochesEnElPuente.remove(sentido + "");
        System.out.println( nombre + " SALE DEL PUENTE          PUENTE:" + cochesEnElPuente.toString());
        notifyAll();

    }

}
