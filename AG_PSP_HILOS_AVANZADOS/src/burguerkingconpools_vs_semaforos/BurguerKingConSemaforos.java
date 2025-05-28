package burguerkingconpools_vs_semaforos;


import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;

public class BurguerKingConSemaforos {

    public static void main(String[] args) throws InterruptedException {
        BurgerKing bg = new BurgerKing();
        ArrayList<Thread> coches = new ArrayList<>();
        long tiempoInicio = System.currentTimeMillis();

        for (int i = 0; i < 30; i++) {
            CocheComilon c = new CocheComilon(i + 1, bg);
            Thread th = new Thread(c);
            coches.add(th);
            coches.get(i).start();
        }
        for (int i = 0; i < 30; i++) {
            coches.get(i).join();
        }

        long tiempoFinal = System.currentTimeMillis();
        long tiempoTotal = tiempoFinal - tiempoInicio;
        System.out.println("La ejecucion del programa ha sido: " + tiempoTotal + " Milisegundos.");

    }

}

class CocheComilon implements Runnable {
    private int id;
    private BurgerKing bg;

    public CocheComilon(int id, BurgerKing bg) {
        this.id = id;
        this.bg = bg;
    }

    public int getIdCoche() {
        return id;
    }

    public void run() {
        bg.acceder(this);
        try {
            Thread.sleep(new Random().nextInt(2000));
            bg.salir(this);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}


class BurgerKing {
    private Semaphore almacen;
    public BurgerKing() {
        almacen = new Semaphore(10, true);
    }

    public void acceder(CocheComilon coche) {
        try {
            almacen.acquire();
            System.out.println("Acaba de entrar el coche: " + coche.getIdCoche());

        } catch (InterruptedException ex) {
        }
    }

    public void salir(CocheComilon coche) {
        almacen.release();
        System.out.println("Acaba de salir el coche: " + coche.getIdCoche());
    }
}
