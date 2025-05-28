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
 * Capitulo 4 Ejercicio c_12
 * Crear un programa que pide por teclado números enteros y rellena un vector
 * (el tamaño se le solicita al usuario anteriormente, tambien por teclado)
 * y luego pide otro entero. Posteriormente, calcula el numero máximo de
 * apariciones consecutivas del último numero leído dentro del vector.
 */
public class Jyoc_Ejercicio_4_c_12 {
    public static void main(String[] args) {

        System.out.println("\nIndique el tamaños del vector a crear");
        int tamano = new Scanner(System.in).nextInt();
        int[] numeros = new int[tamano];
        int num = 0;

        for (int j = 0; j < tamano; j++) {
            System.out.println("\nIntroduzca numero:");
            num = new Scanner(System.in).nextInt();
            numeros[j] = num;
        }

        int maxseguidos = 0;
        int contadorparcial = 0;
        int elnumero = 0;
        for (int i = 0; i < tamano - 1; i++) {
            if (numeros[i] == numeros[i + 1]) {
                contadorparcial++;
            } else {
                if (contadorparcial > maxseguidos) {
                    maxseguidos = contadorparcial;
                    elnumero = numeros[i - 1];
                }
                contadorparcial = 0;
            }
        }

        System.out.print("Maximo de apariciones: " + (maxseguidos + 1) + " y el numero era el " + elnumero);

    }
}
