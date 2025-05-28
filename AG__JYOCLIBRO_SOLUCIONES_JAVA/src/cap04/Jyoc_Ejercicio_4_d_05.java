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

/**
 * Capitulo 4 Ejercicio d_04
 * Crear un vector bidimensional de tamaño 8x6. Todos sus elementos deben ser 0
 * salvo los de los bordes que deben ser 1. Mostrar el resultado
 */
public class Jyoc_Ejercicio_4_d_05 {
    public static void main(String[] args) {

        int numFilas = 7;
        int numCol = 7;
        int[][] numeros = new int[numFilas][numCol];
        // rellenamos la matriz
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                if(f==0 || f==numFilas-1 || c==0 || c==numCol-1){
                numeros[f][c] = 1;

                }else{

                numeros[f][c] = 0;
                }
            }
        }

        // escribir el vector matriz resultante
        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCol; c++) {
                System.out.print(numeros[f][c] + "\t");
            }
            System.out.println();
        }
    }
}
