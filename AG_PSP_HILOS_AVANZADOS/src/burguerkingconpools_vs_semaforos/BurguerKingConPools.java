package burguerkingconpools_vs_semaforos;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BurguerKingConPools {
    public static void main(String[] args) {
        BurgerKingPool bg = new BurgerKingPool();
        ExecutorService piscina = Executors.newFixedThreadPool(10);
        ArrayList<CocheComilonPool> coches = new ArrayList<>();
        long tiempoInicio = System.currentTimeMillis();
        for (int i = 0; i < 30; i++) {
            CocheComilonPool c = new CocheComilonPool(i + 1, bg);
            coches.add(c);
        }
        try {
            piscina.invokeAll(coches);
        } catch (InterruptedException ex) {
        }
        long tiempoFinal = System.currentTimeMillis();
        long tiempoTotal = tiempoFinal - tiempoInicio;
        System.out.println("La ejecucion del programa ha sido: " + tiempoTotal + " Milisegundos.");
        piscina.shutdown();
    }
}
 class CocheComilonPool implements Callable<Boolean> {
    private int id;
    private BurgerKingPool bg;
    public CocheComilonPool(int id, BurgerKingPool bg) {
        this.id = id;
        this.bg = bg;
    }
    public int getIdCoche() {
        return id;
    }
    public Boolean call() {
        bg.acceder(this);
        try {
            Thread.sleep(new Random().nextInt(2000));
            bg.salir(this);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

class BurgerKingPool {
    public void acceder(CocheComilonPool coche) {
        System.out.println("Acaba de entrar el coche: " + coche.getIdCoche());
    }

    public void salir(CocheComilonPool coche) {
        System.out.println("Acaba de salir el coche: " + coche.getIdCoche());
    }
}
