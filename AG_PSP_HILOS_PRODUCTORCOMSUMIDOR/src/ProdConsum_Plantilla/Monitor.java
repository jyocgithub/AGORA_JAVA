package ProdConsum_Plantilla;

import java.util.ArrayList;

/**
 * Clase Monitor Gestiona los hilos de entrada y salida del buffer
 * donde se almacenan los mensajes Sus principales metodos son
 * - sacar() . Metodo sincronizado para extraer mensajes del buffer
 * - poner() . Metodo sincronizado para poner mensajes en el buffer
 */
public class Monitor {
	// ATRIBUTOS DE CLASE
	// buzonMensajes es un array que se comporta como un buzon donde
	// se meten y sacan los mensajes. Tiene un tamaño de 3
	// mensajes. Si se llena, no se pueden meter mas mensajes
	// hasta que se saque alguno y quede sitio
	private final ArrayList<String> buzonMensajes = new ArrayList<>();
	int tamanoMaximoBuzon = 3;


	/**
	 * sacar() Saca mensajes del buffer y los devuelve como String
	 */
	public synchronized String sacar() {
		// mira si el buzonMensajes esta vacio, si lo esta, espera
		while (buzonMensajes.size()==0 ) {
			try {
				// queda en espera (wait) de que alguien le
				// de paso con un notify(). Quien lo hace
				// sera el metodo poner, cuando meta algo
				// en el buzonMensajes
				wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Ya se sabe que no esta vacio el buzonMensajes, asi que
		// el metodo debe devolver en el return unelemento
		// del buzonMensajes

		// 1-Vemos cual es el primer mensaje del buzonMensajes
		String mensajeQueSaco = buzonMensajes.get(0);

		// 2-Eliminamos (sacamos) dicho mensaje del buzonMensajes
		buzonMensajes.remove(0);

		// 3-Notifico a otros metodos que esten en espera que he
		// metido algo en el buzonMensajes, específicamente, le notifico a
		// los metodos poner que esten en espera que ya hay hueco para algo que
		// poner en el buzonMensajes
		notify();
		// 5- Se devuelve el mensaje al monitor
		return (mensajeQueSaco);
	}

	/**
	 * poner() Mete mensajes en el buffer Los mensajes los
	 * recibe como un parametro String
	 */
	public synchronized void poner(String ss) {
		// ----- 1 -----------
		// Se mira si el buffer esta lleno, si lo esta,
		// se espera a que haya hueco
		while (buzonMensajes.size()>= tamanoMaximoBuzon) {
			try {
				// queda en espera (wait) de que alguien le
				// de paso con un notify() quien lo hace sera
				// el metodo sacar, cuando saque algo del buffer,
				// con lo que el flag estaLLeno se pondra tambien a false
				wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// ----- 2 -----------
		// Añadir el mensaje en el buzonMensajes
		// muevo el puntero del siguiente sitio disponible
		buzonMensajes.add(ss);

		// ----- 3 -----------
		// 2-Notifico a otros metodos que esten en espera que he
		// metido algo en el buzon, específicamente, le notifico a los metodos
		// sacar que esten en espera que ya hay algo que sacar del buzon
		notifyAll();
	}
	public synchronized boolean monitorVacio() {
		return buzonMensajes.isEmpty();
	}


}
