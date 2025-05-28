package aaPruebasSencillas;

import java.util.Scanner;

public class AAZonaDePruebas {
// ejemplos simples

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numI, num, contD = 0, contP = 0, copiaI;
        System.out.println("Introduzca un numero: ");
        numI = sc.nextInt();
        copiaI = numI;
        while (copiaI > 0) {
            contD = 0;
            for (num = 1; num <= copiaI; num++) {
                if (copiaI % num == 0) {
                    contD++;
                }
            }
            if (contD <= 2) {
                contP++;
            }
            copiaI--;
        }
        System.out.println("Entre 1 y " + numI + " hay " + contP + " numeros primos");
    }
}