package ej_psp_3_a_5_sincronyzed_lingotes;

import java.util.Random;
import java.util.Scanner;

public class Main {
	private static CajaFuerte _cajaFuerte;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Número de lingotes: ");
		int numLingotes = sc.nextInt();
		sc.close();

		_cajaFuerte = new CajaFuerte(numLingotes);
		Thread th1 = new Thread(new Ladron("1"));
		Thread th2 = new Thread(new Ladron("2"));
		Thread th3 = new Thread(new Ladron("3"));
		th1.start();
		th2.start();
		th3.start();

	}

	// En este caso, la clase que crea los hilos es una clase interna a la clase principal
	// con lo que el monitor no se recibe en el hilo como parámetro, sino que el hilo puede
	// acceder al monitor directamente al ser objeto de la clase "envolvente"
	public static class Ladron implements Runnable {

		private String _nombreLadron;
		private Random _random;

		public Ladron(String nombreLadron) {
			_nombreLadron = nombreLadron;
			_random = new Random();
		}

		@Override
		public void run() {
			while (_cajaFuerte.sacarLingotes(_nombreLadron, _random.nextInt(6) + 1))
				;

		}

	}
}
