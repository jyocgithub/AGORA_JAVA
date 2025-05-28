package soluciones_ejercicicios.ims.jyoc.cap02;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 2 Ejercicio 01
 * Programa que declare una variable de tipo entero y pida un valor para ella.
 * A continuación muestra un mensaje indicando si el valor de dicha variable es positivo o negativo,
 * si es par o impar, si es múltiplo de 5, si es múltiplo de 10 y si es mayor o menor que 100.
 * Consideraremos el 0 como positivo.
 * MEJORA: Hacer el mismo ejercicio, usando cuando se pueda el operador condicional ( ? : ) .
 */
public class Jyoc_Ejercicio_2_a_01 {

    public static void main(String[] args) {
        System.out.println("\n\n Ejercicio 2.01\n\n");

        int numero = 4;

        if (numero > 0) {
            System.out.println("Es positivo");
        } else {
            System.out.println("Es negativo");
        }

        if (numero % 2 == 0) {
            System.out.println("Es par");
        } else {
            System.out.println("Es impar");
        }

        if (numero % 5 == 0) {
            System.out.println("Es multiplo de cinco");
        } else {
            System.out.println("No es multiplo de cinco");
        }

        if (numero % 10 == 0) {
            System.out.println("Es multiplo de 10");
        } else {
            System.out.println("No es multiplo de 10");
        }

        if (numero > 100) {
            System.out.println("Es mayor de 100");
        } else {
            System.out.println("Es menor o igual a 100");
        }

        // Con if resumido (solo ultimo if anterior)
        String respuesta = (numero > 100) ? "Es mayor de 100" : "Es menor o igual a 100";
        System.out.println(respuesta);


    }
}
