package GUT_Sockets_UDP_Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class GestorMulticastOpcion2 {
    static MulticastSocket multicastSocket;

    public static void main(String[] args) {

        new ClienteMulticast();
        new ServidorMulticast();

    }


}

class ClienteMulticast {
    public ClienteMulticast() {
        try {
            int puerto=12345;
            MulticastSocket ms= new MulticastSocket(puerto);
            InetAddress grupo= InetAddress.getByName("225.0.0.1");
            ms.joinGroup(grupo);
            String msj="";
            byte[] buffer= new byte[1000];
            while (!msj.trim().equals("*"))
            {
                DatagramPacket dp= new DatagramPacket(buffer, buffer.length);

                ms.receive(dp);

                msj=new String(dp.getData());
                System.out.println(msj.trim());
                buffer= new byte[1000];
            }
            ms.leaveGroup(grupo);

        } catch (IOException ex) {
        }
    }
}


class ServidorMulticast {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String cadena = "";
            MulticastSocket ms= new MulticastSocket();
            int puerto=12345;
            InetAddress grupo= InetAddress.getByName("225.0.0.1");

            while (!cadena.trim().equals("*"))
            {
                cadena=sc.nextLine();
                DatagramPacket paquete= new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
                ms.send(paquete);
            }
        } catch (IOException ex) {
        }
    }
}


