package GUT_Sockets_UDP_Multicast;
/*
 *      _
 *     | |
 *     | |  _   _     __      ____
 *     | | | | | |  / __ \   /  __\
 *     | | | |_| | | (__) | |  (__
 *     | |  \__, |  \____/   \____/
 *   __/ |   __/ |
 *  |___/   |___/
 *
 */

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class GestorMulticastMetereologicov1 {

    public static void main(String[] args) {

    }


}



/**
 * Servidor de avisos meteorológicos usando MulticastSocket.
 * Envía mensajes a todos los clientes que están escuchando en el grupo multicast.
 */
 class ServidorMeteorologico {
    public static void main(String[] args) {
        final String GRUPO_MULTICAST = "230.0.0.0";
        final int PUERTO = 4446;

        try (MulticastSocket socket = new MulticastSocket()) {
            InetAddress grupo = InetAddress.getByName(GRUPO_MULTICAST);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Servidor meteorológico iniciado.");
            System.out.println("Escribe avisos para enviar a los clientes. Escribe 'salir' para terminar.");

            while (true) {
                System.out.print("> ");
                String mensaje = scanner.nextLine();

                if (mensaje.equalsIgnoreCase("salir")) {
                    break;
                }

                byte[] buffer = mensaje.getBytes();
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, grupo, PUERTO);
                socket.send(paquete);
                System.out.println("Aviso enviado: " + mensaje);
            }

            System.out.println("Servidor detenido.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



/**
 * Cliente que se une a un grupo multicast para recibir avisos meteorológicos.
 */
 class ClienteMeteorologico {
    public static void main(String[] args) {
        final String GRUPO_MULTICAST = "230.0.0.0";
        final int PUERTO = 4446;

        try (MulticastSocket socket = new MulticastSocket(PUERTO)) {
            InetAddress grupo = InetAddress.getByName(GRUPO_MULTICAST);
            socket.joinGroup(grupo);

            System.out.println("Cliente conectado al canal de avisos meteorológicos.");
            System.out.println("Esperando mensajes... (Ctrl+C para salir)");

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
                socket.receive(paquete);

                String mensaje = new String(paquete.getData(), 0, paquete.getLength());
                System.out.println(">> AVISO METEOROLÓGICO: " + mensaje);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
