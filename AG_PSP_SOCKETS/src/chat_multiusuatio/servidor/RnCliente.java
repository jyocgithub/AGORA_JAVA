package chat_multiusuatio.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;

public class RnCliente implements Runnable {
	private Socket socket;
	private DataOutputStream salida;
	private DataInputStream entrada;
	private String nombre, mensaje;
	private boolean seguir = true;

	public RnCliente(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			/*
			 * Las instancias en servidor y cliente deben ser opuestas. Es decir, si en el servidor instanciamos primero
			 * InputStream, en el cliente debemos instanciar primero OutputStream
			 */
			System.out.println("Usuario conectado, esperando nombre... ");
			entrada = new DataInputStream(socket.getInputStream());
			salida = new DataOutputStream(socket.getOutputStream());

			nombre = entrada.readUTF();
			System.out.println("Nuevo usuario: " + nombre);

			Servidor.añadirUsuario(nombre, salida); // A�ade el nuevo usuario al HashMap
			Servidor.enviarNuevoUsuarioATodos(nombre); // Envia el nombre del usuario a los dem�s

			while (seguir) {
				mensaje = entrada.readUTF();
				extraerNumeros(mensaje); // Extrae el numero del mensaje y lo a�ade al TreeSet

				System.out.println(nombre + ": '" + mensaje + "'");

				if (mensaje.equalsIgnoreCase("parar")) // Si el usuario escribe "parar"
				{
					Servidor.borrarUsuario(nombre); // Borra el usuario
					Servidor.enviarMensajeATodos(nombre, "Usuario " + nombre + " desconectado");
					seguir = false;
				} else
					Servidor.enviarMensajeATodos(nombre, mensaje); // Envia el mensaje del usuario a los dem�s

				if (cincoNumerosLeidos()) // Si ya van 5 numeros leidos, se muestran
				{
					System.out.println("Se han leido 5 n�meros");
					mostrarNumerosOrdenadosATodos();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (entrada != null) entrada.close();

				if (salida != null) salida.close();

				if (socket != null) socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Manda un mensaje a todos los usuarios con los numeros ordenados
	 */
	private synchronized void mostrarNumerosOrdenadosATodos() {
		try {
			String numOrdenados = getNumerosOrdenados();

			for (DataOutputStream salida : Servidor.getHmUsuarios().values()) // Recorre todos los usuarios
			{
				salida.writeUTF("Se han leido 5 n�meros distintos: " + numOrdenados);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Recorre el TreeSet y devuelve un String con todos los numeros
	 * 
	 * @return Cadena con todos los numeros ordenados
	 */
	private synchronized String getNumerosOrdenados() {
		String cadenaNumeros = "";
		Iterator<Integer> it = Servidor.getTsNumeros().iterator();

		while (it.hasNext()) {
			cadenaNumeros += it.next() + " ";
		}

		return cadenaNumeros;
	}

	/**
	 * Comprueba si ya se han leido y almacenado 5 numeros
	 * 
	 * @return true si se han leido, false si no
	 */
	private synchronized boolean cincoNumerosLeidos() {
		if (Servidor.getTsNumeros().size() == 5)
			return true;
		else
			return false;
	}

	/**
	 * Extrae un numero de un mensaje y lo a�ade al TreeSet, siempre que no est� lleno
	 *
	 * @param mensaje
	 *            Mensaje del que se extrae el numero
	 */
	private synchronized void extraerNumeros(String mensaje) {
		int num;

		for (int i = 0; i < mensaje.length(); i++) {
			if (Character.isDigit(mensaje.charAt(i)) && Servidor.getTsNumeros().size() < 5) {
				num = Character.getNumericValue(mensaje.charAt(i));
				Servidor.añadirNumero(num);
			}
		}
	}
}