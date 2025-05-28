package chat_multiusuatio.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainCliente {
	public static void main(String[] args) {
		DataOutputStream salida;
		DataInputStream entrada;
		Socket socket;
		Scanner sc;
		String nombre, mensaje;
		boolean parar = false;

		try {
			socket = new Socket("localhost", 40001);

			// La instanciaci�n de estas dos variables debe ser opuesta en el servidor
			salida = new DataOutputStream(socket.getOutputStream());
			entrada = new DataInputStream(socket.getInputStream());

			RnEscuchaServidor rnescuchaServidor = new RnEscuchaServidor(socket, entrada, salida);
			Thread thEscuchaServidor = new Thread(rnescuchaServidor);
			thEscuchaServidor.start(); // Crea un hilo de escucha y lo lanza

			sc = new Scanner(System.in);
			System.out.print("Nombre: ");
			nombre = sc.nextLine();

			salida.writeUTF(nombre);

			while (!parar) {
				System.out.println("Mensaje: ");
				mensaje = sc.nextLine();

				if (mensaje.equalsIgnoreCase("parar")) {
					rnescuchaServidor.pararEscucha();
					;
					parar = true;

				}
				salida.writeUTF(mensaje);
			}

			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
