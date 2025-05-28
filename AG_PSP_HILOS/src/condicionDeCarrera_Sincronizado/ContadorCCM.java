package condicionDeCarrera_Sincronizado;

public class ContadorCCM {

	private int			valor		= 0;
	public final int	NUMVECES	= 10;

	public ContadorCCM(int valor) {
		this.valor = valor;
	}

	// el método ahora está sincronizado
	synchronized void incrementa() {
		this.valor++;
	}

	// el método ahora está sincronizado
	synchronized void decrementa() {
		this.valor--;
	}

	public int getValue() {
		return valor;
	}

}
