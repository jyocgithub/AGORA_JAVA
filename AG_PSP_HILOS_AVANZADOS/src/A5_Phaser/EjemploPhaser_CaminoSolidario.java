package A5_Phaser;
/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */

import java.util.Random;
import java.util.concurrent.Phaser;

public class EjemploPhaser_CaminoSolidario {

    String[] etapas = {"Salamanca", "Leon", "Santiago"};

    public static void main(String[] args) {
        new EjemploPhaser_CaminoSolidario();
    }

    public EjemploPhaser_CaminoSolidario() {
        int currentPhase;
        Phaser phaser = new Phaser();
        // el hilo principal tambien se registra en el phaser..
        // es uno mas a esperar a los demas, el que indica como van las cosas
        phaser.register();

        System.out.println("Vamos allá...");

        new MyThread(phaser, "Hilo 1");
        new MyThread(phaser, "Hilo 2");
        new MyThread(phaser, "Hilo 3");

        currentPhase = phaser.getPhase();
        // Wait for all threads to complete phase.
        phaser.arriveAndAwaitAdvance();
        System.out.println("Fase " + currentPhase + " acabada, hemos llegado todos a " + etapas[currentPhase]);

        currentPhase = phaser.getPhase();
        // espero, como una barrera, a que lleguen todos lo que se hayan registrado en el phaser
        phaser.arriveAndAwaitAdvance();
        System.out.println("Fase " + currentPhase + " acabada, hemos llegado todos a " + etapas[currentPhase]);

        currentPhase = phaser.getPhase();
        // espero, como una barrera, a que lleguen todos lo que se hayan registrado en el phaser
        phaser.arriveAndAwaitAdvance();
        System.out.println("Fase " + currentPhase + " acabada, hemos llegado todos a " + etapas[currentPhase]);

        // espero, como una barrera, a que lleguen todos lo que se hayan registrado en el phaser
        // pero en este caso, al acabar, hago in Deregister, 'me salgo del grupo'
        phaser.arriveAndDeregister();

        // compruebo que no hay nadie en el grupo, y acabamos
        if (phaser.isTerminated()) {
            System.out.println("El camino ha terminado para todos");
        }
    }


    class MyThread implements Runnable {
        Phaser phaser;
        String title;

        public MyThread(Phaser phaser, String title) {
            this.phaser = phaser;
            this.title = title;

            // cada hilo se debe registrar en el phaser, es como 'añadirse al grupo'
            phaser.register();
            new Thread(this).start();
        }

        @Override
        public void run() {
            System.out.println("Soy " + title + ". Inicio camino a " + etapas[0]);
            // espero, como una barrera, a que lleguen todos lo que se hayan registrado en el phaser
            phaser.arriveAndAwaitAdvance();

            espera(100, 500);
            System.out.println("Soy " + title + ". Inicio camino a " + etapas[1]);
            // espero, como una barrera, a que lleguen todos lo que se hayan registrado en el phaser
            phaser.arriveAndAwaitAdvance();

            espera(100, 500);
            System.out.println("Soy " + title + ". Inicio camino a " + etapas[2]);
            // espero, como una barrera, a que lleguen todos lo que se hayan registrado en el phaser
            // pero en este caso, al acabar, hago in Deregister, 'me salgo del grupo'
            phaser.arriveAndDeregister();
        }

        public void espera(int min, int max) {
            try {
                Thread.sleep(new Random().nextInt(max - min) + min);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }
    }
}



















