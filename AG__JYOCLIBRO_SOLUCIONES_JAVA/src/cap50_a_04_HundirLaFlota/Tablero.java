package cap50_a_04_HundirLaFlota;

public class Tablero {
    char[][] celdas;
    int numIntentos;
    int numAguas;
    int numFilas;
    int numCol;
    int numHundidos;

    // *******************************************************
    public Tablero(int numFilas, int numCol) {
        this.numFilas = numFilas;
        this.numCol = numCol;
        this.numIntentos = 0;
        this.numAguas = 0;
        this.numHundidos = 0;
        this.celdas = new char[numFilas][numCol];
    }

}