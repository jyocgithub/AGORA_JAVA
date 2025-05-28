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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Capitulo 4 Ejercicio b_3
 *  Crear un programa que lea por teclado un array de 10 números enteros y
 *  la ordene ascendentemente y la muestre, y luego la ordene descendentemente y la muestre.
 */
public class Jyoc_Ejercicio_4_b_13
{
    public static void main(String[] args) throws IOException {
        int[] valores = new int[10];
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 0, aux;
        for (int j = 0; j < 10; j++)
        {
            System.out.println("\nIntroduzca un numero:");
            num = Integer.parseInt(br.readLine());
            valores[j] = num;
        }

        // ORDENACION ASCENDENTE, OPCION POR METODO BURBUJA, version 1
        for (int j = 0; j < valores.length; j++)
        {
            for (int k = 0; k < valores.length-1 ; k++)
            {
                if (valores[k]>valores[k+1]){
                    aux = valores[k];
                    valores[k] = valores[k+1];
                    valores[k+1] = aux;
                }
            }
        }
        System.out.print("\nOrdenado ascendentemente: ");
        for (int j = 0; j < 10; j++)
            System.out.print(valores[j] + " ");

        // ORDENACION ASCENDENTE, OPCION POR METODO BURBUJA, version 2
        for (int j = 0; j < valores.length-1; j++)
        {
            for (int k = 0; k < j ; k++)
            {
                if (valores[k]>valores[k+1]){
                    aux = valores[k];
                    valores[k] = valores[k+1];
                    valores[k+1] = aux;
                }
            }
        }
        System.out.print("\nOrdenado ascendentemente: ");
        for (int j = 0; j < 10; j++)
            System.out.print(valores[j] + " ");



        // ORDENACION DESCENDENTE, OPCION POR METODO BURBUJA, version 1
        for (int j = 0; j < valores.length; j++)
        {
            for (int k = 0; k < valores.length-1 ; k++)
            {
                if (valores[k] < valores[k+1]){
                    aux = valores[k];
                    valores[k] = valores[k+1];
                    valores[k+1] = aux;
                }
            }
        }
        System.out.print("\nOrdenado descendentemente: ");
        for (int j = 0; j < 10; j++)
            System.out.print(valores[j] + " ");


    }
}
