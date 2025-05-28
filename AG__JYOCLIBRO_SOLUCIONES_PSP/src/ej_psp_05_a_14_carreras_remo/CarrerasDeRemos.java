package ej_psp_5_a_14_carreras_remo;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CarrerasDeRemos {
    public static void main(String[] args) {
        CosasCompartidas cosas = new CosasCompartidas();
        System.out.println("Arranca la carrera !!!");
        for (int i = 0; i < 10; i++) {
            Equipo eq = new Equipo("Equipo " + i, cosas);
            eq.start();
        }
    }
}

class Equipo extends Thread {
    String equipo;
    CosasCompartidas cosas;

    public Equipo(String equipo, CosasCompartidas cosas) {
        this.equipo = equipo;
        this.cosas = cosas;
    }

    public void run() {
        Random azar = new Random();
        int tiempo = azar.nextInt(1000 - 100 + 1) + 100;
        try {
            Thread.sleep(tiempo);
            cosas.bandera.acquire();// Equipo x ha cogido la bandera

            cosas.cuantosHanLlegado++;

            if (cosas.cuantosHanLlegado == 1) {
                System.out.println("Somos el equipo " + equipo + " y hemos ganado !!!");
            } else {
                System.out.println("Somos el equipo " + equipo + ", alguien ha llegado antes al banderín, hemos llegado en el puesto " + cosas.cuantosHanLlegado + "... hemos perdido");
            }
            cosas.bandera.release();// Equipo x ha soltado la bandera
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}

class CosasCompartidas {
    Semaphore bandera = new Semaphore(1);
    int cuantosHanLlegado = 0;
}
