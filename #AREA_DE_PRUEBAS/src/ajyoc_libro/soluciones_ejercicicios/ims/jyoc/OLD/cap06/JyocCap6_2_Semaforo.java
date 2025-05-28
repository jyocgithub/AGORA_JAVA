package soluciones_ejercicicios.ims.jyoc.OLD.cap06;

/**
 * Ejercicios de Guiones de Curso Java SE
 * <p>
 * Capitulo 6
 * Ejercicio 6.2. (dif 1) Construir una clase llamada Semaforo que simule un semáforo; con
 * - un atributo color, y
 * - un metodo cambio() que debe hace cambiar el color entre verde, amarillo y rojo en ese orden.
 * Cuando un objeto luz se cree su color inicial debe ser rojo.
 *
 * @author Iñaki Martin
 */

public class JyocCap6_2_Semaforo {

    String color = "Rojo";

    public void cambio() {
        if (color.equals("Verde")) {
            color = "Amarillo";
        } else if (color.equals("Amarillo")) {
            color = "Rojo";
        } else if (color.equals("Rojo")) {
            color = "Verde";
        }
    }

}
