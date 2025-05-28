package ejercicio1;

public class Corredor extends Thread {

	private String nombre;
	private boolean esperando = true;

	public Corredor(String nombre) {
		this.nombre = nombre;
	}

	public void run() {

		try {
			while (!isInterrupted()) {
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			System.out.println("Soy " + nombre + " y comienzo a correr !!");
		}


		for (int i = 1; i < 11; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Soy " + nombre + " y voy por el paso " + i);
		}

		System.out.println("Soy " + nombre + " y entrego el relevo  ");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void arrancar() {
		interrupt();
	}

}
