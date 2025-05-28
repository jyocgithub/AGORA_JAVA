package ej_psp_4_a_15_consumidorMensajes;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase ProductorMensajes
 * Extiende de Thread para comportarse como un hilo,
 * por lo que sobreescribira su metodo run()
 * donde esta el codigo a ejecutgar cuando se le permita por sincronizacion
 */
public class ProductorMensajes extends Thread {

	private Monitor	pMonitor;
	private String	pMensaje;

	/**
	 * Constructor ProductorMensajes. Recibe como parametros
	 * - un objeto del Monitor que es quien esta controlando el trafico
	 * El productor y el programa termina al recibir un mensaje "DONE"
	 */
	public ProductorMensajes(Monitor pMon) {
		pMonitor = pMon;
	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
	    String[] mensajes = {"hola", "buenas", "adios", "claro!!", "Agur", "Vale", "Fin"};
		do {
			int numeromensaje = random.nextInt(mensajes.length);
			pMensaje = mensajes[numeromensaje];

			// Se añade el atributo de clase pMensaje, que es el mensaje,
			// al buffer, con el metodo poner() del monitor
			pMonitor.poner(pMensaje);

			// mensaje por consola de confirmacion
			System.out.println("++ Puesto en Monitor el mensaje " + pMensaje);

			// Espera un poco antes de añadir más letras
			// Este valor se puede cambiar para ver con que alternancia se efectuan
			// las lecturas y escrituras en el buffer, por bloqueos y esperas variables
			try {
				sleep((int) (Math.random() * 100));
			}
			catch (InterruptedException e) {
				System.err.println("ProductorMensajes; Error en poner: " + e.getMessage());
			}

		} while (!(pMensaje.equals("Fin")));

		System.out.println("FIN DE ENTRADAS DE MENSAJERIA");
		sc.close();
	}
}
