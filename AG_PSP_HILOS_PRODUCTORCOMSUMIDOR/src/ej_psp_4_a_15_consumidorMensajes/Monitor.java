package ej_psp_4_a_15_consumidorMensajes;

/**
 * Clase Monitor Gestiona los hilos de entrada y salida del buffer
 * donde se almacenan los mensajes Sus principales metodos son
 * - sacar() . Metodo sincronizado para extraer mensajes del buffer
 * - poner() . Metodo sincronizado para poner mensajes en el buffer
 */
public class Monitor {
	// ATRIBUTOS DE CLASE
	// buffer es un array que se comporta como un buzon donde
	// se meten y sacan los mensajes. Tiene un tamaño de 3
	// mensajes. Si se llena, no se pueden meter mas mensajes
	// hasta que se saque alguno y quede sitio
	private final String	buffer[]	= new String[3];

	// siguiente es el puntero que indica que elemento del
	// buzon estamos tratando
	private int				siguiente	= 0;

	// Estos son los flags para saber el estado del buffer,
	// si vacio o lleno
	private boolean			estaLlena	= false;
	private boolean			estaVacia	= true;

	// Sed definen los getters de los atributos flag (settes
	// no son necesarios)
	public boolean isEstaLlena() {
		return estaLlena;
	}

	public boolean isEstaVacia() {
		return estaVacia;
	}

	/**
	 * sacar() Saca mensjes del buffer y los devuelve como String
	 */
	public synchronized String sacar() {
		// mira si el buffer esta vacio, si lo esta, espera
		while (estaVacia ) {
			try {
				// queda en espera (wait) de que alguien le
				// de paso con un notify(). Quien lo hace
				// sera el metodo poner, cuando meta algo
				// en el buffer, con lo que el flag
				// estaVacia se pondra tambien a false
				wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// Ya se sabe que no esta vacio el buffer, asi que
		// el metodo debe devolver en el return el elemento
		// numero "siguiente" del buffer pero antes de hacer
		// el return, cambia los parametros del buffer para
		// dejarlos coherentes:

		// 1-Decrementa la cuenta, ya consumimos un mensaje
		siguiente--;
		// 2-Comprueba si se retiró la última letra, en cuyo
		// caso, debe poner el flag de estaVacia a true
		if (siguiente == 0) {
			estaVacia = true;
		}
		// 3-El buffer no puede estar lleno, porque acabamos
		// de sacar algo, asi que ponemos el flag estaLlena a false
		estaLlena = false;
		// 4-Notifico a otros metodos que esten en espera que he
		// metido algo en el buzon, específicamente, le notifico a
		// los metodos sacar que esten en espera que ya hay algo que
		// sacar del buzon
		notify();
		// 5- Se devuelve el mensaje al monitor
		return (buffer[siguiente]);
	}

	/**
	 * poner() Mete mensajes en el buffer Los mensajes los
	 * recibe como un parametro String
	 */
	public synchronized void poner(String ss) {
		// Se mira si el buffer esta lleno, si lo esta,
		// se espera a que haya hueco
		while (estaLlena) {
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
		// siguiente es el indice del primer lugar disponible
		// asi que pongo el mensaje en el lugar correspondiente del array
		buffer[siguiente] = ss;

		// Tras poner un mensaje en el buffer, se debe cambiar los
		// parametros del buffer para dejarlos coherentes:
		// 1-muevo el puntero del siguiente sitio disponible
		siguiente++;
		// 2-si acabo de poner algo, el flag estaVacia debe ser
		// false a la fuerza
		estaVacia = false;
		// 3-Comprueba si el buffer está lleno, y pongo el flag
		// estaLleno a true en tal caso
		if (siguiente == buffer.length) {
			estaLlena = true;
		}
		// 4-Notifico a otros metodos que esten en espera que he
		// metido algo en el buzon, específicamente, le notifico a los metodos
		// sacar que esten en espera que ya hay algo que sacar del buzon
		notify();
	}
}
