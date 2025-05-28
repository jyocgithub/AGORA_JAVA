package swing_MVC;

import java.util.ArrayList;

public class Controlador {

    Modelo modelo;

    public Controlador() {
        this.modelo = new Modelo();
    }

    public boolean accesocorrecto(  Empleado emp ) {
        Empleado e = modelo.dameEmpleadoPorNombre(emp.getNombre());

        if (e != null && emp.getPassword().equals(e.getPassword())) {
            return true;
        }
        return false;
    }


    public String[][] crearDatosTabla() {

        // CREAR ARRAYLIST CON LOS DATOS
        ArrayList<Empleado> lista = modelo.leerEmpleados();

        // CREAR MATRIZ CON LOS DATOS DEL ARRAYLIST
        String[][] mat = new String[lista.size()][2];
        for (int f = 0; f < lista.size(); f++) {
            for (int c = 0; c < 2; c++) {
                mat[f][0] = lista.get(f).getPassword();
                mat[f][1] = lista.get(f).getNombre() + "";
            }
        }
        return mat;

    }

    public String[] crearCabeceraTabla() {
        // CREAR ARRAY DE CABECERAS
        String[] cabeceras = {"1", "2"};
        return cabeceras;
    }


}
