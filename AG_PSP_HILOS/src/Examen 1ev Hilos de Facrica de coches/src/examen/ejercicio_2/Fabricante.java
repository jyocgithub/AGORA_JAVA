package examen.ejercicio_2;

public class Fabricante implements Runnable
{
	private Coches coche;

	public Fabricante(Coches coche)
	{
		this.coche = coche;
	}

	@Override
	public void run()
	{
		while (true) // Fabrica continuamente
		{
			try
			{
				Thread.sleep(1000); // Para que la ejecucion pueda verse mejor
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			coche.FabricarCoche();
		}
	}
}