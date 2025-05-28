package GUT_Sockets_TCP_ABSTRACTA;

public class Main {

	public static void main(String[] args) {
		TCPTeletipoServidor tcpServidor = new TCPTeletipoServidor(8000);
		TCPTeletipoCliente tcpCliente = new TCPTeletipoCliente("localhost",8000);
	
		
		

	}

}
