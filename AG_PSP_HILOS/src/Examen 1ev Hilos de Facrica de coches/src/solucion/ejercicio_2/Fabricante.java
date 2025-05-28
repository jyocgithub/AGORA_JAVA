package solucion.ejercicio_2;

import java.util.Random;

public class Fabricante extends Thread {
	String[] marcas = { "Mercedes", "BMW", "Renault", "Seat", "Audi" };
	Random r = new Random();
	Coches coche;
	boolean tresMercedes;
	int cont = 0;

	public Fabricante(Coches c) {
		this.coche = c;
		tresMercedes = false;
	}

	@Override
	public void run() {
		while (true) {
			int aleatorio = r.nextInt(5);
			if (aleatorio == 1) {
				cont++;
				if (cont == 3) {
					tresMercedes = true;
				}
			}
			if (!(tresMercedes && aleatorio == 1)) {
				this.coche.fabrico(marcas[aleatorio]);
			}
		}
	}
}
