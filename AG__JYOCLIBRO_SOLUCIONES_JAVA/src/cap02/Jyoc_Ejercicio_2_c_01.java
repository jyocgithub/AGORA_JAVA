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
 * Ejercicios de Guiones de Curso Java S
 * <p>
 * @author Iñaki Martin
 */

/**
 * Capitulo 2 Ejercicio c_1
 * Pedir por teclado tres números y mostrarlos ordenados de mayor a menor
 */
public class Jyoc_Ejercicio_2_c_01 {

     public static void main(String[] args) {
          Scanner objetoScanner3 = new Scanner(System.in);
          System.out.println("Indíque un valor para el numero 1 : ");
          int a = objetoScanner3.nextInt();
          System.out.println("Indíque un valor para el numero 2 : ");
          int b = objetoScanner3.nextInt();
          System.out.println("Indíque un valor para el numero 3 : ");
          int c = objetoScanner3.nextInt();

          int mayor = a;
          int menor = a;
          int medio = a;
          // Solo haremos comparaciones de mayor que, no de igual,
          // pues para dos elementos iguales es indiferente su orden
          if (a > b) {
               if (a > c) {
                    mayor = a;    // aqui a es el mator seguro,falta saber el orden de los otros dos
                    if (b > c) {
                         medio = b;
                         menor = c;
                    }
               } else {          // aqui a es mayor que b pero menor que c, ero c es el mayor
                                 // si a es mayor que b, a es el del medio
                    mayor = c;
                    medio = a;
                    menor = b;
               }
          } else {                // aqui b es mayor que a
               if (b > c) {       // comprobar si tambien es mayor que c
                    mayor = b;
                    if (a > c) {
                         medio = a;
                         menor = c;
                    }
               } else {
                    mayor = c;
                    medio = b;
                    menor = a;
               }
          }
     }
}
