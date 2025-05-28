//9.1.Hacer un programa que cree una clase Persona, con estos atributos: nombre, edad, dni, estadocivil.
//Crear una clase Inicio que en su main cree varios objetos de Persona y le de valor a sus atributos. Crear
//estos métodos en la clase Persona, y probarlos luego en el main de Inicio:
//• EsSoltero() nos dice si la persona es soltera,
//• EsMayorDeEdad() nos dice si la persona es mayor de edad,
//• AsignarDNI() es un metodo que recibe un String por parametro, y lo asigna al DNI de la Persona.
//Antes, debe validar si el DNI es correcto (es correcto si tiene 9 caracteres, ni mas ni menos). El
//método ademas devuelve un valor bool
package soluciones_ejercicicios.ims.jyoc.OLD.Ej7_a_1;

public class Pruebas_EJ7_a_1 {

    public static void main(String[] args) {
        // creamos objetos de Persona
        Persona per1 = new Persona("JUAN", 43, "4232342K");
        Persona per2 = new Persona("ANA", 17, "5728389M");
        Persona per3 = new Persona("MARIA", 24, "3234232P");

        // consultamos los atributos de per1
        System.out.println(per1.nombre);
        System.out.println(per1.edad);
        System.out.println(per1.dni);

        // cambiamos los atributos de per1
        per1.nombre = "JUAN";
        per1.dni = "34672873T";
        per1.edad = 23;
        per1.esMayorDeEdad();
        per1.estaJubilado(65);

        boolean pudoASignarse = per1.asignarDni("32242234J");

        if (pudoASignarse) {
            System.out.println("Se asigno correctamente el dni");
        } else {
            System.out.println("El dni no se ha validado correctamente");
        }

        if (per1.estaJubilado(60)) {
            System.out.println(per1.nombre + " está jubilado");
        } else {
            System.out.println(per1.nombre + " no está jubilado");
        }

        // Cambiamos el dni de per2, poniendole el que tiene per1
        per2.dni = per1.dni;
        System.out.println(per2.dni);
    }
}

