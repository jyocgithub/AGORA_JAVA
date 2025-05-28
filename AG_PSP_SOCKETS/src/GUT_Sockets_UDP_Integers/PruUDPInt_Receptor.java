package GUT_Sockets_UDP_Integers;


import GUT_Sockets_UDP_Strings.ProcesarUDP;

public class PruUDPInr_Receptor {

    public static void main(String[] args) {

        String recibido = GUT_Sockets_UDP_Strings.ProcesarUDP.recibirStringUDP("localhost", 22001);
        String recibido1 = GUT_Sockets_UDP_Strings.ProcesarUDP.recibirStringUDP("localhost", 22001);
        String recibido2 = GUT_Sockets_UDP_Strings.ProcesarUDP.recibirStringUDP("localhost", 22001);

        System.out.println(recibido.length());
        System.out.println(recibido);
        System.out.println(recibido1);
        System.out.println(recibido2);

        ProcesarUDP.enviarStringUDP("RESPUESTA", "localhost", 22002);

    }
}