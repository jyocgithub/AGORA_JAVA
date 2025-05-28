package examen.ejercicio_1;

import java.util.Random;
import java.util.Scanner;

public class Main
{
	static int[][] matriz;
	static Random r = new Random();
	static int numUnos = 0, numDos = 0, numTres = 0;
	static int filas, columnas;

	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);

		System.out.print("Introduzca el numero de filas de la matriz: ");
		filas = sc.nextInt();
		System.out.print("Introduzca el numero de columnas de la matriz: ");
		columnas = sc.nextInt();

		sc.close();

		matriz = generarMatrizAleatoria(filas, columnas);

		Runtime rt = Runtime.getRuntime();

		int cores = rt.availableProcessors();
		int rangoFilas = Math.round(filas / (float) cores);

		System.out.println("Numero de cores: " + cores);

		int inicioRango = 1;
		int finRango = rangoFilas;

		BuscarNumeros[] bn = new BuscarNumeros[cores];

		for (int i = 0; i < cores; i++)
		{
			System.out.println(
					"Estamos en el hilo " + i + " inicio de rango " + inicioRango + " fin de rango " + finRango);
			bn[i] = new BuscarNumeros(inicioRango, finRango);

			inicioRango += rangoFilas;
			finRango += rangoFilas;

			bn[i].start();
		}

		System.out.println("El numero de valores es " + (filas * columnas));
		System.out.println("El numero de unos es " + numUnos + " El % de unos es " + calcularPorcentaje(numUnos) + "%");
		System.out.println("El numero de dos es " + numDos + " El % de dos es " + calcularPorcentaje(numDos) + "%");
		System.out.println("El numero de tres es " + numTres + " El % de tres es " + calcularPorcentaje(numTres) + "%");

		mostrarMatriz(matriz);
	}

	public static int[][] generarMatrizAleatoria(int filas, int columnas)
	{
		int[][] array = new int[filas][columnas];

		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[0].length; j++)
			{
				array[i][j] = r.nextInt(3) + 1;
			}
		}

		return array;
	}

	public static void mostrarMatriz(int[][] array)
	{
		for (int i = 0; i < matriz.length; i++)
		{
			for (int j = 0; j < matriz[0].length; j++)
			{
				System.out.print(matriz[i][j]);
				System.out.print("\t");
			}

			System.out.println("\n");
		}
	}

	public static double calcularPorcentaje(int num)
	{
		return (num / (filas * columnas)) * 100;
	}
}
