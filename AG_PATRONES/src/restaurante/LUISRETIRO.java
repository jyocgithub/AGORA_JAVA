package restaurante;

public class LUISRETIRO {

    public static void main(String[] args) {
        restaurante re1 = new restaurante();
        re1.crearSucursal("Restaurante1", 1990, "Italiano");

    }

}

class negocio {

    private String nombre;
    private int fundacion;

    public void especificarNegocio(String n, int f) {
        nombre = n;
        fundacion = f;
    }

    public void mostrar() {
        System.out.print("Nombre " + nombre + " Año Fundación "+ fundacion);
    }
}

abstract class sucursal {
    public negocio ne;
    public abstract void crearSucursal(String e, int a, String t);
}

class restaurante extends sucursal {

    String tipo;

    public void crearSucursal(String e, int a, String t) {
        tipo = t;
        ne = new negocio();
        ne.especificarNegocio(e, a);
        ne.mostrar();
        System.out.println(" Tipo de restaurante: " + tipo);
    }

}
