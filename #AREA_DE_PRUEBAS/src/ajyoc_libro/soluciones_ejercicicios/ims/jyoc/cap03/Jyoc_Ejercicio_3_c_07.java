package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio c_7
 * Programa consistente en un juego en el que el Jugador1
 * introduce un número entre el 1 y el 100 y el Jugador2
 * tendrá que adivinarlo en un máximo de 10 intentos.
 * Por cada intento del Jugador2 se mostrará el mensaje
 * “Te pasaste”, o “No llegaste”, según corresponda.
 * El programa terminará cuando se agoten los intentos y/o el Jugador2
 * acierte el número. Se ha de mostrar el mensaje correspondiente.
 */
public class Jyoc_Ejercicio_3_c_07 {

    public static void main(String[] args) {
        int numero = 0, intentos = 0, prueba = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Jugador 1, indique un numero entre 1 y 100");
        numero = sc.nextInt();
        boolean adivinado = false;

        while (!adivinado && intentos < 11) {

            System.out.println("Jugador 2, indique un numero a ver si acierta:");
            prueba = sc.nextInt();
            if (prueba == numero) {
                System.out.println("ACERTOOOO !!!");
                adivinado = true;
            } else if (prueba < numero) {
                System.out.println("No llegaste....");
            } else {
                System.out.println("Te pasaste....");
            }
            intentos++;
        }
        if (!adivinado) {
            System.out.println("Mas de 10 intentos sin adivinar "
                    + "que el numero era el " + numero);
        }
    }
}
