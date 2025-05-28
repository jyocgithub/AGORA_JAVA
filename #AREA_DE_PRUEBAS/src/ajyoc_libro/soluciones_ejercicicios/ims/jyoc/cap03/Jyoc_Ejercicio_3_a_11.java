package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio a_11
 * Programa que pide dos numero por teclado, a y b.
 * A continuación, escribe todos los números menores de 100
 * que son múltiplos de a y de b a la vez.
 */
public class Jyoc_Ejercicio_3_a_11 {

    public static void main(String[] args) {
        int a, b;
        int contador = 0;

        System.out.println("Indique un numero (a) :");
        a = new Scanner(System.in).nextInt();
        System.out.println("Indique un numero (b) :");
        b = new Scanner(System.in).nextInt();

        for (int i = 1; i <= 100; i++) {
            if (i % a == 0 && i % b == 0) {
                System.out.println(i + " es multiplo de " + a + " y de " + b);
            }
        }
    }
}

