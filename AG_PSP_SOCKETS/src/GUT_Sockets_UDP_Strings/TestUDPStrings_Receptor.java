package GUT_Sockets_UDP_Strings;


public class PruebasPlantillaUDPStrings_Receptor {

    // ESTA CLASE SE EJECUTA PRIMERA SIEMPRE

    public static void main(String[] args) {


        String recibido = ProcesarUDP.recibirStringUDP("localhost", 22001);
        String recibido1 = ProcesarUDP.recibirStringUDP("localhost", 22001);
        String recibido2 = ProcesarUDP.recibirStringUDP("localhost", 22001);

        System.out.println(recibido.length());
        System.out.println(recibido);
        System.out.println(recibido1);
        System.out.println(recibido2);

        ProcesarUDP.enviarStringUDP("RESPUESTA", "localhost", 22002);

    }
}