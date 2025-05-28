package ej_psp_3_b_3_ExamenProcesosLaPaloma11_2018;

import java.util.Random;

public class Ejercicio1 {
	static int[][] matriz;
	static Random ran = new Random();
	static GuardaNumeros guardaNumeros = new GuardaNumeros();

	public static void main(String[] args) {

		int filas = 20;
		int columnas = 100;
		int numeroHilos = 20;
		int arrayFila[] = new int[columnas];

		matriz = generarMatrizAleatoria(filas, columnas);

		Runtime runtime = Runtime.getRuntime();
//		System.out.println("numero cores: " + runtime.availableProcessors());
//		int numeroHilos = runtime.availableProcessors();

		Thread[] thHilos = new Thread[numeroHilos];
		generarMatrizAleatoria(filas, columnas);


		for (int i = 0; i < thHilos.length; i++) {
			thHilos[i] = new Thread(new RnHilo(i, matriz[i], guardaNumeros));
			thHilos[i].start();
		}
		for (int i = 0; i < thHilos.length; i++) {
			try {
				thHilos[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Hay " + guardaNumeros.getUno() + " unos. El porcentaje es: " + calcPorcentaje(1));
		System.out.println("Hay " + guardaNumeros.getDos() + " doses. El porcentaje es: " + calcPorcentaje(2));
		System.out.println("Hay " + guardaNumeros.getTres() + " treses. El porcentaje es: " + calcPorcentaje(3));

		mostrarMatriz();
	}

	public static int[][] generarMatrizAleatoria(int fila, int columna) {
		int[][] mat = new int[fila][columna];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = ran.nextInt(3) + 1;
			}
		}
		return mat;
	}

	public static void mostrarMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
			}
			System.out.println("");
		}
	}

	public static float calcPorcentaje(int numero) {
		float porcentaje = 0f;
		float suma = guardaNumeros.getUno() + guardaNumeros.getDos() + guardaNumeros.getTres();
		if (numero == 1) {
			porcentaje = (guardaNumeros.getUno() / suma) * 100;

		} else if (numero == 2) {
			porcentaje = (guardaNumeros.getDos() / suma) * 100;

		} else
			porcentaje = (guardaNumeros.getTres() / suma) * 100;

		return porcentaje;
	}

}

class RnHilo implements Runnable {
	private int[] arrayN;
	GuardaNumeros guardaNumeros;
	int soy;

	public RnHilo(int soy, int[] arrayN, GuardaNumeros guardaNumeros) {
		this.arrayN = arrayN;
		this.guardaNumeros = guardaNumeros;
		this.soy = soy;
	}

	@Override
	public void run() {

		for (int i = 0; i < arrayN.length; i++) {

			System.out.println("soy hilo " + soy + " y tengo que sumar un " + arrayN[i]);
			if (arrayN[i] == 1) {
				guardaNumeros.creceUno();
			}
			if (arrayN[i] == 2) {
				guardaNumeros.creceDos();
			}
			if (arrayN[i] == 3) {
				guardaNumeros.creceTres();
			}
		}

	}
}

class GuardaNumeros {
	private int uno = 0;
	private int dos = 0;
	private int tres = 0;

	public synchronized void creceUno() {
		uno++;
	}

	public synchronized void creceDos() {
		dos++;
	}

	public synchronized void creceTres() {
		tres++;
	}

	public synchronized int getUno() {
		return uno;
	}

	public synchronized int getDos() {
		return dos;
	}

	public synchronized int getTres() {
		return tres;
	}
}