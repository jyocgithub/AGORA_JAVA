package GUT_Sockets_TCP_ABSTRACTA;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public abstract class TCPClienteAbstract {
	
	private String ip;
	private int puerto;
	private Socket manguera;
	protected DataOutputStream escritor;
	protected DataInputStream lector;

	public TCPClienteAbstract(String ip, int puerto) {
		this.ip = ip;
		this.puerto = puerto;
		this.manguera = null;
		crearSocket();
	}
	
	
	public void crearSocket() {
		
		try {
			manguera = new Socket(ip, puerto);
			lector = new DataInputStream( manguera.getInputStream());
			escritor = new DataOutputStream( manguera.getOutputStream());
			System.out.println("Conectado con servidor, comienza comunicación:");
	
			comunicacion();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(manguera != null) {
					manguera.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void comunicacion();

}
