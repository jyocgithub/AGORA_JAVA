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
 * Capitulo 4 Ejercicio b_6
 * Hacer una mejora al ejercicio 4_a_6,
 * para que cuando pida la nota de los estudiantes, solo notas de 0 a 10.
 * Ejemplo de como funcionaria:
 * Indique el numero de estudiantes: 3
 * Escriba nombre del estudiante numero 1: Juan
 * Nota del estudiante numero 1: 12
 * nota invalida, pruebe otra vez...
 * Nota del estudiante numero 1: 1
 * (resto igual)
 */
public class Jyoc_Ejercicio_4_b_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader entrada2 = new BufferedReader(new InputStreamReader(System.in));

        int numestudiantes2;
        System.out.println("Escriba cuantos estudiantes vamos a tratar:");
        numestudiantes2 = Integer.parseInt(entrada2.readLine());
        String nombres2[] = new String[numestudiantes2];
        int notas2[] = new int[numestudiantes2];
        int suma2 = 0, media2 = 0;

        // primer bucle, que lee los nombres y notas de los estudiantes
        System.out.println("Escriba nombre y notas de cada estudiante:");
        for (int i = 0; i < numestudiantes2; i++) {
            System.out.println("Nombre del estudiante : " + (i + 1));
            nombres2[i] = entrada2.readLine();
            System.out.println("Nota del estudiante : " + (i + 1));
            notas2[i] = Integer.parseInt(entrada2.readLine());
            while (notas2[i] < 0 || notas2[i] > 10) {
                System.out.println("Nota erronea, introduzca nuevamente una nota");
                System.out.println("Nota del estudiante : " + (i + 1));
                notas2[i] = Integer.parseInt(entrada2.readLine());
            }

            suma2 += notas2[i];
        }

        // segundo bucle, muestra resultados
        System.out.println("Resultado del análisis de datos:");
        for (int i = 0; i < numestudiantes2; i++) {
            System.out.print("El estudiante " + nombres2[i]);
            String texto = (notas2[i] >= 5) ? " ha aprobado" : " ha suspendido";
            System.out.println("ha sacado una nota de " + notas2[i] + ", asi que " + texto);
        }
        System.out.println("La media de la clase ha sido " + (suma2 / numestudiantes2));
    }
}