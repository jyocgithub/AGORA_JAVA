package chat_consola;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor {

    static final int PUERTO = 20001;


    static ArrayList<Usuario> listaUsuarios;

    public static void main(String[] args) {
        DataOutputStream escritor = null;
        DataInputStream lector = null;
        ServerSocket servidor = null;
        Socket manguera = null;

        listaUsuarios = new ArrayList<>();

        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor arrancado y esperando a alguien...");

            do {
                manguera = servidor.accept(); //esperando a que alguien conecte
                Usuario esteusuario = new Usuario("sinnombreaun", manguera);
                listaUsuarios.add(esteusuario);
                HiloServidorParaCadaCliente hilo = new HiloServidorParaCadaCliente(esteusuario, listaUsuarios);
                hilo.start();
            } while (true);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                escritor.close();
                lector.close();
                manguera.close();
                servidor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


//	public static void comunicarse() throws IOException {
//
//		Scanner sc = new Scanner(System.in);
//		HiloLectorCompartido CC = new HiloLectorCompartido("Cliente", escritor, lector);
//		CC.start();
//		String mensaje= "";
//		boolean fin = false;
//
//		escritor.writeUTF("Mensaje de prueba de servidor");
//
//		System.out.println("Servidor conectado");
//
//		while (CC.fin == false || fin == false) {
//
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			System.out.println("Introduzca un mensaje (Servidor) :");
//			mensaje = sc.next();
//			escritor.writeUTF(mensaje);
//
//			if(mensaje.contains("fin")){
//
//				System.out.println("Fin encontrado. Saliendo...");
//				fin = true;
//
//			}
//
//		}
//
//
//	}

}
