package ajyoc_libro;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String patron;

        // Comprobar si un String comienza por “abc”
        patron = "^abc.*";
        System.out.println(validarRegEx(patron, "abc"));   // TRUE
        System.out.println(validarRegEx(patron, "abd"));   // FALSE

        // Comprobar si un String comienza por “abc” o "Abc"
        patron = "[aA]bc.*";
        System.out.println(validarRegEx(patron, "abc"));   // TRUE
        System.out.println(validarRegEx(patron, "aBc"));   // FALSE

        // Comprobar si un String contiene dentro “abc”
        patron = ".*abc.*";
        System.out.println(validarRegEx(patron, "zzabczz"));   // TRUE
        System.out.println(validarRegEx(patron, "xxaczzz"));   // FALSE

        // Comprobar si un String está formado por un mínimo de 5 letras mayúsculas o minúsculas y un máximo de 10
        patron = "[a-zA-Z]{5,10}";
        System.out.println(validarRegEx(patron, "ffasd"));   // TRUE
        System.out.println(validarRegEx(patron, "dfa44"));   // FALSE

        // Comprobar si un String solo contiene los caracteres 0 ó 1, y debe contener algo
        patron = "(0|1)+";
        System.out.println(validarRegEx(patron, "01101001"));   // TRUE
        System.out.println(validarRegEx(patron, "10020102"));   // FALSE

        // Comprobar si un String es una matricula española (4 numeros y tres letras mayúsculas)
        patron = "[0-9]{4}[A-Z]{3}";
        System.out.println(validarRegEx(patron, "3423GCB"));   // TRUE
        System.out.println(validarRegEx(patron, "342XGCB"));   // FALSE

        // Comprobar si un String es un telefono movil (comienza por 6,7 u 8 , y tiene 9 numeros)
        patron = "[6-8][0-9]{8}";
        System.out.println(validarRegEx(patron,"676111222"));   // TRUE
        System.out.println(validarRegEx(patron,"67611122"));    // FALSE

        // Comprobar si un String contiene un 1 y ese 1 no está seguido por un 2
        patron = ".*1(?!2).*";
        System.out.println(validarRegEx(patron, "aa21ds"));   // TRUE
        System.out.println(validarRegEx(patron, "aa12ds"));   // FALSE

        // Comprobar si un String  es una direccion de mail valida
        patron = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        System.out.println(validarRegEx(patron, "abc@mm.com"));  // TRUE
        System.out.println(validarRegEx(patron, "abcmm.com"));   // FALSE

        // Comprobar si un String  contiene exactamente y exclusivamente la frase "Vita Brevis"
        patron = "Vita\\sBrevis";                      // VERSION SENCILLA
        patron = "(\\W|^)Vita\\sBrevis(\\W|$)";        // VERSION AMPLIADA
        System.out.println(validarRegEx("(\\W|^)Vita\\sBrevis(\\W|$)", "Vita Brevis"));   // TRUE
        System.out.println(validarRegEx("(\\W|^)Vita\\sBrevis(\\W|$)", "VitaBrevis"));   // FALSE

    }

    public static boolean validarRegEx(String expresionregular, String valor) {
//		return valor.matches(expresionregular);  // otra forma
        return Pattern.matches(expresionregular, valor);
    }


}


class ProcesarUDP {

    public static void enviarObjetoUDP(Object objeto, String host, int puerto) {
        try {
            // Convertimos el objeto en un array de bytes
            byte[] array = objetoToByteArray(objeto);
            // Enviamos el byte[] como un Datagram normal
            InetAddress direcc = InetAddress.getByName(host);
            DatagramPacket dpacket = new DatagramPacket(array, array.length, direcc, puerto);
            DatagramSocket dSocket = new DatagramSocket();
            dSocket.send(dpacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object recibirObjectUDP(String host, int puerto) {
        try {
            // Preparar una array de bytes donde recibir un datagrama
            byte[] array = new byte[5000];
            // Recibir un datagrama
            DatagramPacket packet = new DatagramPacket(array, array.length);
            InetAddress direcc = InetAddress.getByName(host);
            DatagramSocket dSocket = new DatagramSocket(puerto, direcc);
            dSocket.receive(packet);
            // Convertir el datagrama leido como byte[] en un objeto
            Object objetoLeido = byteArrayToObject(array);
            return objetoLeido;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (null);
    }

    public static byte[] objetoToByteArray(Object o) {
        try {
            // Escribimos el objeto en un ByteArrayOutpuStream, y de ahi lo convertimos en
            // byte[]
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(o);
            oos.flush();
            byte[] array = baos.toByteArray(); // convertimos el objeto escrito en el byte[]
            oos.close(); // mejor en un finally, aqui ahora por ahorro de espacio
            return array;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // si se llega aqui es por que hubo un error...
    }

    public static Object byteArrayToObject(byte[] array) {
        try {
            // Escribimos el byte[] en un ByteArrayInpuStream, y de ahi lo convertimos en
            // Object
            ByteArrayInputStream byteStream = new ByteArrayInputStream(array);
            ObjectInputStream is = new ObjectInputStream(byteStream);
            Object objetoLeido = is.readObject();
            is.close(); // mejor en un finally, aqui ahora por ahorro de espacio
            return objetoLeido;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // si se llega aqui es por que hubo un error...
    }
}
 class ProgramaA {
    public static void main(String[] args) {
        Student alumno = new Student ("Ana", 123);
        ProcesarUDP p = new ProcesarUDP();
        p.enviarObjetoUDP(alumno, "localhost", 22001);
    }
}
 class ProgramaB {
    public static void main(String[] args) {
        ProcesarUDP p = new ProcesarUDP();
        Object o = p.recibirObjectUDP( "localhost", 22001);
        Student alumno = (Student) o;
        System.err.println("Recibida informacion del alumno "+alumno.getNombre());
    }
}
 class Student implements Serializable{
    private String nombre;
    private int edad;
    public Student(String nombre, int edad) {
        super();
        this.nombre = nombre;
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }



}






