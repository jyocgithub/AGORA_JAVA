package soluciones_ejercicicios.ims.jyoc.cap02;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 2 Ejercicio a_0610
 * Pedir por teclado tres numero: el día, mes y año de una fecha.
 * Indicar si la fecha es correcta y es de el siglo XXI
 * (vamos a suponer que todos los meses del año tienen 30 días,
 * así que hay que comprobar que el día que se haya introducido
 * no sea ni 0 ni menor que 0, ni sea mayor que 30,
 * que el mes es menor que 12 y mayor que 0, y que el año está entre 2000 y 2099)
 */
public class Jyoc_Ejercicio_2_a_06 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el valor del dia de la fecha:");
        int dia = sc.nextInt();
        System.out.println("Escriba el valor del mes de la fecha:");
        int mes = sc.nextInt();
        System.out.println("Escriba el valor del año de la fecha:");
        int año = sc.nextInt();

        if (dia < 0 || dia > 30) {
            System.out.println("Fecha erronea, dia incorrecto");
        } else if (mes < 0 || mes > 12) {
            System.out.println("Fecha erronea, mes incorrecto");
        } else {
            System.out.println("Fecha correcta:" + dia + " del " + mes + " del año " + año);
        }
    }
}
