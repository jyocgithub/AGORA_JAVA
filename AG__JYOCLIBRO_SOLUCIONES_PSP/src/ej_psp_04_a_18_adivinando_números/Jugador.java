package MARIO_HILOS_3.MarioAndreu_Mesa_Arbitro;

import java.util.Random;

public class Jugador extends Thread {
    int numeroJugador;
    Arbitro arbitroComun;
    public Jugador(int nombre, Arbitro arbitroComun) {
        this.numeroJugador = nombre;
        this.arbitroComun = arbitroComun;
    }

    @Override
    public void run() {
        Random r = new Random();
        while (! arbitroComun.seAcerto()) {
            int minumero = r.nextInt(10)+1;
            arbitroComun.mirarNumero(numeroJugador, minumero);
        }
    }
}


