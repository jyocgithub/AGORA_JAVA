package condicionDeCarrera_Sincronizado;

public class Hilo2 extends Thread {
	private ContadorCCM ccc;

	public Hilo2(String nombre, ContadorCCM c) {
		super(nombre);
		this.ccc = c;
	}

	@Override
	public void run() {
		for (int i = 0; i < ccc.NUMVECES; i++) {
			try {
				Thread.sleep(10);
				ccc.incrementa();
				ccc.incrementa();
				System.out.println("Vuelta " + i + "\n " + this.getName() + ", tras ++++ pone "
				        + ccc.getValue());
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
