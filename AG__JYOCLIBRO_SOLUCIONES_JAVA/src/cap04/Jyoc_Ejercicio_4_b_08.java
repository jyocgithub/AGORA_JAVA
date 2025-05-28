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
 * Capitulo 4 Ejercicio b_8
 * Realiza un programa que lea desde teclado 10 números.
 * A continuación nos pedirá que busquemos un número entre los introducidos,
 * y nos dirá si ha sido encontrado o no.
 * MEJORA 1: El programa nos preguntará si queremos seguir buscando
 * más números o no: “¿Desea seguir buscando números?(s/n)”.
 * MEJORA 2: En el caso en el que haya sido encontrado, nos indicará
 * cuántas veces se ha introducido..
 */
public class Jyoc_Ejercicio_4_b_08 {
    public static void main(String[] args) throws IOException {
        BufferedReader entrada2 = new BufferedReader(new InputStreamReader(System.in));
        int nums[] = new int[10];
        String n, num;
        int i, total = 0;
        for (i = 0; i < 10; i++) {
            System.out.println("Introduzca numero : ");
            n = entrada2.readLine();
            nums[i] = Integer.parseInt(n);
        }

        boolean seguir = true, estaba;
        do {
            System.out.println("Escriba un numero a buscar entre los anteriores ");
            num = entrada2.readLine();
            estaba = false;
            total = 0;
            for (int j = 0; j < 10; j++) {
                if (nums[i] == Integer.parseInt(num)) {
                    estaba = true;
                    total++;
                }
            }
            if (estaba) {
                System.out.println("el numero " + num + " estaba " + total + "  veces");
            }else{
                System.out.println("el numero "+ num + " no estaba entre los previos");
            }

            System.out.println("Desea seguir (S/N) ? ");
            n = entrada2.readLine();
            if (n.equalsIgnoreCase("N")) {
                seguir = false;
            }
        } while (seguir);


    }
}