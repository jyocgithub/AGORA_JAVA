package ej_psp_5_a_1_la_barberia_version1;


import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class LaBarberia {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner ca = new Scanner(System.in);
        System.out.println("Numero de clientes ");
        int numero = in.nextInt();
        Semaphore silla = new Semaphore(1, true);
        for (int i = 1; i <=numero; i++) {
            Cliente c = new Cliente( "cliente "+i, silla);
            c.start();
        }
    }
}

class Cliente extends Thread{

    String nombre;
    Semaphore silla;

    public Cliente(String nombre, Semaphore silla) {
        this.nombre = nombre;
        this.silla = silla;
    }

    public void run() {

        Random azar = new Random();

        // cada cliente hace lo suyo.....
        // --- da vueltas por la calle
        try {
            System.out.println("El "+nombre+" esta paseando");
            int tiempo = azar.nextInt(1000-100+1)  + 100;      // entre 100 y 1000
            Thread.sleep(tiempo);
            System.out.println("El "+nombre+" entra en la barberia");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // --- entra a ver si se corta el pelo
        try {
            silla.acquire();
            System.out.println("El "+nombre+" tiene el turno para cortar el pelo");
            int tiempo2 = azar.nextInt(800-300+1)+300   ;//entre 300 y 800
            Thread.sleep(tiempo2);
            System.out.println("El "+nombre+" ha terminado de cortar el pelo");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // --- paga y se va
        silla.release();
        System.out.println("El "+nombre+" paga y se va");
    }
}

