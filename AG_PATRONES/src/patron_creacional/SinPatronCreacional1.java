package patron_creacional;

public class SinPatronCreacional1 {

    public static void main(String[] args) {
        Motox unaMoto = new Motox("1111AAA", 1999);

        unaMoto.mostrarVehiculo();
        
        
    }

}

//***************************************************+
class Automovilx {

    private String matricula;
    private int aniocompra;

    public Automovilx(String m , int n ) {
        matricula = m;
        aniocompra = n;
    }

    public void mostrarVehiculo() {
        System.out.println("\nMatricula " + matricula + "; Año de compra " + aniocompra);
    }
}


//***************************************************+
class Motox extends Automovilx {

    public Motox(String m, int n) {
        super(m, n);
    }

}
