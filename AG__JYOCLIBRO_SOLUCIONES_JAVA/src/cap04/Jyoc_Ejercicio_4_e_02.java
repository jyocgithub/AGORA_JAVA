package cap04;
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
 *
 * @author Iñaki Martin
 */

import java.util.Random;

/**
 * Capitulo 4 Ejercicio e_02
 * Realiza un programa que rellene, con números aleatorios entre ,
 * un vector bidimensional de enteros de tamaño 4 x 4 .
 * Mostrar el vector. Finalmente el programa dirá si
 * existe algún número repetido o no (sin especificar cuál o cuáles).
 */
public class Jyoc_Ejercicio_4_e_02 {
    public static void main(String[] args) {

        int numFilas = 3;
        int numCol = 3;
        int[][] numeros = new int[numFilas][numCol];

        Random r = new Random();
        // rellenamos la matriz
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                numeros[f][c] = r.nextInt(20)+1;
            }
        }

        // escribir el vector matriz resultante
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                System.out.print(numeros[f][c] + "\t");
            }
            System.out.println();
        }
        int cuantasVecesEsta, numeroABuscar;
        boolean hayRepetidos = false;
        //  los dos primeros for eligen cada numero de la matriz
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                numeroABuscar = numeros[f][c];

                // los dos segundos for revisan nuevamente cada numero de la matris
                // contando cuantas veces aparece el numero numeroAbuscar
                cuantasVecesEsta=0;
                for (int f2 = 0; f2 < numFilas; f2++) {
                    for (int c2 = 0; c2 < numCol; c2++) {
                        if(numeroABuscar==numeros[f2][c2]){
                            cuantasVecesEsta++;
                        }
                    }
                }
                // si numeroABuscar es mayor que uno, es que hay, aparte del propio
                // numero, alguno mas como el
                if(cuantasVecesEsta>2){
                    hayRepetidos=true;
                }
            }
        }

        String mensaje = (hayRepetidos)?"Hay repetidos": "No hay repetidos";
        System.out.println(mensaje);


    }
}
