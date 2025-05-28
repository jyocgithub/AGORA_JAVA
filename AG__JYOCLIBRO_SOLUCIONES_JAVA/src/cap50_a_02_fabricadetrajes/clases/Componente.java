package cap50_a_02_fabricadetrajes.clases;

/**
 * cap50_a_12_MundialBaloncesto.clases.Componente
 *
 * @author inaki
 */
public abstract class Componente {
    protected int id;
    protected String nombre;
    protected String talla;
    protected String color;
    protected boolean escomunitario;
    protected double precio;
    protected boolean sonRebajas=false;

    public Componente(int id, String nombre, String talla, String color, boolean escomunitario, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.escomunitario = escomunitario;
        this.precio = precio;
    }

    // Cambia el precio de un componente dependiendo de si se activan o desactivan las rebajas
    // La rebaja en blusas es del 50%, en pantalones  y faldas, un 40% y en chaquetas, un 25%
    abstract void aplicarRebaja(boolean estaEnRebajas);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEscomunitario() {
        return escomunitario;
    }

    public void setEscomunitario(boolean escomunitario) {
        this.escomunitario = escomunitario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "cap50_a_12_MundialBaloncesto.clases.Componente{" + ", nombre='" + nombre + '\'' + ", talla='" + talla + '\'' + ", color='" + color + '\'' + ", escomunitario=" + escomunitario + ", precio=" + precio + '}';
    }
}
