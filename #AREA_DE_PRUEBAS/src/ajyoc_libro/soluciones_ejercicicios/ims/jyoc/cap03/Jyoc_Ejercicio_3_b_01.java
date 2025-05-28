package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio b_1
 * Pedir números hasta que se teclee un 0, 
 * mostrar la suma y la media de todos los números introducidos.
 */
public class Jyoc_Ejercicio_3_b_01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int suma = 0;
        double contador = 0;
        double media = 0.0;
        System.out.println("Escriba un numero y pulse INTRO");
        int num = sc.nextInt();
        while (num != 0) {
            suma = suma + num;
            contador++;
            System.out.println("\nEscriba un numero y pulse INTRO");
            num = sc.nextInt();
        }
        System.out.println("Se han pedido " + contador + " numeros");
        System.out.println("La suma es  " + suma);
        media = (suma / contador);
        System.out.println("la media es " + media);

        // ADVERTIR QUE SI LA VARIABLE CONTADOR ES DE TIPO INT, NO FUNCIONA
    }
}
