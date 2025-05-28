package B1_RMI.ejemploRMIAcuarioConObjetos;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceAcuario extends Remote{

    // Definimos los métodos que vamos a publicar.
    // Pueden arrojar RemoteException, o controlar la excepcion en el futuro en el propio método
    // Puede ser mas cómodo arrojar la excepcion y que en el cliente sea donde se controle, si algo va mal
    int tamano(String tipoPescado) throws RemoteException;
    Pez getPez(String tipoPescado) throws Exception;
}

