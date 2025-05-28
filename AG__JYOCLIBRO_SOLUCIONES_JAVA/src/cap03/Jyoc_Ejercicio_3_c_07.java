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
 * 	Escribir un programa que muestre primero esto por pantalla:
 *	XXXXX
 *	XXXX
 *	XXX
 *	XX
 *	X
 *
 */
public class Jyoc_Ejercicio_3_c_07 {

     public static void main(String[] args) {

          for (int i = 5; i > 0; i--) {
               for (int h = 1; h <= i; h++) {
                    System.out.print ("X");
               }
               System.out.println ();
          }
     }
}
