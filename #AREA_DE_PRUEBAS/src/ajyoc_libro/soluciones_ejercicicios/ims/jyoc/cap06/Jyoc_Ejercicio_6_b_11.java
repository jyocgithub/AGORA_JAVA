package soluciones_ejercicicios.ims.jyoc.cap06;

import java.util.Scanner;
/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 6 Ejercicio a_11
 * Realizar un método que reciba una frase y calcule la suma de los
 * dígitos que aparecen en ella. Por ejemplo, si la frase es "Juan cobro 134 y Andrés 26"
 * la suma será 1+3+4+2+6 =16 (realizarlo cuando haya explicado las clases de envoltura)
 */
public class Jyoc_Ejercicio_6_b_11 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Escriba frase");
        String texto = entrada.nextLine();

        int res = calcular(texto);
        System.out.println("suma de numeros de la frase:" + res);
    }

    public static int calcular(String cadena) {
        int respuesta = 0;
        int numero = 0;
        for (int i = 0; i < cadena.length(); i++) {
            // extraemos cada caracter de la cadena
            char cadachar = cadena.charAt(i);

            // si el char es un numero, lo sumamos
            if (cadachar >= '0' && cadachar <= '9') {
                numero = cadachar - '0';
                respuesta = respuesta + numero;
            }
        }
        return respuesta;
    }

}
