package soluciones_ejercicicios.ims.jyoc.cap01;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 1
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 1 Ejercicio b_1
 * Programa que pone en una variable int un numero
 * de segundos y nos dice a cuantas horas, minutos y segundos
 * corresponde dicha cantidad de segundos. Por ejemplo, si en el
 * programa se define un int seg = 3734, después nos dice; 3734 segundos
 * son 1 horas 2 minutos y 14 segundos
 * <p>
 */
public class Jyoc_Ejercicio_1_b_01 {

    public static void main(String[] args) {
        System.out.println("\n\n Ejercicio 1.5\n\n");
        int segundos = 3661;
        int minutos = segundos / 60;
        segundos = segundos % 60;
        int horas = minutos / 60;
        minutos = minutos % 60;

        System.out.println(segundos + " segundo son " + horas + " horas , " +
                minutos + " minutos y " + segundos + " segundos ");

    }
}
