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
 * Realiza un programa que lea números enteros desde teclado
 * hasta que se introduzcan 12, o bien hasta que se introduzca
 * un número igual que el anterior. Muestra los numeros introducidos al acabar de pedir todos
 */
public class Jyoc_Ejercicio_4_a_19 {
    public static void main(String[] args) throws IOException {
        BufferedReader entrada2 = new BufferedReader(new InputStreamReader(System.in));
        int nums[] = new int[12];
        boolean seguir = true;

        System.out.println("Escriba nombre y notas de cada estudiante, o FIN para acabar:");
        int i;
        for ( i = 0; i < 12 && (seguir); i++) {
            System.out.println("Introduzca numero : " );
            String n= entrada2.readLine();
            nums[i] = Integer.parseInt(n);
            if(i>0 && nums[i]==nums[i-1]){
                seguir = false;
            }
        }
        for (int j = 0; j <i; j++) {
            System.out.println(nums[j]);
        }
    }
}