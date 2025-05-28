package ChatMonousuario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClienteMiniChatMonousuario {
    public static void main(String[] args) {
        Socket socketCliente = null;

        PrintWriter escritor;
        BufferedReader lector;
        Scanner sc = new Scanner(System.in);
        String mensaje = "";
        String leido;
        try {
            socketCliente = new Socket("localhost", 20001);    // Esperamos que "llame" un cliente.
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        try {
            escritor = new PrintWriter(socketCliente.getOutputStream());    //obtenemos los canales para leere y escribir en servidor
            lector = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            leido = lector.readLine();
            System.out.println(leido);
            escritor.println("Hola !!! Soy el cliente !!");
            escritor.flush();
            while (!mensaje.equalsIgnoreCase("ADIOS")) {
                leido = lector.readLine();
                if (!leido.equalsIgnoreCase("ADIOS")) {
                    System.out.println("** Mensaje del Servidor : " + leido);
                    System.out.println("** ¿Que responde al Servidor?");
                    mensaje = sc.nextLine();
                    System.out.println("** enviando... esperando respuesta...");
                    escritor.println(mensaje);
                    escritor.flush();
                } else {
                    mensaje = "ADIOS";
                }
            }
        } catch (IOException e) { e.printStackTrace(); } finally {
            try {
                socketCliente.close();
            } catch (IOException e) { e.printStackTrace(); }
        }
    }

}

