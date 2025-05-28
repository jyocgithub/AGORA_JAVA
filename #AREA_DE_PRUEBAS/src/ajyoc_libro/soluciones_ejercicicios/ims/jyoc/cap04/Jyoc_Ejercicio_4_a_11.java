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
 * Capitulo 4 Ejercicio a_11
 * Realiza un programa que lea por teclado un array de enteros de tamaño 10. Se deberá crear un
 * nuevo array invirtiendo la ubicación de los elementos y posteriormente mostrarlo.
 */
public class Jyoc_Ejercicio_4_a_11 {
    public static void main(String[] args) throws IOException {
        int[] valores = new int[10];
        int[] nuevosvalores = new int[10];
        int num, pos, aux;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 0;
        // rellenamos array de valores
        for (int j = 0; j < 10; j++) {
            System.out.println("\nIntroduzca un numero:");
            num = Integer.parseInt(br.readLine());
            valores[j] = num;
        }
        for (int j = 0; j < 10; j++) {
            nuevosvalores[j] = valores[9 - j];
        }


        System.out.print("\nVIEJO ARRAY: ");
        for (int j = 0; j < 10; j++)
            System.out.print(valores[j] + " ");
        System.out.print("\nNUEVO ARRAY: ");
        for (int j = 0; j < 10; j++)
            System.out.print(nuevosvalores[j] + " ");


    }
}
