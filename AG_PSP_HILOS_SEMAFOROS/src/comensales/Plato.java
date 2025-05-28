package comensales;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Plato {

    private static int contador = 0;

    private int idPlato;
    private int disponible;
    private Semaphore tenedor;

    public Plato(int inicial) {
        idPlato = ++contador;
        disponible = inicial;
        tenedor = new Semaphore(1);
    }

    public boolean comer(Comensal comensal) throws InterruptedException {
        boolean haComido = false;
        if (!vacio() && tenedor.tryAcquire()) {
            // Come
            System.err.println(comensal + " come del plato " + idPlato + ".");
            Thread.sleep((new Random()).nextInt(1000) + 300);
            disponible--;

            // Libera
            System.err.print("\t\t\t\t\t\t");
            System.err.println(comensal + " libera el plato " + idPlato + ".");
            tenedor.release();
            haComido = true;
        }
        return haComido;
    }

    public boolean vacio() {
        return disponible == 0;
    }

}
