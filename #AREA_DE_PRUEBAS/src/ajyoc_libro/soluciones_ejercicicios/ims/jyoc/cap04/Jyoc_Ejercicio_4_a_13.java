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
 * Capitulo 4 Ejercicio a_13
 * Hacer un programa que pida por teclado 10 números enteros y los almacene
 * en un vector al que llamaremos numeros.
 * Posteriormente, crear dos vectores de 10 elementos (llamados pares e impares).
 * Recorrer luego el vector números, y almacenar cada valor par en el vector
 * pares y cada valor impar en el vector impares. Escribir luego los tres vectores
 * MEJORA 1: al escribir los vectores, escribir solamente los que tengan
 * valor valido, esto es, lo que tengan valor mayor que cero
 */

public class Jyoc_Ejercicio_4_a_13 {
    public static void main(String[] args) throws IOException {
        int[] numeros = new int[10];
        int[] pares = new int[10];
        int[] impares = new int[10];

        int num = 0;
        // rellenamos array de 10 numeros por teclado
        for (int j = 0; j < 10; j++) {
            System.out.println("\nIntroduzca un numero:");
            num = new Scanner(System.in).nextInt();
            numeros[j] = num;
        }

        int indicepares = 0, indiceimpares = 0;
        for (int j = 0; j < 10; j++) {
            if (numeros[j] % 2 == 0) {
                pares[indicepares++] = numeros[j];
            } else {
                impares[indiceimpares++] = numeros[j];
            }
        }

        System.out.print("\n ARRAY ORIGINAL: ");
        for (int j = 0; j < 10; j++)
            System.out.print(numeros[j] + " ");
        System.out.print("\n ARRAY DE PARES: ");
        for (int j = 0; j < 10; j++)
            System.out.print(pares[j] + " ");
        System.out.print("\n ARRAY DE IMPARES: ");
        for (int j = 0; j < 10; j++)
            System.out.print(impares[j] + " ");


    }
}
