package cap03;

import java.util.Scanner;

/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */


public class Jyoc_Ejercicio_3_c_13_TrianguloDePascal {


    public static void main(String[] args) {

        System.out.println("Indica el numero a procesar");
        int n = new Scanner(System.in).nextInt();

        pascal(n);


    }


    public static void pascal( int nfilas) {

        int[] filaanterior = new int[1];
        for (int i = 1; i <= nfilas; i++) {
            int[] filaactual = new int[i];
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == (i - 1)) {  //es el primer o ultimo numero de cada fila
                    filaactual[j] = 1;
                } else {                       // es un numero intermedio de cada fila
                    filaactual[j] = filaanterior[j] + filaanterior[j - 1];
                }
                System.out.print(filaactual[j] + "\t");
            }
            filaanterior = filaactual;
            System.out.println();
        }
    }

}
