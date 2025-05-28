package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio a_06
 * Escribir los primeros 20 números seguidos, tanto con un FOR, con un WHILE y con DO WHILE
 * MEJORA 1: la lista además sale en una sola línea, separados los números por comas
 * <p>
 */
public class Jyoc_Ejercicio_3_a_06 {

    public static void main(String[] args) {
        for (int i = 1; i < 21; i++) {
            System.out.println(i);
        }

        int j = 1;
        while (j < 21) {
            System.out.println(j);
            j++;
        }

        int k = 1;
        do {
            System.out.println(k);
            k++;
        } while (k < 21);


        // MEJORA 1
        for (int i = 1; i < 21; i++) {
            System.out.print(i);
            if (i != 20) {
                System.out.print(",");
            }
        }

    }
}
