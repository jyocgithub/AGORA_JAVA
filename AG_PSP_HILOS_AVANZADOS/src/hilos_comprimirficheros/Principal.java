package hilos_comprimirficheros;

public class Principal {

	public static void main(String[] args) {

		Hilo11 primero = new Hilo11();
		Hilo2 segundo = new Hilo2();
		Hilo3 tercero = new Hilo3();
		primero.start();
		try {
			primero.join();

			segundo.start();
			segundo.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		tercero.start();
	}
}
