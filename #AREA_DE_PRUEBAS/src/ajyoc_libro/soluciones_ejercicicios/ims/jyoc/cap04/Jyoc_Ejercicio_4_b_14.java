package soluciones_ejercicicios.ims.jyoc.cap04;

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
 * Realizar un programa que pida por teclado 10 números enteros.
 * Guardar en otro vector los elementos pares del primero,
 * y en el mismo vector, a continuación, los elementos impares
 */

public class Jyoc_Ejercicio_4_b_14 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int[] nuevo = new int[10];

        int num = 0;
        // rellenamos array de 10 numeros por teclado
        for (int j = 0; j < 10; j++) {
            System.out.println("\nIntroduzca un numero:");
            num = new Scanner(System.in).nextInt();
            numeros[j] = num;
        }
        int proximoindice = 0;
        for (int j = 0; j < 10; j++) {
            if (numeros[j] % 2 == 0) {
                nuevo[proximoindice] = numeros[j];
                proximoindice++;
            }
        }
        for (int j = 0; j < 10; j++) {
            if (numeros[j] % 2 != 0) {
                nuevo[proximoindice] = numeros[j];
                proximoindice++;
            }
        }

        System.out.print("\n ARRAY ORIGINAL: ");
        for (int j = 0; j < 10; j++)
            System.out.print(numeros[j] + " ");
        System.out.print("\n ARRAY RECOMBINADO: ");
        for (int j = 0; j < 10; j++)
            System.out.print(nuevo[j] + " ");
    }
}
