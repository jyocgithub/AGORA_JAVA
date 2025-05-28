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
 * Capitulo 1 Ejercicio a_4
 * Diseñe un programa que convierta una temperatura
 * en grados Celsius a Fahrenheit. La temperatura celsius se guarda en
 * una variable double. Una temperatura en grados Celsius o centígrados
 * puede convertirse a su equivalente en Fahrenheit de acuerdo con la
 * siguiente fórmula: f = (9/5) * C + 32
 */
public class Jyoc_Ejercicio_1_a_04 {

    public static void main(String[] args) {

        System.out.println("\n\n Ejercicio 1.4\n\n");
        int gradosCelsius = 44;
        double gradosFarenheit = ((9 / 5) * gradosCelsius) + 32;
        System.out.println(gradosCelsius + " grados Celsius son " + gradosFarenheit + " grados Farenheit");
    }
}
