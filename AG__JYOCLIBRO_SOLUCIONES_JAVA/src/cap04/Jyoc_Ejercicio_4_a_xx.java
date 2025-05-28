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
 * Capitulo 4 Ejercicio a_6
 * Escribir un programa que:
 * - pide por teclado un numero de estudiantes
 * - crea dos vectores para guardar nombres de estudiantes y sus notas.
 * - con un bucle pide por teclado los nombres y las notas de cada uno de los estudiantes,
 *   y los va guardando en el vector.
 * - con otro bucle escribe qué alumnos han aprobado y cuales no
 * - finalmente escribe la media de todas las notas introducidas
 * Ejemplo de como funcionaria:
 * Indique el numero de estudiantes: 2
 * Escriba nombre del estudiante numero 1: Juan
 * Nota del estudiante numero 1: 5
 * Escriba nombre del estudiante numero 2: Pedro
 * Nota del estudiante numero 2: 2
 * <p>
 * Maria ha suspendido
 * La media de las notas es 3,5
 */
public class Jyoc_Ejercicio_4_a_xx {
    public static void main(String[] args) throws IOException {

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        int numestudiantes;
        System.out.println("Escriba cuantos estudiantes vamos a tratar:");
        numestudiantes = Integer.parseInt(entrada.readLine());
        String nombres[] = new String[numestudiantes];
        int notas[] = new int[numestudiantes];
        int suma = 0, media = 0;

        // primer bucle, que lee los nombres y notas de los estudiantes
        System.out.println("Escriba nombre y notas de cada estudiante:");
        for (int i = 0; i < numestudiantes; i++) {
            System.out.println("Nombre del estudiante : " + (i + 1));
            nombres[i] = entrada.readLine();
            System.out.println("Nota del estudiante : " + (i + 1));
            notas[i] = Integer.parseInt(entrada.readLine());
            suma += notas[i];
        }

        // segundo bucle, muestra resultados
        System.out.println("Resultado del análisis de datos:");
        for (int i = 0; i < numestudiantes; i++) {
            System.out.print("El estudiante " + nombres[i]);
            String texto = (notas[i] >= 5) ? " ha aprobado" : " ha suspendido";
            System.out.println("ha sacado una nota de " + notas[i] + ", asi que " + texto);
        }
        System.out.println("La media de la clase ha sido " + (suma / numestudiantes));




    }
}