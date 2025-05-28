package cap04;
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

public class Jyoc_Ejercicio_4_f_02_CuadradoMagico {
/*
Realiza un programa que construya un cuadrado mágico
Para empezar se introduce por teclado un número impar comprendido entre 3 y 21.
Esto determinará la matriz de elementos n*n en la que tenemos que colocar los números de 1 a n*n de tal forma que las ﬁlas, las columnas y las dos diagonales principales sumen lo mismo.
El primer elemento, el 1, se sitúa siempre en el centro de la matriz pero una posición arriba, es decir, una ﬁla más arriba.
El siguiente número, el 2 se sitúa una ﬁla arriba y una columna a la derecha.
El procedimiento continúa con los siguientes números consecutivos, hasta que se encuentre una posición en la que hay ya un número anterior. En este caso la nueva posición, será partiendo de la posición ocupada una ﬁla menos y una columna menos.
Al ﬁnal del proceso se tienen que quedar colocados los números de 1 a n*n en la matriz de elementos dependiendo de la dimensión de la misma.
Se pinta la matriz, con la suma de filas y columnas para comprobar que el cuadrado es realmente mágico.

 */

    static int tamano, fil, col, actual = 1;
    static int[][] mat;

    public static void main(String[] args) {
        tamano = 7;

        mat = new int[tamano][tamano];


        // primero
        col = tamano /2 +1;   // debe ser el centro
        fil = tamano/2 +1;  // debe ser el centro
        subirfila();
        mat[fil][col] = actual;

        do {
            actual++;

            siguiente(false);
            pintamatriz();
        } while (actual < tamano * tamano);

    }

    public static void siguiente(boolean hubofallo) {

        if (hubofallo) {
            subirfila();
            colizda();
        } else {
            subirfila();
            colDerecha();
        }

        if (mat[fil][col] == 0) {
            mat[fil][col] = actual;
        } else {
            siguiente(true);
        }

    }

    public static void subirfila() {
        fil = fil - 1;
        if (fil < 0) {
            fil = tamano - 1;
        }
    }

    public static void colDerecha() {
        col = col + 1;
        if (col > tamano - 1) {
            col = 0;
        }
    }

    public static void colizda() {
        col = col - 1;
        if (col < 0) {
            col = tamano - 1;
        }
    }

    public static void pintamatriz() {
        int[] sumacols = new int[tamano];
        System.out.println("\n\n===========================");
        for (int f = 0; f < tamano; f++) {
            int sumafila = 0;
            for (int c = 0; c < tamano; c++) {
                System.out.print(mat[f][c] + "\t");
                sumafila += mat[f][c];
                sumacols[c] += mat[f][c];
            }
            System.out.println("   -> " + sumafila);
        }

        System.out.println("---------------------------------------------------");
        for (int i = 0; i <tamano ; i++) {
            System.out.print(sumacols[i] + "\t");

        }
    }
}