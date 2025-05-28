package ej_psp_05_a_03_hamsters;

import java.util.concurrent.Semaphore;

public class ej_psp_05_a_03_hamsters {


    static Semaphore plato = new Semaphore(4);
    static Semaphore rueda = new Semaphore(2);

    public static void main(String[] args) {

        Hamster[] hamsters = new Hamster[20];

        for (int i = 0; i < hamsters.length; i++) {
            Hamster c = new Hamster(i);
            hamsters[i] = c;
            c.start();
        }


        for (int i = 0; i < hamsters.length; i++) {
            try {
                hamsters[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Hamster extends Thread {

        int numero;

        public Hamster(int numero) {
            this.numero = numero;
        }

        public void run() {
            try {

                System.out.println("El hamster " + numero + " intenta comer....");

                plato.acquire(); // intento coger llave, si puedo, sigo, sino, me espero que haya una llave libre
                System.out.println("--> El hamster " + numero + " empieza a comer");
                int milisegundos = (int) (Math.random() * 200) + 100;
                Thread.sleep(milisegundos);
                System.out.println("--> El hamster " + numero + " termina de comer e intenta jugar en la rueda ");
                plato.release();

                rueda.acquire(); // intento coger llave, si puedo, sigo, sino, me espero que haya una llave libre
                System.out.println("--> El hamster " + numero + " empieza a jugar en la rueda");
                milisegundos = (int) (Math.random() * 100) ;
                Thread.sleep(milisegundos);
                System.out.println("--> El hamster " + numero + " termina de jugar y se pira");
                rueda.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}



