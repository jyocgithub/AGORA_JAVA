package condicionDeCarrera_no_sincronizado;

public class Hilo1 extends Thread {
	private ContadorCC ccc;

	public Hilo1 (String nombre, ContadorCC c) {
		super (nombre);
		this.ccc = c;
	}

	@Override
	public void run () {
		for (int i = 0; i < ccc.NUMVECES; i++) {
			try {
				Thread.sleep (10);
				ccc.decrementa ();
				System.out.println ("Vuelta " + i + "\n " + this.getName () + ", tras -- pone " + ccc.getValor ());
			}
			catch (InterruptedException e) {
				e.printStackTrace ();
			}
		}
	}
}
