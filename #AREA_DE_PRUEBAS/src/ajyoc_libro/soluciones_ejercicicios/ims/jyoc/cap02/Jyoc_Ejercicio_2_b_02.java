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
 * Capitulo 2 Ejercicio b_02
 * Pedir por teclado dos fechas y mostrar el número de días que hay de diferencia.
 * Suponiendo que todos los meses fueran de 30 días,
 * y que los años deben ser siempre positivos y tienen siempre 365 días.
 * Suponer tambien que la primera fecha es anterior a la segunda.
 */
public class Jyoc_Ejercicio_2_b_02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba el valor del dia de la fecha 1:");
        int dia1 = sc.nextInt();
        System.out.println("Escriba el valor del mes de la fecha 1:");
        int mes1 = sc.nextInt();
        System.out.println("Escriba el valor del año de la fecha 1:");
        int año1 = sc.nextInt();
        System.out.println("Escriba el valor del dia de la fecha 2:");
        int dia2 = sc.nextInt();
        System.out.println("Escriba el valor del mes de la fecha 2:");
        int mes2 = sc.nextInt();
        System.out.println("Escriba el valor del año de la fecha 2:");
        int año2 = sc.nextInt();

        int tot1 = dia1;    // en tot1 vamos a ir calculando el total de dias de la fecha 1
        tot1 = tot1 + ((mes1 - 1) * 30);
        tot1 = tot1 + ((año1 - 1) * 365);

        int tot2 = dia2;    // en tot2 vamos a ir calculando el total de dias de la fecha 2
        tot2 = tot2 + ((mes2 - 1) * 30);
        tot2 = tot2 + ((año2 - 1) * 365);

        // este if es solo para que no nos de un numero negativo,
        // hay otras maneras de hacerlo mas repidas pero aun no conocidas
        int dif = 0;

        if (tot1 > tot2) {
            dif = tot1 - tot2;
        } else {
            dif = tot2 - tot1;
        }
        System.out.println("Hay una diferencia de " + dif + " entre las dos fechas");
    }
}
