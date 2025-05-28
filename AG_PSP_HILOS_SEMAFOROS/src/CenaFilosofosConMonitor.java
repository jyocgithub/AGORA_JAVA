
import java.util.Random;
import java.util.concurrent.Semaphore;

public class CenaFilosofosConMonitor {

    public static void main(String[] args) {
        Palillos p = new Palillos();
        /*
         * Solo hay cinco palillos y cada invitado o filosofo necesita dos palillos para
         * comer
         */
        Semaphore[] palillos = new Semaphore[5];
        for (int i = 0; i < palillos.length; i++) {
            palillos[i] = new Semaphore(1, true);
        }
        /*
         * Por ejemplo; Josechu es la opción a y la posicion derecha es la cinco y
         * posición izquiera es la seis, por lo tanto, tendrá que conseguir el palillos
         * 4 (5) y 0 (1)
         */
        Filosofo in1 = new Filosofo("Josechu", 5, 1, palillos[4], palillos[0]);
        Filosofo in2 = new Filosofo("Patxi", 1, 2, palillos[0], palillos[1]);
        Filosofo in3 = new Filosofo("Iñaki", 2, 3, palillos[1], palillos[2]);
        Filosofo in4 = new Filosofo("Antxon", 3, 4, palillos[2], palillos[3]);
        Filosofo in5 = new Filosofo("Paquito", 4, 5, palillos[3], palillos[4]);

        in1.start();
        in2.start();
        in3.start();
        in4.start();
        in5.start();

    }
}

class Filosofo extends Thread {
    Semaphore palilloDerecha;
    Semaphore palilloIzquierda;
    String invitado;
    int posDerecha = -1;
    int posIzquierda = -1;
    Palillos palillos = new Palillos();
    boolean pensando = false;
    Random azar = new Random();

    public Filosofo(String invitado, int posDerecha, int posIzquierda, Semaphore palilloDerecha,
                    Semaphore palilloIzquierda) {
        this.invitado = invitado;
        this.posDerecha = posDerecha;
        this.posIzquierda = posIzquierda;
        this.palillos.palilloDerecha = palilloDerecha;
        this.palillos.palilloIzquierda = palilloIzquierda;
    }

    public void run() {
        int milisegundoPensando = azar.nextInt(1800);
        int milisegundoComiendo = azar.nextInt(1200);
        while (!palillos.getPensando()) {
            try {
                System.out.println(invitado + " meditando...");
                Thread.sleep(milisegundoPensando);

                System.out.println(invitado + " queda parado a que pueda coger el palillo " + posDerecha);
                palillos.palilloDerecha.acquire();

                System.out.println(invitado + " tiene el palillo " + posDerecha);

                System.out.println(invitado + " va a intentar coger el palillo " + posIzquierda + " pero no esperará si no esta libre");
                if (palillos.palilloIzquierda.tryAcquire()) {
                    // HA PODIDO COGERLO !!!
                    System.out.println("    " + invitado + " tiene palillos " + posDerecha + " y " + posIzquierda + " y ahora está comiendo");
                    Thread.sleep(milisegundoComiendo);

                    System.out.println(invitado + " acaba de comer y deja los dos palillos libres ");
                    palillos.palilloDerecha.release();
                    palillos.palilloIzquierda.release();

                } else {
                    // NO HA PODIDO COGER EL SEFGUNDO PALILLO
                    System.out.println(invitado + " no ha podido coger el palillo " + posIzquierda + ", aqi que suelta el que tiene (el " + posDerecha + ") y se va a pensar...");
                    palillos.palilloDerecha.release();
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Palillos {
    Semaphore palilloDerecha;
    Semaphore palilloIzquierda;
    boolean pensando = false;

    public boolean getPensando() {
        return pensando;
    }

    public void dejarPalillos() {
        palilloDerecha.release();
        palilloIzquierda.release();
    }

    public void tiempoEspera() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
