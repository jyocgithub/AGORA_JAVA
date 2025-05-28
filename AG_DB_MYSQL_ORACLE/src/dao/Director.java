package dao;

/**
 * Clases auxiliares para los ejemplos
 */

public class Director {
    int cod_dir;
    String nombre;

    public Director(int cod_dir, String nombre) {
        this.cod_dir = cod_dir;
        this.nombre = nombre;
    }

    public int getCod_dir() {
        return cod_dir;
    }

    public void setCod_dir(int cod_dir) {
        this.cod_dir = cod_dir;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
