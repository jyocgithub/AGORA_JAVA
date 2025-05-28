package ftp.inicio;

public class EjemploFTP {

	public static void main(String[] args) {
		// ------------- FTP
		String servidor = "ftp.jyoc.heliohost.org";
		String usuario = "ftp1@jyoc.heliohost.org";
		String password = "66666";
		int puerto = 21;

		MiFTPJava miftp = new MiFTPJava(servidor, puerto);

		// conectar el ftp
		miftp.conectar();
		// login
		miftp.login(usuario, password);
		// subir el fichero
		miftp.subirFichero("EjemploTXT1.txt", "subido.txt");
		// bajar el fichero
		miftp.bajarFichero("subido.txt", "bajado.txt");
		// desconectar el ftp
		miftp.desconectar();

	}

}
