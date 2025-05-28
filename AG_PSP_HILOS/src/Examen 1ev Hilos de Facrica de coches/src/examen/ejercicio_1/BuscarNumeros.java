package examen.ejercicio_1;

public class BuscarNumeros extends Thread
{
	private int inicioRango, finRango;

	public BuscarNumeros(int inicioRango, int finRango)
	{
		this.inicioRango = inicioRango;
		this.finRango = finRango;
	}

	@Override
	public void run()
	{
		buscaNumeros();
	}

	public void buscaNumeros()
	{
		for (int i = inicioRango; i < finRango; i++)
		{
			for (int j = 0; j < Main.matriz[0].length; j++)
			{
				if (Main.matriz[i][j] == 1)
					Main.numUnos++;
				else if (Main.matriz[i][j] == 2)
					Main.numDos++;
				else Main.numTres++;
			}
		}
	}
}
