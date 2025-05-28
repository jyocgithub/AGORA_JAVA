package B1_RMI.ejemploRMILonja;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// La unica clase que no hace el servidor
public class ClienteLonja {

    public static  void main(String[] args) {
        try {
            // Creamos un acceso al registro, con getRegistry,
            // indicando donde ha de buscar objetos: host y puerto
            Registry registry = LocateRegistry.getRegistry("localhost",2222);

            // Con el registro, y su método lookup, buscamos un objeto dado,
            // ubicandolo con el nombre del host y el nombre de publicacion que se dio en el servidor
            // lookup busca el objeto publicado, y lo devuelve como respuesta, pero lo devuelve como Object,
            // asi que se debe hacer un casting a la interfaz para poder manejar el objeto
            InterfaceLonja objRecibido = (InterfaceLonja) registry.lookup("//localhost/ObjetoObtenerPrecioDeLonja");

            // con el objeto recibido, puedo llamar ya a sus métodos....
            String quepescado = "asd";
            int respuesta = objRecibido.precioActual(quepescado);

            System.out.println("El dicen que el precio actual de "+quepescado+" es "+respuesta);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



