package chat_consola;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    static final int PUERTO = 20001;

    public static void main(String[] args) {
        try {
            Socket manguera = new Socket("localhost", PUERTO);
            comunicarse(manguera);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void comunicarse(Socket manguera) throws IOException {
        String mensaje;

        Scanner sc = new Scanner(System.in);
        System.out.println("Cliente, dime tu nombre :");
        String nombre = sc.nextLine();

        Usuario yo = new Usuario(nombre, manguera);

        HiloLectorParaClientes hiloLectorCompartido = new HiloLectorParaClientes(yo);
        hiloLectorCompartido.start();

        yo.escritor.writeUTF(nombre);

        System.out.println("Cliente conectado");

        while (yo.conectado == true) {

            miniespera();

            System.out.print("-->");
            mensaje = sc.nextLine();

            yo.escritor.writeUTF(yo.nombre);
            yo.escritor.writeUTF(mensaje);

            if (mensaje.equalsIgnoreCase("FIN")) {
                System.out.println("Fin del chat.");
                yo.conectado = false;
            }
        }

        try {
            yo.escritor.close();
            yo.lector.close();
            yo.manguera.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void miniespera() {
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

}
