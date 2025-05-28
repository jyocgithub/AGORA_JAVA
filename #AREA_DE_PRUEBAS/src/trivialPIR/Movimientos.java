package trivialPIR;

import java.util.*;

public class Movimientos {

    private Tablero tablero;
    private ArrayList<Integer> usados = new ArrayList<>();

    public Movimientos(Tablero tablero) {
        this.tablero = tablero;
        tablero.cargaCasillas();
    }


    public int azar(int rango){
        Random r = new Random();
        int n = r.nextInt(rango)+1;
        return n;
    }


    public TreeSet<Integer> dimeSalidas(int nodoactual, int pasosPendientes) {
//        tablero.cargaCasillas();
        usados = new ArrayList<>();
        TreeSet<Integer> soluciones = new TreeSet<>();
        buscarSalidas2( nodoactual,  pasosPendientes,  soluciones);
        return soluciones;
    }


    public void buscarSalidas2(int nodoactual, int pasosPendientes,  TreeSet<Integer> soluciones) {

        if (pasosPendientes == 1) {
            int tam = tablero.casillas.get(nodoactual).nodos.size();
            for (int i = 0; i < tam; i++) {
                ArrayList<Integer> s = tablero.casillas.get(nodoactual).nodos;
                int nodolateral = tablero.casillas.get(nodoactual).nodos.get(i);
                if ( ! usados.contains(nodolateral)) {
                    soluciones.add(nodolateral);
                    usados.add(nodolateral);
                }
            }
            return;

        } else {
            pasosPendientes--;
            int tam = tablero.casillas.get(nodoactual).nodos.size();
            for (int i = 0; i < tam; i++) {
                ArrayList<Integer> s = tablero.casillas.get(nodoactual).nodos;
                int nodolateral = tablero.casillas.get(nodoactual).nodos.get(i);
                if ( ! usados.contains(nodolateral)) {
                    ArrayList<Integer> nodosdellateral =  tablero.casillas.get(nodolateral).nodos;
                    usados.add(nodoactual);
                    buscarSalidas2(nodolateral, pasosPendientes,  soluciones);
                }
            }
        }
    }

//    public void buscarSalidas(int nodoactual, int pasosPendientes,  TreeSet<Integer> soluciones) {
//
//        if (pasosPendientes == 1) {
//            int tam = tablero.casillas.get(nodoactual).nodos.size();
//            for (int i = 0; i < tam; i++) {
//                ArrayList<Integer> s = tablero.casillas.get(nodoactual).nodos;
//                int nodo = tablero.casillas.get(nodoactual).nodos.get(i);
//                if (nodo != 0 ) {  // es un nodo valido
//                    soluciones.add(nodo);
//                }
//            }
//            return;
//
//        } else {
//            pasosPendientes--;
//            ArrayList<Integer> adyacentes = tablero.casillas.get(nodoactual).nodos;
//            for (int i = 0; i < adyacentes.size(); i++) {
//                int nodolateral = adyacentes.get(i);
//                if (nodolateral != 0) {
//                    ArrayList<Integer> nodosdellateral =  tablero.casillas.get(nodolateral).nodos;
//                    nodosdellateral.set(nodosdellateral.indexOf(nodoactual),0);
//                    buscarSalidas(nodolateral, pasosPendientes,  soluciones);
//                }
//            }
//        }
//    }
}
