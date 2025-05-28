package chat_multiusuatio.servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.TreeSet;

public class Servidor {
	private static HashMap<String, DataOutputStream> hmUsuarios; // Guarda el nombre del cliente y su salida
	private static TreeSet<Integer> tsNumeros; // Guarda y ordena numeros

	public Servidor() {
		hmUsuarios = new HashMap<>();
		tsNumeros = new TreeSet<>();
	}

	/**
	 * Inicializa el servidor y se queda esperando a clientes. Cuando un cliente entra, crea un hilo y lo lanza.
	 */
	public void arrancar() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		Thread thCliente = null;

		try {
			serverSocket = new ServerSocket(40001);
			System.out.println("Servidor funcionando y a la espera...");

			while (true) // Bucle infinito a la espera de nuevos clientes
			{
				socket = serverSocket.accept(); // En cuanto llega un cliente se crea un hilo y se lanza
				System.out.println("pollo enganchado");
				thCliente = new Thread(new RnCliente(socket));
				System.out.println("lanzo hilo");
				thCliente.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Getter del HashMap
	 *
	 * @return el HashMap con los nombres de los clientes y sus conexiones de salida
	 */
	public static synchronized HashMap<String, DataOutputStream> getHmUsuarios() {
		return hmUsuarios;
	}

	/**
	 * Getter del TreeSet
	 *
	 * @return el TreeSet con los numeros ordenados
	 */
	public static synchronized TreeSet<Integer> getTsNumeros() {
		return tsNumeros;
	}

	/**
	 * A�ade un nuevo usuario al HashMap
	 *
	 * @param nombre
	 *            Nombre del usuario
	 * @param salida
	 *            Conexion de salida del usuario
	 */
	public static synchronized void añadirUsuario(String nombre, DataOutputStream salida) {
		hmUsuarios.put(nombre, salida);
	}

	/**
	 * Borra un usuario del HashMap y detiene su hilo
	 *
	 * @param nombre
	 *            Nombre del usuario
	 */
	public static synchronized void borrarUsuario(String nombre) {
		try {
			if (hmUsuarios.containsKey(nombre)) {
				DataOutputStream salida = hmUsuarios.get(nombre);
				salida.writeUTF("parar"); // Manda la orden de parar el hilo

				hmUsuarios.remove(nombre); // Borra el usuario del HashMap
				System.out.println("Usuario '" + nombre + "' borrado");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * A�ade un numero al TreeSet
	 *
	 * @param numero
	 *            Numero a a�adir
	 */
	public static synchronized void añadirNumero(int numero) {
		tsNumeros.add(numero);
	}

	/**
	 * Manda el nombre del nuevo usuario a los dem�s usuarios
	 *
	 * @param nombre
	 *            Nombre del nuevo usuario
	 */
	public static synchronized void enviarNuevoUsuarioATodos(String nombre) {
		try {
			DataOutputStream salida = null;

			for (String nombreUsuario : hmUsuarios.keySet()) // Recorre todos los usuarios
			{
				salida = hmUsuarios.get(nombreUsuario);

				if (!nombreUsuario.equals(nombre)) // Controla que enviamos a todos, excepto al que envi� el mensaje
					salida.writeUTF(nombre + " se ha conectado"); // Manda el mensaje
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Manda un mensaje enviado por un usuario a todos los dem�s usuarios
	 *
	 * @param nombre
	 *            Nombre del usuario
	 * @param mensaje
	 *            Mensaje a enviar
	 */
	public static synchronized void enviarMensajeATodos(String nombre, String mensaje) {
		try {
			DataOutputStream salida = null;

			for (String nombreUsuario : hmUsuarios.keySet()) // Recorre todos los usuarios
			{
				salida = hmUsuarios.get(nombreUsuario);

				if (!nombreUsuario.equals(nombre)) // Controla que enviamos a todos, excepto al que envi� el mensaje
					salida.writeUTF(nombre + ": '" + mensaje + "'"); // Manda el mensaje
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}