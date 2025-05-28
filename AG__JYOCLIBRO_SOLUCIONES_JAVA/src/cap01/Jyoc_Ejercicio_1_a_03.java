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
 * @author Iñaki Martin
 */

/**
 * Capitulo 1 Ejercicio a_3
 Escribir un programa que pida dos números al usuario,
 y los guarde en dos variables (a y b).
 Posteriormente intercambia el valor de ambas variables
 (a valdrá lo que vale b, y b valdrá lo que vale a)
 */
public class Jyoc_Ejercicio_1_a_03 {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          System.out.println("\n\n Ejercicio 1.3\n\n");

          System.out.println("Escriba el valor del primer numero");
          int x1 = sc.nextInt();
          System.out.println("Escriba el valor del segundo numero");
          int x2 = sc.nextInt();

          int auxiliar = x1;
          x1 = x2;
          x2 = auxiliar;
          System.out.println("El numero primero es ahora " + x1 );
          System.out.println("El numero segundo es ahora " + x2 );
     }
}
