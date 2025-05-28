package mysql_jyoc_libros;

public class Autor {

  private  int idautor;
    private  String nombre;
    private  int anonacim;
    private   int anofallec;
    private  String nacionalidad;

    public Autor(int idautor, String nombre, int anonacim, int anofallec, String nacionalidad) {
        this.idautor = idautor;
        this.nombre = nombre;
        this.anonacim = anonacim;
        this.anofallec = anofallec;
        this.nacionalidad = nacionalidad;
    }

    public Autor() {

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

    public int getAnonacim() {
        return anonacim;
    }

    public void setAnonacim(int anonacim) {
        this.anonacim = anonacim;
    }

    public int getAnofallec() {
        return anofallec;
    }

    public void setAnofallec(int anofallec) {
        this.anofallec = anofallec;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
