package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.io.IOException;
import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio c_10
 * Pedir dos series de 5 números enteros
 * (se supone que se introducen ordenados de forma creciente)
 * y guardar ambas series en vectores diferentes.
 * Copiar (fusionar) los dos vectores en un tercero, de forma que esté ordenado.
 */
public class Jyoc_Ejercicio_4_c_10 {
    public static void main(String[] args) throws IOException {

        int[] numeros1 = new int[5];
        int[] numeros2 = new int[5];
        int[] numerosfinal = new int[10];
        int num = 0;

        System.out.println("\nSerie 1: Introduzca varios numeros en ORDEN ASCENDENTE");
        for (int j = 0; j < 5; j++) {
            System.out.println("\nIntroduzca numero:");
            num = new Scanner(System.in).nextInt();
            numeros1[j] = num;
        }
        System.out.println("\nSerie 2: Introduzca varios numeros en ORDEN ASCENDENTE");
        for (int j = 0; j < 5; j++) {
            System.out.println("\nIntroduzca numero:");
            num = new Scanner(System.in).nextInt();
            numeros2[j] = num;
        }

        // vamos a guardar en dos variables "puntero" el indice de cada una de las series,
        // el indice del elemento proximo a intentar ser candidato a meter en el nueva vector
        int indice1 = 0, indice2 = 0;

        for (int i = 0; i < 10; i++) {
            if (indice1 == 5) {  // si ya hemos sacado todos los numeros de la serie 1, meter de la serie 2
                numerosfinal[i] = numeros2[indice2];
                indice2++;
            } else if (indice2 == 5) {// si ya hemos sacado todos los numeros de la serie 2, meter de la serie 1
                numerosfinal[i] = numeros1[indice1];
                indice1++;
            } else { // si no se ha llegado al imite de ninguna de las series, miramos el numero menor de las dos y añadimos ese
                if (numeros1[indice1] <= numeros2[indice2]) {
                    numerosfinal[i] = numeros1[indice1];
                    indice1++;
                } else {
                    numerosfinal[i] = numeros2[indice2];
                    indice2++;
                }
            }
        }

        System.out.print("\nNUEVO ARRAY: ");
        for (int j = 0; j < 10; j++)
            System.out.print(numerosfinal[j] + " ");

    }
}
