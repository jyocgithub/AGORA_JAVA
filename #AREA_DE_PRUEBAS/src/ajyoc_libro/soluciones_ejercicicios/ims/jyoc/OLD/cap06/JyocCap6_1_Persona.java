package soluciones_ejercicicios.ims.jyoc.OLD.cap06;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 6
 * Ejercicio 6.1.- (dif 1) Hacer un programa que cree una clase Persona, con estos atributos:
 * nombre, edad, dni, estadocivil
 * <p>
 * Crear una clase Inicio que en su main cree varios objetos de Persona y le de valor a sus atributos
 * Crear estos métodos en la clase persona, y probarlos luego en el main de Inicio:
 * - EsSoltero: nos dice si la persona es soltera
 * - EsMayorDeEdad; nos dice si la persona es mayor de edad
 * - AsignarDNI: Metodo que recibe un string por parametro, y lo asigna al DNI de la Persona. Antes, debe validar
 * si el DNI es correcto (es correcto si tiene 9 caracteres, ni mas ni menos). El método ademas devuelve un
 * valor booleano dependiendo de si el DNI se ha validado (y por lo tanto, se ha asignado al atributo de la clase )
 *
 * @author Iñaki Martin
 */

public class JyocCap6_1_Persona {
    String nombre;
    int edad;
    String dni;
    String estadocivil;

    public boolean esSoltero() {
        if (estadocivil.equals("S")) return true;
        else return false;
    }

    public boolean esMayorDeEdad() {
        if (edad > 17) {
            return true;
        } else {
            return false;
        }
    }

    public boolean asignarDNI(String posibleDni) {
        boolean resultado = false;
        if (posibleDni.length() == 9) {
            resultado = true;
            dni = posibleDni;
        }
        return resultado;
    }
}
