/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras_estaticas;

/**
 *
 * @author iniaski
 */
public class pruebas2 {

    public static void main(String[] args) {


        // creamos una matriz
        int[][] mimatriz = new int[4][4];

        // inincializando matriz con numeros aleatorios
        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                mimatriz[fila][columna] = (int) (Math.random() * 9);
            }
        }

        // pintamos la matriz
        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                System.out.print("\t" + mimatriz[fila][columna]);
            }
            System.out.println("");
        }

        // creamos otra matriz
        int[][] matriz2 = new int[4][4];

        // copiamos la traspuesta de la original en la nueva matriz
        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                matriz2[columna][fila] = mimatriz[fila][columna];
            }
        }

        // pintamos la nueva matriz
        System.out.println("");
        for (int fila = 0; fila < 4; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                System.out.print("\t" + matriz2[fila][columna]);
            }
            System.out.println("");
        }

// 4 6 2
// 9 8 7 
// 1 2 2 
        int[][] a = new int[3][3];

        // primera fila
        int total = 0;
        for (int i = 0; i < 3; i++) {
            total = total + a[0][i];

        }

        int total1 = a[0][0]
                + a[0][1]
                + a[0][2];

        // primera columna
        int total3 = a[0][0] + a[1][0] + a[2][0];

        // primera diagonal
        int total4 = a[0][0] + a[1][1] + a[2][2];

        // TAMAÑOP DE UNA MATRIZ
        // NUMERO DE FILAS DE LA MATRIZ
        int numfilas = a.length;
        // NUMERO DE COLUMNAS
        int numcolumnas = a[0].length;

        // SI FUERA UNA MATRIZ DE TRES DIMENSIONES, EL TAMAÑO DE LA TERCERA 
        // DIMENSION SE SACA ASI:
        // int numterceradim = a[0][0].legth;
//        int suma = 0;
//        for (int fila = 0; fila < 4; fila++) {
//            for (int columna = 0; columna < 4; columna++) {
//                suma = suma + mimatriz[fila][columna];
//            }
//        }
//
//        System.out.println("la suma es :" + suma);
//
//        int[][] dias = new int[5][7];
//        int contador = 1;
//        for (int fila = 0; fila < 5; fila++) {
//            for (int columna = 0; columna < 7; columna++) {
//                if (contador < 32) {
//                    dias[fila][columna] = contador;
//                    contador++;
//                }
//            }
//        }
//        
//        contador = 1;
//        for (int fila = 0; fila < 5; fila++) {
//            for (int columna = 0; columna < 7; columna++) {
//                if (contador <= 31) {
//                    System.out.print("\t" + dias[fila][columna]);
//                    contador++;
//                }
//            }
//            System.out.println("");
//        }
    }
}
