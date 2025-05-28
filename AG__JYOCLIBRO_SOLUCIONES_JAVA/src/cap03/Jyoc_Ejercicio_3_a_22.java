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
 * Pedir números hasta que se teclee un 0,
 * mostrar la suma y la media de todos los números introducidos.
 */
public class Jyoc_Ejercicio_3_a_22 {

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          int suma = 0;
          double contador = 0;
          double media = 0.0;
          int num;
          do{
               System.out.println("\nEscriba un numero y pulse INTRO");
               num = sc.nextInt();
               suma = suma + num;
               contador++;
          } while (num != 0) ;
          System.out.println("Se han pedido "+contador+" numeros");
          System.out.println("La suma es  "+suma);
          media =  (suma/contador);
          System.out.println("la media es "+media);
          
          // ADVERTIR QUE SI LA VARIABLE CONTADOR ES DE TIPO INT, NO FUNCIONA
          // ADVERTIR QUE EL NUMERO 0 TAMBIEN ENTRA EN LA CUENTA DE NUMEROS INTODUCIDOS, PUES
          //    NO DICE NADA EL ENUNCIDO EN CONTRA
     }
}
