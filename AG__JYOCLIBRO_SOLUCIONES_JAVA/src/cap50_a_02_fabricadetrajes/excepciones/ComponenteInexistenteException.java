package cap50_a_02_fabricadetrajes.excepciones;

public class ComponenteInexistenteException extends Exception {
    public ComponenteInexistenteException(String mensaje) {
        super(mensaje) ;
    }
}
