package cap50_a_02_fabricadetrajes.clases;

/**
 * Blusa
 *
 * @author inaki
 */
public class Chaqueta extends Componente {

    private int numBotones;

    public Chaqueta(int numBotones, int id, String nombre, String talla, String color, boolean escomunitario, double precio) {
        super(id, nombre, talla, color, escomunitario, precio);
        this.numBotones = numBotones;
    }

    public int getNumBotones() {
          return numBotones;
     }

    void aplicarRebaja(boolean estaEnRebajas){
        int descuento = 40;
        if(estaEnRebajas){
            precio = precio * ( (100-descuento) / 100);
        }else{
            precio = precio / ( (100-descuento) / 100);
        }
    }

    @Override
    public String toString() {
        return "id=" + id + " - Chaqueta :" + nombre + ", talla " + talla + ", color " + color + ", Botones (" + numBotones + "), precio=" + precio;
    }
}
