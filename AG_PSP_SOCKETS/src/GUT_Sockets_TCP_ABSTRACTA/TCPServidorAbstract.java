package GUT_Sockets_TCP_ABSTRACTA;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class TCPServidorAbstract {
	
	private int puerto;
	private ServerSocket serversocket;
	protected DataInputStream lector;
	protected DataOutputStream escritor;
	
	public TCPServidorAbstract(int puerto) {
		this.puerto = puerto;
		this.serversocket = null;
		crearServerSocket();
	}


	public void crearServerSocket() {
		
		try {
			serversocket = new ServerSocket(puerto);
			System.out.println("Servidor preparado, esperando algún cliente...");

			Socket manguera = serversocket.accept();
			escritor = new DataOutputStream( manguera.getOutputStream());
			lector = new DataInputStream( manguera.getInputStream());
			System.out.println("Cliente conectado, comienza comunicación:");
			
			comunicacion();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serversocket != null) {
							serversocket.close();
				}
		
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void comunicacion();
	
}
