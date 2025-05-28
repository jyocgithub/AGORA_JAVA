package servido_web_completoAmadeo;

import java.net.ServerSocket;

/*
 * Informacion sobre MIME: 
 * 		https://es.wikipedia.org/wiki/Anexo:Cabeceras_HTTP
 */
enum TipoMIME {
	ERR, UNK, HTM, CSS, TXT, GIF, JPG, PNG,ICO, ZIP, JS,AVI,MOV,MPEG,MP4
}

/*
 * Informacion sobre REQUEST
 * 		https://es.wikipedia.org/wiki/Protocolo_de_transferencia_de_hipertexto
 * 		https://es.wikipedia.org/wiki/Anexo:C%C3%B3digos_de_estado_HTTP
 * 		
 */
enum TipoPeticion {
	UNK, GET
}

/**
 * Servidor web
 * 
 * @author amadeo
 */
public class WebServer {

	static final private int PORT = 8080;
	static final String PATH = "C:\\Users\\carlos\\eclipse-workspace\\Programacion_ProcesosRed\\diney pixar\\raiz";
	static final String INDEX = "index.html";
	
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		try {
			serverSocket = new ServerSocket(PORT);
			System.err.printf("WebServer port=%d path=%s index=%s running...%n%n", PORT, PATH, INDEX);
			while (true) {
				new WebRequest(serverSocket.accept()).start();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

}

