package examen.ejercicio_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Coches
{
	private ArrayList<Integer> arrayCoches; // Donde se añaden y compran los coches fabricados

	public Coches()
	{
		arrayCoches = new ArrayList<>();
	}

	public synchronized void FabricarCoche()
	{
		int numCoche = (new Random().nextInt(5)) + 1; // Numeros del 1 al 5

		arrayCoches.add(numCoche);

		System.out.println("Coche recien fabricado " + elegirCoche(numCoche));

		notify();

		try
		{
			wait();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public synchronized void ComprarCoche(Integer idComprador)
	{
		boolean comprado = false;

		Iterator<Integer> it = arrayCoches.iterator();

		while (it.hasNext() && !comprado) // Busca entre todos los coches disponibles
		{
			if (it.next() == idComprador) // Si el coche que quiere comprar esta disponible
			{
				System.out.println("El comprador " + idComprador + " ha comprado un " + elegirCoche(idComprador));
				it.remove(); // Compra el coche (Se elimina del ArrayList)

				comprado = true;
			}
		}

		notify();

		try
		{
			wait();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public String elegirCoche(int id) // Metodo para elegir una marca de coche a traves del id del comprador
	{
		String marca = "";

		switch (id)
		{
			case 1:
				marca = "Audi";
				break;
			case 2:
				marca = "Seat";
				break;
			case 3:
				marca = "BMW";
				break;
			case 4:
				marca = "Renault";
				break;
			case 5:
				marca = "Mercedes";
				break;
		}

		return marca;
	}
}
