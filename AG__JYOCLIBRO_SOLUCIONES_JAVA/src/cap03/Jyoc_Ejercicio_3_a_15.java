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
 * Capitulo 3 Ejercicio 6
 * Hacer un programa que muestre el producto de los 10 primeros números impares. (no de los impares menores de 10, sino de los primeros 10 números mayores que 0 que sean impares)
 */
public class Jyoc_Ejercicio_3_a_15 {

     public static void main(String[] args) {
          int producto = 1;
          int contadorDeImpares = 0;
          int indice = 0;
          while (contadorDeImpares < 10) {
               if (indice % 2 != 0) {
                    // es un numero impar
                    producto = producto * indice;
                    contadorDeImpares++;
               }
               indice++;
          }
          System.out.println("El producto es "+producto);
     }
}
