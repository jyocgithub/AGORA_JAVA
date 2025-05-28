package ej_psp_05_a_16_clinica_perros_gatos;

import java.util.concurrent.CountDownLatch;

public class Inicio {

    public static void main(String[] args) {
        System.out.println("Abriendo clínica...");

        //Creo el objeto clinica
        Clinica cl = new Clinica();
        System.out.println("Clinica abierta, pueden pasar los pacientes.");

        try {
            //Creo los hilos y los ejecuto añadiendo countdownlatch
            CountDownLatch latch = new CountDownLatch(7);

            Thread hg1 = new HiloGato(latch, 1, cl);
            Thread hg2 = new HiloGato(latch, 2, cl); //Mayor prioridad
            hg2.setPriority(10);

            Thread hp1 = new HiloPerro(latch, 1, cl);
            Thread hp2 = new HiloPerro(latch, 2, cl);
            Thread hp3 = new HiloPerro(latch, 3, cl); //Mayor prioridad
            hp3.setPriority(10);

            Thread hp4 = new HiloPerro(latch, 4, cl);
            Thread hp5 = new HiloPerro(latch, 5, cl);

            hg1.start();
            hg2.start();

            hp1.start();
            hp2.start();
            hp3.start();
            hp4.start();
            hp5.start();

            hg1.join();
            hg2.join();
            hp1.join();
            hp2.join();
            hp3.join();
            hp4.join();
            hp5.join();
            // etc

            System.out.println("Todas las mascotas han sido salvadas.");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
