package Semaforos;

public class Contador {
	private int			valor		= 0;
	public final int	NUMVECES	= 10;

	public Contador(int valor) {
		this.valor = valor;
	}

	// el método ahora no está sincronizado
	public void incrementa() {
		this.valor++;
	}

	// el método ahora está sincronizado
	public void decrementa() {
		this.valor--;
	}

	public int getValue() {
		return valor;
	}

}
