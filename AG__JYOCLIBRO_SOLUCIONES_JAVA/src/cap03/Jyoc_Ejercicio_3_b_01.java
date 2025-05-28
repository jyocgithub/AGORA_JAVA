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
 * Programa que lee 9 números,
 * y en el caso en el que el primero introducido sea igual al último,
 * nos muestra la media. En caso contrario, no se mostrará nada.
 */
public class Jyoc_Ejercicio_3_b_01 {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int n = 0, primero = 0, ultimo=0;
          for (int i = 0; i < 9; i++) {
               System.out.println("Indique un numero:");
               n = sc.nextInt();
               if (i == 0) {
                    primero = n;
               }
               if (i == 8) {
                    ultimo = n;
               }
          }

          // FIJARSE que la comparacion se hade FUERA DEL BUCLE, al terminar de meter todo
          if (primero == ultimo) {
               System.out.println("primero y ultimo iguales, y la media es: "+ ((primero+ultimo)/2));
          }

     }
}
