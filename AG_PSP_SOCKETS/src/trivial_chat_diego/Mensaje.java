import java.io.Serializable;

public class Mensaje implements Serializable {

	public static final int AUTORIZACION = 1;
	public static final int CLIENTEYAEXISTE = 2;
	public static final int SALUDOINICIAL = 3;
	public static final int PREGUNTAR = 4;
	public static final int RESPONDER = 5;
	public static final int CORRECTO = 6;
	public static final int INCORRECTO = 7;

	private String mensaje;
	private int tipo;

	public Mensaje(String mensaje, int tipo) {
		super();
		this.mensaje = mensaje;
		this.tipo = tipo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
