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
 * Pedir dos números y decir si uno es múltiplo del otro,
 * y decir cual es el mayor o si son iguales.
 */
public class Jyoc_Ejercicio_2_a_0xxx {

     public static void main(String[] args) {

          Scanner sc = new Scanner(System.in);
          System.out.println("Escriba un numero y pulse INTRO:");
          int numero1 = sc.nextInt();
          System.out.println("Escriba un numero y pulse INTRO:");
          int numero2 = sc.nextInt();

          if ((numero1 % numero2 == 0)) {
               System.out.println("El numero " + numero1 + "es multiplo de " + numero2);
          }
          if ((numero2 % numero1 == 0)) {
               System.out.println("El numero " + numero2 + "es multiplo de " + numero1);
          }

          if ((numero1 > numero2)) {
               System.out.println("El numero " + numero1 + " es el mayor.");
          } else if ((numero2 > numero1)) {
               System.out.println("El numero " + numero1 + " es el mayor.");
          } else {
               System.out.println("Ambos numeros son iguales.");
          }
     }
}
