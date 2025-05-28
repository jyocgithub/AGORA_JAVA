package solucion.ejercicio_2;

public class Comprador extends Thread {
	Coches coche;
	int id;
	int cont;

	public Comprador(Coches c, int id) {
		this.coche = c;
		this.id = id;
		cont = 0;
	}

	@Override
	public void run() {
		while (cont < 3) {
			this.coche.compro(this.id);
			cont++;
		}
	}
}
