package patron_creacional;

public class ConPatronCreacional {

    public static void main(String[] args) {
        Moto unaMoto = new Moto();
        unaMoto.crearAutomovil("1111AAA", 1999);
        unaMoto.objetoAutomovil.mostrarAutomovil();
        
        
    }

}

//***************************************************+
class Automovil {

    private String matricula;
    private int aniocompra;

    public void crearAutomovil(String n, int f) {
        matricula = n;
        aniocompra = f;
    }

    public void mostrarAutomovil() {
        System.out.println("\nMatricula " + matricula + "; Año de compra " + aniocompra);
    }
}

//***************************************************+
abstract class PatronCreaciAuto {

    public Automovil objetoAutomovil;

    public abstract void crearAutomovil(String mat, int anio);
}

//***************************************************+
class Moto extends PatronCreaciAuto {

    public void crearAutomovil(String mat, int anio) {
        objetoAutomovil = new Automovil();
        objetoAutomovil.crearAutomovil(mat, anio);
    }
}
