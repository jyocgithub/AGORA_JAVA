package patron_decorador_V2;


// Permite "decorar" objetos para darles más funcionalidad 
// de la que tienen en un principio.
//**********************************************************************
public class ConPatronDecorador {

    public static void main(String[] args) {
        Ordenador2 ord = new OrdenadorBasico2();
        ord = new Disco(ord);
        ord = new Memoria(ord);
    }
}

//**********************************************************************
//**********************************************************************
// La clase principal pierde atributos, que se convierten en clases
// Solo declara los metodos que se han de heredar por todos
// Tambien puede hacerse con una iterfaz
abstract class Ordenador2 {

    public abstract double CalcularCoste();
}

//**********************************************************************
abstract class PatronDecoradorDeOrdenador extends Ordenador2 {

    protected Ordenador2 elOrdenador;
    public PatronDecoradorDeOrdenador(Ordenador2 unord){
        elOrdenador = unord;
    }
    public abstract double CalcularCoste();
}

// esta es la base donde se añaden las "decoraciones", 
// puede haber verias bases diferentes, claro. 
//**********************************************************************
class OrdenadorBasico2 extends Ordenador2 {

    public double CalcularCoste() {
        return 0;
    }
}
//**********************************************************************

class Disco extends PatronDecoradorDeOrdenador {

    public Disco(Ordenador2 ord) {
        super(ord);
    }

    public double CalcularCoste() {
        return elOrdenador.CalcularCoste() + 180.50;
    }
}

//**********************************************************************
class Memoria extends PatronDecoradorDeOrdenador {

    public Memoria(Ordenador2 ord) {
        super(ord);
    }

    public double CalcularCoste() {
        return elOrdenador.CalcularCoste() + 80.10;
    }
}
