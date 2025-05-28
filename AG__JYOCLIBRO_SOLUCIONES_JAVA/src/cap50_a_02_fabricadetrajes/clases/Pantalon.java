package cap50_a_02_fabricadetrajes.clases;

/**
 * Blusa
 *
 * @author inaki
 */
public class Pantalon extends Componente {

    private boolean conCremallera;

    public Pantalon(boolean concremallera, int id, String nombre, String talla, String color, boolean escomunitario, double precio) {
        super(id, nombre, talla, color, escomunitario, precio);
        this.conCremallera = concremallera;
    }

     public boolean isConcremallera() {
          return conCremallera;
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
        return "id=" + id + " - Pantalon :" + nombre + ", talla " + talla + ", color " + color + ", cremallera (" + conCremallera + "), precio=" + precio;
    }

}
