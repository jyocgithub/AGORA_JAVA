package solucion.ejercicio_2;

public class Main
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Coches coche;
		Fabricante f;
		Comprador[] compradores;
		final int CANTIDADCOMPRADORES = 5;
		coche = new Coches();
		f = new Fabricante(coche);
		compradores = new Comprador[CANTIDADCOMPRADORES];

		for (int i = 0; i < CANTIDADCOMPRADORES; i++)
		{
			compradores[i] = new Comprador(coche, i + 1);
			compradores[i].start();
		}

		f.start();
	}
}
