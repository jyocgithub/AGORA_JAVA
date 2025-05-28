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
 * Pedir dos números y decir si son iguales o no, decir si uno
 * es múltiplo del otro, y decir si el primero es positivo o negativo.
 */
public class Jyoc_Ejercicio_2_a_22 {

     public static void main(String[] args) {

          System.out.println("\n\n Ejercicio 2.2\n\n");
          Scanner sc = new Scanner(System.in);
          System.out.println("Escriba un numero y pulse INTRO:");
          int numero1 = sc.nextInt();
          System.out.println("Escriba un numero y pulse INTRO:");
          int numero2 = sc.nextInt();
          if (numero1 == numero2) {
               System.out.println("El numero " + numero1 + " y el numero " + numero2 + " son iguales.");
          }
          if (numero1 == numero2) {
               System.out.println("El numero " + numero1 + " y el numero " + numero2 + " son iguales.");
          }
          if ((numero1 % numero2 == 0) || (numero2 % numero1 == 0)) {
               System.out.println("El numero " + numero1 + " y el numero " + numero2 + " son multiplos.");
          }
          if ((numero1 > 0)) {
               System.out.println("El numero " + numero1 + " es positivo.");
          }
          if ((numero1 < 0)) {
               System.out.println("El numero " + numero1 + " es negativo.");
          }
     }
}
