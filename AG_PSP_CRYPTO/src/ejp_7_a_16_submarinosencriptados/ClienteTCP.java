package ejp_7_a_16_submarinosencriptados;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class ClienteTCP {

	public static int puerto = 45003;
	private static DataInputStream lector = null;
	private static DataOutputStream escritor = null;

	public static void main(String[] args) {
		Socket manguera = null;
		try {
			manguera = new Socket("localhost", puerto);

			escritor = new DataOutputStream(manguera.getOutputStream());
			lector = new DataInputStream(manguera.getInputStream());

			conversacion();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				manguera.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void conversacion() {

		UtilCriptoSimetricosFile ucs = new UtilCriptoSimetricosFile("AES");


		String[] mensajes = { "vamos al norte", "vamos al sur", "yendo al sur", "yendo al norte", "mas al sur",
				"giro al sur", "no nos movemos", "sin avanzar" };

		try {
			String mensaje;
			Random r = new Random();
			int x = 0;
			while (x < 10) {
				espera();

				int n = r.nextInt(mensajes.length);
				mensaje = mensajes[n];
				byte[] mensajeCifrado = ucs.cifrarString(mensaje);
				escritor.write(mensajeCifrado);
				x++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void espera(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
