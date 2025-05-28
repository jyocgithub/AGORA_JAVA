package A3_Exchanger;
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
import java.util.concurrent.Exchanger;


/*
Un objeto Exchanger permite intercambiar información entre dos hilos.
Lo de un hilo A pasa al hilo B, y viceversa
Los dos hilos comparten un objeto Exchanger.
Cuando un hilo quiere intercambiar información, llama al método exchange() del objeto,
pasándole la información que él expone hacia el otro hilo.
Cuando el otro hilo hace lo mismo, se produce el intercambio de datos.
El método exchange() devuelve, en cada hilo, la información que recibe del otro hilo

 */




public class ExchangerDeConsumidorProductor {

    public static void main(String args[]) throws InterruptedException {
        int tamano = 3;
        Exchanger<ArrayList> ex = new Exchanger();
        ArrayList<String> bufferDelProductor = new ArrayList<>();
        ArrayList<String> bufferDelConsumidor = new ArrayList<>();
        Productor pro = new Productor(bufferDelProductor, ex, tamano);
        Consumidor cons = new Consumidor(bufferDelConsumidor, ex);
        pro.start();  cons.start();
    }



}


class Productor extends Thread {
    private int tamano;
    private Exchanger<ArrayList> ex;
    private ArrayList<String> bufferDelProductor;
    public Productor(ArrayList<String> bufferDelProductor, Exchanger ex, int tamano) {
        this.bufferDelProductor = bufferDelProductor;
        this.ex = ex;
        this.tamano = tamano;
    }
    public void run() {
        int contador = 0;
        try {
            while (true) {
                contador++;
                System.out.println("  P: meto " + contador);  // Insertar nuevo elemento en el buffer
                bufferDelProductor.add("Elemento " + (contador));
                if (bufferDelProductor.size() == tamano) {   // Mirar si el buffer está lleno
                    // Cuando el buffer está lleno, queda pendiente de que le llamen para intercambiar
                    System.out.println("P: a la espera de intercambio." );
                    bufferDelProductor = ex.exchange(bufferDelProductor);
                    System.out.println("P: hecho, tengo " + bufferDelProductor.size() + " elementos");
                }
                Thread.sleep(new Random().nextInt(1000) + 1000);
            }
        } catch (InterruptedException ex) { }
    }
}

class Consumidor extends Thread {
    Exchanger<ArrayList> ex;
    ArrayList<String> bufferDelConsumidor;

    public Consumidor(ArrayList<String> bufferDelConsumidor, Exchanger ex) {
        this.bufferDelConsumidor = bufferDelConsumidor;
        this.ex = ex;
    }

    public void run() {
        try {
            while (true) {
                if (bufferDelConsumidor.size() > 0) {
                    // Sacar elemento del buffer
                    System.out.println("  C: saco" + bufferDelConsumidor.remove(0));
                } else {
                    // Cuando el buffer está lleno, queda pendiente de que le llamen para intercambiar
                    System.out.println("C: a la espera de intercambio." );
                    bufferDelConsumidor = ex.exchange(bufferDelConsumidor);
                    System.out.println("C: Hecho, tengo " + bufferDelConsumidor.size() + " elementos");
                }
                Thread.sleep(new Random().nextInt(1000) + 100);
            }
        } catch (InterruptedException ex) { }
    }
}