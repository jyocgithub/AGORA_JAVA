package cap01;

import java.util.Scanner;

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
 * Capitulo 1
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 Pedir un número por teclado y escribir por consola
 (sustituyendo X e Y por lo que corresponda)  “El doble de X es Y”
 */
public class Jyoc_Ejercicio_1_a_06 {


    public static void main(String[] args) {
        // -- Opción con Scanner y nextInt()
        Scanner objeto7 = new Scanner(System.in);
        System.out.println("Indíque un numero, por favor: ");
        int num  = objeto7.nextInt();
        int doble = num*num;

        System.out.println("El doble de "+ num + " es "+ doble);

        // -- Opción con Scanner y nextLine()
        Scanner objeto8 = new Scanner(System.in);
        System.out.println("Indíque un numero, por favor: ");
        int num2  = Integer.parseInt(objeto8.nextLine());
        int doble2 = num2*num2;

        System.out.println("El doble de "+ num2 + " es "+ doble2);
    }
}
