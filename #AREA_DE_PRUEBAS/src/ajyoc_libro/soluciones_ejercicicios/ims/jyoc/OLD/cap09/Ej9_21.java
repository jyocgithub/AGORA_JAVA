//Crear una clase llamada Empleado con
//• atributos privados nombre, y teléfono, de tipo String.
//• El constructor necesitará el nombre y el teléfono.
//• Implementar los métodos necesarios para acceder a estos dos atributos de manera pública (getters y
//  setters).
//• Añadir el atributo estático y privado numeroEmpleados. Este atributo almacenará el número de
//  instancias que se han creado de la clase Empleado.
//• No implementar un método alguno para conocer el valor de numeroEmpleados.
//Crear una clase aparte con el método main:
//• Crear un vector de 4 empleados. Los datos de cada empleado será leidos por consola.
//  Mostrar el número de empleados tras crear cada nuevo empleado.
//• Mostrar los datos de cada empleado del vector, usando un metodo toString() en la clase Empleado
package ej_capitulo_9;

import java.util.Scanner;

public class Ej9_21 {

    public static void main(String[] args) {
        Empleado[] listaEmpleados = new Empleado[4];
        for (int i = 0; i < listaEmpleados.length; i++) {
            System.out.println("Dime un nombre para el empleado");
            String nombre = new Scanner(System.in).nextLine();
            System.out.println("Dime un telefono para el empleado");
            String telefono = new Scanner(System.in).nextLine();
            Empleado e = new Empleado(nombre, telefono);
            listaEmpleados[i] = e;
            System.out.println("Hasta ahora hay " + Empleado.numempleados + " empleados creados");
        }

        for (int i = 0; i < listaEmpleados.length; i++) {
            System.out.println(listaEmpleados[i]);

        }
    }

}

class Empleado {

    private String nombre;
    private String telefono;
    static int numempleados;

    public Empleado(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        numempleados++;
    }

    @Override
    public String toString() {
        return "Empleado: nombre=" + nombre + ", telefono=" + telefono;
    }

    public static int getNumempleados() {
        return numempleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
