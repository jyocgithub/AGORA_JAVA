package GUT_Sockets_UDP_Strings;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ProcesarUDPBueno {


    public static void enviarStringUDP(String mensaje, String ipMaquinaDestino, int puerto) throws Exception {
        // ponemos una espera minima para asegurar que quien este esperando lo haga antes que esta lectura
        Thread.sleep(400);

        // 1.- Convertir el mensaje a enviar en un array de bytes
        byte[] arrayLleno = mensaje.getBytes();

        // 2.- Crear un objeto con la direccion de la maquina destino del mensaje
        InetAddress direcc = InetAddress.getByName(ipMaquinaDestino);

        // 3.- Crear el paquete ya con los datos del array de bytes relleno
        // Al ser el que envia, el datagrama se crea con los 4 valores indicados
        DatagramPacket paqueteLleno = new DatagramPacket(arrayLleno, arrayLleno.length, direcc, puerto);

        // 4.- Crear la maquina de enviar mensajes
        // Al ser el que envia, se crea con un constructor vacio
        DatagramSocket maquinaEnviar = new DatagramSocket();

        // 5.- Usar la maquina para enviar el paquete
        maquinaEnviar.send(paqueteLleno);
        maquinaEnviar.close();
    }


    public static String recibirStringUDP(String ipMaquinaOrigen, int puerto) throws Exception {
        // ponemos una espera minima para asegurar que quien este esperando lo haga antes que esta lectura
        Thread.sleep(400);

        // 1.- Preparar una array de bytes vacio donde recibir un datagrama en el futuro
        byte[] arrayvacio = new byte[5000];

        // 2.- Crear un objeto con la direccion de la maquina destino del mensaje
        InetAddress direcc = InetAddress.getByName(ipMaquinaOrigen);

        // 3.- Crear un paquete vacio que tiene dentro el array vacio
        // Al ser el que recibe, el datagrama se crea solo con los 2 valores indicados
        DatagramPacket paquetevacio = new DatagramPacket(arrayvacio, arrayvacio.length);

        // 4,. Crear una maquina de recibir, apuntando con la direccion y el puerto
        // Al ser el que recibe, el datagrama se crea con puerto y dureccion
        DatagramSocket maquinaRecibir = new DatagramSocket(puerto, direcc);

        // 5.- Con la maquina recibir lo que se este enviando,
        // y eso que se meterá en el array vacio que tiene el paquetevacio
        maquinaRecibir.receive(paquetevacio);

        // 6.- Convertir el array de bytes en un string
        // -- FORMA 1: crear un string con el valor recibido, sin mas, si va a quedar como String, vale asi
        //    String mensajerecibido = new String(paquetevacio.getData());
        // -- FORMA 2: crear un string con el valor recibido, pero eliminando los valores invalidos del byte array, mucho mas recomendable
        // -- pues si no, estos valores (el relleno de posiciones hasta completar el byte array) no permiten una correcta conversion a int
        String mensajerecibido = new String(paquetevacio.getData(),paquetevacio.getOffset(), paquetevacio.getLength());  // otro modo

        maquinaRecibir.close();

        return mensajerecibido.trim();
    }


}



