package cap50_a_02_fabricadetrajes.clases;

import java.util.ArrayList;

/**
 * Traje
 *
 * @author inaki
 */
public class Traje {
    String nombre;
    ArrayList<Componente> piezas;

    public Traje(String nombre) {
        this.nombre = nombre;
        piezas = new ArrayList<>();
    }

    public ArrayList<Componente> getPiezas() {
        return piezas;
    }

    public void setPiezas(ArrayList<Componente> piezas) {
        this.piezas = piezas;
    }

    public void anadirPieza(Componente com) {
        piezas.add(com);
    }

    public String toString() {
        String res = "";
        res += "\nTraje: " + this.nombre;
        for (int i = 0; i < piezas.size(); i++) {
            res += "\ncap50_a_12_MundialBaloncesto.clases.Componente:  " + piezas.get(i).getNombre();
            res += "\n\tTalla: " + piezas.get(i).getTalla();
            res += "\n\tColor: " + piezas.get(i).getColor();
            res += "\n\tPrecio: " + piezas.get(i).getPrecio();
            res += "\n\tEs comunitario: " + piezas.get(i).isEscomunitario();
        }
        return res;
    }

}
