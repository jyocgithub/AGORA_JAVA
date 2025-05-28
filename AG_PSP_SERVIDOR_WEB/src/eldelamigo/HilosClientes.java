package eldelamigo;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.imageio.ImageIO;

class HilosClientes extends Thread {

	private Socket socket;
	BufferedReader input;
	DataOutputStream output;

	public HilosClientes(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			DataOutputStream output = new DataOutputStream(socket.getOutputStream());
			responder(input, output);
			input.close();
			output.close();
		} catch (IOException ioe) {
			System.err.println("ERROR " + ioe.getLocalizedMessage());
			return;
		}
	}

	public void responder(BufferedReader input, DataOutputStream output) {

		String peticion;
		int tipo_peticion = 0;
		String ruta;
		FileInputStream archivo;
		int tipoArchivo = 0;
		String directorio = ".";
		String fichero = "index.html";

		/*
		 * Leemos la peticiÃ³n desde el navegador
		 * 
		 */

		try {
			peticion = input.readLine();
			input.readLine();
		} catch (Exception ex) {
			System.err.println("Error no se puede leer la peticiÃ³n: " + ex.getMessage());
			return;
		}

		/*
		 * Comprobamos que tipo de peticÃ­on se ha realizado
		 * 
		 */

		String tmp = peticion.toUpperCase();
		if (tmp.startsWith("HEAD")) {
			tipo_peticion = 1;
		}
		if (tmp.startsWith("GET")) {
			tipo_peticion = 2;
		}

		if (tipo_peticion == 0) {
			try {
				output.writeBytes(crearCabecera(501, -1));
				System.err.println("Se ha detectado un error 501");
			} catch (Exception ex) {
				System.err.println("Error: " + ex.getMessage());
				System.err.println("No se pudo enviar el mensaje de error 501");
				return;
			}
		} else {
			// Como la peticion no se ha rechazado, continuamos:
			// Linea 2: Etraemos la ruta del archivo solicitado
			ruta = comprobarRuta(peticion);

			File p = new File(ruta);

			if (ruta.equals("/")) {
				ruta = directorio + "/" + fichero;
			} else {
				ruta = directorio + ruta;
			}
			File p2 = new File(ruta);
			// Preparamos la escritura del fichero en el output
			try {
				archivo = new FileInputStream(ruta);
			} catch (Exception ex) {
				// Si el fichero no existe, enviamos un error 404
				System.err.println("Error: " + ex.getMessage());
				System.err.println("Se ha detectado un error 404");
				try {
					output.writeBytes(crearCabecera(404, -1));
				} catch (Exception ex2) {
					// QuizÃ¡s no ha sido posible enviar el error
					System.err.println("Error: " + ex2.getMessage());
					System.err.println("No se pudo enviar el mensaje de error 404");
				}
				return; // No se debe seguir adelante
			}

			ruta = ruta.toLowerCase();
			tipoArchivo = comprobarTipoArchivo(ruta);

			// Enviamos la cabecera
			try {
				output.writeBytes(crearCabecera(200, tipoArchivo));
			} catch (Exception ex) {
				System.err.println("Error: " + ex.getMessage());
				System.err.println("No se pudo enviar la cabecera de la respuesta correctamente");
				return;
			}

			if (tipo_peticion == 2) {

				// String respuestaHttp = "";
				//
				// BufferedReader bfdefich;
				// try {
				// bfdefich = new BufferedReader(new FileReader(ruta));
				// String linfich = bfdefich.readLine();
				// while (linfich != null) {
				// respuestaHttp += linfich;
				// linfich = bfdefich.readLine();
				// }
				// bfdefich.close();
				// output.write(respuestaHttp.getBytes("UTF-8"));
				// } catch (FileNotFoundException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// } catch (IOException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
				// }

				//
				// try {
				// while (true) {
				// int b = archivo.read();
				// // Si llegamos al final del fichero, paramos el bucle
				// if (b == -1) {
				// break;
				// }
				// output.write(b);
				// }
				// archivo.close();
				// } catch (Exception ex) {
				// // QuizÃ¡s no ha sido posible enviar el contenido
				// System.err.println("Error: " + ex.getMessage());
				// System.err.println("No se pudo enviar el contenido de la respuesta correctamente");
				// return;
				// }
				String respuestaHttp = "";

				File f = new File(ruta);
				BufferedImage originalImage;
				try {
					originalImage = ImageIO.read(f);
					byte[] imagenInByte;
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ImageIO.write(originalImage, "png", baos);
					baos.flush();
					imagenInByte = baos.toByteArray();
					baos.close();
					respuestaHttp = "HTTP/1.1 200 OK\r\nContent-type: image/png\r\n\r\n";
					output.write(respuestaHttp.getBytes("UTF-8"));
					output.write(imagenInByte);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private String crearCabecera(int codigoRepuesta, int tipoArchivo) {
		String s = "HTTP1.0 ";

		switch (codigoRepuesta) {
		case 200:
			s = s + "200 OK";
			break;
		case 404:
			s = s + "404 Not Found";
			break;
		case 501:
			s = s + "501 Not Implemented";
			break;
		}
		s = s + "\r\n";
		s = s + "Connection: close\r\n";
		s = s + "Server: DAVID GONZÃ�LEZ MORENO-SERVIDOR WEB\r\n";

		switch (tipoArchivo) {
		// El caso -1 no devuelve nada porque lo reservamos para errores
		case -1:
			break;
		// MIME conocidos
		case 1:
			s = s + "Content-Type: text/html\r\n";
			break;
		case 2:
			s = s + "Content-Type: text/plain\r\n";
			break;
		case 3:
			s = s + "Content-Type: image/gif\r\n";
			break;
		case 4:
			s = s + "Content-Type: text/jpeg\r\n";
			break;
		case 5:
			s = s + "Content-Type: image/png\r\n";
			break;
		case 6:
			s = s + "Content-Type: application/zip\r\n";
			break;
		case 7:
			s = s + "Content-Type: application/javascript\r\n";
			break;
		case 8:
			s = s + "Content-Type: video/x-msvideo\r\n";
			break;

		case 9:
			s = s + "Content-Type: video/quicktime\r\n";
			break;
		case 10:
			s = s + "Content-Type: video/mpeg\r\n";
			break;
		case 11:
			s = s + "Content-Type: video/mp4\r\n";
			break;
		// En casos de formatos desconocidos... (es decir, el caso 0)
		case 0:
		default:
			s = s + "Content-Type: application/octet-stream\r\n";
			break;
		}
		s = s + "\r\n";
		return s;
	}

	public String comprobarRuta(String peticion) {

		String ruta;

		int ini = 0, fin = 0;
		for (int pos = 0; pos < peticion.length(); pos++) {
			// Buscamos el ultimo espacio en blanco en la linea
			if (peticion.charAt(pos) == ' ' && ini != 0) {
				fin = pos;
				break;
			}
			// Buscamos el primer espacio en blanco en la linea
			if (peticion.charAt(pos) == ' ' && ini == 0) {
				ini = pos;
			}
		}
		ruta = peticion.substring(ini + 1, fin);

		return ruta;
	}

	public int comprobarTipoArchivo(String ruta) {

		int tipoArchivo = 0;

		if (ruta.endsWith(".htm") || ruta.endsWith(".html")) {
			tipoArchivo = 1;
		}
		if (ruta.endsWith(".txt")) {
			tipoArchivo = 2;
		}
		if (ruta.endsWith(".gif")) {
			tipoArchivo = 3;
		}
		if (ruta.endsWith(".jpg") || ruta.endsWith(".jpeg")) {
			tipoArchivo = 4;
		}
		if (ruta.endsWith(".png")) {
			tipoArchivo = 5;
		}
		if (ruta.endsWith(".zip")) {
			tipoArchivo = 6;
		}
		if (ruta.endsWith(".js")) {
			tipoArchivo = 7;
		}
		if (ruta.endsWith(".avi")) {
			tipoArchivo = 8;
		}
		if (ruta.endsWith(".mov")) {
			tipoArchivo = 9;
		}
		if (ruta.endsWith(".mpg") || ruta.endsWith(".mpeg")) {
			tipoArchivo = 10;
		}
		if (ruta.endsWith(".mp4")) {
			tipoArchivo = 11;
		}
		return tipoArchivo;
	}
}
