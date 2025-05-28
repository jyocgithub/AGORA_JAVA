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
 * Capitulo 2 Ejercicio b_03
 * Pedir por teclado dos numero enteros correspondientes a un numero de mes y un numero de año.
 * Calcular el número de días que tiene dicho mes.
 * Se debe comprobar que el valor introducido para el mes esté comprendido entre 1 y 12.
 * Se de be controlar que un año sea bisiesto (un año es bisiesto si es múltiplo de 4 y no de 100,
 * pero sí son bisiestos los múltiplos de 400)
 * <p>
 */
public class Jyoc_Ejercicio_2_b_03 {

     public static void main(String[] args) {

          Scanner sc = new Scanner(System.in);
          System.out.println("Escriba el mes :");
          int mes = sc.nextInt();
          System.out.println("Escriba el año :");
          int anio = sc.nextInt();

          if (mes < 0 || mes > 12) {
               System.out.println("Mes incorrecto");
          } else {
               switch (mes) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                         System.out.println("Mes con 31 dias");
                         break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                         System.out.println("Mes con 30 dias");
                         break;
                    case 2:
                         int numDias = 28;
                         if ((anio % 4 == 0) && !(anio % 100 == 0)) {
                              numDias = 29;
                         }
                         if ((anio % 400 == 0)) {
                              numDias = 29;
                         }
                         System.out.println("Mes con " + numDias + " dias");

                         // en una sola linea las comparaciones anteriores podría ser:
                         // numDias = ( (anio10 % 4==0) && !(anio10 % 100==0) || (anio10 % 400==0) ? 29 : 28);
                         break;
               }
          }


     }
}
