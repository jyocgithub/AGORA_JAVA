package patron_strategy;

import java.util.ArrayList;
import java.util.List;


/*
Propone usar clases distintas, unida por herencia de una interfaz, a distintos comportamientos
que ha de tomar el programa
En el ejemplo un catalogo de vehiculos se puede escribir solo con descripcion, o con toda su informacion
Pintamos el catalogo con el método dibuja() de SelectorDeEstrategias, a quien al construirse, le pasamos un objeto de una clase
distinta segun como deseemos pintar
 */

public class Inicio {
    public static void main(String[] args) {

        // crear una lista
        List<Vehiculo> listaVehiculos = new ArrayList<>();
        listaVehiculos.add(new Vehiculo("vehiculo economico",22120));
        listaVehiculos.add(new Vehiculo("vehiculo amplio",43232));
        listaVehiculos.add(new Vehiculo("vehiculo rapido",44339));
        listaVehiculos.add(new Vehiculo("vehiculo confortable",15622));
        listaVehiculos.add(new Vehiculo("vehiculo deportivo",65244));

        // crear distintas estrategias
        EstrategiaDibujarTodo estrat_1 = new EstrategiaDibujarTodo();
        EstrategiaDibujarSoloDescripcion estrat_2 = new EstrategiaDibujarSoloDescripcion();

        // usar distintas estrategias
        SelectorDeEstrategias objetoConEstrategia1 = new SelectorDeEstrategias(estrat_1);
        objetoConEstrategia1.dibuja(listaVehiculos);

        SelectorDeEstrategias objetoConEstrategia2 = new SelectorDeEstrategias(estrat_2);
        objetoConEstrategia2.dibuja(listaVehiculos);
    }
}

//******************************************************************************
//******************************************************************************
interface IAccionesComunes {
    void dibuja(List<Vehiculo> listaVehiculos);
}

//******************************************************************************
//******************************************************************************

class SelectorDeEstrategias {

    protected IAccionesComunes objetopadre;

    public SelectorDeEstrategias(IAccionesComunes objetopadre) {
        this.objetopadre = objetopadre;
    }

    public void dibuja(List<Vehiculo> listaVehiculos) {
        objetopadre.dibuja(listaVehiculos);
    }
}


//******************************************************************************
//******************************************************************************

class Vehiculo {

    protected String descripcion;
    protected int precio;

    public Vehiculo(String descripcion, int precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }
}



//******************************************************************************
//******************************************************************************
class EstrategiaDibujarSoloDescripcion implements IAccionesComunes {

    public void dibuja(List<Vehiculo> listaVehiculos) {
        System.out.println("\n\nDibuja los vehiculos mostrando solo descripcion");
        for (Vehiculo cadavehiculo : listaVehiculos) {
            System.out.println(cadavehiculo.descripcion);
        }
    }
}

//******************************************************************************
//******************************************************************************
class EstrategiaDibujarTodo implements IAccionesComunes {

    public void dibuja(List<Vehiculo> listaVehiculos) {
        System.out.println("\n\nDibuja los vehiculos mostrando todos los datos");
        for (Vehiculo cadavehiculo:  listaVehiculos) {
                System.out.println(cadavehiculo.descripcion + " " + cadavehiculo.precio);
        }
    }
}

//******************************************************************************
//******************************************************************************
