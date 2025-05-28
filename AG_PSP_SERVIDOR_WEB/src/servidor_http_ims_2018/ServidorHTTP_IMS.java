package servidor_http_ims;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ServidorHTTP_IMS {

	static final String Directorioraizdepaginas = ".";

	public static void main(String[] args) {
		int puerto = 8080;
		ServerSocket ss;
		Socket socket;

		try {
			ss = new ServerSocket(puerto);
			System.out.println("SERVIDOR CREADO ===========");
			while (true) {
				System.out.println("-- Esperando clientes...");
				socket = ss.accept();
				System.out.println("-- Cliente conectado...");
				HiloDelServidor hds = new HiloDelServidor(socket);
				Thread t = new Thread(hds);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class HiloDelServidor implements Runnable {
	OutputStream escritor;
	BufferedReader lector;
	Socket socket;
	ArrayList<String> peticiones;
	File f;

	public HiloDelServidor(Socket socket) {
		super();
		this.socket = socket;
		peticiones = new ArrayList<>();
		try {
			escritor = socket.getOutputStream();
			lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String peticion = "";
		String peticion2 = "";
		System.out.println("En el hilo servidor");
		URL unaurl = null;
		String respuestaHttp = "";

		try {

			String linea = lector.readLine();
			while (!linea.isEmpty()) {
				peticiones.add(linea);
				linea = lector.readLine();
			}

			String linea1 = peticiones.get(0);

			if (linea1.toUpperCase().startsWith("GET")) {
				int pos1 = linea1.indexOf("/");
				int pos2 = linea1.indexOf(" ", pos1);
				String ficheropedido = linea1.substring(pos1 + 1, pos2);
				System.out.println("He recibido la peticion: " + linea1);

				// ELEMENTROS DE LA CABECERA DE LA RESPUESTA AL NAVEGADOR
				// "HTTP/1.1 200 OK\r\n"
				// "Connection: close\r\n"
				// "Server: ejercicio.servidor.local\r\n"
				// "Content-type: text/html charset=utf-8"
				// "\r\n"

				respuestaHttp = "HTTP/1.1 200 OK\r\n"; // analizar antes si es o no OK
				String tipocontenido = "";
				if ((ficheropedido.toUpperCase().endsWith("HTML")) || (ficheropedido.toUpperCase().endsWith("HTM"))) {
					tipocontenido = "ES HTML";
				} else if (ficheropedido.toUpperCase().endsWith("JPG")) {
					tipocontenido = "JPG";
				} else if (ficheropedido.toUpperCase().endsWith("PNG")) {
					tipocontenido = "PNG";
				} else if (ficheropedido.toUpperCase().endsWith("GIF")) {
					tipocontenido = "GIF";
				} else {
					// httpResponse = "HTTP/1.1 200 OK\r\n\r\n" ;
					respuestaHttp = "HTTP/1.0 415 Unsupported Media Type\r\n\r\n FORMATO NO SOPORTADO";
					escritor.write(respuestaHttp.getBytes("UTF-8"));
				}
				if (tipocontenido.equals("ES HTML")) {
					File f = new File(ServidorHTTP_IMS.Directorioraizdepaginas, ficheropedido);
					if (f.exists() == false) {
						respuestaHttp = "HTTP/1.0 404 Not Found\r\n\r\n";
					} else {
						respuestaHttp += "Content-type: text/html charset=utf-8\r\n\r\n";
						BufferedReader bfdefich = new BufferedReader(new FileReader(f));
						String linfich = bfdefich.readLine();
						while (linfich != null) {
							respuestaHttp += linfich;
							linfich = bfdefich.readLine();
						}
						bfdefich.close();
						escritor.write(respuestaHttp.getBytes("UTF-8"));
					}
				} // if del envio de html
				if (tipocontenido.equals("PNG")) {
					f = new File(ServidorHTTP_IMS.Directorioraizdepaginas, ficheropedido);
					if (f.exists() == false) {
						respuestaHttp = "HTTP/1.0 404 Not Found\r\n\r\n";
					} else {
						BufferedImage originalImage = ImageIO.read(f);
						byte[] imagenInByte;
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						ImageIO.write(originalImage, "png", baos);
						baos.flush();
						imagenInByte = baos.toByteArray();
						baos.close();
						respuestaHttp = "HTTP/1.1 200 OK\r\nContent-type: image/png\r\n\r\n";
						escritor.write(respuestaHttp.getBytes("UTF-8"));
						escritor.write(imagenInByte);
					}
				}
				if (tipocontenido.equals("JPG")) {
					f = new File(ServidorHTTP_IMS.Directorioraizdepaginas, ficheropedido);
					if (f.exists() == false) {
						respuestaHttp = "HTTP/1.0 404 Not Found\r\n\r\n";
					} else {

						BufferedImage originalImage = ImageIO.read(f);
						byte[] imagenInByte;
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						ImageIO.write(originalImage, "jpg", baos);
						baos.flush();
						imagenInByte = baos.toByteArray();
						baos.close();
						respuestaHttp = "HTTP/1.1 200 OK\r\nContent-type: image/jpg\r\n\r\n";
						escritor.write(respuestaHttp.getBytes("UTF-8"));
						escritor.write(imagenInByte);
					}
				} // if del envio de img
			} else {
			} // if del get
			System.out.println("__DEVUELVO: " + respuestaHttp);

		} catch (

		IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (escritor != null) escritor.close();
				if (lector != null) lector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public byte[] unirDosArraysBytes(byte[] a, byte[] b) {
		int aLen = a.length;
		int bLen = b.length;
		byte[] c = new byte[aLen + bLen];
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);
		return c;
	}
}




