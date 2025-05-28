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
 * Capitulo 4 Ejercicio c_7
 * Hacer un programa que declare una tabla de 10 elementos enteros. Leer mediante el teclado 8
 * números. Después se debe pedir un número y una posición, insertarlo en la posición indicada,
 * desplazando los que estén detrás.
 */
public class Jyoc_Ejercicio_4_c_07
{
    public static void main(String[] args) throws IOException
    {
        int[] valores = new int[10];
        int num, pos, aux;
        boolean seguir = true, hayNumeroVacio = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 0;
        // rellenamos array de valores
        while (i < 8)
        {
            num = (int) (Math.random() * 50 + 1);
            valores[i++] = num;
        }
        System.out.print("\nARRAY INICIAL: ");
        for (int j = 0; j < 10; j++)  // recorremos array de valores y pintamos
            System.out.print(valores[j] + " ");


        System.out.println("\nIntroduzca un numero a intercalar:");
        num = Integer.parseInt(br.readLine());
        System.out.println("\nIntroduzca un numero de posicion, entre 0 y 7:");
        pos = Integer.parseInt(br.readLine());
        if (pos < 0 || pos > 7)
        {
            System.out.println("posision erronea");
            System.exit(0);
        }
        // intercalar

            aux = valores[pos + 1];
        for (int j = 8; j >=pos ; j--)
        {
            valores[j+1] =  valores[j];
        }
        valores[pos] = num;


        System.out.println("\nIntroduzca otro numero a intercalar:");
        num = Integer.parseInt(br.readLine());
        System.out.println("\nIntroduzca otra numero de posicion, entre 0 y 7:");
        pos = Integer.parseInt(br.readLine());
        if (pos < 0 || pos > 7)
        {
            System.out.println("posision erronea");
            System.exit(0);
        }
        // intercalar

        aux = valores[pos + 1];
        for (int j = 8; j >=pos ; j--)
        {
            valores[j+1] =  valores[j];
        }
        valores[pos] = num;

        System.out.print("\nNUEVO ARRAY: ");
        for (int j = 0; j < 10; j++)  // recorremos array de premiados y pintamos
            System.out.print(valores[j] + " ");


    }
}
