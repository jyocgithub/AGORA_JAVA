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
 * Idem al ejercicio anterior, pero ahora sera el programa (“el ordenador”)
 * quien debe adivinar un numero que “piense” el usuario
 */
public class Jyoc_Ejercicio_3_c_08 {

    public static void main(String[] args) {
        int numero = 0, intentos = 0, min = 0, max = 100;
        Scanner sc = new Scanner(System.in);

        System.out.println("Jugador, indique un numero entre 1 y 100");
        numero = sc.nextInt();
        boolean adivinado = false;
        int prueba;

        while (!adivinado && intentos < 11) {
            prueba = (int) (((max - min) / 2) + min);
            System.out.println("A ver si acierto, ¿es el " + prueba);
            if (prueba == numero) {
                System.out.println("ACERTEEEEEEEEE !!!");
                adivinado = true;
            } else if (prueba < numero) {
                System.out.println("No he llegado....");
                min = prueba;
            } else {
                System.out.println("Me pase....");
                max = prueba;
            }
            intentos++;
        }
        if (!adivinado) {
            System.out.println("Mas de 10 intentos sin adivinar " + "que el numero era el " + numero);
        }
    }
}
