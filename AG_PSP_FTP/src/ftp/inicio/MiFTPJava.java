package ftp.inicio;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.SocketException;

public class MiFTPJava {

	FTPClient ftpcliente;
	String servidor;
	int puerto;

	public MiFTPJava(String servidor, int puerto) {
		this.servidor = servidor;
		this.puerto = puerto;
		ftpcliente = new FTPClient();
	}

	// ------------------------------- CONEXION
	// ----------------------------------------
	public void conectar() {
		try {
			ftpcliente.connect(servidor);
			 System.out.println("----------- respuesta al connect()");
			 System.out.println(ftpcliente.getReplyString());
			 System.out.println("----------- codigo respuesta al connect()");
			 System.out.println(ftpcliente.getReplyCode());
			 System.out.println("----------- saber si estamos conectados");
			 System.out.println(ftpcliente.isConnected());
			 System.out.println(FTPReply.isPositiveCompletion(ftpcliente.getReplyCode()));

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void desconectar() {
		try {
			ftpcliente.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean login(String usuario, String password) {
		try {
			boolean loginCorrecto = ftpcliente.login(usuario, password);
			if (loginCorrecto) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	// ------------------------------- TRANSFERENCIAS
	// ---------------------------------------------
	public boolean subirFichero(String nombreEnEquipo, String nombreEnServidor) {
		BufferedInputStream bis = null;
		try {
			ftpcliente.setFileType(FTP.BINARY_FILE_TYPE);
			bis = new BufferedInputStream(new FileInputStream(nombreEnEquipo));
			if (ftpcliente.storeFile(nombreEnServidor, bis)) {
				System.out.println("-> Fichero subido correctamente");
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean bajarFichero(String nombreEnServidor, String nombreEnEquipo) {
		BufferedOutputStream bos = null;
		try {
			ftpcliente.setFileType(FTP.BINARY_FILE_TYPE);
			bos = new BufferedOutputStream(new FileOutputStream(nombreEnEquipo));
			if (ftpcliente.retrieveFile(nombreEnServidor, bos)) {
				System.out.println("-> Fichero bajado correctamente");
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	// ------------------------------- DIRECTORIOS
	// -------------------------------------------
	public boolean moverADirectorio(String directoriodestino) {
		try {
			return ftpcliente.changeWorkingDirectory(directoriodestino);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean moverADirectorioRaiz(String directoriodestino) {
		try {
			return ftpcliente.changeToParentDirectory();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String directorioActual() {
		try {
			return ftpcliente.printWorkingDirectory();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// Crea un nuevo subdirectorio en el servidor FTP
	// en el directorio actual (si se proporciona un nombre de ruta relativo)
	// o donde se especifica (si se proporciona un nombre de ruta absoluto).
	public boolean creardirectorio(String dir) {
		try {
			return ftpcliente.makeDirectory(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	// ------------------------------- FICHEROS
	// ----------------------------------------
	public String[] listarNombres() {
		String[] nombres = null;
		try {
			nombres = ftpcliente.listNames();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nombres;
	}

	public void mostrarNombres() {
		try {
			String[] nombres = ftpcliente.listNames();
			for (String s : nombres) {
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FTPFile[] listarFiles() {
		FTPFile[] files = null;
		try {
			files = ftpcliente.listFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return files;
	}

	public boolean borrarFichero(String nombrefichero) {
		try {
			return ftpcliente.deleteFile(nombrefichero);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean renombrarFIchero(String nombreorigen, String nombrenuevo) {
		try {
			return ftpcliente.rename(nombreorigen, nombrenuevo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
