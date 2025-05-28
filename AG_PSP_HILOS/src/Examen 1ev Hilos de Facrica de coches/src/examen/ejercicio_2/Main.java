package examen.ejercicio_2;

public class Main {
	public static void main(String[] args) {
		final int CANTIDAD_COMPRADORES = 5;
		Coches coche = new Coches();

		// CREACION DE HILOS
		Thread hiloFabricante = new Thread(new Fabricante(coche)); // Hilo del fabricante

		Thread[] compradores = new Thread[CANTIDAD_COMPRADORES]; // Array de hilos de los 5 compradores

		for (int i = 0; i < compradores.length; i++) {
			compradores[i] = new Thread(new Comprador(coche, i + 1));
		}

		// INICIO DE HILOS
		hiloFabricante.start();

		for (int i = 0; i < compradores.length; i++) {
			compradores[i].start();
		}
		for (int i = 0; i < compradores.length; i++) {
			compradores[i].start();
		}
	}
}