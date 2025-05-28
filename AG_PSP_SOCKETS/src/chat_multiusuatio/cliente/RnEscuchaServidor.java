package chat_multiusuatio.cliente;

import java.io.*;
import java.net.Socket;

public class RnEscuchaServidor implements Runnable
{
	private DataInputStream entrada;
	private DataOutputStream salida;
	private Socket socket;
	private boolean parar = false;

	/*Pasamos el socket y la salida al constructor para evitar el error de salida del chat y poder cerrar
	en condiciones sin que haya error*/
	public RnEscuchaServidor(Socket socket, DataInputStream entrada, DataOutputStream salida)
	{
		this.socket = socket;
		this.entrada = entrada;
		this.salida = salida;
	}

	@Override
	public void run()
	{
		try
		{
			String mensajeServidor;

			while (!parar)
			{
				mensajeServidor = entrada.readUTF();
				System.out.println(mensajeServidor);
			}

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
					salida.close();

				if (socket != null)
					socket.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void pararEscucha()
	{
		parar = true;
	}
}
