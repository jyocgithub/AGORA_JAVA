package soluciones_ejercicicios.ims.jyoc.OLD.cap7_2;

import java.util.Scanner;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 7
 * 7.1.- (dif 1) Ejercicio Club de Socios. Plantear una clase Club y otra clase Socio. La clase Socio debe tener los siguientes
 * atributos privados:
 * - nombre
 * - antigüedad en el club (en años).
 * En el mismo constructor, pedir la carga por teclado del nombre y su antigüedad.
 * La clase Club debe tener como atributos 3 objetos de la clase Socio.
 * Definir en ella un método para imprimir el nombre del socio con mayor antigüedad en el club.
 *
 * @author Iñaki Martin
 */

public class Socio {
    String nombre;
    int antiguedad;

    public Socio() {

        Scanner objSc = new Scanner(System.in);
        System.out.println("Indique el nombre del socio");
        nombre = objSc.nextLine();
        System.out.println("Indique la antiguedad del socio");
        int ant = objSc.nextInt();
        if (ant < 0 || ant > 120) {
            System.out.println("Antiguedad erronea, se guarda 0 como valor");
            antiguedad = 0;
        } else {
            antiguedad = ant;
        }
    }

}
