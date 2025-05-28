package condicionDeCarrera_no_sincronizado;

public class ContadorCC {

	private int			valor		= 0;
	public final int	NUMVECES	= 10;

	public ContadorCC (int valor) {
		this.valor = valor;
	}

	public void incrementa () {
		this.valor++;
	}

	public void decrementa () {
		this.valor--;
	}

	public int getValor () {
		return valor;
	}

}
