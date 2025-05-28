package eldelamigo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorWeb {

	static private final Integer PUERTO = 8080;

	public static void main(String[] args) {
		ServerSocket socketServidor = null;
		try {
			socketServidor = new ServerSocket(PUERTO);
			System.out.println("servidor arrancado....");
			while (true) {
				try {
					Socket socketCliente = socketServidor.accept();
					HilosClientes hilo = new HilosClientes(socketCliente);
					hilo.start();
				} catch (IOException ioe) {
					System.err.println("Error esperando clientes: " + ioe.getLocalizedMessage());
				}
			}
		} catch (IOException ioe) {
			System.err.println("No se puede escuchar en el puerto: " + PUERTO);
			return;
		}

	}
}
