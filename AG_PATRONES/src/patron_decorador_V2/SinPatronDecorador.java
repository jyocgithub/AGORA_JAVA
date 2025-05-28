package patron_decorador_V2;

public  class SinPatronDecorador{

    public static void main(String[] args) {
        Ordenador1 od1 = new OrdenadorBasico1() ;
        
    }

}


//**********************************************************************
 abstract class Ordenador1 {

    public abstract double CalcularCoste();

}

//**********************************************************************
class OrdenadorBasico1 extends Ordenador1{

    private double procesador = 200.0;
    private double memoria = 200.0;
    private double discoduro = 200.0;

    @Override
    public double CalcularCoste() {
        double coste = this.procesador + this.memoria + this.discoduro;
        return coste;
    }
     
}
