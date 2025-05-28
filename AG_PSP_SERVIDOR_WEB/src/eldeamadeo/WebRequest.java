package servido_web_completoAmadeo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Responder a cada petición
 * 
 * @author amadeo
 */
class WebRequest extends Thread {

	private Socket socket;

	private BufferedReader in;
	private DataOutputStream out;

	/**
	 * Constructor
	 * 
	 * @param socket
	 */
	public WebRequest(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			out = new DataOutputStream(socket.getOutputStream());
			request();
			in.close();
			out.close();
			socket.close();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	/**
	 * Respuesta a cada petición
	 */
	private void request() {

		FileInputStream fis;
		String get;
		TipoPeticion peticion;
		
		// Leo línea de GET/HEAD
		try {
			get = in.readLine(); // GET /index.html HTTP/1.1
			System.err.println(get);
			while (!in.readLine().isEmpty());
		} catch (Exception e) {
			return; //
		}

		// Analizo tipo de petición
		StringTokenizer st = new StringTokenizer(get);
		switch (st.nextToken().toUpperCase()) {
		case "GET":
			peticion = TipoPeticion.GET;
			break;
		default: // UNKNOWN
			try {
				out.writeBytes(getHead(501, TipoMIME.ERR));
			} catch (Exception e) {
				System.err.println(e);
			}
			return; //
		}

		// Obtengo la ruta del fichero
		String fileName = getFileName(st.nextToken());
		
		// Abrimos el fichero solicitado
		try {
			fis = new FileInputStream(fileName);
		} catch (Exception ex) {
			try {
				// Not found
				out.writeBytes(getHead(404, TipoMIME.ERR));
			} catch (Exception e) {
				System.err.println(e);
			}
			return; //
		}

		// OK
		try {
			out.writeBytes(getHead(200, getMIME(fileName)));
		} catch (Exception ex) {
			try {
				fis.close();
			} catch (IOException e) {
				System.err.println(e);
			}
			return; //
		}

		// Si GET, envío el contenido
		if (peticion == TipoPeticion.GET) {
			try {
				int b;
				while ((b = fis.read()) != -1) {
					out.write(b);
				}
				fis.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	/**
	 * Devuelve la cabecera del envío
	 * 
	 * @param status
	 * @param mime
	 * @return 
	 */
	private String getHead(int status, TipoMIME mime) {
		String sStatus = getStatus(status);
		String sContentType = getContentType(mime);
		System.err.printf("[%s] %s (%s)%n", new Date(), sStatus, sContentType);
		return String.format("%s\r\n%s\r\n\r\n", sStatus, sContentType);
	}
	
	/**
	 * Devuelve el status de una petición
	 * 
	 * @param status
	 * @return
	 */
	private String getStatus(int status) {
		if (status == 200)	return "HTTP1.0 200 OK";
		if (status == 404)	return "HTTP1.0 404 Not Found";
		if (status == 501)	return "HTTP1.0 501 Not Implemented";
		return "HTTP1.0 " + status + " Unknown";
	}
	
	/**
	 * Devuelve el ContentType de un fichero
	 * 
	 * @param mime
	 * @return
	 */
	private String getContentType(TipoMIME mime) {
		if (mime == TipoMIME.HTM)	return "Content-Type: text/html";
		if (mime == TipoMIME.CSS)	return "Content-Type: text/css";
		if (mime == TipoMIME.TXT)	return "Content-Type: text/plain";
		if (mime == TipoMIME.GIF)	return "Content-Type: image/gif";
		if (mime == TipoMIME.JPG)	return "Content-Type: image/jpeg";
		if (mime == TipoMIME.PNG)	return "Content-Type: image/png";
		if (mime == TipoMIME.ICO)	return "Content-Type: image/x-icon";
		if (mime == TipoMIME.ZIP)	return "Content-Type: application/zip";
		if (mime == TipoMIME.JS)	return "Content-Type: application/javascript";
		if (mime == TipoMIME.AVI)	return "Content-Type: video/x-msvideo";
		if (mime == TipoMIME.MOV)	return "Content-Type: video/quicktime";
		if (mime == TipoMIME.MPEG)	return "Content-Type: video/mpeg";
		if (mime == TipoMIME.MP4)	return "Content-Type: video/mp4";
		return "Content-Type: application/octect-stream";
	}

	/**
	 * Devuelve la ruta real del fichero solicitado
	 * 
	 * @param fileName
	 * @return
	 */
	private String getFileName(String fileName) {
		if (fileName.startsWith("/")) {
			fileName = fileName.substring(1);
		}

		if (fileName.endsWith("/") || fileName.equals("")) {
			fileName += WebServer.INDEX;
		}
		
		return WebServer.PATH + "/" + fileName;
	}

	/**
	 * Devuelve la extensión de un fichero
	 * 
	 * @param fileName
	 * @return
	 */
	private String getExtension(String fileName) {
		String extension = "";
		StringTokenizer stExtension = new StringTokenizer(fileName, ".");
		while (stExtension.hasMoreTokens()) {
			extension = stExtension.nextToken();
		}
		return extension.toLowerCase();
	}

	/**
	 * Devuelve el mime correspondiente a un fichero
	 * 
	 * @param fileName
	 * @return
	 */
	private TipoMIME getMIME(String fileName) {
		TipoMIME mime;
		
		switch (getExtension(fileName)) {
		case "htm":
		case "html":
			mime = TipoMIME.HTM;
			break;
		case "css":
			mime = TipoMIME.CSS;
			break;
		case "txt":
			mime = TipoMIME.TXT;
			break;
		case "gif":
			mime = TipoMIME.GIF;
			break;
		case "jpg":
		case "jpeg":
			mime = TipoMIME.JPG;
			break;
		case "png":
			mime = TipoMIME.PNG;
			break;
		case "ico":
			mime = TipoMIME.ICO;
			break;
		case "zip":
			mime = TipoMIME.ZIP;
			break;
		case "js":
			mime = TipoMIME.JS;
			break;
		case "avi":
			mime = TipoMIME.AVI;
			break;
		case "mov":
			mime = TipoMIME.MOV;
			break;
		
		case "mpg":	
		case "mpe":		
		case "MPEG":
			mime = TipoMIME.MPEG;
			break;
		case "MP4":
			mime = TipoMIME.MP4;
			break;
		default:
			mime = TipoMIME.UNK;
			break;
		}
		
		return mime;
	}
}
