package soluciones_ejercicicios.ims.jyoc.cap02;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 2 Ejercicio a_11
 * Explicar qué hace este programa e indicar que se escribe por la consola,
 * suponiendo que a la variable nota  se le asignan diferentes valores en
 * diferentes ejecuciones del programa (los valores que se han
 * de probar son  3,4, 5, 6, 7, 8, 9 y 10). Si se ve algún error en la lógica
 * o en la ejecución del programa, proponer una solución
 */
public class Jyoc_Ejercicio_2_a_11 {

    public static void main(String[] args) {

        int nota = 7;
        if (nota >= 5) {
            System.out.print("El resultado es aprobado ");
            switch (nota) {
                case 5:
                case 6:
                    break;
                case 7:
                case 8:
                    System.out.println(" con Notable");
                    break;
                case 10:
                    System.out.println(" con Matrícula");
                case 9:
                    System.out.println(" y con Sobresaliente");
            }
        } else {
            System.out.println("El resultado es suspenso");
        }


        /**
         * Ejecucion del programa: Va a dar la nota en letras
         * correspondiente a la nota numerica de la variable Si el valor
         * de la nota es menor de 5 no esntra en el switch y simplemente
         * da suspenso Si es mayor de 4 indica que el alumno ha
         * aprobado, y si la nota es 5 o 6, se sale del switch si la
         * nota es 7 u 8, entra en cualquiera de estos dos case, y acaba
         * por indicar "con notable" y si la nota es 9 dice
         * "con sobresaliente" y si es 10 "y con matricula" La pega es
         * que el mensaje de 9 tambien dice "y con matricula" (no
         * encuentra un break y sigue con el resto de cases) y el del 10
         * no dice "con sobresaliente" (eso se dice solo en el case del 9)
         *
         * La solución más simples es meter el break al 9 y cambiar los
         * mensajes.
         *
         * case 9:
         *     System.out.println("con Sobresaliente");
         *     break;
         * case 10:
         *     System.out.println("con Sobresaliente y con Matrícula");
         *
         * Se admiten soluciones mas refinadas !!
         */
    }
}
