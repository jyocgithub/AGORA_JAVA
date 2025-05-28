package plantilla_matisse;

import com.matisse.MtDatabase;
import com.matisse.reflect.MtClass;
import com.matisse.reflect.MtObject;

import java.util.Arrays;

public class Autor extends MtObject {


    public Autor(MtDatabase db) {
        super(getClass(db));
    }

    String nombre;
    String apellidos;
    int edad;
    Obra[]obras;

    public void setObras(Obra[]obras){
        this.obras  = obras;
    }

    public Obra[] getObras() {
        return obras;
    }

    public Autor(MtDatabase mtDatabase, int i) {
        super(mtDatabase, i);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", obras=" + Arrays.toString(obras) +
                '}';
    }
}
