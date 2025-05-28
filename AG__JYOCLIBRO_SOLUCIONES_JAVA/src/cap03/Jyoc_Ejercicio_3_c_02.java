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
 * Capitulo 3 Ejercicio b_10
 * Encontrar y mostrar todos los números de cuatro cifras que
 * cumplan la condición de que la suma de las cifras
 * de orden impar es igual a la suma de las cifras de orden par.
 *
 */
public class Jyoc_Ejercicio_3_c_02 {

     public static void main(String[] args) {

          int sumapar, sumaimpar, numero;
          int a1, a2, a3, a4;
          for (int i = 1000; i < 10000; i++) {
               numero = i;
               a1= i % 10; 	                // conocer el ultimo digito
               numero = (int)numero / 10; 	// quita el ultimo digito
               a2= i % 10; 	                // conocer el ultimo digito
               numero = (int)numero / 10; 	// quita el ultimo digito
               a3= i % 10; 	                // conocer el ultimo digito
               numero = (int)numero / 10; 	// quita el ultimo digito
               a4= i % 10; 	                // conocer el ultimo digito
               numero = (int)numero / 10; 	// quita el ultimo digito
               sumaimpar = a1 +a3;
               sumapar = a2 + a4;
               if (sumapar == sumaimpar) {
                    System.out.println ("El numero " + i + " cumple con la regla");
               }
          }

     }
}
