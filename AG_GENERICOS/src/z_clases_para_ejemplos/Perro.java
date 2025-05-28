package z_clases_para_ejemplos;
/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */

public class Perro extends Animal {

    public String raza;

    public Perro(String nombre, int peso, String raza) {
        super(nombre, peso);
        this.raza = raza;
    }
}
