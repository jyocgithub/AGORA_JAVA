package primos_con_y_sin_hilos;

public class PrimosConHilos {
    private final static int NUM = 1000000;

    public static void main(String[] args) {

        // creamos 5 hilos y repartimos el millon a buscar en 5 tramos
        BuscarPrimosHilo b1 = new BuscarPrimosHilo(1, 200000);
        BuscarPrimosHilo b2 = new BuscarPrimosHilo(200001, 400000);
        BuscarPrimosHilo b3 = new BuscarPrimosHilo(400001, 600000);
        BuscarPrimosHilo b4 = new BuscarPrimosHilo(600001, 700000);
        BuscarPrimosHilo b5 = new BuscarPrimosHilo(800001, 1000000);
        b1.start();
        b2.start();
        b3.start();
        b4.start();
        b5.start();



//		Runtime r = Runtime.getRuntime();
//		int cores = r.availableProcessors();
//		System.out.println("Numero de cores: " + cores);
//
//		int rango = Math.round(NUM / (float) cores);
//
//		System.out.println("Rango de numeros: " + rango);
//
//		BuscarPrimosHilo[] p = new BuscarPrimosHilo[cores];
//
//		int inicioRango = 1;
//		int finRango = rango;
//
//		for (int i = 0; i < cores; i++)	{
//			p[i] = new BuscarPrimosHilo(inicioRango, finRango);
//
//			inicioRango += rango;
//			finRango += rango;
//
//			p[i].start();
//		}
    }
}


class BuscarPrimosHilo extends Thread {
    private int inicio, fin;

    public BuscarPrimosHilo(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        muestraPrimos();
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

