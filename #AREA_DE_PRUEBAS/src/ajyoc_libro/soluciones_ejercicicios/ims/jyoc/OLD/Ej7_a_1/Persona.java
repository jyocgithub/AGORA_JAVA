//9.1.Hacer un programa que cree una clase Persona, con estos atributos: nombre, edad, dni, estadocivil.
//Crear una clase Inicio que en su main cree varios objetos de Persona y le de valor a sus atributos. Crear
//estos métodos en la clase Persona, y probarlos luego en el main de Inicio:
//• EsSoltero() nos dice si la persona es soltera,
//• EsMayorDeEdad() nos dice si la persona es mayor de edad,
//• AsignarDNI() es un metodo que recibe un String por parametro, y lo asigna al DNI de la Persona.
//Antes, debe validar si el DNI es correcto (es correcto si tiene 9 caracteres, ni mas ni menos). El
//método ademas devuelve un valor bool
package soluciones_ejercicicios.ims.jyoc.OLD.Ej7_a_1;

public class Persona {
    // ATRIBUTOS
    String nombre;
    int edad;
    String dni;

    // CONSTRUCTOR
    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    // es mayor de edad
    public void esMayorDeEdad() {
        if (edad > 17) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
    }

    // asignar DNI
    public boolean asignarDni(String nuevoDni) {
        boolean resultado = false;
        if (nuevoDni.length() == 9) {
            dni = nuevoDni;
            resultado = true;
        }
        return resultado;
    }

    //esta jubilado
    public boolean estaJubilado(int edadDeJubilacion) {
        boolean resultado = false;
        if (edad >= edadDeJubilacion) {
            resultado = true;
        }
        return resultado;
    }

}
