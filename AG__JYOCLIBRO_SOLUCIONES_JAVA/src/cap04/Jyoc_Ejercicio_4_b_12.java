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

import java.util.Arrays;

/**
 * Capitulo 4 Ejercicio b_12
 * Crear un programa que tenga dos arrays, uno con los 6 números de una apuesta de la primitiva, y
 * otro con los 6 números ganadores. La función debe devolver el número de aciertos.
 * Los array se rellenan
 * aleatoriamente, y se muestran los dos arrays y el numero de aciertos.
 */
public class Jyoc_Ejercicio_4_b_12
{
    public static void main(String[] args)
    {
        int num;
        boolean yaesta;
        int[] valores = new int[6];
        int[] premiados = new int[6];
        boolean seguir = true, hayNumeroVacio = true;
        int i = 0;

        // rellenamos array de valores
        while (i < 6)
        {
            num = (int) (Math.random() * 49 + 1);
            yaesta = false;
            for (int j = 0; j < 6; j++)
            {
                if (num == valores[j])
                {
                    yaesta = true;
                }
            }
            if (!yaesta)
            {
                valores[i] = num;
                i++;
            }
        }
        // rellenamos array de premiados
        i = 0;
        while (i < 6)
        {
            num = (int) (Math.random() * 49 + 1);
            yaesta = false;
            for (int j = 0; j < 6; j++)
            {
                if (num == premiados[j])
                {
                    yaesta = true;
                }
            }
            if (!yaesta)
            {
                premiados[i] = num;
                i++;
            }
        }

        // ordenamos los arrays
        Arrays.sort(premiados);
        Arrays.sort(valores);

        int totalpremiados = 0;
        for (int j = 0; j < 6; j++)  // recorremos array de premiados y vemos si esta en valores
        {
            for (int k = 0; k < 6; k++)
                if (premiados[k] == valores[j])
                {
                    totalpremiados++;
                }
            {
            }

        }

        System.out.print("\nVALORES JUGADOS: ");
        for (int j = 0; j < 6; j++)  // recorremos array de valores y pintamos
            System.out.print(valores[j] + " ");

        System.out.print("\nPREMIADOS: ");
        for (int j = 0; j < 6; j++)  // recorremos array de premiados y pintamos
            System.out.print(premiados[j] + " ");

        System.out.print("\nHay " + totalpremiados + " aciertos");
    }
}
