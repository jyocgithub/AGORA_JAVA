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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "ALMACEN_CENTRAL")
@XmlType(propOrder = {  "nombre", "listaarticulos" })

public class Almacen {
  private String nombre;

  private List<Articulo> listaarticulos;

  public Almacen(String nombre, List<Articulo> listaarticulos) {
    super();
    this.nombre = nombre;
    this.listaarticulos = listaarticulos;
  }

  public Almacen() {
    super();
  }

  public String getNombre() {
    return nombre;
  }

  @XmlElement
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<Articulo> getListaarticulos() {
    return listaarticulos;
  }

  // Si hay un  @XmlElementWrapper  junto a un @XmlElement   DEBEN IR EN ESTE ORDEN:
  // XmlElementWrapper es el nombre,en el XML,  de la etiqueta agrupadora
  // si no se pone esto, ES POR QUE NO HAY AGRUPACION, los elementos de la lista no tienen etiqueta comun
  @XmlElementWrapper(name = "articulos")
  // XmlElement es el nombre, en el XML, de cada etiqueta agrupada
  // si no se pone esto, se usa en cada elemento el nombre de la coleccion (condiciones)
  @XmlElement(name = "Condiciones")
  public void setListaarticulos(List<Articulo> listaarticulos) {
    this.listaarticulos = listaarticulos;
  }

  @Override
  public String toString() {
    return "Almacen{" +
            "nombre='" + nombre + '\'' +
            ", listaarticulos=" + listaarticulos +
            '}';
  }
}