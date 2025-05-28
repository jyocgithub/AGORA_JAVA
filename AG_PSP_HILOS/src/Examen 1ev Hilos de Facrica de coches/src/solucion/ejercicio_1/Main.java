package solucion.ejercicio_1;

import java.io.*;
import java.util.*;

public class Main
{

	static File fichero = new File("matriz1.txt");
	static int[][] matriz;
	static Random r = new Random();

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int filas;
		int columnas;
		System.out.print("Introduzca el número de filas de la matriz: ");
		filas = sc.nextInt();
		System.out.print("Introduzca el número de columnas de la matriz: ");
		columnas = sc.nextInt();
		matriz = generarMatrizAleatoria(filas, columnas);

		Runtime runtime = Runtime.getRuntime();
		System.out.println("Numero de cores: " + runtime.availableProcessors());

		int numCores = runtime.availableProcessors();

		// -----------------------------------------------------parte para generar los
		// hilos-------------------------------------------

		int rango = Math.round(filas / (float) numCores);
		// NUM ES UN MILLÓN
		// System.out.println(" El rango es " + rango); //en mi caso son 250000, porque
		// tengo 4 cores
		int inicioRango = 0;
		int finRango = rango;

		Hilo[] hilos = new Hilo[numCores];

		// Lanzamos tantos hilos como cores tenga el sistema 999983
		for (int i = 0; i < numCores; i++)
		{
			// new Thread(new Hilo(matriz, inicioRango, finRango)).start();
			System.out.println(
					"Estamos en el hilo " + i + " inicio de rango " + inicioRango + " fin de rango " + finRango);
			hilos[i] = new Hilo(matriz, inicioRango, finRango);
			hilos[i].start();
			inicioRango += rango;
			finRango += rango;
			if (i == numCores - 2)// para asegurarnos que el hilo ultimo termina
			{
				finRango = filas;
			}
		}

		for (int j = 0; j < numCores; j++)
		{
			try
			{
				hilos[j].join();
			}
			catch (InterruptedException e)
			{
			}
		}

		int[] valores = new int[3];

		for (int k = 0; k < hilos.length; k++)
		{
			valores[0] += hilos[k].getNumUnos();
			valores[1] += hilos[k].getNumDos();
			valores[2] += hilos[k].getNumTres();
		}

		double porciento1, porciento2, porciento3;
		double suma = valores[0] + valores[1] + valores[2];
		porciento1 = (valores[0] / suma) * 100;
		porciento2 = (valores[1] / suma) * 100;
		porciento3 = (valores[2] / suma) * 100;
		System.out.println(" El numero de valores es " + suma);
		System.out.println(" El numero de unos es " + valores[0] + " El % de unos es " + porciento1 + "%");
		System.out.println(" El número de dos es " + valores[1] + " El % de dos es " + porciento2 + "%");
		System.out.println(" El numero de tres es " + valores[2] + " El % de tres es " + porciento3 + "%");
		// ----------------------------------------------------------------------------------------------------------------------------

		mostrarMatriz();
	}

	private static int[][] generarMatrizAleatoria(int filas, int columnas)
	{
		// TODO Auto-generated method stub
		BufferedWriter bw = null;
		FileWriter fw = null;
		matriz = new int[filas][columnas];

		try
		{
			if (!fichero.exists())
			{
				fichero.createNewFile();
			}

			fw = new FileWriter(fichero.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			// creo la matríz con números aleatorios del 0 al 2
			for (int i = 0; i < filas; i++)
			{
				for (int j = 0; j < columnas; j++)
				{
					Integer valor = r.nextInt(3) + 1;
					matriz[i][j] = valor;
					bw.write(valor.toString());
					bw.write(" ");
				}
				bw.write("\n");
			}
			if (bw != null)
				bw.close();
			if (fw != null)
				fw.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}

		return matriz;
	}

	private static void mostrarMatriz()
	{
		for (int i = 0; i < matriz.length; i++)
		{
			for (int j = 0; j < matriz[i].length; j++)
			{
				System.out.print(" " + matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

}
