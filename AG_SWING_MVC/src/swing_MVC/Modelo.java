package swing_MVC;

import java.util.ArrayList;

public class Modelo {

    public  ArrayList<Empleado> leerEmpleados(){
        ArrayList<Empleado> lista = new ArrayList<>();
        lista.add( new Empleado("1234567J", "Eva"));
        lista.add( new Empleado("1111111H", "Luis"));
        lista.add( new Empleado("6534343D", "Pepa"));
        lista.add( new Empleado("4423244K", "Ana"));
        lista.add( new Empleado("6655334G", "Raul"));
        lista.add( new Empleado("1654646Q", "Blas"));
        return lista;
    }

    public Empleado dameEmpleadoPorNombre(String nom){
        // poner logica que devuelta el empleado o null
        Empleado e = new Empleado();
        return e;
    }

}
