package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio a_14
 * Escribir un programa que genere 100 números enteros aleatorios entre
 * el 1 y el 500, los almacene en un vector, y a continuación
 * genere un vector de chars que contenga una ‘p’ en las posiciones
 * donde hay números pares y una ‘i’ en los impares. Mostrar el contenido
 * de ambos vectores en filas de 4 elementos formados por pares de número y letra.
 * Ejemplo:
 * 269 I - 311 I - 91 I - 367 I
 * 206 P - 32 P - 183 I - 460 P
 * 487 I - 432 P - 42 P - 47 I
 * … … …
 */

public class Jyoc_Ejercicio_4_b_15 {
    public static void main(String[] args) {
        int[] numeros = new int[100];
        char[] letras = new char[100];
        Random rn = new Random();

        int num = 0;
        // rellenamos array de 10 numeros por teclado
        for (int j = 0; j < 100; j++) {
            numeros[j] = rn.nextInt(500) + 1;
            if (numeros[j] % 2 == 0) {
                letras[j] = 'P';
            } else {
                letras[j] = 'I';
            }
        }


        System.out.print("ARRAYS JUNTOS:\n");
        for (int j = 0; j < 100; j++) {
            System.out.print(numeros[j] + " " + letras[j]);
            if (j % 4 == 0 && j > 0) {
                System.out.println();
            } else {
                System.out.print(" - ");
            }

        }
    }
}
