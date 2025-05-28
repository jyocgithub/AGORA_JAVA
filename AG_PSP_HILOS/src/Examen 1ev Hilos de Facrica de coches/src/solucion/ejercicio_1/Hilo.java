package solucion.ejercicio_1;

public class Hilo extends Thread
{

	private static int[][] matriz;
	private int filasiniciorango, filasfinalrango, num1, num2, num3;

	public Hilo(int[][] m, int filasinicio, int filasfinal)
	{
		matriz = m;
		this.filasiniciorango = filasinicio;
		this.filasfinalrango = filasfinal;
		num1 = 0;
		num2 = 0;
		num3 = 0;
	}

	public int getNumUnos()
	{
		return num1;
	}

	public int getNumDos()
	{
		return num2;
	}

	public int getNumTres()
	{
		return num3;
	}

	@Override
	public void run()
	{

		for (int i = this.filasiniciorango; i < this.filasfinalrango; i++)
		{
			for (int j = 0; j < matriz[i].length; j++)
			{
				if (matriz[i][j] == 1)
				{
					num1++;
				}
				if (matriz[i][j] == 2)
				{
					num2++;
				}
				if (matriz[i][j] == 3)
				{
					num3++;
				}
			}
		}

	}
}
