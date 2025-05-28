package patron_decorador_V2;



// Permite "decorar" objetos para darles más funcionalidad 
// de la que tienen en un principio.
//**********************************************************************
public class ConPatronDecorador2 {

    public static void main(String[] args) {
        PatronDecoOrd ordejem1 = new PatronDecoOrd();
            double c = ordejem1.elOrdenador.getCoste();
            System.out.println(c);
        PatronDecoOrd ordejem2 = new PatronDecoOrd(ordejem1,50);
            c = ordejem2.elOrdenador.getCoste();
            System.out.println(c);
        PatronDecoOrd ordejem3 = new PatronDecoOrd(ordejem2,100.90);
            c = ordejem3.elOrdenador.getCoste();
            System.out.println(c);
            
            
        PatronDecoOrd ordejem10 = new PatronDecoOrd();
            c = ordejem10.elOrdenador.getCoste();
            System.out.println(c); 
        PatronDecoOrd ordejem11 = new PatronDecoOrd(ordejem10, 30, 100.90);
            c = ordejem11.elOrdenador.getCoste();
            System.out.println(c);
    }
}

//**********************************************************************
//**********************************************************************
// La clase principal pierde atributos, que se convierten en clases
// Solo declara los metodos que se han de heredar por todos 
 class Ordenador3 {
    
    public double coste ;
    public Ordenador3 () {
        coste = 0;
    }
            
    public double getCoste(){
        return coste;
    }
}

//**********************************************************************
class PatronDecoOrd extends Ordenador3 {

    public Ordenador3 elOrdenador;
    
    // Constructor basico que solo crea un ordenador base
    public PatronDecoOrd(){
         elOrdenador = new Ordenador3();
        elOrdenador.coste = 100;
    }
    
    // Constructor basico que solo añade a un oddenador creado un disco, por 
    // que tiene un parametro mas que (por convenio de este ejemplo) es un int
    public PatronDecoOrd(PatronDecoOrd unord, int preciodisco){
         elOrdenador = new Ordenador3();
        elOrdenador.coste = unord.elOrdenador.coste + preciodisco;
    }
    
    // Constructor basico que solo añade a un oddenador creado un monitor, por 
    // que tiene un parametro mas que (por convenio de este ejemplo) es un double
    public PatronDecoOrd(PatronDecoOrd unord, double preciomonitor){
         elOrdenador = new Ordenador3();
        elOrdenador.coste = unord.elOrdenador.coste + preciomonitor;
    }
    
    // Constructor basico que añade a un ordenador creado un monitor y un disco, por 
    // que tiene dos parametro mas que (por convenio de este ejemplo) 
    // son int (para disco) y double (para monitor)
    public PatronDecoOrd(PatronDecoOrd unord, int preciodisco, double preciomonitor){
         elOrdenador = new Ordenador3();
        elOrdenador.coste = unord.elOrdenador.coste + preciodisco + preciomonitor ;
    }
    
}
