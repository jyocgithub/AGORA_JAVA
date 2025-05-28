package A1_Barriers_Barreras;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
Ejemplo de uso de CyclycBarrier: se usa en el main para esperar el finalizar de todos los hilos,
antes de continuar su propia ejecución (como se puede hacer normalmente con varios join() )
 */

public class EsperarEnMainConBarriers {
    public static void main(String args[]) {
        new EsperarEnMainConBarriers();
    }


    public EsperarEnMainConBarriers() {
        CyclicBarrier barrera = new CyclicBarrier(5);  // ponemos 5 pues hay que esperar a los 4 hilos y al propio main
        Hilo t = null;


        Hilo[] hilos = new Hilo[4];

        for (int i = 0; i < 4; i++) {
            t = new Hilo(i, barrera);
            t.start();
            hilos[i] = t;
        }

        try {
            barrera.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("FIN");
    }
}


class Hilo extends Thread {
    CyclicBarrier barrera;
    private int num;

    public Hilo(int num, CyclicBarrier barrera) {
        this.num = num;
        this.barrera = barrera;
    }

    public void run() {
        try {
            System.out.println("El hilo " + num + " arranca y espera");
            Thread.sleep(new Random().nextInt(1000) + 1000);
            System.out.println("El hilo " + num + " acabo");
            barrera.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}