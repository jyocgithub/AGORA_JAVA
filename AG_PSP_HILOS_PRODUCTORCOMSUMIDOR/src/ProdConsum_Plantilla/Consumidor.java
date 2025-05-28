package ProdConsum_Plantilla;

public class Consumidor extends Thread {
	private String nombre;
	private Monitor pMonitor;

	public Consumidor(String nombre , Monitor pMonitor) {
		this.nombre = nombre;
		// Mantiene una copia propia del objeto compartido
		this.pMonitor = pMonitor;
	}

	@Override
	public void run() {

		// El consumidor es unico para todos los productgores
		// debe extraer todos los mensajes que haya en el buffer, contando con que
		// 100 es el tamaño máximo del buffer, que se definió al instanciar el Monitor
		// asi pues, debo estar sacando del buffer con el metodo sacar()
		// hasta que saue unh mensaje con contenido "DONE"
		// ADvertir que el control de sincronizacion de las ejecuciones de sacar()
		// y de control y espera por si el buffer esta vacio, se hace en el propio sacar()

		// defino una cadena donde recoger el mensaje
		String mensajeSacado = "";

		// ejecuto un bucle que dure:
		// - mientras no se encuentre un mensaje leido con valor DONE,
		// O BIEN, tambien se ejecute
		// - mientras el buffer no este vacio
		// Tanto una cosa como otra (OR) me obligan a swguir leyendo del buffer
		// Cuando se detecte un mensaje DONE, se activa un flag para que, desde ese momento,
		// cuando se vacie el buffer, se cierre el proceso Consumidor
		// Para mas legibilidad se controlo con unas variables booleanas:
		boolean noHaymensajeDone = true;
		boolean noEstaVacioElBuffer = true;
		boolean seguirEnElBucle = true;

		do {

			// extraemos un mensaje del buffer
			mensajeSacado = pMonitor.sacar();

			// mensaje de aviso
			System.out.println("-- Saco del Monitor el mensaje " + mensajeSacado);

			// Espera un poco antes de añadir más letras
			// Este valor se puede cambiar para ver con que alternancia se efectuan
			// las lecturas y escrituras en el buffer, por bloqueos y esperas variables
			try {
				sleep((int) (Math.random() * 2000));
			}
			catch (InterruptedException e) {
				System.err.println("ConsumidorMensajes; Error en sacar: " + e.getMessage());
			}

			// Evaluamos si se ha enviado ya desde el productor un mensaje DONE
			// esto lo debemos guardar en un flag por que no sera mensajeSacado
			// el ultimo mensaje que saque, y hemos de contar con ello en futuro
			if (mensajeSacado.equals("Fin")) {
				noHaymensajeDone = false;
			}

			// Evaluemos si seguir en el bucle, o ya no hay nada que consumir y se ha
			// recibido el mensaje de DONE para acabar
			noEstaVacioElBuffer = !pMonitor.monitorVacio();
			seguirEnElBucle = (noHaymensajeDone || noEstaVacioElBuffer);

		} while (seguirEnElBucle);

		System.out.println("FIN DE SALIDAS DE MENSAJERIA");
	}
}
