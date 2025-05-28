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
 * Capitulo 4 Ejercicio b_11
 * Realiza un programa que termine cuando el usuario haya metido todos los números comprendidos
 * entre el 1 y el 10.
 */
public class Jyoc_Ejercicio_4_b_11
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        int[] valores = new int[11];
        boolean seguirleyendo = true, hayNumeroVacio = true;
        while (seguirleyendo)
        {
            System.out.println("\nIntroduzca un numero entre 1 y 10:");
            num = Integer.parseInt(br.readLine());
            if (num >= 1 && num <= 10)
            {
                valores[num] = num;
            }
            hayNumeroVacio = false;
            for (int i = 1; i < 10; i++)
            {
                if (valores[i] == 0)
                {
                    hayNumeroVacio = true;
                }
            }
            seguirleyendo = hayNumeroVacio;
        }
        System.out.print("fin");
    }
}
