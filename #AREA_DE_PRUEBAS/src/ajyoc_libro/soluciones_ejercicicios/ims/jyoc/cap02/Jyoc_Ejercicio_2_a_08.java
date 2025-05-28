package soluciones_ejercicicios.ims.jyoc.cap02;

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
 * Capitulo 2 Ejercicio a_08
 * Pedir por teclado el día, mes y año de una fecha correcta y mostrar la fecha del día siguiente.
 * Suponer que todos los meses del año tienen 30 días
 */
public class Jyoc_Ejercicio_2_a_08 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el valor del dia de la fecha:");
        int dia = sc.nextInt();
        System.out.println("Escriba el valor del mes de la fecha:");
        int mes = sc.nextInt();
        System.out.println("Escriba el valor del año de la fecha:");
        int año = sc.nextInt();

        dia = dia + 1;
        if (dia > 30) {
            dia = 1;
            mes = mes + 1;
        }
        if (mes > 12) {
            mes = 1;
            año = año + 1;
        }
        System.out.println("Fecha nueva:" + dia + " del " + mes + " del año " + año);
    }
}
