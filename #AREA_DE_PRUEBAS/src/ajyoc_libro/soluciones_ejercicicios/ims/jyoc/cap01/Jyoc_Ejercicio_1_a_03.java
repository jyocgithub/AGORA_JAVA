package soluciones_ejercicicios.ims.jyoc.cap01;

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
 * Capitulo 1 Ejercicio a_3
 * Ejercicio 1 (dificultad 1) Escribir un programa que crea e inicializa
 * dos variables con números enteros y muestre :
 * "El numero [poner aquí el primer numero] sumado a [poner aquí el otro numero] da [poner el resultado]"
 * "El numero [poner aquí el primer numero] restado a [poner aquí el otro numero] da [poner el resultado]"
 * "El numero [poner aquí el primer numero] multiplicado por [poner aquí el otro numero] da [poner el resultado]"
 * "El numero [poner aquí el primer numero] dividido entre [poner aquí el otro numero] da [poner el resultado]"
 */
public class Jyoc_Ejercicio_1_a_03 {

    public static void main(String[] args) {

        System.out.println("\n\n Ejercicio 1.3\n\n");
        int numero1 = 23;
        int numero2 = 45;
        System.out.println("El numero " + numero1 + " sumado a " + numero2 + " da " + (numero1 + numero2));
        System.out.println("El numero " + numero1 + " restado a " + numero2 + " da " + (numero2 - numero1));
        System.out.println("El numero " + numero1 + " multiplicado por " + numero2 + " da " + (numero1 * numero2));
        System.out.println("El numero " + numero1 + " dividido entre " + numero2 + " da " + (numero1 / numero2));
    }
}
