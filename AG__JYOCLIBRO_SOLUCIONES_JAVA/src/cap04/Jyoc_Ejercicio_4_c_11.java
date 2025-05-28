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
/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 *
 * @author Iñaki Martin
 */

/**
 * Capitulo 4 Ejercicio c_11
 * Crear un array de Strings con las 27 fichas de domino, usando bucles.
 * Las fichas seran algo asi: "0:0" "3:4" "6:6"
 * Escribir posteriormente el array.
 *
 * MEJORA 1: hacer posteriormente el reparto inicial de las fichas, que quedan en 4 arrays de 7 fichas.
 */
public class Jyoc_Ejercicio_4_c_11 {
    public static void main(String[] args) {

        String[] fichas = new String[28];

        int indice = 0;
        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= 6; j++) {
                if (0 <= i && i <= j && j <= 6) {
                    fichas[indice] = i + ":" + j;
                    indice++;
                }
            }
        }

        for (int i = 0; i < 28; i++) {
            System.out.println(i+"-"+fichas[i]);
        }

        // MEJORA 1

        // desordenamos el array
        for (int i = 0; i <100 ; i++) {
            int a = (int) (Math.random()*28);
            int b = (int) (Math.random()*28);
            String aux  = fichas[a];
            fichas[a] = fichas[b];
            fichas[b] = aux;
        }

        // Repartimos en 4 arrays
        String[] fichasJugador1 = new String[8];
        String[] fichasJugador2 = new String[8];
        String[] fichasJugador3 = new String[8];
        String[] fichasJugador4 = new String[8];


        for (int i = 0; i < 7; i++) {
            fichasJugador1[i]=fichas[i];
            System.out.println("J1: " +fichasJugador1[i]);
        }
        for (int i = 7; i < 14; i++) {
            fichasJugador2[i-7]=fichas[i];
            System.out.println("J2: " +fichasJugador2[i-7]);
        }
        for (int i = 14; i < 21; i++) {
            fichasJugador3[i-14]=fichas[i];
            System.out.println("J3: " +fichasJugador3[i-14]);
        }
        for (int i = 21; i < 28; i++) {
            fichasJugador4[i-20]=fichas[i];
            System.out.println("J4: " +fichasJugador4[i-20]);
        }


    }
}
