package soluciones_ejercicicios.ims.jyoc.cap04;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Capitulo 4 Ejercicio a_10
 * Escribir un programa que sea capaz de calcular la letra de un NIF a partir del número del DNI. El
 * programa debe poseer al menos un método encargado de pedir al usuario el DNI de 8 dígitos y otro que
 * calculará la letra del NIF (se pueden añadir más métodos auxiliares). Al finalizar el programa se debe
 * presentar el NIF completo con el formato: ocho dígitos, un guion y la letra en mayúscula; por ejemplo:
 * 00395469-F.
 * ALGORITMO DE CALCULO DE LA LETRA DE UN NIF: la letra se calculará de la siguiente
 * forma: Se obtiene el resto de la división entera del número del DNI entre 23 y se usa la siguiente tabla
 * para obtener la letra que corresponde, esta tabla debe estar almacenada en un array para buscar la letra
 * por su posición.
 * Según lo dicho, con dicha tabla se puede tener un array en Java con las letras colocadas en su orden;
 * String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q",
 * "V", "H", "L", "C", "K", "E"}; Por ejemplo, si introducimos el DNI 20267079, el resto de dividirlo por
 * 23 sería 8, luego la letra sería la P, que es la que ocupa esa posició en la matriz de caracteres.
 */
public class Jyoc_Ejercicio_4_a_10 {
    public static void main(String[] args) throws IOException {
        String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nIntroduzca un numero:");
        int num = Integer.parseInt(br.readLine());

        int pos = num % 23;
        String letra = letras[pos];
        System.out.print("\nNIF: " + num + "-" + letra);
    }
}
