package A1_Barriers_Barreras;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
Ejemplo de uso de CyclicBarrier: cuatro jugadores van a jugar al mus, pero no pueden
comenzar si no estan los cuatro en la mesa

 */
public class JugarAlMusConBarrera {
    public static void main(String args[]) {
        CyclicBarrier barrera = new CyclicBarrier(4);
        for (int i = 1; i <= 4; i++) {
            Musero t = new Musero(i, barrera);
            t.start();
        }
    }
}

class Musero extends Thread {
    private CyclicBarrier barrera;
    private int num;
    public Musero(int num, CyclicBarrier barrera) {
        this.num = num;
        this.barrera = barrera;
    }
    public void run() {
        try {
            System.out.println("El jugador " + num + " se va hacia la mesa para jugar");
            Thread.sleep(new Random().nextInt(1000)+1000);
            System.out.println("El jugador " + num + " esta ya esperando en la mesa");
            this.barrera.await();
            System.out.println("Ya estan todos: El jugador " + num + " se presenta a los demas");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("Error en la barrera");
        }
    }
}