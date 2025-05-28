package chatV1.cliente;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		DataOutputStream salida = null;
		DataInputStream entrada = null;
		Socket socket = null;

		try
		{
			socket = new Socket("127.0.0.1", 5555);
			salida = new DataOutputStream(socket.getOutputStream());
			entrada = new DataInputStream(socket.getInputStream());

			// lanzo el hilo de escucha
			/* Thread escuchaServidor = new Thread(new
			 * RnEscuchaServidor(entrada)); escuchaServidor.start(); */
			// me pongo a escribir
			String parar = "";

			while (!parar.equalsIgnoreCase("parar"))
			{
				Scanner lectura = new Scanner(System.in);

				System.out.println("Introduzca su nick");
				String nick = lectura.nextLine();
				lectura.close();

				salida.writeUTF(nick);

				if (nick.equalsIgnoreCase("parar"))
					parar = "parar";

				String dato = entrada.readUTF();
				System.out.println("los clientes conectados son: " + dato);
			}

			entrada.close();
			salida.close();
			socket.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}