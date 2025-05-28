package GUT_Sockets_UDP_Strings;

public class PruebasPlantillaUDPStrings_Emisor {

    // ESTA CLASE SE EJECUTA SEGUNDA SIEMPRE

    public static void main(String[] args) {

        String mensaje = "MAJETE TE SALUDO";
        ProcesarUDP.enviarStringUDP(mensaje, "localhost", 22001);
        ProcesarUDP.enviarStringUDP(mensaje, "localhost", 22001);
        ProcesarUDP.enviarStringUDP(mensaje, "localhost", 22001);

        String recibido = ProcesarUDP.recibirStringUDP("localhost", 22002);
        System.out.println(recibido);

    }
}
