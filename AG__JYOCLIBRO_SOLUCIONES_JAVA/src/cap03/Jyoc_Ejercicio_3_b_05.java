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
 * Programa que lee un número y muestra la suma de sus divisores,
 * sin incluir el propio número entre sus divisores.
 * <p>
 */
public class Jyoc_Ejercicio_3_b_05 {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int i, n, sig, suma;
          System.out.println("Indique un numero:");
          n = sc.nextInt();
          suma = 0;
          for (i = 1; i < n; i++) {  // i son los divisores. Se divide desde 1 hasta sig-1 
               if (n % i == 0) {
                    suma = suma + i; // si es divisor se suma
               }
          }
          System.out.println("La suma de los divisores es:" + suma);
     }
}
