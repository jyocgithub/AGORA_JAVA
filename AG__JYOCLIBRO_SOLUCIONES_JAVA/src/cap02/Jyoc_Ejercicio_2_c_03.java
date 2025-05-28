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
 * Crear un programa que asigne a dos variables enteras
 * dos números aleatorios (llamémosles  numA y numbB).
 * No se muestran los datos por pantalla.
 * El usuario debe intentar adivinar cual de los dos numero es el mayor.
 * Para ello, el programa pedirá por teclado al usuario que escriba por
 * quién apuesta (que escriba A o B). Una vez el usuario haya introducido su apuesta,
 * el programa mostrará el valor de A y B,
 * dirá si se ha ganado la apuesta (si ha acertado el número más alto) o si ha perdido
 */
public class Jyoc_Ejercicio_2_c_03 {

     public static void main(String[] args) {

          Scanner objetoScanner = new Scanner(System.in);
          int numA = (int) (Math.random() * 10);
          int numB = (int) (Math.random() * 10);
          System.out.println("Indíque que número es mas alto, A o B: ");
          String apuesta = objetoScanner.nextLine();
               System.out.println("Numeros que han salido: A="+numA+" B="+numB);
          if ((apuesta.equalsIgnoreCase("A") && numA >= numB) || (apuesta.equalsIgnoreCase("B") && numB >= numA)) {
               System.out.println("Ha ganado !!!");
          } else {
               System.out.println("Ha fallado ...");
          }
     }
}
