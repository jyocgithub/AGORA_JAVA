package jaxb.articulos;
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

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "nombre", "descripcion", "precio", "stock" })
public class Articulo {

    private int id;
    private String nombre;
    private String descripcion;
    private int stock;
    private double precio;

    public Articulo(int id, String nombre, String descripcion, int stock, double precio) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }

    public Articulo() {
        super();
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    @XmlElement
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @XmlElement
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    @XmlElement(name = "cantidad")
    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    @XmlElement
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Articulo [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", stock=" + stock
                + ", precio=" + precio + "]";
    }

}