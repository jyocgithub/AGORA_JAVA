package juliaMensajeria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * PROGRAMA SERVIDORDECHAT.java
 * 
 * Contiene cuatro clases:
 * - class ServidorDeChat: es una instancia única, que esta en un bucle infinito esperando
 * a que se comuniquen con el algun cliente, establenciendo el socket que necesita,
 * autentica a los clientes y si es correcta la password crea los hilos HiloServidorParaCadaCliente
 * 
 * - class HiloServidorParaCadaCliente : es la clase que es un hilo, hay una inbstancia para cada cliente,
 * un hilo de tipo servidor, que controla lo que envia el hilo de cada cliente (peticiones) y
 * le devuelve lo que haya pedido (gestiona sus mensajes)
 * 
 * - class Cliente: Vale para crear objetos Cliente, con sus atributos (buzones de mensaje, streem de
 * lectura y de escritura, etc)
 * 
 * - class datos : tiene datos de conexion (puerto , basicamente) para que todos los hilos cliente
 * y servidor puertos identicos
 * 
 */

class datos {
	int port = 22220;
}

/**
 * SalaDeChat
 * 
 * Es el lado del servidor de una sala de chat.
 * Permite que se le conecten tantos
 * clientes como se quiera. Para cada uno, se queda escuchando
 * en su stream de entrada y actua en consecuencia
 */
public class ServidorDeChat {

	/**
	 * main
	 * 
	 */
	public static void main (String[] args) {

		Socket socketCliente;
		int numeroPuerto = new datos ().port;
		HiloServidorParaCadaCliente obHiloServidorPorCliente;
		ServerSocket serverSocket;
		PrintWriter escritor;
		BufferedReader lector;
		List<Cliente> clientes;
		boolean hayunprimercliente = false;

		// Creamos el ServerSocket donde nos quedaremos escuchando.
		try {
			serverSocket = new ServerSocket (numeroPuerto);
		}
		catch (IOException e) {
			System.out.println ("No pude escuchar en el puerto " + numeroPuerto);
			return;
		}

		// Creamos la lista de "writers" (el lado de salida de todos los sockets que se nos han conectado),
		clientes = new ArrayList<> ();
		boolean seguirEnElBucle = true;
		System.out.println ("Servidor arrancado");

		// Damos vueltas continuamente
		while (seguirEnElBucle) {

			// Esperamos el siguiente cliente.
			try {
				socketCliente = serverSocket.accept ();
			}
			catch (IOException ioe) {
				System.err.println ("Error esperando clientes: " + ioe.getLocalizedMessage ());
				return;
			}

			// Acaba de llegarnos un nuevo cliente.
			// Obtenemos el canal para escribir en el socket, que sera el de entrada
			// a este cliente cuando cualquier otro escriba.
			try {
				// obtenemos los canales para leere y escribir en el cliente
				escritor = new PrintWriter (socketCliente.getOutputStream ());
				lector = new BufferedReader (new InputStreamReader (socketCliente.getInputStream ()));
				// Pedimos user y passwrd
				escritor.println ("Bienvenido, identifiquese con su nombre:");
				escritor.flush ();
				String n = lector.readLine ();
				escritor.println ("Indique la contraseña:");
				escritor.flush ();
				String p = lector.readLine ();
				// pass ok, seguimos
				if (p.equals ("123")) {
					// Añadimos el strem del cliente a la lista de clientes
					// y al usuario a la lista de clientes
					Cliente c = new Cliente (n, escritor, lector, socketCliente);
					clientes.add (c);

					// Lanzamos una hebra para escribir todo lo que nos llegue.
					obHiloServidorPorCliente = new HiloServidorParaCadaCliente (c, clientes);
					new Thread (obHiloServidorPorCliente).start ();
					escritor.flush ();
				}
				else {
					escritor.println ("Password erronea, se le desconecta...");
					socketCliente.close ();
				}
			}
			catch (IOException e) {
				System.err.println ("No pude conseguir canal de escritura o escritura del socket.");
				return;
			}
		}
	}
}

