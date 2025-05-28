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
 Escribe un programa que diga cuál es la primera cifra
 de un número entero introducido por teclado. Se permiten números de hasta 5 cifras.
 */
public class Jyoc_Ejercicio_2_b_01 {

     public static void main(String[] args) {
          Scanner objetoScanner1 = new Scanner(System.in);
          System.out.println("Indíque un numero (entre 0 y 99999): ");
          int numero1 = objetoScanner1.nextInt();
        int res;
          if (numero1 >= 10000) {
               res = numero1 / 10000;
          } else if (numero1 >=1000) {
               res = numero1 / 1000;
          } else if (numero1 >=100) {
               res = numero1 / 100;
          } else if (numero1 >=10) {
               res = numero1 / 10;
          } else {
               res = 1;
          }
          System.out.println("El primer digito es "+res);

     }
}
