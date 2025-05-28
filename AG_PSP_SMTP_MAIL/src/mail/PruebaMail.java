package mail;

import java.util.Date;
import java.util.Scanner;

public class PruebaMail {

	public static void main(String[] args) {

		// EMVIO SMTP a correo

		String servidor = "smtp.gmail.com";
		String usuario = "imartinsacristan@gmail.com";
		String maildestinio = "javayotrascosas@gmail.com";
		String asunto = "Correo de ejemplo de fecha " + new Date();
		String mensaje = "Este es el cuerpo del mensaje";
		Scanner sc = new Scanner(System.in);
		System.out.println("Por seguridad no guardamos la password en el código");
		System.out.println("Por favor, indique ahora la passwoed de la cuenta de correo '" + usuario + "' :");
		String password = sc.nextLine();

		GUT_SMTPJava micorreojava = new GUT_SMTPJava(servidor, usuario, password);
		// micorreojava.enviarMensaje(maildestinio, asunto, mensaje);

		// RECIBIR MENSAJES
		micorreojava.recibirMensajes();

	}

}
