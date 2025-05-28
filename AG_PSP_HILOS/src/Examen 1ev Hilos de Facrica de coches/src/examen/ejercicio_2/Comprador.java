package examen.ejercicio_2;

public class Comprador implements Runnable
{
	private Coches coche;
	private int idComprador;

	public Comprador(Coches coche, int idComprador)
	{
		this.coche = coche;
		this.idComprador = idComprador;
	}

	@Override
	public void run()
	{
		while (true) // Intenta comprar continuamente
		{
			try
			{
				Thread.sleep(1000); // Para que la ejecucion pueda verse mejor
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			coche.ComprarCoche(idComprador);
		}
	}
}
