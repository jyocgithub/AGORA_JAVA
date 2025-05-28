package condicionDeCarrera_no_sincronizado;

public class Hilo2 extends Thread {
	private ContadorCC ccc;

	public Hilo2 (String nombre, ContadorCC c) {
		super (nombre);
		this.ccc = c;
	}

	@Override
	public void run () {
		for (int i = 0; i < ccc.NUMVECES; i++) {
			try {
				Thread.sleep (10);
				ccc.incrementa ();
				ccc.incrementa ();
				System.out.println ("Vuelta " + i + "\n " + this.getName () + ", tras ++++ pone " + ccc.getValor ());

			}
			catch (InterruptedException e) {
				e.printStackTrace ();
			}
		}
	}
}

/*
 * Ejecucion del programa
 * ----------------------
 * Vuelta 0
 * Hilo1, tras -- pone 1
 * Vuelta 0
 * Hilo2, tras ++++ pone 1
 * Vuelta 1
 * Hilo2, tras ++++ pone 3
 * Vuelta 1
 * Hilo1, tras -- pone 3
 * Vuelta 2
 * Hilo2, tras ++++ pone 5
 * Vuelta 2
 * Hilo1, tras -- pone 4
 * Vuelta 3
 * Hilo2, tras ++++ pone 5
 * Vuelta 3
 * Hilo1, tras -- pone 5
 * Vuelta 4
 * Hilo2, tras ++++ pone 6
 * Vuelta 4
 * Hilo1, tras -- pone 6
 * Vuelta 5
 * Hilo2, tras ++++ pone 7
 * Vuelta 5
 * Hilo1, tras -- pone 7
 * Vuelta 6
 * Hilo2, tras ++++ pone 9
 * Vuelta 6
 * Hilo1, tras -- pone 9
 * Vuelta 7
 * Hilo1, tras -- pone 9
 * Vuelta 7
 * Hilo2, tras ++++ pone 9
 * Vuelta 8
 * Hilo2, tras ++++ pone 11
 * Vuelta 8
 * Hilo1, tras -- pone 11
 * Vuelta 9
 * Hilo2, tras ++++ pone 12
 * Vuelta 9
 * Hilo1, tras -- pone 12
 * Valor final de variable: 12
 */
