//9.1.Hacer un programa que cree una clase Persona, con estos atributos: nombre, edad, dni, estadocivil.
//Crear una clase Inicio que en su main cree varios objetos de Persona y le de valor a sus atributos. Crear
//estos métodos en la clase Persona, y probarlos luego en el main de Inicio:
//• EsSoltero() nos dice si la persona es soltera,
//• EsMayorDeEdad() nos dice si la persona es mayor de edad,
//• AsignarDNI() es un metodo que recibe un String por parametro, y lo asigna al DNI de la Persona.
//Antes, debe validar si el DNI es correcto (es correcto si tiene 9 caracteres, ni mas ni menos). El
//método ademas devuelve un valor bool
package ej_capitulo_9;

public class EJ9_1 {

    public static void main(String[] args) {

        Persona p1 = new Persona();
        p1.nombre = "JUAN";
        p1.dni = "4232342j";
        p1.edad = 23;
        p1.estadoCivil = "SOLTERO";
        p1.esMayorDeEdad();
        p1.esSoltero();
        boolean pudoASignarse = p1.asignarDni("32242234J");
        if (pudoASignarse) {
            System.out.println("Se asigno correctamente el dni");
        } else {
            System.out.println("El dni no se ha validado correctamente");
        }

    }

}

class Persona {

    String nombre;
    int edad;
    String dni;
    String estadoCivil;

    //es soltero
    public void esSoltero() {
        if (estadoCivil.equals("SOLTERO")) {
            System.out.println("Es soltero");
        } else {
            System.out.println("No es soltero");
        }
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
}
