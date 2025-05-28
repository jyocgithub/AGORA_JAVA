package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio b_3
 * Pedir 10 números enteros por teclado. De todos ellos,
 * mostrar la media de los números que sean pares,
 * mostrar la media de los que sean negativos,
 * y la cantidad de números cero que se hayan introducido.
 */
public class Jyoc_Ejercicio_3_b_03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;
        int contadorDeCeros = 0;
        double contadorDePositivos = 0;
        double contadorDeNegativos = 0;
        int sumadorDePositivos = 0;
        int sumadorDeNegativos = 0;
        System.out.println("Escriba 10 numeros con un INTRO entre ellos");
        for (int i = 0; i < 10; i++) {
            numero = sc.nextInt();
            if (numero == 0) {
                contadorDeCeros++;
            } else if (numero > 0) {
                sumadorDePositivos += numero;
                contadorDePositivos++;
            } else {
                sumadorDeNegativos += numero;
                contadorDeNegativos++;
            }
        }
        System.out.println("El numero de ceros ha sido; " + contadorDeCeros);
        System.out.println("La media de positivos es; " + (sumadorDePositivos / contadorDePositivos));
        System.out.println("La media de negativos es; " + (sumadorDeNegativos / contadorDeNegativos));
    }
}
