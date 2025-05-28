package cap03;

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
 * 	Escribir un programa que muestre  esto por pantalla:
 *	X
 *	XX
 *	XXX
 *	XXXX
 *	XXXXX
 */
public class Jyoc_Ejercicio_3_c_06 {

     public static void main(String[] args) {

          for (int i = 1; i < 6; i++) {
               for (int h = 1; h <= i; h++) {
                    System.out.print ("X");
               }
               System.out.println ();
          }
     }
}
