package sax.sax_con_defaulthandler;

public class Gimnasta {

    private String nombre, apellidos;
    private String id;
    private double nota;

    public Gimnasta() {
    }

    public Gimnasta(String nombre, String id, double nota) {
        this.nombre = nombre;
        this.id = id;
        this.nota = nota;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Gimnasta{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", id='" + id + '\'' +
                ", nota=" + nota +
                '}';
    }
}