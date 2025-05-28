package ej_psp_5_a_4_cena_filosofos_con_semaforos;

import java.util.concurrent.Semaphore;

public class CenaFilosofosSemaforos {
    public static void main(String args[]) {
        System.out.println("Cena de los Filosofos");
        Cena cena = new Cena();
        for (int i = 0; i < 5; i++) {
            Filosofo pensante = new Filosofo(i, cena);
        }
    }

}

/////////////clase principal
class Cena {

    Tenedor tenedores[];
    int parametro = 5;         //numero de filosofos y tenedores

    //constructor cena
    public Cena() {
        tenedores = new Tenedor[parametro];
        for (int i = 0; i < 5; i++) {
            tenedores[i] = new Tenedor(i);
        }
    }

    public Tenedor getTenedor(int x) {

        return tenedores[x];
    }

    public int getTenedorDer(int x) {

        return (x + 1) % parametro;
    }

    public int getTenedorIzq(int x) {

        return x;
    }

}

///////////////////////clase Tenedor

class Tenedor {

    int numero;
    Semaphore semaforoTenedor;

    public Tenedor(int x) {
        numero = x;
        semaforoTenedor = new Semaphore(1);
    }

    synchronized public boolean coger() { // synchronized : para no usar este metodo simultaneamente
        if (semaforoTenedor.tryAcquire()) {
            System.out.println("Se esta usando el STenedor " + numero);
            return true;
        }
        System.out.println("STenedor " + numero + " esta en uso, a esperar");
        return false;
    }

    synchronized public void dejar() {
        semaforoTenedor.release();
        System.out.println("STenedor " + numero + " esta ahora disponible");
    }

}

////////////////////// clase Filosofo
class Filosofo implements Runnable {

    private Thread hilo;
    protected Cena cena;
    protected int tizq, tder;
    protected int numero;
    protected int numerocomidas= 0;

    public Filosofo(int x, Cena cena) {
        this.numero = x;
        this.cena = cena;
        tizq = cena.getTenedorIzq(numero);
        tder = cena.getTenedorDer(numero);
        hilo = new Thread(this);
        hilo.start();
    }

    public void pensar() {
        try {
            System.out.println("Filosofo " + numero + " pensando");
            int espera = (int) (Math.random() * 1000) +1000;
            hilo.sleep(espera);
            System.out.println("Filosofo " + numero + " tiene hambre");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tomarTenedores() {
        System.out.println("Filosofo " + numero +" intenta coger STenedores...");
        Tenedor t1 = cena.getTenedor(tizq);
        Tenedor t2 = cena.getTenedor(tder);
        if (t1.coger()) {
            if (t2.coger()) {
                comer();
                t1.dejar();
                t2.dejar();
            } else {
                t1.dejar();
            }
        }
    }

    public void comer() {
        try {
            System.out.println("   ---- >>>> Filosofo " + numero + " esta comiendo !!");
            numerocomidas++;
            int espera = (int) (Math.random() * 2000) + 2000;
            hilo.sleep(espera);
            System.out.println("Filosofo " + numero + " esta satisfecho");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//
//    protected void dejarTenedores() {
//        System.out.println("Soltando los STenedores.");
//        Tenedor t1 = cena.getTenedor(tizq);
//        Tenedor t2 = cena.getTenedor(tder);
//        t1.dejar();
//        t2.dejar();
//    }

    public void run() {
        while (numerocomidas<=3) {
            pensar();
            tomarTenedores();
//            dejarTenedores();
        }
            System.out.println("   ---------- >>>> Filosofo " + numero + " SE LEVANTA DE LA MESA!!");
    }
}
