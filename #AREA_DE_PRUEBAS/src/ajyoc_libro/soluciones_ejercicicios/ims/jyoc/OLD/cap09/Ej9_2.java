//Construir una clase llamada Semáforo que simule un semáforo; tiene un un atributo color, y un
//método cambio() que debe hace cambiar el color entre verde, amarillo y rojo en ese orden. Cuando un
//objeto luz se cree su color inicial debe ser rojo.
package ej_capitulo_9;

public class Ej9_2 {

    public static void main(String[] args) {
        Semaforo s = new Semaforo();
        System.out.println(s.color);
        s.cambiar();
        System.out.println(s.color);
        s.cambiar();
        System.out.println(s.color);
        s.cambiar();
        System.out.println(s.color);
        s.cambiar();
        System.out.println(s.color);
        s.cambiar();
        System.out.println(s.color);
        s.cambiar();
    }
}

class Semaforo {

    String color = "ROJO";

    public void cambiar() {
        if (color.equals("ROJO")) {
            color = "AMARILLO";
        } else if (color.equals("AMARILLO")) {
            color = "VERDE";
        } else {
            color = "ROJO";
        }
    }
}
