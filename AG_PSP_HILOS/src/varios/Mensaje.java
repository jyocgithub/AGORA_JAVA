package varios;

import java.io.Serializable;

public class Mensaje implements Serializable {
	public int tipo;
	public String texto;

	public Mensaje(int tipo, String texto) {
		this.tipo = tipo;
		this.texto = texto;
	}

}
