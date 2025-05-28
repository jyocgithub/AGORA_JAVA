package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Capitulo 4 Ejercicio b_07
 * Simular un lanzamiento de 6000 veces un dado,
 * y decir al finalizar cuantas veces ha salido cada uno de los números del dado
 * MEJORA 1; decir además la desviación máxima y mínima
 * (la mayor diferencia entre dos resultados y la minima)
 */
public class Jyoc_Ejercicio_4_b_07 {
    public static void main(String[] args) throws IOException {
        // dados sin desviacion
        int res[] = new int[6];

        for (int i = 1; i <= 6000; i++) {
            int numero = (int) (Math.random() * 6 + 1);
            res[numero - 1]++;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println("El numero " + (i + 1) + " ha salido: " + res[i]);
        }


    }
}