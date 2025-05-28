package MARIO_HILOS_3.MarioAndreu_Mesa_Arbitro;

import java.util.Random;

public class Arbitro {
    boolean acierto = false;
    Random r = new Random();
    int numeroAcertado = r.nextInt(10) + 1;
    int turno = 1;

    public Arbitro() {
            System.out.println("  Soy arbitro: eligo el numero " + numeroAcertado);
    }

//    synchronized void comprobarJugadas(int numeroJugador) {
//
//        while (!acierto) {
//            System.out.println(nombre + " juega " + turno);
//            try {
//                System.out.println("Soy arbitro y " + nombre + " ha acertado");
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            notifyAll();
//        }
//    }


    public synchronized void mirarNumero(int numeroJugador, int numeroAdivinar) {

        // SI NO ES MI TURNO ME PARO
        while (numeroJugador != turno) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!acierto) {

            System.out.println("  Soy arbitro: el jugador " + numeroJugador + " intenta con el numero " + numeroAdivinar);
            // VEO SI HE ACERTADO
            if (numeroAdivinar == numeroAcertado) {
                System.out.println("Soy arbitro y el jugador " + numeroJugador + " ha acertado !!!");
                acierto = true;
            }

            // cambio el turno
            if (turno == 1) {
                turno = 2;
            } else {
                turno = 1;
            }
        }

        // despierto a quien sea
        notifyAll();

    }


    public synchronized boolean seAcerto() {
        return acierto;
    }


}
