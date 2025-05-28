import dao.DAOMongo;
import pojo.Cliente;
import pojo.Vehiculo;

import java.util.ArrayList;


// arrancar el servidor de Mongo desde la carpeta bin de la instalacion del servidor (en compiladores)
// y desde una terminal en la carpeta bin, ejecutar
// ./mongod --dbpath ./data/db

public class MainMongo {

    public static void main(String[] args) {
        new MainMongo();
    }

    public MainMongo() {

        DAOMongo daoMongo = new DAOMongo();

        Vehiculo v = new Vehiculo("1122QQW", 340, 100);

        daoMongo.insertarVehiculoComoJson(v);
        daoMongo.insertarVehiculoComoObjeto(v);

        ArrayList<Vehiculo> listaVehiculos = daoMongo.consultarVehiculos();
        for (Vehiculo vehi : listaVehiculos) {
          System.out.println(vehi);
        }

        System.out.println("===================================");

        ArrayList<Vehiculo> listaVehiculos2 = daoMongo.consultarVehiculosConTamanoMaximo(340);
        for (Vehiculo vehi : listaVehiculos2) {
          System.out.println(vehi);
        }

        Cliente c1 = new Cliente("PACO", "12312339q", v);
        Cliente c2 = new Cliente("ANA", "98798787k", v);

        daoMongo.insertarClienteComoObjeto(c1);
        daoMongo.insertarClienteComoObjeto(c2);

        System.out.println("===================================");

        ArrayList<Cliente> lista = daoMongo.consultarClientes();
        for (Cliente c : lista) {
          System.out.println(c);
        }

    }


}
