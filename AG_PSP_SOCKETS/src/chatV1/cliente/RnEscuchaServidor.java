package chatV1.cliente;
import java.io.DataInputStream;
import java.io.IOException;

public class RnEscuchaServidor implements Runnable
{
	DataInputStream entrada = null;

	public RnEscuchaServidor(DataInputStream entrada)
	{
		this.entrada = entrada;
		System.out.println("estamos en el constructor");
	}

	@Override
	public void run()
	{
		System.out.println("estamos en el run");
		while (true)
		{
			String servidorDice = "";
			try
			{
				servidorDice = entrada.readUTF();
				System.out.println("El servidor dice " + servidorDice);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}