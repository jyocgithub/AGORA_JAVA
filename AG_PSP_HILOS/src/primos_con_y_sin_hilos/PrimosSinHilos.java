package primos_con_y_sin_hilos;

public class PrimosSinHilos {
    private final static int NUMERO_DESDE = 3;
    private final static int NUMERO_HASTA = 1000000;

    public static void main(String[] args) {
        long tiempoComienzo = System.currentTimeMillis();
        BuscarPrimos p = new BuscarPrimos(NUMERO_DESDE, NUMERO_HASTA);
        p.muestraPrimos();
        long tiempoFinal = System.currentTimeMillis();
        long duracion = tiempoFinal - tiempoComienzo;
        System.out.println("Ha tardado " + duracion +" milisegundos");
    }
}

class BuscarPrimos {
    private int inicio, fin;

    public BuscarPrimos(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public void muestraPrimos() {
        for (int i = inicio; i < fin; i++) {
            if (esPrimo(i)) {
                System.out.println(i);
            }
        }
    }

    private boolean esPrimo(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
