package chatV1.servidor;
import java.io.*;
import java.net.*;
import java.util.*;

public class Servidor
{
	private static HashMap<String, DataOutputStream> hmUsuarios;

	public Servidor()
	{
		hmUsuarios = new HashMap<>();
	}

	public void arrancar()
	{
		ServerSocket serverSocket = null;
		Socket socket = null;
		try
		{
			serverSocket = new ServerSocket(5555);

			while (true)
			{
				socket = serverSocket.accept();
				Thread cliente = new Thread(new RnCliente(socket));
				cliente.start();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static HashMap<String, DataOutputStream> getHmUsuarios()
	{
		return hmUsuarios;
	}

	public static synchronized void setHmUsuarios(String nick, DataOutputStream conexionSalida)
	{

		Servidor.hmUsuarios.put(nick, conexionSalida);
	}

	public static synchronized void mensajeatodos(String nick)
	{
		Iterator<String> iterator = hmUsuarios.keySet().iterator();
		String nombre;
		while (iterator.hasNext())
		{
			// Obtenemos la clave del índice del hash y la guardamos en nombre
			nombre = iterator.next();
			try
			{
				// vamos al hash donde esté ese nombre y escribimos en su cadena
				// de conexión
				hmUsuarios.get(nombre).writeUTF(nick);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}