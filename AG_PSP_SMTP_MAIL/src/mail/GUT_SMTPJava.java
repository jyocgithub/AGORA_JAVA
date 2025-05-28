package mail;

import java.io.IOException;
import java.io.Writer;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient.AUTH_METHOD;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;
import java.io.BufferedReader;

import org.apache.commons.net.pop3.POP3MessageInfo;

import org.apache.commons.net.pop3.POP3SClient;

public class GUT_SMTPJava {

	String servidor;
	String usuario;
	String password;

	public GUT_SMTPJava(String servidor, String usuario, String password) {
		super();
		this.servidor = servidor;
		this.usuario = usuario;
		this.password = password;
	}

	public int enviarMensaje(String maildestinio, String asunto, String mensaje) {
		int puerto = 587;
		int respuesta;

		AuthenticatingSMTPClient cliente = new AuthenticatingSMTPClient();

		try {

			KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			kmf.init(null, null);
			KeyManager km = kmf.getKeyManagers()[0];
			cliente.connect(servidor, puerto);

			System.out.println("1. " + cliente.getReplyString());
			cliente.setKeyManager(km);

			respuesta = cliente.getReplyCode();
			if (!SMTPReply.isPositiveCompletion(respuesta)) {
				cliente.disconnect();
				System.out.println("El servicor SMTP ha rechazado la conexion");
				return 0;
			}

			cliente.ehlo(servidor);
			System.out.println("2. " + cliente.getReplyString());

			// el metoxo execTLS() inica la sesion TLS ( del protocolo de seguridad, en la capa de transporte)
			// internamente ejecuta un STARTTLS
			boolean exitoTLS = cliente.execTLS();
			if (!exitoTLS) {
				System.out.println("Fallo al intentar TLS");
				return 1;
			}

			System.out.println("3. " + cliente.getReplyString());
			if (!cliente.auth(AUTH_METHOD.XOAUTH.LOGIN, usuario, password)) {
				System.out.println("Fallo al intentar autenticacion");
				return 2;
			}

			System.out.println("4. " + cliente.getReplyString());

			// cabecera
			SimpleSMTPHeader cabecera = new SimpleSMTPHeader(usuario, maildestinio, asunto);
			cliente.setSender(usuario);
			cliente.addRecipient(maildestinio);
			System.out.println("5. " + cliente.getReplyString());

			// envio
			Writer writer = cliente.sendMessageData();

			if (writer == null) {
				System.out.println("Error al enviar mensaje");
				System.exit(3);
			}
			writer.write(cabecera.toString());
			writer.write(mensaje);
			writer.close();

			System.out.println("6. " + cliente.getReplyString());

			boolean exitosend = cliente.completePendingCommand();
			System.out.println("7. " + cliente.getReplyString());

			if (!exitosend) {
				System.out.println("Error al terminar envio");
				System.exit(4);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cliente != null) cliente.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return 0;

	}

	public int recibirMensajes() {

		int puerto = 110;

		POP3SClient pop3 = new POP3SClient();

		try {
			pop3.connect(servidor, puerto);
			System.out.println("Conexión realizada al servidor POP3 " + servidor);

			// login
			if (!pop3.login(usuario, password)) {
				System.err.println("Error al hacer login");
				return 1;
			}

			POP3MessageInfo[] men = pop3.listMessages();

			if (men == null) {
				System.out.println("Imposible recuperar mensajes.");
				return 2;
			}

			System.out.println("Nº de mensajes: " + men.length);
			if (men.length > 0) {
				recorrerListaMensajes(men, pop3);
			}

			// desconexion
			pop3.logout();
			pop3.disconnect();

		} catch (IOException e) {
			e.printStackTrace();
			return 3;
		}
		return 0;
	}

	private void recorrerListaMensajes(POP3MessageInfo[] men, POP3SClient pop3) throws IOException {

		for (int i = 0; i < men.length; i++) {//
			// POP3MessageInfo msginfo : messages) {
			System.out.println("Mensaje: " + (i + 1));
			POP3MessageInfo msginfo = men[i];

			System.out.println("IDentificador: " + msginfo.identifier + ", Number: " + msginfo.number + ", Tamaño: "
					+ msginfo.size);
			System.out.println("Prueba de listUniqueIdentifier: ");

			POP3MessageInfo pmi = pop3.listUniqueIdentifier(i + 1);// un mensaje
			System.out.println(
					"\tIDentificador: " + pmi.identifier + ", Number: " + pmi.number + ", Tamaño: " + pmi.size);

			// solo recupera cabecera
			System.out.println("Cabecera del mensaje:");
			BufferedReader reader = (BufferedReader) pop3.retrieveMessageTop(msginfo.number, 0);
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line.toString());
			}
			reader.close();

			// recupera todo
			BufferedReader reader2 = (BufferedReader) pop3.retrieveMessage(msginfo.number);
			String linea;
			while ((linea = reader2.readLine()) != null) {
				System.out.println(linea.toString());
			}
			reader2.close();
		}
	}
}
