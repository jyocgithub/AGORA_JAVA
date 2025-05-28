package B1_RMI.ejemploRMIAcuarioConObjetos;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// La unica clase que no hace el servidor
public class ClienteAcuario {

    public static  void main(String[] args) {
        try {

            String quepescado = "Caballa";
            // Creamos un acceso al registro, con getRegistry,
            // indicando donde ha de buscar objetos: host y puerto
            Registry registry = LocateRegistry.getRegistry("localhost",2222);

            // Con el regsitro, y su método lookup, buscamos un objeto dado,
            // ubicandolo con el nombre del host y el nombre de publicacion que se dio en el servidor
            // lookup busca el objeto publicado, y lo devuelve como respuesta, pero lo devuelve como Object,
            // asi que se debe hacer un casting a la interfaz para poder manejar el objeto
            InterfaceAcuario objRecibido = (InterfaceAcuario) registry.lookup("//localhost/ObjetoCosasDeAcuario");

            // con el objeto recibido, puedo llamar ya a sus métodos....
            int respuesta = objRecibido.tamano(quepescado);
            System.out.println("El tamaño de "+quepescado+" es "+respuesta);

            Pez quepez = objRecibido.getPez(quepescado);
            System.out.println("La familia de "+quepescado+" es : "+quepez.getFamilia());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



