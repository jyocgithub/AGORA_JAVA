package GUT_Sockets_UDP_Integers;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ProcesarUDP {


    public static void enviarIntegerUDP(int mensaje, String maquinaDestino, int puerto) {
        // simplemente declaramos la maquina que luego vamos a crear
        DatagramSocket maquinaEnviar = null;
        try {
            // ponemos una espera minima para asegurar que quien este esperando lo haga antes que esta lectura
            Thread.sleep(400);
            // Convertimos el mensaje a enviar en un array de bytes
            byte[] arrayLleno = (mensaje+"").getBytes();
            // creo un objeto con la direccion de la maquina destino del mensaje
            InetAddress direcc = InetAddress.getByName(maquinaDestino);

            // creamos el paquete ya con los datos del array de bytes relleno
            DatagramPacket paqueteLleno = new DatagramPacket(arrayLleno, arrayLleno.length, direcc, puerto);

            // creamos la maquina de enviar
            maquinaEnviar = new DatagramSocket();
            // usamos la maquina para enviar el paquete
            maquinaEnviar.send(paqueteLleno);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (maquinaEnviar != null)  maquinaEnviar.close();
        }
    }


    public static int recibirIntegerUDP(String ipMaquinaOrigen, int puerto) {
        // simplemente declaramos la maquina que luego vamos a crear
        DatagramSocket maquinaRecibir = null;
        try {
            // Preparar una array de bytes vacio donde recibir un datagrama en el futuro
            byte[] arrayvacio = new byte[5000];

            // creo un objeto con la direccion de la maquina origen del mensaje
            InetAddress direcc = InetAddress.getByName(ipMaquinaOrigen);
            // Crear un paquete vacio que tiene dentro el array vacio
            DatagramPacket paquetevacio = new DatagramPacket(arrayvacio, arrayvacio.length);

            // creo una maquina y la activo . apuntando con la direccion y el puerto
            maquinaRecibir = new DatagramSocket(puerto, direcc);
            // con la maquina recibimos lo que se este enviando, y eso que se mete en le paquetevacio (realmente, en el array vacio que tiene el paquetevacio)
            maquinaRecibir.receive(paquetevacio);

            // Convertir el array de bytes en un string
            String mensajerecibido = new String(arrayvacio);
          //String mensajerecibido = new String(paquetevacio.getData(),paquetevacio.getOffset(), paquetevacio.getLength());  // otro modo
            int res = Integer.parseInt(mensajerecibido);
            return res;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (maquinaRecibir != null) maquinaRecibir.close();
        }
        // si se llega aqui es por que hubo un error...
        return 0;
    }

}



