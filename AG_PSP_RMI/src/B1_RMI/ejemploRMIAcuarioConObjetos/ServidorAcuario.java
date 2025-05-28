package B1_RMI.ejemploRMIAcuarioConObjetos;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class ServidorAcuario {

    public static void main(String[] args) {
        try {
            // Crear un objero de la clase que contiene los metodos a publicar
            ClaseAcuario objClaseAcuario = new ClaseAcuario();

            // Crear un registro (un servicio para publicar objetos),
            // Se indica el puerto, el host, no, pues es nuestra propia máquina
            Registry registry = LocateRegistry.createRegistry(2222);

            // En el registro creado, PUBLICAMOS el objeto que se ha creado,
            // y se le indica en la publicacion:
            //    1 - el host donde ha de llamarse para conectarse
            //    2 - Un nombre con el que conocer el objeto que se publica.
            registry.rebind("//localhost/ObjetoCosasDeAcuario",objClaseAcuario);

            System.out.println("El objeto objClaseAcuario ha quedado registrado... esperando solicitudes");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
