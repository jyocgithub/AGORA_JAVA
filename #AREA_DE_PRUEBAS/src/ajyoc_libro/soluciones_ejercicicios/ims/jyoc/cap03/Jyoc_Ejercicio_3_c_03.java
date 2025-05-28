package soluciones_ejercicicios.ims.jyoc.cap03;

import java.util.Scanner; /**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 3 Ejercicio c_3
 * 	Escribir un programa que muestre  esto por pantalla:
 *	X
 *	XX
 *	XXX
 *	XXXX
 *	XXXXX
 */
public class Jyoc_Ejercicio_3_c_03 {

    public static void main(String[] args) {

        for (int i = 1; i < 6; i++) {
            for (int h = 1; h <= i; h++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }
}
