package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio a_10
 * Hacer un programa que lea un número entero por teclado
 * y escriba los números enteros impares que hay desde
 * el 1 hasta el número leído (éste incluido),
 * pero escribiendo solo 5 números por línea.
 * Ejemplo para el 26:
 * 1 3 5 7 9
 * 11 13 15 17 19
 * 21 23 25
 */
public class Jyoc_Ejercicio_3_a_10 {

    public static void main(String[] args) {
        int num;
        int contador = 0;

        System.out.println("Indique un numero:");
        num = new Scanner(System.in).nextInt();

        for (int i = 1; i <= num; i = i + 2) {
            System.out.print(i + " ");
            contador++;
            if (contador == 5) {
                System.out.println();
                contador = 0;
            }
        }
    }
}
