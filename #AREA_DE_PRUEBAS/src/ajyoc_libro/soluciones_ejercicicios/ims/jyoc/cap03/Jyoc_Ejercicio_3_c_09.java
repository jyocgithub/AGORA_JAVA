package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio c_9
 * Escribir en modo matriz la hoja de calendario del mes de mayo de 1992.
 * (ayuda: el 1 de mayo del 1992 fue viernes, y el
 *  1 de junio 2015 fue lunes, empezar por ahi)
 */
public class Jyoc_Ejercicio_3_c_09 {

    public static void main(String[] args) {
        int primerDiaDeSemana = 5; // 4 es viernes, pues se cuentan desde 0
        int diasEnBlanco = 0, diasPasadosPorMes = 0;
        int ultimoDiaDelMes = 31;
        int diaDelMes = 1;
        System.out.println("\tCalendario de Mayo 1992");
        System.out.println("\t---------------------------------------------------");
        System.out.println("\tLUN\tMAR\tMIE\tJUE\tVIE\tSAB\tDOM");
        System.out.println("\t---------------------------------------------------");
        while (diaDelMes <= ultimoDiaDelMes) {
            diasPasadosPorMes++;
            if (diasEnBlanco++ < primerDiaDeSemana) {
                System.out.print("\t");
                continue;
            }
            System.out.print("\t" + (diaDelMes++));
            if (diasPasadosPorMes == 7) {
                diasPasadosPorMes = 0;
                System.out.println("");
            }
        }
    }
}
