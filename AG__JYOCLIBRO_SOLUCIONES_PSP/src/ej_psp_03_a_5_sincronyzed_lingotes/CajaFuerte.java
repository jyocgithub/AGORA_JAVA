package ej_psp_3_a_5_sincronyzed_lingotes;

public class CajaFuerte {
	private int _numLingotes;
	private boolean _todosLosLadronesVivos;
	private boolean _haRobadoElUno = false;

	public CajaFuerte(int numLingotes) {
		_numLingotes = numLingotes;
		_todosLosLadronesVivos = true;

	}

	public synchronized boolean sacarLingotes(String nombreLadron, int numRobo) {
		// if(nombreLadron.equals("1"))
		// {
		// _haRobadoElUno = true;
		// }
		// else if(!_haRobadoElUno)
		// {
		// return true;
		// }

		// Si se puede hacer el robo
		if (_numLingotes >= numRobo) {
			System.out.println("El ladrón " + nombreLadron + " ha robado " + numRobo);
			_numLingotes -= numRobo;

			// Sólo pasamos a wait si el otro hilo está vivo
			// if (_todosLosLadronesVivos) {
			notify();
			try {
				wait();
			} catch (InterruptedException e) {
			}
			// }
			return true;
		} else // No hay lingotes suficientes
		{
			System.out.println("El ladrón " + nombreLadron + " no puede sacar " + numRobo + " y finaliza.");
			_todosLosLadronesVivos = false;
			notify();
			return false;
		}
	}
}
