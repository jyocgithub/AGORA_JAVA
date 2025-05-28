package chat_diego.servidorchat;

public class Main {

	public static void main(String[] args) {
		Servidor servidor = new Servidor(1234);
		System.out.println("Escuchando en el puerto 1234...");
		servidor.arrancar();
	}

}
