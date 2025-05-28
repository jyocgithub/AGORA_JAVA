package servidor_web_jyoc_2019;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

public class ServidorWebJYOC2019 {

	static private final Integer PUERTO = 8087;
	static private final Integer TIMEOUT_CLIENTES = 20000; // 20 segundos, se mide en milisegundos
	static private final String DIRECTORIO_DE_CONTENIDOS = "CARPETA_DE_CONTENIDOS_SERVIDOR_WEB";
	static final String Directorioraizdepaginas = "." + File.separator + DIRECTORIO_DE_CONTENIDOS; // File.separator asegura que la
																									// / que se añade sea la de unix
																									// o la de windows, la que le
																									// toque

	public static void main(String[] args) {
		ServerSocket serverSocket;
		Socket socket;

		try {
			serverSocket = new ServerSocket(PUERTO);
			System.out.println("SERVIDOR CREADO ===========");
			while (true) {
				System.out.println("-- Esperando nueva peticion...");
				System.out.println("-- Debe realizarla en un navegador, pidiendo una url como esta:");
				System.out.println("-- Http://localhost:8087/tutorial.html  ");
				System.out.println("-- Puede pedir ese fichero u otro cualquiera, que debe estar en la carpeta ");
				System.out.println("-- "+ DIRECTORIO_DE_CONTENIDOS + " (en el raiz de este proyecto)");
				// En este caso el socket no es una clase cliente que hagamos nosotros,
				// si no que lo genera el navegador (chrome, por ejemplo), al hacer una peticion al puerto correspondiente
				// Se ha de leer del socket lo que pide , y al mismo socket (navegador), devolverle la respuesta
				// con lo que ha pedido.
				// EL navegador sabe procesar lo se le devuelve pintandolo en la pantalla , o descargandolo, o lo que tenga
				// configurado.
				socket = serverSocket.accept();
				System.out.println("-- Cliente conectado, peticion recibida.");
				HiloDelServidorWeb hds = new HiloDelServidorWeb(socket, TIMEOUT_CLIENTES);
				Thread t = new Thread(hds);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



 class HiloDelServidorWeb implements Runnable {
	OutputStream escritor;
	BufferedReader lector;
	Socket socket;
	private int timeout;
	ArrayList<String> lineasDeLaPeticion;

	public HiloDelServidorWeb(Socket socket, int timeout) {
		super();
		this.timeout = timeout;
		this.socket = socket;
		lineasDeLaPeticion = new ArrayList<>();

	}

	@Override
	public void run() {
		String tipocontenido = "";
		// String peticion = "";
		// String peticion2 = "";
		// URL unaurl = null;
		String respuestaHttp = "";
		System.out.println("En el hilo servidor");

		try {
			// soTimeOut es el tiempo que se espera desde que se hace la conexion hasta que se recibe la primera
			// lectura. Este tiempo en conexioes de red inestables puede ser mas largo, y si llega al limite
			// establecido, provoca una SocketTimeoutException
			// En nuestro ejemplo, no va a pasar, pues al ser el mismo equipo, desde que se crea el socket
			// hasta que se hace la primera lectura es tiempo casi inmediato.
			socket.setSoTimeout(timeout);
			// creamos los canales para leer y escribir del socket
			escritor = socket.getOutputStream();
			lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// leemos todas las lineas de las peticion y las guardamos en un arraylist
			// aqui es donde se empieza a leer del socket, y donde ya se cancela el soTimeOut hablado antes
			String linea = lector.readLine();
			while (!linea.isEmpty()) {
				lineasDeLaPeticion.add(linea);
				linea = lector.readLine();
			}
			// aunque se leen todas las lineas de la peticion, solo hacemos caso a la primera
			String linea1 = lineasDeLaPeticion.get(0);

			// en este ejemplo, solo hacemos caso de las peticiones GET
			if (linea1.toUpperCase().startsWith("GET")) {
				int pos1 = linea1.indexOf("/"); // posision del primer caracter /
				int pos2 = linea1.indexOf(" ", pos1); // posicion del primer espacio, despues de la pos1
				// sabiendo donde esta el primer / y el primer espacio, entre medias, esta el nombre del fichero solicitado
				String ficheropedido = linea1.substring(pos1 + 1, pos2);
				ficheropedido = ficheropedido.toLowerCase();
				System.out.println("He recibido la peticion: " + linea1);
				System.out.println("El fichero pedido es:" + ficheropedido);

				// creamos un objeto File con el directorio donde estamos "sirviendo" contenidos
				// y el nombre del fichero que no han pedido
				// Si el fichero lo tenemos, lo devolveremos
				File objetoFileDelficheroQueSePide = new File(ServidorWebJYOC2019.Directorioraizdepaginas,
						ficheropedido);

				// si el fichero no existe...
				if (objetoFileDelficheroQueSePide.exists() == false) {
					// creamos una cabecera de respuesta con error 404, y la escribimos en el socket
					respuestaHttp = "HTTP/1.0 404 Not Found\r\n\r\n FICHERO NO ENCONTRADO, ERROR 404. ";
					// para escribir en el socket un String, lo convertimos a array de bytes
					escritor.write(respuestaHttp.getBytes("UTF-8"));
				} else {

					respuestaHttp = "HTTP/1.1 200 OK\r\n"; // analizar antes si es o no OK
					String extensionDelArchivo = ficheropedido.substring(ficheropedido.lastIndexOf(".") + 1);
					extensionDelArchivo = extensionDelArchivo.toUpperCase();
					switch (extensionDelArchivo) {
						case "HTML":
						case "HTM":
						case "CSS":
						case "TXT":
						case "JAVA":
							tipocontenido = "TEXTO";
							respuestaHttp += "Content-type: text/plain charset=utf-8\r\n\r\n";
							BufferedReader bfdefich = new BufferedReader(new FileReader(objetoFileDelficheroQueSePide));
							String linfich = bfdefich.readLine();
							while (linfich != null) {
								respuestaHttp += linfich;
								linfich = bfdefich.readLine();
							}
							bfdefich.close();
							escritor.write(respuestaHttp.getBytes("UTF-8"));
							break;
						case "AVI":
						case "MP4":
							tipocontenido = "VIDEO";
							byte[] imagenEnArrayDeBytes = leerFileYDevolverArrayDeBytes(objetoFileDelficheroQueSePide);
							respuestaHttp = "HTTP/1.1 200 OK\r\nContent-type: video/" + extensionDelArchivo + "\r\n\r\n";
							escritor.write(respuestaHttp.getBytes("UTF-8"));
							escritor.write(imagenEnArrayDeBytes);
							break;
						case "PNG":
						case "JPG":
						case "GIF":
						case "JPEG":
							tipocontenido = "IMAGEN";
							byte[] imagenEnArrayDeBytes2 = leerFileYDevolverArrayDeBytes(objetoFileDelficheroQueSePide);
							respuestaHttp = "HTTP/1.1 200 OK\r\nContent-type: image/" + extensionDelArchivo + "\r\n\r\n";
							escritor.write(respuestaHttp.getBytes("UTF-8"));
							escritor.write(imagenEnArrayDeBytes2);
							break;
						default:
							respuestaHttp = "HTTP/1.0 415 Unsupported Media Type\r\n\r\n FORMATO NO SOPORTADO, ERROR 415";
							escritor.write(respuestaHttp.getBytes("UTF-8"));
					} // fin del if de seleccion de tipo de fichero

				}
			} // fin del if de no existe el fichero
			System.out.println("-- TIPO MENSAJE DEVUELTO: " + respuestaHttp);
		} catch (SocketTimeoutException ex) {
			System.err.println("La conexión ha caducado (20 segundos desde conexion sin recibir nada)");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (escritor != null) escritor.close();
				if (lector != null) lector.close();
				if (socket != null) {
					socket.close();
					System.err.println("La conexión se ha cerrado");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private byte[] leerFileYDevolverArrayDeBytes(File objetoFileDelficheroQueSePide) {
		FileInputStream fis = null;
		int tamanodelfichero = (int) objetoFileDelficheroQueSePide.length();
		byte[] arrayDeBytesConTantosBytesComoTamanoDelFichero = new byte[tamanodelfichero];
		try {
			fis = new FileInputStream(objetoFileDelficheroQueSePide);
			fis.read(arrayDeBytesConTantosBytesComoTamanoDelFichero);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return arrayDeBytesConTantosBytesComoTamanoDelFichero;
	}
}
