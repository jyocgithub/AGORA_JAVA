package juliaMensajeria;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Cliente
 * 
 * Permite crear tantos clientes como conexiones tenga el servidor
 * Tiene un arrayList donde guarda los mensjes del cliente
 * Y unos objetos de stream para leer del cliente y escribir desde el cliente
 * Asi como un referencia al propio socket por donde se comunica con el servidor
 */

public class Cliente {
	String				nombre;
	ArrayList<String>	mensajes;
	PrintWriter			escritor;
	BufferedReader		lector;
	Socket				miSocket;

	public Cliente (String nombre, PrintWriter escritor, BufferedReader lector, Socket s) {
		super ();
		this.nombre = nombre;
		this.mensajes = new ArrayList<String> ();
		this.escritor = escritor;
		this.lector = lector;
		this.miSocket = s;
	}

	public String getNombre () {
		return nombre;
	}

	public void setNombre (String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getMensajes () {
		return mensajes;
	}

	public void setMensajes (ArrayList<String> mensajes) {
		this.mensajes = mensajes;
	}

	public PrintWriter getEscritor () {
		return escritor;
	}

	public void setEscritor (PrintWriter escritor) {
		this.escritor = escritor;
	}

	public BufferedReader getLector () {
		return lector;
	}

	public void setLector (BufferedReader lector) {
		this.lector = lector;
	}

}
