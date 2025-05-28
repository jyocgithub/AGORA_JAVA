package Semaforos;

import java.util.concurrent.Semaphore;

public class HiloQueResta extends Thread {
	private Contador	cont;
	private Semaphore	miSemaforo;

	@Override
	public void run () {

		for (int i = 0; i < 4; i++) {
			try {
				// CAPTURA. Intentamos coger un semaforo. 
				// si el objeto miSemaforo no tiene ninguno, 
				// se queda aqui esperando que alguien libere (con release) alguno
				miSemaforo.acquire ();

				// - ZONA BLOQUEADA
				// Aqui se hace lo que se desee que solo se ejecute por quien 
				// tenga un semaforo disponible
				sleep (500);
				cont.decrementa ();
				System.out.println ("-- " + this.getName () + " : " + cont.getValue ());
				// - FIN ZONA BLOQUEADA

			}
			catch (InterruptedException e) { // El acquire() puede dar excepción.
				e.printStackTrace ();
			}
			finally {
				// LIBERACION. Cuando he acabado de hacer lo que tenga que hacer en la 
				// seccion bloqueada, libero un semaforo para que otro entre
				miSemaforo.release ();
			}
		}
	}

	// constructor
	public HiloQueResta (String nombre, Contador c, Semaphore semaforo) {
		super (nombre);
		this.cont = c;
		this.miSemaforo = semaforo;
	}


}
