/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioMediaNotas;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author atico
 */
public class Profesor {

    static String url = "localhost";
    static DatagramSocket maquina;
    static int puertoParte1 = 12000;
    static int puertoParte2 = 12001;


    public static void main(String[] args) {

        String mensaje1 = Plantilla_Sockets_UDP_centro.recibirStringUDP("localhost", puertoParte1);
        System.out.println("EL centro responde " + mensaje1);

        String mensaje2 = Plantilla_Sockets_UDP_centro.recibirStringUDP("localhost", puertoParte1);
        System.out.println("EL centro responde " + mensaje2);

        String mensaje3 = Plantilla_Sockets_UDP_centro.recibirStringUDP("localhost", puertoParte1);
        System.out.println("EL centro responde " + mensaje3);

        String mensaje4 = Plantilla_Sockets_UDP_centro.recibirStringUDP("localhost", puertoParte1);
        System.out.println("EL centro responde " + mensaje4);

        String mensaje5 = Plantilla_Sockets_UDP_centro.recibirStringUDP("localhost", puertoParte1);
        System.out.println("EL centro responde " + mensaje5);

        if (Integer.parseInt(mensaje1) < 2 ||
                Integer.parseInt(mensaje2) < 2 ||
                Integer.parseInt(mensaje3) < 2 ||
                Integer.parseInt(mensaje4) < 2 ||
                Integer.parseInt(mensaje5) < 2) {
            Plantilla_Sockets_UDP_centro.enviarStringUDP("La nota media es SUSPENDIDO", "localhost", puertoParte2);

        } else {
            int notaMedia = (Integer.parseInt(mensaje1) + Integer.parseInt(mensaje2) + Integer.parseInt(mensaje3) + Integer.parseInt(mensaje4) + Integer.parseInt(mensaje5)) / 5;
            String s = Integer.toString(notaMedia);
            Plantilla_Sockets_UDP_centro.enviarStringUDP("La nota media es " + s, "localhost", puertoParte2);
        }

    }
}
