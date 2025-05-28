package socketsUDP_conSwing;

import java.io.Serializable;

/**
 * Clase Mensaje. Provee informacion de los mensajes a enviar entre cliente y
 * servidor
 *
 * @author Mark A. Lagasca
 */
public class Mensaje implements Serializable {
	// Atributos

	public int tipo;
	public String texto;

	/**
	 * Constructor de Mensaje
	 *
	 * @param tipo:
	 *            integer para asignar al atributo tipo
	 * @param texto:
	 *            String para asignar al atributo texto
	 */
	public Mensaje(int tipo, String texto) {
		this.tipo = tipo;
		this.texto = texto;
	}
}
