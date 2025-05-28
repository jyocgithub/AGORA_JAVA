package prog09_tarea;/*
Decido utilizar un arrayList, que aunque no se ordena por orden natural,
llamo al método sort para que me ordene los vehiculos por mátricula.
Este método es llamado justo después de que se inserta un vehiculo.
 */

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * @author angerine martínez del corral
 */
public class Concesionario implements Serializable { //Implemento la Interfaz Seriazable para que luego este objeto pueda transferirlo a traves de un fichero.

    private static final long serialVersionID = 1L;
    private Vehiculo coche; // Solo creo el espacio en memoria para el objeto, no lo creo porque no llamo al
    // constructor.
    private List<Vehiculo> veh;

    private int contador = 0;
    private final int MAX_PLAZAS = 50;


    public List<Vehiculo> getVeh() {
        return veh;
    }

    public void setVeh(List<Vehiculo> veh) {
        this.veh = veh;
    }


    /**
     * Método constructor donde se inicializa el array y la variable que
     * contabiliza los coches.
     */
    public Concesionario() {
        veh = new ArrayList<Vehiculo>(MAX_PLAZAS);

    }

    public boolean hayVehiculos() {
        boolean hayveh = true;
        if (veh.isEmpty()) {
            hayveh = false;
        }
        return hayveh;
    }

    /**
     * método que busca dentro del array si esta el cohe.Se le llama al método
     * existe.
     *
     * @param matricula
     * @return String
     */
    public String consultarDescripcion(String matricula) {
        String cadena = null;
        Vehiculo v = buscarVehiculo(matricula);
        if (v != null) {
            cadena = v.getDescripcion();
        } else {
            cadena = "Vehiculo no existente en el concesionario";
        }
        return cadena;
    }

    /**
     * Realizo metodo existe para ver si el coche existe dentro del array de
     * concesionario
     *
     * @param matricula
     * @return boolean
     */
    public Vehiculo buscarVehiculo(String matricula) {
        Vehiculo elcoche = null;

        for (int i = 0; i < veh.size() && elcoche == null; i++) {
            if (veh.get(i).getMatricula().equals(matricula)) {
                elcoche = veh.get(i);
            }
        }

        return elcoche;
    }

    /**
     * Inserta el objeto vehiculo siempre que no este lleno o ya esta exista
     * dicha matricula
     *
     * @param marca
     * @param matricula
     * @param numKilometros
     * @param fechaMatriculacion
     * @param descripcion
     * @param precio
     * @param nombrePropietario
     * @param dniPropietario
     * @return int
     */
    public int insertarVehiculo(String marca, String matricula, int numKilometros, LocalDate fechaMatriculacion,
                                String descripcion, double precio, String nombrePropietario, String dniPropietario) {

        int exito = 0;

        if (veh.size() == MAX_PLAZAS) {
            exito = -1;
        } else if (buscarVehiculo(matricula) != null) {
            exito = -2;
        } else {
            this.coche = new Vehiculo(marca, matricula, numKilometros, fechaMatriculacion, descripcion, precio,
                    nombrePropietario, dniPropietario);
            veh.add(coche);

            // tras añadir un vahiculo, dejo ahora nuevamente el arraylist ordenado
            Collections.sort(veh);
        }
        return exito;
    }

    /**
     * Método que imprime por pantalla la información de los coches.
     */
    public void listaVehículos() {
        for (Vehiculo v : veh) {
            System.out.println(v.mostrarDescripcion());
        }

    }

    /**
     * Método que actualiza los km de un coche ya existente en el concesionario.
     *
     * @param matricula
     * @param numKm
     * @return
     */
    public boolean actualizaKms(String matricula, int numKm) {
        boolean cambioKm = false;
        Vehiculo vh = buscarVehiculo(matricula);
        if (vh != null) {
            vh.setNumKilometros(numKm);

            cambioKm = true;

        }

        return cambioKm;

    }

    public boolean eliminarVehiculo(String matricula) {
        boolean eliminar = true;
        Vehiculo vh = buscarVehiculo(matricula);
        if (vh != null) {
            int pos = veh.indexOf(vh);
            veh.remove(pos);

            // otra forma:     
            // veh.remove(vh);
        } else {
            eliminar = false;

        }
        return eliminar;

    }

//Metodos Getter y Setter
//    public void setA(Vehiculo[] a) {
//        this.a = a;
//    }
//
//    public Vehiculo[] getA() {
//        return a;
//    }
    // Estos dos métodos anteriores los comento ya que no son utilizados.


}
