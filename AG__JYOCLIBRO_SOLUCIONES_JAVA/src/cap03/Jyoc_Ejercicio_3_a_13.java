package cap03;

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
 * Capitulo 3 Ejercicio b_2
 * Leer un número y mostrar su cuadrado,
 * repetir el proceso hasta que se introduzca un número negativo.
 */
public class Jyoc_Ejercicio_3_a_13 {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

          System.out.println("Escriba un numero y pulse INTRO");
          int num = sc.nextInt();
          while (num > 0) {
               System.out.println("El cuadrado es " + (num * num));
               System.out.println("\nEscriba un numero y pulse INTRO");
               num = sc.nextInt();
          }
     }
}
