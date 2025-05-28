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
 * Capitulo 3 Ejercicio a_05
 * Pedir 10 sueldos. Mostrar su suma y cuantos hay mayores de 500€. 
 */
public class Jyoc_Ejercicio_3_a_03 {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int numero;
          double contadorDeMasDeQuinientos = 0;
          int sumador = 0;
          System.out.println("Escriba 10 sueldos con un INTRO entre ellos");
          for (int i = 0; i < 10; i++) {
               numero = sc.nextInt();
               if(numero>500){
                    contadorDeMasDeQuinientos++;
               }
               sumador += numero;
          }
          System.out.println("El numero de sueldos de mas de 500 es ; "+contadorDeMasDeQuinientos);
          System.out.println("La suma de salarios es ; "+ sumador);
     }
}
