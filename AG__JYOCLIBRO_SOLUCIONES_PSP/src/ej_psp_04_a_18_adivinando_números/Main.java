package MARIO_HILOS_3.MarioAndreu_Mesa_Arbitro;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Arbitro arbitroComun = new Arbitro();
        Jugador Jugador1 = new Jugador(1, arbitroComun);
        Jugador Jugador2 = new Jugador(2, arbitroComun);
        Jugador1.start();
        Jugador2.start();
    }
}
