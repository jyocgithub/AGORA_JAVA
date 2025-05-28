package dao;

public class Autor {
    int idautor;
    String nombre;
    String anonacim;
    String anofallec;
    String nacionalidad;

    public Autor(int idautor, String nombre, String anonacim, String anofallec, String nacionalidad) {
        this.idautor = idautor;
        this.nombre = nombre;
        this.anonacim = anonacim;
        this.anofallec = anofallec;
        this.nacionalidad = nacionalidad;
    }

    public Autor( ) {
    }

    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnonacim() {
        return anonacim;
    }

    public void setAnonacim(String anonacim) {
        this.anonacim = anonacim;
    }

    public String getAnofallec() {
        return anofallec;
    }

    public void setAnofallec(String anofallec) {
        this.anofallec = anofallec;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
