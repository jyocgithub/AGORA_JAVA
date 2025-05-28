package GUT_Sockets_UDP_Multicast;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class GestorMulticast {
    static MulticastSocket multicastSocket;

    public static void main(String[] args) {

        enviar();
        recibir();
    }

    public static void enviar() {

        String msg = "Mensaje para un multicast";
        try {
            // Elegimos una direccion que dentro del rango 224.0.0.1 a 239.255.255.255   y un puerto cualquiera
            multicastSocket = new MulticastSocket(6789);
            multicastSocket.joinGroup (InetAddress.getByName("239.0.0.1"));

            byte[] msgBytes = msg.getBytes(StandardCharsets.UTF_8);
            DatagramPacket hi = new DatagramPacket(msgBytes, msgBytes.length,  InetAddress.getByName("239.0.0.1"),6789);
            multicastSocket.send(hi);


        } catch (  IOException e) {
            e.printStackTrace();
        }

    }

    public static void recibir() {
        try {
            byte[] buf = new byte[1000];
            // esto haria falta normalmente... pero como estamos probando en el mismo ordenador,
            // ya se agrego al grupo en el 'enviar', no permite volver a ponerlo ahora otra vez
            //  multicastSocket.joinGroup (InetAddress.getByName("239.0.0.1"));
            DatagramPacket recv = new DatagramPacket(buf, buf.length);
            multicastSocket.receive(recv);
            multicastSocket.leaveGroup(InetAddress.getByName("239.0.0.1"));
            System.out.println(new String(buf).trim());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
