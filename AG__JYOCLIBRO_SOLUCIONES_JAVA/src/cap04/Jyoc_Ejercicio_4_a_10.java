package cap04;

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


/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.io.IOException;
import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio a_14
 * Realiza un programa que pida por teclado 10 números enteros y los almacene en un vector.
 * Posteriormente, nos dice si hay alguna posición del vector que tenga el mismo numero
 * que la posición siguiente del vector.
 * MEJORA 1; no solo nos dice si hay “repetidos”, sino que nos dice que numero se repite
 * y en que dos posiciones del vector están los “repetidos”
 */

public class Jyoc_Ejercicio_4_a_10 {
    public static void main(String[] args) throws IOException {
        int[] numeros = new int[10];

        int num = 0;
        // rellenamos array de 10 numeros por teclado
        for (int j = 0; j < 10; j++) {
            System.out.println("\nIntroduzca un numero:");
            num = new Scanner(System.in).nextInt();
            numeros[j] = num;
        }

        for (int j = 0; j < 9; j++) {
            if (numeros[j] == numeros[j + 1]) {
                System.out.println("Se repite el numero " + numeros[j]);
                System.out.println("y es iguales en las posiciones " + j + " y " + (j + 1));
            }
        }
    }
}
