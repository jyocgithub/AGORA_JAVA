package soluciones_ejercicicios.ims.jyoc.cap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 1
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 1 Ejercicio a_10
 * Pide un nombre por pantalla y da por consola
 * la bienvenida, p.e., "Bienvenido Juan !!!". Escribirlo con Scanner y con BufferedReader
 */
public class Jyoc_Ejercicio_1_a_10 {


    public static void main(String[] args) {
        // -- Opción con Scanner (opcion 1)
        Scanner objeto7 = new Scanner(System.in);
        System.out.println("Indíqueme su nombre, por favor: ");
        String nombre = objeto7.nextLine();
        System.out.println("¡¡ Bienvenido, señor " + nombre + " !!");

        // -- Opción con Scanner (opcion 1)
        System.out.println("Indíqueme su nombre, por favor: ");
        String nombre2 = new Scanner(System.in).nextLine();
        System.out.println("¡¡ Bienvenido, señor " + nombre2 + " !!");

        // -- Opción con BufferedReader
        InputStreamReader objetoIsr = new InputStreamReader(System.in);
        BufferedReader objetoBf = new BufferedReader(objetoIsr);
        System.out.println("Indíqueme su nombre, por favor: ");
        String nombre3 = "";
        try {
            nombre2 = objetoBf.readLine();
            System.out.println("¡¡ Bienvenido, señor " + nombre3 + " !!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
