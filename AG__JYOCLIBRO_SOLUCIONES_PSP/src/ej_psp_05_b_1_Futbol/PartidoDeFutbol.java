package ej_psp_05_b_1_Futbol;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class PartidoDeFutbol {



    public static void main(String[] args) {
        // El hilo principal, este hilo, hace de arbitro

        Scanner sc = new Scanner(System.in);

        Goles objetoGoles = new Goles();

        objetoGoles.cogerTodosLosPermisosDeJugar(); 		// EL ARBITRO TOMA LOS DOS PERMISOS DE JUGAR PARA QUE LOS EQUIPOS ESPEREN A JUGAR


        EquipoFutbol eq = new EquipoFutbol("Real Madrid", objetoGoles);
        EquipoFutbol eq2 = new EquipoFutbol("Real Sociedad", objetoGoles);
        eq.start();
        eq2.start();

        System.out.println("Pulsa intro para siguiente gol...................................");

        while (!objetoGoles.getFindelpartido()) {
            // el arbitro dice a los jugadores que jueguen
            String loquepulsaelarbitro = sc.nextLine();

            objetoGoles.jugar.release(2);  // libera los dos permisos de jugar, para que los dos equipos puedan continuar, que estaban parados

            objetoGoles.esperar(100);
            objetoGoles.cogerTodosLosPermisosDeJugar(); 		// EL ARBITRO TOMA LOS DOS PERMISOS DE JUGAR PARA QUE LOS EQUIPOS ESPEREN A JUGAR
        }

        System.out.println("RESULTADO FINAL");
        System.out.println(eq.nombreEquipo + " : " + eq.goles);
        System.out.println(eq2.nombreEquipo + " : " + eq2.goles);
    }
}

class EquipoFutbol extends Thread {
    String nombreEquipo;
    Goles objetoGoles;
    int goles;
    int golesMaximo = 5;

    public EquipoFutbol(String nombreEquipo, Goles objetoGoles) {
        this.nombreEquipo = nombreEquipo;
        this.objetoGoles = objetoGoles;
    }

    public void run() {

        while (!objetoGoles.getFindelpartido()) {
            objetoGoles.intentoJugar(nombreEquipo);
            if (objetoGoles.intentoMarcarGol(nombreEquipo)) {
                goles++;

                if (goles == golesMaximo) {
                    objetoGoles.findelpartido = true;
                }
            } else {
                System.out.println("Pulsa intro para siguiente gol...................................");
                objetoGoles.gol.release();
            }
        }
    }
}

class Goles {
    Semaphore gol = new Semaphore(1,false);
    Semaphore jugar = new Semaphore(2);
    boolean quienHanMarcadoMasGoles = false;

    Random azar = new Random();
    boolean findelpartido = false;

    public boolean intentoJugar(String nombreEquipo) {
        try {

            jugar.acquire();  // el equipo queda aqui parado hasta que el arbitro libere los permisos de jugar
            jugar.release();  // en cuanto puede continuar, libera el permiso para que el arbitro pueda volver a coger los dos permisos
            System.out.println(nombreEquipo + " .... intenta marcar ");

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        return false;
    }

    public  boolean intentoMarcarGol(String nombreEquipo) {

        int tiempo = azar.nextInt(1800) + 100; // No más de 2 segundos
        esperar(tiempo);

        if (gol.tryAcquire()) {
            System.out.println("GOOOOLL de " + nombreEquipo);

            return true;
        } else {
            //	System.out.println("   Grr, soy " + nombreEquipo + " y me han marcado un gol ");

            return false;
        }

    }

    public boolean getFindelpartido() {
        return findelpartido;
    }

    public void cogerTodosLosPermisosDeJugar() {
        try {
            jugar.acquire(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void esperar(int cuanto) {
        try {
            Thread.sleep(cuanto);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


