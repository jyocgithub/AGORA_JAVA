package trivialPIR;

import java.util.ArrayList;
import java.util.TreeSet;
/*
                       01
                  16   24   02
              15       25      03
           14          26         04
        13   17 18 19  20 21 22 23   05
           12          27         06
              11       28      07
                  10   29   08
                       09
 */

public class PruebaTrivialPIR {

    public static void main(String[] args) {

        Tablero t = new Tablero();
        Movimientos m = new Movimientos(t);
//        m.cargaCasillas();


        int celdainicial =20;
        int valortirada = 3;
        TreeSet<Integer> soluciones = m.dimeSalidas(celdainicial, valortirada);

        for (int i : soluciones) {
            System.out.println(i);
        }


        System.out.println("======================");
//        celdainicial = 2;
//        valortirada = 2;
        soluciones = m.dimeSalidas(celdainicial, valortirada);

        for (int i : soluciones) {
            System.out.println(i);
        }
    }
}
//-------------------------------------------------------------


