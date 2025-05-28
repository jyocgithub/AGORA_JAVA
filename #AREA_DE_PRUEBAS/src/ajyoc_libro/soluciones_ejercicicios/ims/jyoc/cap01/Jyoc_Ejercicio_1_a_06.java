package soluciones_ejercicicios.ims.jyoc.cap01;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 1
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 1 Ejercicio a_6
 * Crear el código de un programa que genera tres números enteros
 * aleatorios a, b, c, comprendidos entre 65 y 90, ambos inclusive.
 * Los mostraremos en pantalla.
 */
public class Jyoc_Ejercicio_1_a_06 {

    public static void main(String[] args) {

        System.out.println("\n\n Ejercicio 1.7\n\n");

        int a = (int) (Math.random() * (90 - 65 - 1) + 65);
        int b = (int) (Math.random() * (90 - 65 - 1) + 65);
        int c = (int) (Math.random() * (90 - 65 - 1) + 65);

        System.out.println("El numero aleatorio a es " + a);
        System.out.println("El numero aleatorio b es " + b);
        System.out.println("El numero aleatorio c es " + c);
    }
}
