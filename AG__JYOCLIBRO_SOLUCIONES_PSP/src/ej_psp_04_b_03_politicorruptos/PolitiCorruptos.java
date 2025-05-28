package ej_psp_04_b_03_politicorruptos;

import java.util.Random;

public class PolitiCorruptos {

    public static void main(String[] args) {

        Ventanilla ventana = new Ventanilla();
        Banco bnc = new Banco("ChungoBank", ventana);
        bnc.start();
        for (int i = 0; i < 10; i++) {
            Politico plc = new Politico("Politico " + i, ventana);
            plc.start();
        }
    }
}



class Ventanilla {

    int cantidadDineroCaja = 30000000;

    int cantidadVentanilla = 0;

    Random rn = new Random();

    public synchronized void pasarDeCajaAVentanilla() {
        while(cantidadVentanilla>0) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        cantidadVentanilla = rn.nextInt(4000001) + 1000000;
        if (cantidadVentanilla > cantidadDineroCaja) {
            cantidadVentanilla = cantidadDineroCaja;
        }
        cantidadDineroCaja = cantidadDineroCaja - cantidadVentanilla;

        System.out.println("\nSoy el BANCO y paso a la ventanilla  " + cantidadVentanilla);
        System.out.println("Dejo en caja  " + cantidadDineroCaja);

        notifyAll();

    }



    public synchronized int  cogerElDineroDeLaVentanilla(String nombre) {

        while(cantidadVentanilla==0) {
            try {

                if(cantidadDineroCaja<=0) {
                    return 0;
                }

                wait();

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        int robado = cantidadVentanilla;
        System.out.println("Soy " + nombre + " y me llevo la pasta, " + robado);

        cantidadVentanilla = 0;

        notifyAll();

        return robado;
    }

}


class Politico extends Thread{

    String nombre;
    Ventanilla ventanilla;
    int contador = 0;

    public Politico(String nombre, Ventanilla ventanilla) {
        super();
        this.nombre = nombre;
        this.ventanilla = ventanilla;
    }

    public void run() {

        boolean seguir = true;

        while (ventanilla.cantidadDineroCaja>0) {

            int robado = ventanilla.cogerElDineroDeLaVentanilla(nombre);
            contador += robado;

        }

        System.out.println("Me piro..... Soy el politicorrupto " + nombre + " y he robado en total " + contador);

    }

}



 class Banco extends Thread{

    String nombre;
    Ventanilla vent;


    public Banco(String nombre, Ventanilla vent) {
        super();
        this.nombre = nombre;
        this.vent = vent;
    }

    public void run() {
        boolean seguir = true;

        while (vent.cantidadDineroCaja>0) {

            vent.pasarDeCajaAVentanilla();


        }

        System.out.println("El banco ha quedao sin dinero !!!!!!!!!!!!!!!!!!!!!!!!!!");

    }

}

