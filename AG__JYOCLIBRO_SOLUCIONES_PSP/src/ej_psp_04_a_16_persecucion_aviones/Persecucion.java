package ej_psp_4_a_16_persecucion_aviones;


import java.util.Random;

public class Persecucion {
    public static void main(String[] args) {

        Monitor mon = new Monitor();
        Thread av1 = new Thread(new Avion1(1, mon));
        Thread av2 = new Thread(new Avion2(2, mon));
        av1.start();
        av2.start();
    }

}


class Avion1 implements Runnable {

    int numeroavion;
    Monitor monitor;

    public Avion1(int numeroavion, Monitor monitor) {
        this.numeroavion = numeroavion;
        this.monitor = monitor;
    }

    public void run() {

        while (true) {
            monitor.mueve1();
        }


    }
}

class Avion2 implements Runnable {

    int numeroavion;
    Monitor monitor;

    public Avion2(int numeroavion, Monitor monitor) {
        this.numeroavion = numeroavion;
        this.monitor = monitor;
    }

    public void run() {

        while (true) {
            monitor.mueve2();
        }
    }
}

class Monitor {
    String[] direcciones = {"NORTE", "SUR", "ESTE", "OESTE"};
    Random azar = new Random();
    String direccion1 = "NORTE";
    int altura1 = 100;
    String direccion2 = "NORTE";
    int altura2 = 100;
    int turno = 1;

    public synchronized void mueve1() {

        while (turno != 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int num = azar.nextInt(4);
        direccion1 = direcciones[num];
        altura1 = azar.nextInt(1000) + 100;
        System.out.println("  Avion 1 propone direccion  " + direccion1);
        System.out.println("  Avion 1 propone altura  " + altura1);

        try {
            Thread.sleep(azar.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        turno = 2;
        notifyAll();

    }

    public synchronized void mueve2() {

        while (turno != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (direccion2 != direccion1) {
            direccion2 = direccion1;
            System.out.println("Avion 2 cambia de direccion, ahora es " + direccion2);
            if (altura2 != altura1) {
                altura2 = altura1 - 10;
                System.out.println("Avion 2 cambia de altura, ahora es " + altura2);
            }
        }

        try {
            Thread.sleep(azar.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        turno = 1;
        notifyAll();

    }


}