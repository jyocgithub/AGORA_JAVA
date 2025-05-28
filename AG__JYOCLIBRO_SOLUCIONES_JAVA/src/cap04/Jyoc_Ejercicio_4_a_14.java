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
 Realiza un programa que pida por teclado 5 números enteros
 y los almacene en un array. Se debe crear posteriormente un
 nuevo array a partir de invertir el primer array.
 Por ejemplo: un array inicial [1, 2, 3, 4, 5] debería crear un
 nuevo array que sea [5, 4, 3 ,2 ,1].
 El programa debe imprimir el array resultante de la inversión.
 */
public class Jyoc_Ejercicio_4_a_14
{
    public static void main(String[] args) throws IOException
    {
        int[] valores = new int[5];
        int[] nuevosvalores = new int[5];
        int num, pos, aux;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 0;
        // rellenamos array de valores
        for (int j = 0; j < 5; j++)
        {
            System.out.println("\nIntroduzca un numero:");
            num = Integer.parseInt(br.readLine());
            valores[j] = num;
        }
        for (int j = 0; j < 5; j++)
        {
            nuevosvalores[j] = valores[5-j] ;
        }


        System.out.print("\nVIEJO ARRAY: ");
        for (int j = 0; j < 5; j++)
            System.out.print(valores[j] + " ");
        System.out.print("\nNUEVO ARRAY: ");
        for (int j = 0; j < 5; j++)
            System.out.print(nuevosvalores[j] + " ");


    }
}
