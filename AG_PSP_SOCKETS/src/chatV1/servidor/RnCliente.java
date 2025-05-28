package chatV1.servidor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RnCliente implements Runnable
{
	Socket socket = null;

	private DataOutputStream salida;
	private DataInputStream entrada;

	public RnCliente(Socket socket)
	{
		this.socket = socket;
	}

	@Override
	public void run()
	{
		String nickCliente = null;
		String mensaje = null;

		try
		{
			entrada = new DataInputStream(this.socket.getInputStream());
			salida = new DataOutputStream(this.socket.getOutputStream());

			nickCliente = entrada.readUTF();
			System.out.println("El nick del cliente es " + nickCliente);
			Servidor.setHmUsuarios(nickCliente, salida);
			// ahora enviamos a todos los clientes la lista de nicks del chat

			while (true)
			{
				Servidor.mensajeatodos(nickCliente);
				mensaje = entrada.readUTF();
				System.out.println("El cliente " + nickCliente + " dice " + mensaje);
				// tiene que llegar a todos
			}

			// salida.writeUTF("Hola cliente soy el servidor y estos son los
			// nick que hay conectados");

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (entrada != null)
					entrada.close();
				if (salida != null)
					entrada.close();
				if (socket != null)
					entrada.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}