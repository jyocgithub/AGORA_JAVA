package trivialPIR;

import java.util.ArrayList;


//-------------------------------------------------------------
class Casilla {
    int id;
    ArrayList<Integer> nodos = new ArrayList<>();
    int idDeImagen;

    public Casilla(int id) {
        this.id = id;
    }
}
