package Semaforos;

import java.util.concurrent.Semaphore;

public class Principal {

	public static void main (String[] args) {
		Contador cont = new Contador (0);
		Semaphore unSemaforo = new Semaphore (2, true);

		// El semaforo es compartido por todos los hilos, sumador y restadores
		// de este modo solo se accede a sumar o restar si se tiene un permiso
		// El semaforo tiene dos permisos disponibles, asi que puede haber dos 
		// hilos actuando como mucho a la vez

		HiloQueSuma hs1 = new HiloQueSuma ("Hilo S1", cont, unSemaforo);
		HiloQueResta hr1 = new HiloQueResta ("Hilo R1", cont, unSemaforo);
		HiloQueResta hr2 = new HiloQueResta ("Hilo R2", cont, unSemaforo);
		HiloQueResta hr3 = new HiloQueResta ("Hilo R3", cont, unSemaforo);

		long initialTime = System.currentTimeMillis ();

		hs1.start ();

		hr1.start ();
		hr2.start ();
		hr3.start ();

		try {
			// ponemos los hilos en join para que los mensajes finales salgan cuando todos acaben
			hs1.join ();
			hr1.join ();
			hr2.join ();
			hr3.join ();
		}
		catch (InterruptedException e) {
			e.printStackTrace ();
		}

		// Mensajes finales
		System.out.println ("Valor final de n: " + cont.getValue ());
		long duracion = (System.currentTimeMillis () - initialTime) / 1000;
		System.out.println ("Duracion " + duracion + " seg.");

		// vemos que la duracion cambia si cambiamos el numero de permisos:
		// - Si se usa un semaforo con 2 permisos, se tarda aprox. 3 segundos en procesar
		// - Si se usa un semaforo con 1 permiso, se tarda aprox. 7 segundos en procesar

	}
}

/*
 * Ejecucion del programa con 2 permisos. 
 * Los restadores aun en orden, se mezclan con el sumador
 * 
 * ----------------------
++++ Hilo S1 : 1
++++ Hilo S1 : 2
-- Hilo R1 : 1
-- Hilo R2 : 0
++++ Hilo S1 : 1
++++ Hilo S1 : 2
-- Hilo R3 : 1
-- Hilo R1 : 0
++++ Hilo S1 : 1
++++ Hilo S1 : 2
-- Hilo R2 : 1
-- Hilo R3 : 0
++++ Hilo S1 : 1
++++ Hilo S1 : 2
-- Hilo R1 : 1
-- Hilo R2 : 0
-- Hilo R3 : -1
++++ Hilo S1 : 0
++++ Hilo S1 : 1
-- Hilo R1 : 0
-- Hilo R2 : -1
++++ Hilo S1 : 0
++++ Hilo S1 : 1
++++ Hilo S1 : 2
++++ Hilo S1 : 3
++++ Hilo S1 : 4
++++ Hilo S1 : 5
++++ Hilo S1 : 6
++++ Hilo S1 : 7
-- Hilo R3 : 6
++++ Hilo S1 : 7
++++ Hilo S1 : 8
++++ Hilo S1 : 9
++++ Hilo S1 : 10
++++ Hilo S1 : 11
++++ Hilo S1 : 12
Valor final de n: 12
Duracion 3 seg.
 */


/*
 * Ejecucion del programa con 1 permisos. 
 * Los restadores aun en orden, pero no se mezclan con el sumador
 * El que no se mezclen es un efecto colateral del planificador
 * 
 * ----------------------
++++ Hilo S1 : 1
++++ Hilo S1 : 2
-- Hilo R1 : 1
-- Hilo R2 : 0
-- Hilo R3 : -1
++++ Hilo S1 : 0
++++ Hilo S1 : 1
-- Hilo R1 : 0
-- Hilo R2 : -1
-- Hilo R3 : -2
++++ Hilo S1 : -1
++++ Hilo S1 : 0
-- Hilo R1 : -1
-- Hilo R2 : -2
-- Hilo R3 : -3
++++ Hilo S1 : -2
++++ Hilo S1 : -1
-- Hilo R1 : -2
-- Hilo R2 : -3
-- Hilo R3 : -4
++++ Hilo S1 : -3
++++ Hilo S1 : -2
++++ Hilo S1 : -1
++++ Hilo S1 : 0
++++ Hilo S1 : 1
++++ Hilo S1 : 2
++++ Hilo S1 : 3
++++ Hilo S1 : 4
++++ Hilo S1 : 5
++++ Hilo S1 : 6
++++ Hilo S1 : 7
++++ Hilo S1 : 8
++++ Hilo S1 : 9
++++ Hilo S1 : 10
++++ Hilo S1 : 11
++++ Hilo S1 : 12
Valor final de n: 12
Duracion 7 seg.

 */

