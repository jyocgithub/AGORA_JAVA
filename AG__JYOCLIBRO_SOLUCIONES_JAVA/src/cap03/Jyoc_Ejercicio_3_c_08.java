package cap03;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * @author Iñaki Martin
 */

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
 * Escribir un programa que muestre
 *
 *	  X
 *	 XXX
 *	XXXXX
 * XXXXXXX
 *
 * MEJORA; la altura de los pisos se debe pedir al usuario por teclado
 */
public class Jyoc_Ejercicio_3_c_08 {

     public static void main(String[] args) {

          System.out.println ("Introduce el numero de pisos de la piramide:");
          Scanner objetoScanner11 = new Scanner (System.in);
          int lim = objetoScanner11.nextInt ();

          for (int i = 1; i < lim + 1; i++) {

               for (int s = lim - i; s > 0; s--) {
                    System.out.print (" ");
               }
               for (int s = i; s < i * 3 - 1; s++) {
                    System.out.print ("X");
               }
               System.out.println ("");
          }
     }
}
