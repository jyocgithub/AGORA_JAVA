import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEjemplos {

    public void informacionEsteEquipo() {
        try {

            // Obtiene el objeto InetAddress de un equipo:
            InetAddress miEquipo = InetAddress.getLocalHost();  // asi es el objetgo de MI equipo
            InetAddress objetoLocalhost = InetAddress.getByName("localhost");  // asi es el objeto de un equipo, indicando su ip

            System.out.println("Nombre de mi Equipo en la red local:" + miEquipo.getHostName());
            System.out.println("IP de mi Equipo en la red local:"+ miEquipo.getHostAddress());

        } catch ( UnknownHostException e) {
            System.out.println(e.getMessage());
            System.out.println( "No hay conexion de red o el servidor DNS no ha tramitado la solicitud");
        }

    }

    public void informacionDeInternet() {
        try {

            InetAddress inetAddress1 =  InetAddress.getByName("www.rediris.org");
            InetAddress inetAddress2 = InetAddress.getByName("ftp.rediris.org");

            System.out.println("\nIP de www.rediris.org:" +inetAddress1.getHostAddress());
            System.out.println("\nIP de ftp.rediris.org:" + inetAddress2.getHostAddress());

            // obtener todas las direccions ip de un host
            InetAddress[] matrizAddress = InetAddress.getAllByName("google.com");

            // Ver todas las IP asociadas a dicho host
            System.out.println("\nImprime todas las IP disponibles para google.com: ");
            for (int i = 0; i < matrizAddress.length; i++) {
                System.out.println(matrizAddress[i].getHostAddress());
            }

        } catch ( UnknownHostException e) {
            System.out.println(e.getMessage());
            System.out.println( "No hay conexion de red o el servidor DNS no ha tramitado la solicitud");
        }

    }

}
