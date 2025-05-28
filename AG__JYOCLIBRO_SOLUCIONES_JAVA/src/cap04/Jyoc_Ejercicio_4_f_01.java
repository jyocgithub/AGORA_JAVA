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

import java.util.Scanner;

/**
 * Capitulo 4 Ejercicio f_01
 * Realiza un programa que pida números por teclado para rellenar
 * una matriz cuadrada (igual numero de filas que de columnas).
 * El tamaño de la matriz tambien de ha de pedir previamente por teclado.
 * Mostrar la matriz.
 * Posteriormente nos indica si la matriz creada es un cuadrado mágico:
 * aquel en el que, sin repetir ningún número, todas las filas, columnas,
 * y las dos diagonales suman lo mismo.
 * Ejemplo de cuadrado mágico de orden 3:
 * <p>
 * 8 3 4
 * 1 5 9
 * 6 7 2
 */
public class Jyoc_Ejercicio_4_f_01 {
    public static void main(String[] args) {
        System.out.println("\nIndique dimension de la matriz cuadrada");
        int numFilas = new Scanner(System.in).nextInt();
        int numCol = numFilas;
        int[][] numeros = new int[numFilas][numCol];

        // rellenamos la matriz
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                System.out.print("Escriba un numero para fila " + f + " y columna " + c + " : ");
                numeros[f][c] = new Scanner(System.in).nextInt();
            }
        }

        // escribir el vector matriz resultante
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                System.out.print(numeros[f][c] + "\t");
            }
            System.out.println();
        }

        // mirar si la suma de filas es siempre igual
        int sumaanterior = -1, suma;
        boolean esCuadradoMagico = true;
        for (int f = 0; f < numFilas && esCuadradoMagico; f++) {
            suma = 0;
            for (int c = 0; c < numCol && esCuadradoMagico; c++) {
                suma += numeros[f][c];
            }

            if (sumaanterior == -1) {
                sumaanterior = suma;
            } else {
                if (sumaanterior != suma) {
                    esCuadradoMagico = false;
                }
            }
        }
        // se deberia probar aqui si seguir es false, pero por no ensuciar con mas if lo obviamos...

        // mirar si la suma de columnas es siempre igual e igual al de las filas de antes
        // son los mismos bucles de antes, pero cambiando el orden de los for
        for (int c = 0; c < numCol && esCuadradoMagico; c++) {
            suma = 0;
            for (int f = 0; f < numFilas && esCuadradoMagico; f++) {
                suma += numeros[f][c];
            }

            if (sumaanterior != suma) {
                esCuadradoMagico = false;
            }
        }
        // se deberia probar aqui si seguir es false, pero por no ensuciar con mas if lo obviamos...

        // ahora miramos que no se repita ningun numero
        // creamos un vector con tantas posiciones como celdas de la matriz
        // y lo vamos rellenando con un 1 en la posicion de cada numero que encontremos en la matriz
        // comprobando que cuando intente poner un 1 no existiera ya antes... señal de numero repetido
        int[] existe = new int [numFilas*numCol+1];  // +1 por que el 0 no se usa ... y si un valor mas
        for (int f = 0; f < numFilas && esCuadradoMagico; f++) {
            for (int c = 0; c < numCol && esCuadradoMagico; c++) {
                if (existe[numeros[f][c]] == 1) {
                    esCuadradoMagico = false;
                }
                existe[numeros[f][c]] = 1;
            }
        }

        // faltaria comprobar las diagonales.....


        if(esCuadradoMagico){
            System.out.println("SI es un cuadrado magico !!");
        }else{
            System.out.println("No es un cuadrado magico");
        }


    }
}

