package Chat_con_UDP_marta;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class HiloRecibir extends Thread {

	DatagramSocket socket;
	DatagramPacket datagramRecibido;
	Vista vista;
	byte[] arrayBytes;
	
	public HiloRecibir(Vista vista) {
		this.vista = vista;
		this.arrayBytes = new byte[512];
		this.socket = null;
		this.datagramRecibido = null;
	}

	public void run() {
		
		try {
			socket = new DatagramSocket(vista.puertoOrigen);
			datagramRecibido= new DatagramPacket(new byte[512], 512);
			
			while(true){
				socket.receive(datagramRecibido);
				String mensaje = new String(datagramRecibido.getData(), 0 ,datagramRecibido.getLength());
				arrayBytes = mensaje.getBytes();
				vista.textAreaRecibir.setText(mensaje);			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
