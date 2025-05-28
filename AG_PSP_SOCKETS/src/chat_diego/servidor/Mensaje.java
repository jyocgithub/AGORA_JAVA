package chat_diego.servidor;

import java.io.Serializable;

public class Mensaje implements Serializable {
	private static final long serialVersionUID = 339469891775223405L;
	// new Mensaje(Mensaje.USUARIO_YA_EXISTE,null,null)
	public final static int USUARIO_YA_EXISTE = 0;
	// new Mensaje(Mensaje.Mensaje.CONECTADO_AL_SERVIDOR,null,null)
	public final static int CONECTADO_AL_SERVIDOR = 1;
	// En la parte contenido se envía TreeSet<String>
	// new Mensaje(Mensaje.LISTA_USUARIOS_CONECTADOS,null,_tsNombres)
	public final static int LISTA_USUARIOS_CONECTADOS = 2;
	// new Mensaje(Mensaje.CLIENTE_ENTRA,nombreCliente,null);
	public final static int CLIENTE_ENTRA = 3;
	// new Mensaje(Mensaje.CLIENTE_SALE,nombreCliente,null);
	public final static int CLIENTE_SALE = 4;
	// new Mensaje(Mensaje.MENSAJE,nombreCliente,mensaje);
	public final static int MENSAJE = 5;
	// new Mensaje(Mensaje.IDENTIFICACION_USUARIO,nombreCliente,null);
	public final static int IDENTIFICACION_USUARIO = 6;

	private int _tipo;
	private String _nombreCliente;
	private Object _contenido;

	public Mensaje(int tipo, String nombreCliente, Object contenido) {
		_tipo = tipo;
		_nombreCliente = nombreCliente;
		_contenido = contenido;
	}

	public int getTipo() {
		return _tipo;
	}

	public String getNombreCliente() {
		return _nombreCliente;
	}

	public Object getContenido() {
		return _contenido;
	}
}
