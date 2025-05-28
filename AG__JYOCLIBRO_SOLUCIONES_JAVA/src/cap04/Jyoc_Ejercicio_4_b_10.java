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
 * Capitulo 4 Ejercicio b_10
 * Realiza un programa que lea desde teclado 200 puntuaciones numéricas enteras que han de estar
 * comprendidas entre el 0 y el 4, ambos inclusive. Al finalizar se mostrará por cada una de las
 * puntuaciones, su frecuencia.
 * Frecuencias:
 * 0: 23 veces.
 * 1: 34 veces.
 * 2: 0 veces.
 * 3: 78 veces.
 * 4: 54 veces.
 */
public class Jyoc_Ejercicio_4_b_10
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        int[] valores = new int[5];

        for (int i = 0; i < 200; i++)
        {
            num = (int) (Math.random() * 5);
            valores[num]++;
        }
        for (int i = 0; i < 5; i++)
        {
            System.out.println("El numero " + i + " ha salido " + valores[i] + " veces");
            ;
            valores[num]++;
        }

    }
}
