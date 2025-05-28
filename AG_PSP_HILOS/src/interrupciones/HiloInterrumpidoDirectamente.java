package interrupciones;
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

public class HiloInterrumpidoDirectamente extends Thread {
    public void run() {
        System.out.println("Estamos currando y sumando...");
        for (int i = 0; i < 2000000000; i++) {
            if (Thread.interrupted()) { //  Thread.interrupted() pone nuevamente el "interrupt status" a "Apagado"
                System.out.println("Me han interrumpido cuando iba por " + i);
                System.out.println("Pero yo sigo currando !!!");
            }
        }
        System.out.println("Acabé !!");
    }
    public static void main(String args[]) throws InterruptedException {
        HiloInterrumpidoDirectamente hf1 = new HiloInterrumpidoDirectamente();
        hf1.start();
        Thread.sleep(100);  // me espero un poco antes de interrumpir
        hf1.interrupt();
    }
}