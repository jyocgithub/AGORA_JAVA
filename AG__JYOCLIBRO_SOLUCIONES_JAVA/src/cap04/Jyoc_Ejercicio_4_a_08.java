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
 * Capitulo 4 Ejercicio a_12
 * Realiza un programa que pida por teclado 10 números enteros y los almacene en un vector..
 * Se deberá crear un nuevo vector que en cada posición almacene
 * - el valor de la misma posición del vector original, pero multiplicado por tres si este era impar
 * - el valor de la misma posición del vector original, pero multiplicado por dos si este era par
 */

public class Jyoc_Ejercicio_4_a_08 {
    public static void main(String[] args) throws IOException {
        int[] valores = new int[10];
        int[] nuevosvalores = new int[10];
        int num;

        int i = 0;
        // rellenamos array de 10 numeros por teclado
        for (int j = 0; j < 10; j++) {
            System.out.println("\nIntroduzca un numero:");
            num = new Scanner(System.in).nextInt();
            valores[j] = num;
        }


        for (int j = 0; j < 10; j++) {
            if (valores[j] % 2 == 0) {
                nuevosvalores[j] = valores[j] * 3;
            } else {
                nuevosvalores[j] = valores[j] * 2;
            }
        }

        System.out.print("\nVIEJO ARRAY: ");
        for (int j = 0; j < 10; j++)
            System.out.print(valores[j] + " ");
        System.out.print("\nNUEVO ARRAY: ");
        for (int j = 0; j < 10; j++)
            System.out.print(nuevosvalores[j] + " ");


    }
}
