package swing_MVC;

public class Empleado {
    private String password;
    private String nombre;

    public Empleado(String NIF, String nombre) {
        this.password = NIF;
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String NIF) {
        this.password = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado() {
    }
}