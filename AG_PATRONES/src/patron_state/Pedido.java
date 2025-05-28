package patron_state;


import java.util.*;


/*      PATRON STATE

La clase Pedido posee métodos cuyo comportamiento varía en función de este estado.
Por ejemplo, el método agregaProducto sólo permite agregar productos si el pedido se
encuentra en el estado EnCurso. El método borra no hace ninguna acción en el estado Entregado.

El enfoque tradicional para resolver estas diferencias en el comportamiento consiste
en utilizar condiciones en el cuerpo de los métodos. Este enfoque conduce a menudo a
métodos complejos de escribir y de comprender.

El patrón State proporciona otra solución que consiste en transformar cada estado en una clase.
Esta clase incluye los métodos de la clase Pedido dependiendo de los estados confiriendo el
comportamiento propio de cada estado.


Elementos;

- MáquinaEstados (Pedido) es una clase concreta que describe los objetos que son máquinas de estados,
es decir que poseen un conjunto de estados que pueden ser descritos mediante un diagrama de estados y transiciones.
Esta clase mantiene una referencia hacia una instancia de una subclase de Estado que define el estado en curso.
- Estado (EstadoPedido) es una clase abstracta que incluye los métodos ligados al estado y que gestionan la
asociación con la máquina de estados.
-EstadoConcretoA y EstadoConcretoB (PedidoEnCurso, PedidoValidado y PedidoEntregado) son subclases concretas
que implementan el comportamiento de los métodos relativos a cada estado.


 */



public class Pedido {

    protected List<Producto> productos = new ArrayList<Producto>();

    protected EstadoPedido estadoPedido;

    public Pedido() {
        estadoPedido = new PedidoEnCurso(this);
    }

    public void agregaProducto(Producto producto) {
        estadoPedido.agregaProducto(producto);
    }

    public void suprimeProducto(Producto producto) {
        estadoPedido.suprimeProducto(producto);
    }

    public void borra() {
        estadoPedido.borra();
    }

    public void estadoSiguiente() {
        estadoPedido = estadoPedido.estadoSiguiente();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void visualiza() {
        System.out.println("Contenido del pedido");
        for (Producto producto : productos)
            producto.visualiza();
        System.out.println();
    }

}

abstract class EstadoPedido {
    protected Pedido pedido;
    public EstadoPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public abstract void agregaProducto(Producto producto);
    public abstract void borra();
    public abstract void suprimeProducto(Producto producto);
    public abstract EstadoPedido estadoSiguiente();
}

//******************************************************************************
//******************************************************************************

class PedidoEnCurso extends EstadoPedido {

    public PedidoEnCurso(Pedido pedido) {
        super(pedido);
    }

    public void agregaProducto(Producto producto) {
        pedido.getProductos().add(producto);
    }

    public void borra() {
        pedido.getProductos().clear();
    }

    public void suprimeProducto(Producto producto) {
        pedido.getProductos().remove(producto);
    }

    public EstadoPedido estadoSiguiente() {
        return new PedidoValidado(pedido);
    }
}

//******************************************************************************
//******************************************************************************
class PedidoValidado extends EstadoPedido {

    public PedidoValidado(Pedido pedido) {
        super(pedido);
    }

    public void agregaProducto(Producto producto) {
    }

    public void borra() {
        pedido.getProductos().clear();
    }

    public void suprimeProducto(Producto producto) {
    }

    public EstadoPedido estadoSiguiente() {
        return new PedidoEntregado(pedido);
    }

}

//******************************************************************************
//******************************************************************************
class PedidoEntregado extends EstadoPedido {

    public PedidoEntregado(Pedido pedido) {
        super(pedido);
    }

    public void agregaProducto(Producto producto) {
    }

    public void borra() {
    }

    public void suprimeProducto(Producto producto) {
    }

    public EstadoPedido estadoSiguiente() {
        return this;
    }
}

//******************************************************************************
//******************************************************************************
class Producto {
    protected String nombre;
    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public void visualiza() {
        System.out.println("Producto: " + nombre);
    }
}