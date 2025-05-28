package ej_psp_05_a_02_parking;

import java.util.concurrent.Semaphore;

public class ej_psp_05_a_02_parking {


    static Semaphore plazas = new Semaphore(10);
    static double  ingresosTotales = 0;

    public static void main(String[] args) {

        Coche[] coches = new Coche[40];

        for (int i = 0; i < coches.length; i++) {
            Coche c = new Coche(i);
            coches[i] = c;
            c.start();
        }


        for (int i = 0; i < coches.length; i++) {
            try {
                coches[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println("El parking ha ganado hoy " + (ingresosTotales/100) + " euros" );










    }

    static class Coche extends Thread {

        int numero;
        double costeEstancia;

        public Coche(int numero) {
            this.numero = numero;
        }

        public void run() {
            try {
                System.out.println("El coche " + numero + " esta llegando al parking y va a tardar un poco");

                int milisegundos = (int) (Math.random() * 5001);  // da un numero al azar entre 0 y 5000
                Thread.sleep(milisegundos);  // simulamos que esperamos circulando.... (realmente estamos dormidos)

                System.out.println("El coche " + numero + " entra en el centro comercial e intenta entrar en el parking");

                plazas.acquire(); // intento coger llave, si puedo, sigo, sino, me espero que haya una llave libre

                System.out.println("--> El coche " + numero + " entra en el parking");

                milisegundos = (int) (Math.random() * 10000 - 1000) + 1000;  // da un numero al azar entre 1000 y 10000

                Thread.sleep(milisegundos);  // simulamos que esta dentro del parking.... (realmente estamos dormidos)

                plazas.release();   // devuelvo la llave al salir !!!!!!!!!

                costeEstancia = (milisegundos * 0.2);
                ingresosTotales += costeEstancia;

                System.out.println("----------------> El coche " + numero + " sale del parking" + " dejando " + plazas.availablePermits() + " plazas libres. Paga "+ costeEstancia + " centimos");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}



