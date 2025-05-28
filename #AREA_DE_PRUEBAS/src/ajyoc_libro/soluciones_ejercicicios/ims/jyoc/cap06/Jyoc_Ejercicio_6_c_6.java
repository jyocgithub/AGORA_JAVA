package soluciones_ejercicicios.ims.jyoc.cap06;

import java.util.Scanner;
/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 6 Ejercicio c_6
 * Realizar un método que reciba una frase y calcule la suma de los
 * números que aparecen en ella. Por ejemplo, si la frase es "Juan cobro 134 y Andrés 26"
 * la suma será 134+26 =160. Simplificado: suponer que los números siempre tienen un blanco antes y otro después.
 * (realizarlo cuando haya explicado las clases de envoltura)
 */
public class Jyoc_Ejercicio_6_c_6 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriba frase");
        String texto = entrada.nextLine();

        int res = calcular(texto);
        System.out.println("suma de numeros de la frase:" + res);
    }

    public static int calcular(String cadena) {
        int sumatotal = 0;
        int numero = 0;
        String numerocreado = "0";

        // el bucle va a ir hasta cadena.length()-1 por que el ultimo caracter no puede ser
        // un numero (pues los numeros tienen un espacio detras),
        // y como se compara cada caracter con el anterior y el siguiente,
        // si vamos hasta  cadena.length() podemos pasarnos de fin de cadena
        // por la misma razon i empieza en el bucle con 1, no con 0, por que el primer caracter
        // no puede ser un numero (pues los numeros tienen un espacio delante)
        for (int i = 1; i < cadena.length() - 1; i++) {
            // extraemos cada caracter de la cadena
            char cadachar = cadena.charAt(i);
            // vemos cuales son los char anterior y siguiente a este
            char charanterior = cadena.charAt(i - 1);
            char charsiguiente = cadena.charAt(i + 1);

            // si el char es un numero, vemos que hacer con el
            if (cadachar >= '0' && cadachar <= '9') {

                // solo seguimos si el char siguiente es un numero o un blanco
                if (charsiguiente == ' ' || (charsiguiente >= '0' && charsiguiente <= '9')) {

                    // si el char anterior a este es otro numero, o un espacio, lo añadimos a numerocreado
                    if (charanterior == ' ' || (charanterior >= '0' && charanterior <= '9')) {
                        numerocreado = numerocreado + cadachar;

                        // si ademas el char siguiente es un espacio, el numerocreado se ha acabado,
                        // asi que lo sumamos a la sumatotal
                        if (charsiguiente == ' ') {
                            int numerocreadoEnInt = Integer.parseInt(numerocreado);
                            sumatotal = sumatotal + numerocreadoEnInt;
                            // y ponemos numerocreado a "" , pues ya no hay numero a crear
                            numerocreado = "0";
                        }
                    }
                }
            }
        }
        return sumatotal;
    }

}
