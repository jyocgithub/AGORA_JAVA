package prog09_tarea;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author angerine martinez del corral
 * Esta clase Vehiculo sería como la fabrica de los coches.
 */

import java.io.Serializable;
import java.time.*;

public class Vehiculo implements Serializable, Comparable<Vehiculo> {

// Variables

    private String marca;
    private String matricula;
    private int numKilometros;
    private LocalDate fechaMatriculacion;
    private String descripcion;
    private double precio;
    private String nombrePropietario;
    private String dniPropietario;

    /**
     * Constructor con que se le pasa parametros.
     *
     * @param marca
     * @param matricula
     * @param numKilometros
     * @param fechaMatriculacion
     * @param descripcion
     * @param precio
     * @param nombrePropietario
     * @param dniPropietario
     */
    public Vehiculo(String marca, String matricula, int numKilometros, LocalDate fechaMatriculacion, String descripcion,
                    double precio, String nombrePropietario, String dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.numKilometros = numKilometros;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
    }

    /**
     * Constructor sin parametros.
     */
    public Vehiculo() {
    }

    /**
     * Metodos Getter para que me devuelva el valor de los aributos.
     *
     */
    // Método que devuelve los agnos usando la clase LocalDate.
    public int getAnios() {
        int aniomatriculacion = fechaMatriculacion.getYear();
        int anioactual = LocalDate.now().getYear();
        int antiguedad = anioactual - aniomatriculacion;
        return antiguedad;
    }

    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getNumKilometros() {
        return numKilometros;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    /**
     * Método donde muestro la descripción
     *
     * @return un String.
     */
    public String mostrarDescripcion() {
        return "Descripción: " + descripcion + " . Matrícula: " + matricula + " Número de km: " + numKilometros;
    }
//Métodos setter para darle valor a mis atributos

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNumKilometros(int numKilometros) {
        this.numKilometros = numKilometros;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    /*Reescribo el metodo compareTo de la interfaz comparable
          para luego poder ordenar los vehiculos con el método sort*/
    @Override
    public int compareTo(Vehiculo o) {

        return this.matricula.compareTo(o.matricula);

    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vehiculo) {
            Vehiculo otroVehiculo = (Vehiculo) obj; // hago un casting.
            if (this.matricula.equals(otroVehiculo.matricula)) {
                return true;
            } else {
                return false;
            }
        } else
            return false; // si no es una instancia de Vehiculo me devuelve false.
    }
}

