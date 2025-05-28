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
 * Capitulo 4 Ejercicio f_3
 * Crear un vector bidimensional de 10 x 3 y rellenarlo con números enteros
 * aleatorios de entre el 1 y el 5.
 * Mostrar el vector.
 * Decir si alguna de las filas es capicúa
 */
public class Jyoc_Ejercicio_4_f_03 {
    public static void main(String[] args) {

        int numFilas = 10;
        int numCol = 3;
        int[][] numeros = new int[numFilas][numCol];
        Random r = new Random();
        // rellenamos la matriz
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                numeros[f][c] = r.nextInt(5) + 1;
            }
        }

        // escribir el vector matriz resultante
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                System.out.print(numeros[f][c] + "\t");
            }
            System.out.println();
        }

        // mirar si una fila es capicua
        for (int f = 0; f < numFilas; f++) {

            // Para cada fila, vamos a crear un string con los numeros en orden
            // de columna, y otro con el orden de columna al reves
            // leugo comparamos los strings. Esta es una de las muchas formas d
            // comprobarlo, otra seria ir mirando si los extremos son iguales,
            // luego los numeros mas internos a los extremos, y asi sucesivamente
            String alderecho = "";
            for (int c = 0; c < numCol; c++) {
               alderecho = alderecho + numeros[f][c];
            }
            String alreves = "";
            for (int c = numCol-1; c >=0 ; c--) {
                alreves = alreves + numeros[f][c];
            }

            if(alreves.equals(alderecho)){
                System.out.println("la fila "+f+" es capicua");
            }
        }

    }
}
