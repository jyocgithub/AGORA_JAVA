package cap50_a_02_fabricadetrajes.clases;

/**
 * Blusa
 *
 * @author inaki
 */
public class Blusa extends Componente {

    private boolean mangaLarga;

    public Blusa(boolean mangaLarga, int id, String nombre, String talla, String color, boolean escomunitario, double precio) {
        super(id, nombre, talla, color, escomunitario, precio);
        this.mangaLarga = mangaLarga;
    }

    public boolean isMangaLarga() {
        return mangaLarga;
    }

    void aplicarRebaja(boolean estaEnRebajas) {
        if (estaEnRebajas) {
            precio = precio / 2;
        } else {
            precio = precio * 2;
        }
    }

    @Override
    public String toString() {
        return "id=" + id + " - Blusa :" + nombre + ", talla " + talla + ", color " + color + ", mangaLarga (" + mangaLarga + "), precio " + precio;
    }
}
