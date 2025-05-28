package GUT_Sockets_TCP_ABSTRACTA;

import java.io.IOException;
import java.util.Scanner;

public class TCPTeletipoServidor extends TCPServidorAbstract {

	public TCPTeletipoServidor(int puerto) {
		super(puerto);
	}

	@Override
	public void comunicacion() {
		
		Scanner sc = new Scanner(System.in);
		String palabra = "";
		int numPalabras = 0;
		boolean fin = false;
		String mensaje = "";
		
		try {

			do {
				System.out.println("Servidor: esperando envio de mensajes");

				// recibe palabra
					palabra = lector.readUTF();
					if( ! palabra.equalsIgnoreCase("fin")){
						System.out.println("Mensaje de cliente que dice: " + palabra);
					}
				
					fin = palabra.equalsIgnoreCase("fin");
				
			} while (! fin);

		}catch(IOException e){
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		new TCPTeletipoServidor(8001);


	}
}
