package hacerZipRecursivamente;

public class Principal {

	public static void main(String[] args) {

		Hilo1 primero = new Hilo1();
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
