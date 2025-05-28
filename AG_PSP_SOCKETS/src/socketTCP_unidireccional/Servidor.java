package socketTCP_unidireccional;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// System.out.print("Número de puerto:");
		ServerSocket serverSocket = null;
		// int numPuerto = sc.nextInt();
		// sc.close();
		try {
			serverSocket = new ServerSocket(10001);
			Socket cliente = serverSocket.accept();
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
			String mensaje = "";
			while (!mensaje.equalsIgnoreCase("fin")) {
				mensaje = entrada.readUTF();
				System.out.println("Soy servidor y he recibido este mensaje:" + mensaje);
				System.out.println("Escribe la respuesta");
				String respuesta = sc.nextLine();
				salida.writeUTF(respuesta);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			if (serverSocket != null) serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
