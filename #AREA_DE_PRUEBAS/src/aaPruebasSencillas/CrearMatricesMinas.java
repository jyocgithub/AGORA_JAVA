package aaPruebasSencillas;

import java.util.Random;

public class CrearMatricesMinas {


    public static void main(String[] args) {
        Tablero t = new Tablero(8, 8, 12);

    }


}


class Tablero {

    int numfils = 8;
    int numcols = 8;
    int numminas;
    int[][] matriz;

    public Tablero(int numfils, int numcols, int numminas) {
        this.numfils = numfils;
        this.numcols = numcols;
        this.numminas = numminas;
        matriz = new int[numfils][numcols];
        inicializarMatriz();

        pintarmatriz();
    }


    public void inicializarMatriz() {
        // rellenar la matriz con 0
        for (int f = 0; f < numfils; f++) {
            for (int c = 0; c < numcols; c++) {
                matriz[f][c] = 0;
            }
        }

        // meter las minas
        Random r = new Random();
        int minaspuestas = 0;
        do {
            int fazar = r.nextInt(numcols);
            int cazar = r.nextInt(numfils);
            if (matriz[cazar][fazar] == 0) {   // elemento aun no usado
                if (noHayNadieAlrededor(fazar, cazar)) {
                    matriz[cazar][fazar] = 1;
                    minaspuestas++;
                    pintarmatriz();
                }
            }
        } while (minaspuestas < numminas);
    }

    public boolean noHayNadieAlrededor(int fazar, int cazar) {
        boolean resultado = true;
        // miramos debajo
        if (fazar < numfils - 1) {  // no es el borde inferior
            if (matriz[fazar + 1][cazar] != 0) {
                return false;
            }
        }
        // miramos encima
        if (fazar > 0) {          // no es el borde superior
            if (matriz[fazar - 1][cazar] != 0) {
                return false;
            }
        }
        // miramos izda
        if (cazar < numcols - 1) {  // no es el borde izquierdo
            if (matriz[fazar][cazar + 1] != 0) {
                return false;
            }
        }
        // miramos derecha
        if (cazar > 0) {          // no es el borde derecho
            if (matriz[fazar][cazar - 1] != 0) {
                return false;
            }
        }

        // miramos arriba y izquierda
        if (cazar > 0 && fazar > 0) {
            if (matriz[fazar - 1][cazar - 1] != 0) {
                return false;
            }
        }


        // miramos arriba y derecha
        if (cazar < numcols - 1 && fazar > 0) {
            if (matriz[fazar - 1][cazar + 1] != 0) {
                return false;
            }
        }

        // miramnos abajo izquierda
        if (cazar > 0 && fazar < numfils - 1) {
            if (matriz[fazar + 1][cazar - 1] != 0) {
                return false;
            }
        }

        // miramos abajo derecha
        if (cazar < numcols - 1 && fazar < numfils - 1) {
            if (matriz[fazar + 1][cazar + 1] != 0) {
                return false;
            }
        }

        return resultado;
    }


    public void pintarmatriz() {
            System.out.println("----------------------------");
        for (int f = 0; f < numfils; f++) {
            for (int c = 0; c < numcols; c++) {
                System.out.print(matriz[f][c] + " ");
            }
            System.out.println();
        }
    }

}
