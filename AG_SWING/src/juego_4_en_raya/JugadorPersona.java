package juego_4_en_raya;

public class JugadorPersona {

	private int colorFicha;
	private int colorContrario;

	public JugadorPersona(int colorFicha, int colorContrario) {
		super();
		this.colorFicha = colorFicha;
		this.colorContrario = colorContrario;

	}

	public int getColorFicha() {
		return colorFicha;
	}

	public void setColorFicha(int colorFicha) {
		this.colorFicha = colorFicha;
	}

	public int getColorContrario() {
		return colorContrario;
	}

	public void setColorContrario(int colorContrario) {
		this.colorContrario = colorContrario;
	}

}
