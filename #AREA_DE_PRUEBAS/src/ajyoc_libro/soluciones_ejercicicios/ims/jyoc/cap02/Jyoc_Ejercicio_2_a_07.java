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
 * Capitulo 2 Ejercicio a_07
 * Pedir por teclado el día, mes y año de una fecha e indicar si la fecha es correcta.
 * Similar al ejercicio anterior, pero considerando ahora que hay en realidad meses de 28, 30 y 31 días.
 * No controlar que haya años bisiestos (consideremos todos los años no bisiestos)
 */
public class Jyoc_Ejercicio_2_a_07 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el valor del dia de la fecha:");
        int dia = sc.nextInt();
        System.out.println("Escriba el valor del mes de la fecha:");
        int mes = sc.nextInt();
        System.out.println("Escriba el valor del año de la fecha:");
        int año = sc.nextInt();

        if (mes < 0 || mes > 12) {
            System.out.println("Fecha erronea, dia incorrecto");
        } else if (dia > 30 && (mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
            System.out.println("Fecha erronea, dia de mes incorrecto");
        } else if (dia > 28 && mes == 2) {
            System.out.println("Fecha erronea, dia de mes incorrecto");
        } else if (dia < 1 || dia > 31) {
            System.out.println("Fecha erronea, dia incorrecto");
        } else {
            System.out.println("Fecha correcta:" + dia + " del " + mes + " del año " + año);
        }
    }
}
