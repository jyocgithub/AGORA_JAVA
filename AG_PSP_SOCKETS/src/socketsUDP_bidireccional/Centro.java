
package ejercicioMediaNotas;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Esta clase es un centro de esrudius, Envia 5 notas a un profesor. El prtofecor lee las 5 nota, y devuelve un mensaje diciendo si el aluimno ha aprobado o no, haciendo media dela notas.
 * Si alguna nota esinferior a 2, el alumno suspende sin importar las oteas ntaso
 */
public class Centro {

    static String url = "localhost";
    static String mensaje;
    static DatagramSocket maquina;
    static int puertoParte1 = 12000;
    static int puertoParte2 = 12001;


    public static void main(String[] args) {
        Plantilla_Sockets_UDP_centro.enviarStringUDP("3", "localhost", puertoParte1);
        Plantilla_Sockets_UDP_centro.enviarStringUDP("7", "localhost", puertoParte1);
        Plantilla_Sockets_UDP_centro.enviarStringUDP("7", "localhost", puertoParte1);
        Plantilla_Sockets_UDP_centro.enviarStringUDP("1", "localhost", puertoParte1);
        Plantilla_Sockets_UDP_centro.enviarStringUDP("9", "localhost", puertoParte1);

        String mensaje = Plantilla_Sockets_UDP_centro.recibirStringUDP("localhost", puertoParte2);
        System.out.println("la nota es " + mensaje);

    }

}
