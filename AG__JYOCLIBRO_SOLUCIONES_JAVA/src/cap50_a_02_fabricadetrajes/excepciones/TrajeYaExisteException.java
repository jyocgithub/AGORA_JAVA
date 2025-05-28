package cap50_a_02_fabricadetrajes.excepciones;

public class TrajeYaExisteException extends Exception {
    public TrajeYaExisteException(String mensaje) {
        super(mensaje) ;
    }
}
