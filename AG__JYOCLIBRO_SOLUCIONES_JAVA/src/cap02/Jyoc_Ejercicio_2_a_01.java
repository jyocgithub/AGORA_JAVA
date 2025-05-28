package cap02;

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
 * @author Iñaki Martin
 */

/**
 * Pedir dos números y mostrarlos ordenados de mayor a menor.
 */
public class Jyoc_Ejercicio_2_a_01 {

     public static void main(String[] args) {

          Scanner sc = new Scanner(System.in);
          System.out.println("Escriba un numero y pulse INTRO:");
          int numero1 = sc.nextInt();
          System.out.println("Escriba un numero y pulse INTRO:");
          int numero2 = sc.nextInt();

          System.out.print("Numeros ordenados; ");
          if ((numero1 > numero2)) {
               System.out.println(numero1 + " " + numero2);
          } else {
               System.out.println(numero2 + " " + numero1);
          }
     }
}
