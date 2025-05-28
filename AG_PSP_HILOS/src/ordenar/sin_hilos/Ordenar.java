package ordenar.sin_hilos;
public class Ordenar
{
	public static void ordenar(int[] n)
	{
		int aux;
		boolean ordenado = false;

		for (int i = 0; i < n.length - 1 && !ordenado; i++)
		{
			ordenado = true;

			for (int j = 0; j < n.length - 1 - i; j++)
			{
				if (n[j] > n[j + 1])
				{
					ordenado = false;

					aux = n[j];
					n[j] = n[j + 1];
					n[j + 1] = aux;
				}
			}
		}
	}
}
