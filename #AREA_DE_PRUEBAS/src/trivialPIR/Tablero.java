package trivialPIR;

import java.util.ArrayList;
import java.util.Arrays;


//-------------------------------------------------------------
class Tablero {
    ArrayList<Casilla> casillas = new ArrayList<>();

    public void cargaCasillas() {
        casillas.clear();

        Integer[][] matriz =
                {
                        {0, 0, 0},   //0
                        {2, 16, 24}, //1
                        {1, 3}, //2
                        {2, 4}, //3
                        {3, 5}, //4
                        {4, 6, 23}, //5
                        {5, 7}, //6
                        {6, 8}, //7
                        {7, 9}, //8
                        {8, 10, 29}, //9
                        {9, 11}, //10
                        {10, 12}, //11
                        {11, 13}, //12
                        {12, 14, 17}, //13
                        {13, 15}, //14
                        {14, 16}, //15
                        {1, 15}, //16
                        {13, 18}, //17
                        {17, 19}, //18
                        {18, 20}, //19
                        {19, 21, 26, 27}, //20
                        {20, 22}, //21
                        {21, 23}, //22
                        {5, 22}, //23
                        {1, 25}, //24
                        {24, 26}, //25
                        {20,25}, //26
                        {20, 28}, //27
                        {27, 29}, //28
                        {9, 28}, //29

                };


        for (int i = 0; i < matriz.length; i++) {
            Casilla c = new Casilla(i);
            ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(matriz[i]));
            c.nodos = lista;
            casillas.add(c);
        }
    }















}

