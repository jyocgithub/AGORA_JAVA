package GUT_Sockets_TCP_ABSTRACTA;

import java.io.IOException;
import java.util.Scanner;

public class TCPTeletipoCliente extends TCPClienteAbstract {

	String palabra = "";
	boolean fin = false;

	public TCPTeletipoCliente(String ip, int puerto) {
		super(ip, puerto);
	}

	@Override
	public void comunicacion() {
		Scanner sc = new Scanner(System.in);
		try {
			do {
				// pide palabra
				System.out.println("Escribe un mensaje cualquiera, o 'Fin' para terminar");
				palabra = sc.nextLine();
			
				fin = palabra.equalsIgnoreCase("fin");
				escritor.writeUTF(palabra);

			} while (!fin);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		TCPTeletipoCliente ttt = new TCPTeletipoCliente("127.0.0.1", 8001);
	}
}
