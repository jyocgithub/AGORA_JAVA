package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio b_11
 * Realizar un programa que pida por teclado números enteros positivos
 * hasta que se escriba un 0.
 * Después deberá mostrar la media de todos los negativos.
 * Comprobar que funcione si no se escribe ningun numero negativo
 */
public class Jyoc_Ejercicio_3_b_11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        double suma = 0;
        int contador = 0;
        do {
            System.out.println("Indique un numero:");
            n = sc.nextInt();
            if (n < 0) {
                suma += n;
                contador++;
            }
        } while (n != 0);
        if (contador == 0) {
            System.out.println("no se indicaron numeros negativos en la secuencia");
        } else {
            System.out.println("la media de los negativos es :" + (suma / contador));
        }
    }
}
