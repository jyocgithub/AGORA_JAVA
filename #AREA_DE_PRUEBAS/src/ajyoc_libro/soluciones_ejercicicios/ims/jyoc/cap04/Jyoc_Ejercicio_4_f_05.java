package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.util.Random;

/**
 * Crear un programa que nos diga si una matriz es triangular superior o no
 * (una matriz es triangular superior si -al menos- los elementos por
 * encima de la diagonal principal son todos ceros, como esta por ejemplo:
 * 8 0 0 0
 * 1 5 0 0
 * 6 7 2 0
 * 8 2 3 8
 * <p>
 * Para probar se pueden usar estas dos matrices:
 * int[][] mat = {{2, 0, 0}, {3, 4, 0}, {9, 1, 7}};  // si es triangular superior
 * int[][] mat = {{2, 0, 9}, {3, 4, 0}, {9, 1, 7}};  // no es triangular superior
 */
public class Jyoc_Ejercicio_4_f_05 {
    public static void main(String[] args) {

        int[][] mat = {{2, 0, 0}, {3, 4, 0}, {9, 1, 7}};

        boolean resultado = true;
        for (int f = 0; f < mat.length - 1; f++) {
            for (int c = (f + 1); c < mat[f].length; c++) {
                if (mat[f][c] != 0) {
                    resultado = false;
                }
            }
        }
        if (resultado) {
            System.out.println("es triangular superior");
        } else {
            System.out.println("no es triangular superior");
        }
    }
}
