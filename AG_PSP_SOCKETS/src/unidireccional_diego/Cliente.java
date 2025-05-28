package unidireccional_diego;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// System.out.print("Host remoto:");
		// String host = sc.nextLine();
		// System.out.print("Puerto: ");
		// int numPuerto = Integer.parseInt(sc.nextLine());
		Socket cliente = null;
		try {
			cliente = new Socket("localhost", 10001);
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
			String linea = "";
			while (!linea.equalsIgnoreCase("FIN")) {
				System.out.print("Escribe mensaje a Enviar: ");
				linea = sc.nextLine();
				salida.writeUTF(linea);
				System.out.println(" el servidor me dice " + entrada.readUTF());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		if (cliente != null) {
			try {
				cliente.close();
			} catch (IOException e) {

			}
		}
		sc.close();
	}

}
