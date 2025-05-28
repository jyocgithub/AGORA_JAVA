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
 * Capitulo 4 Ejercicio c_8
 * Crear un programa que lea por teclado una tabla de 10 números enteros y la desplace una posición
 * hacia adelante (el primero pasa a ser segundo, el segundo pasa a ser tercero, etc, y el último pasa a ser el primero)
 * MEJORA: igual que antes, pero desplazar N posiciones (N es introducido por el usuario)
 */
public class Jyoc_Ejercicio_4_c_08
{
    public static void main(String[] args) throws IOException
    {
        int[] valores = new int[10];
        int[] nuevosvalores = new int[10];
        int num, aux;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 0;
        for (int j = 0; j < 10; j++)
        {
            System.out.println("\nIntroduzca un numero:");
            num = Integer.parseInt(br.readLine());
            valores[j] = num;
        }

        aux = valores[9];
        for (int j =9; j> 0; j--)
        {
            nuevosvalores[j] = valores[j-1];
        }
        nuevosvalores[0]=aux;

        System.out.print("\nVIEJO ARRAY: ");
        for (int j = 0; j < 10; j++)
            System.out.print(valores[j] + " ");
        System.out.print("\nNUEVO ARRAY: ");
        for (int j = 0; j < 10; j++)
            System.out.print(nuevosvalores[j] + " ");

    }
}
