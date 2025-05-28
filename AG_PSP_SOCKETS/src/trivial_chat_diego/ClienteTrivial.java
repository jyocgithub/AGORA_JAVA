import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTrivial {

	String nombre;
	Socket cliente = null;

	public ClienteTrivial(String nombre) {
		this.nombre = nombre;
		procesar();

	}

	public void procesar() {
		ObjectInputStream entrada = null;
		ObjectOutputStream salida = null;
		Mensaje menEnviado;
		Mensaje menRecibido;
		Scanner sc;
		String respuesta;

		try {
			cliente = new Socket("localhost", 10001);
			salida = new ObjectOutputStream(cliente.getOutputStream());
			entrada = new ObjectInputStream(cliente.getInputStream());

			menEnviado = new Mensaje(nombre, Mensaje.AUTORIZACION);
			salida.writeObject(menEnviado);
			menRecibido = (Mensaje) entrada.readObject();
			// comprobamos si puedo seguir
			if (menEnviado.getTipo() == Mensaje.CLIENTEYAEXISTE) {
				System.out.println("No me deja conectarme por que ya estoy conectaco, tontorron");

			} else {
				// aqui ya se que puedo seguir
				System.out.println(menEnviado.getMensaje());
				sc = new Scanner(System.in);
				boolean seguir = true;
				while (seguir) {
					// recibo pregunta
					menRecibido = (Mensaje) entrada.readObject();
					System.out.println(menRecibido.getMensaje());
					// leo en teclado respuesta
					respuesta = sc.nextLine();
					menEnviado = new Mensaje(respuesta, Mensaje.RESPONDER);
					// envio respuesta
					salida.writeObject(menEnviado);
					// recibo corecto o incorrecto
					menRecibido = (Mensaje) entrada.readObject();
					System.out.println(menRecibido.getMensaje());
					if (menRecibido.getTipo() == Mensaje.INCORRECTO) {
						seguir = false;
					}
				}

			}
		} catch (EOFException e) {
			System.out.println("JAJAJA Me han echado !!!");
		} catch (IOException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (salida != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (entrada != null) {
				try {
					entrada.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
