package ordenar.con_hilos;
import java.util.Random;

public class Main
{
	public static void main(String[] args)
	{
		final int NUM = 100000;
		int[] numeros1 = new int[NUM];
		int[] numeros2 = new int[NUM];
		long tiempoComienzo, tiempoFinal;

		Random r = new Random();
		System.out.println("Rellenando arrays con aleatorios...");

		for (int i = 0; i < numeros1.length; i++)
		{
			numeros1[i] = r.nextInt(1000) + 1;
			numeros2[i] = r.nextInt(1000) + 1;
		}

		System.out.println("Arrays rellenos");
		System.out.println("Ordenando arrays...");

		tiempoComienzo = System.currentTimeMillis();
		// ----Aqui creamos y lanzamos los hilos-----

		ThOrdenar ord1 = new ThOrdenar(numeros1);
		ThOrdenar ord2 = new ThOrdenar(numeros2);

		ord1.start();
		ord2.start();
		
		try
		{
			ord1.join();
			ord2.join();
		} 
		catch (Exception e)
		{
			// TODO: handle exception
		}

		// ------------------------------------------
		tiempoFinal = System.currentTimeMillis();

		System.out.println("Ha tardado en ordenar " + (tiempoFinal - tiempoComienzo) + " milisegundos");
	}
}