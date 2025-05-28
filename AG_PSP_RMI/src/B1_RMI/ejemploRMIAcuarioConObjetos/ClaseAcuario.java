package B1_RMI.ejemploRMIAcuarioConObjetos;

import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;

// Clase de la que vamos a crear objetos para compartir
// Debe extender de UnicastRemoteObject,
// y debe implementar la interfaz que se creo (que define los métodos que se comparten)

public class ClaseAcuario extends UnicastRemoteObject implements InterfaceAcuario, Serializable {
    private static final long serialVersionUID = 111122223333444466L;

    // Debe obligatoriamente tener un constructor vacio
    public ClaseAcuario() throws Exception {
    }

    // Este es uno de los métodos que se comparten
    public int tamano(String tipopescado) {
        int tamano = 0;
        try {
            if (tipopescado.equals("Caballa")) {
                tamano = 12;
            } else if (tipopescado.equals("Bacalao")) {
                tamano = 37;
            } else {
                tamano = -1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tamano;
    }

    // Este es otro de los métodos que se comparten
    public Pez getPez(String tipoPescado) {
        Pez pez = new Pez(tipoPescado);
        return pez;
    }
}
