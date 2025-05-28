package ej_psp_4_a_17_cada_hilo_su_numero;


import java.util.ArrayList;
import java.util.Random;

public class Inicio {


    public static void main(String[] args) {

        Monitor monitor = new Monitor();
        monitor.rellenarArraylist();

        for (int i = 0; i < 5; i++) {
            Hilo pr = new Hilo(i, monitor);
            pr.start();
        }

        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            monitor.rellenarArraylist();
            monitor.liberar();
        }
    }


}

 class Hilo extends Thread {
    int numero;
    Monitor monitor;

    public Hilo(int numero, Monitor monitor) {
        super();
        this.numero = numero;
        this.monitor = monitor;
    }

    public void run() {

        int num = monitor.cogerNumero();
        System.out.println("Soy el hilo " + numero + " y he cogido el " + num);
        monitor.esperar();

        num = monitor.cogerNumero();
        System.out.println("Soy el hilo " + numero + " y he cogido el " + num);
        monitor.esperar();

        num = monitor.cogerNumero();
        System.out.println("Soy el hilo " + numero + " y he cogido el " + num);

        System.out.println("HILO " + numero + " FIN");

    }
}
class Monitor {

    ArrayList<Integer> numeros = new ArrayList<Integer>();

    public synchronized void rellenarArraylist() {
        Random rn = new Random();

        for (int i = 0; i < 5; i++) {
            numeros.add(rn.nextInt(20) + 1);
        }

        System.out.println("Se ha rellenado con 5 nuevos numeros");
    }


    public synchronized int cogerNumero() {
        int n = numeros.get(0);
        numeros.remove(0);
        return n;

    }

    public synchronized void esperar() {
        try {
            wait();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public synchronized void liberar() {
        notifyAll();
    }

}

