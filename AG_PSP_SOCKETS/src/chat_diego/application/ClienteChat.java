package chat_diego.application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.TreeSet;

import chat_diego.servidor.Mensaje;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClienteChat {
	private Socket _socket;
	private ObjectInputStream _entrada;
	private ObjectOutputStream _salida;

	private TreeSet<String> _tsUsuarios;

	@FXML
	private TextField _tfUsuario;

	@FXML
	private Button _btConectar;

	@FXML
	private Button _btDesconectar;

	@FXML
	private TextArea _taUsuarios;

	@FXML
	private TextArea _taConsola;

	@FXML
	private TextArea _taEnviar;

	@FXML
	private Button _btEnviar;

	@FXML
	public void onActionConectar() {
		System.out.println("conectando");
		Thread thConectar = new Thread(new RnConectar());
		thConectar.setDaemon(true);
		thConectar.start();
	}

	@FXML
	public void onActionDesconectar() {
		estadoDesconectado();
		cerrarRecursos();
	}

	private void cerrarRecursos() {
		try {
			if (_entrada != null) {
				_entrada.close();
			}
			if (_salida != null) {
				_salida.close();
			}
			if (_socket != null) {
				_socket.close();
			}
		} catch (IOException e) {
		}
	}

	@FXML
	public void onActionEnviar() {

		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				try {

					// ENVIA MENSAJES A SU HILO SERVIDOR, PARA QUE ESTE LO REENVIE A TODOS LOS OTROS CLIENTES
					_salida.writeObject(new Mensaje(Mensaje.MENSAJE, _tfUsuario.getText(), _taEnviar.getText()));
					_taEnviar.clear();
				} catch (IOException e) {
					escribeConsola("Error al enviar mensaje.");
					cerrarRecursos();
					e.printStackTrace();
				}

			}
		});
	}

	private class RnConectar implements Runnable {

		@SuppressWarnings("unchecked")
		@Override
		public void run() {
			try {
				_socket = new Socket("localhost", 1234);
				System.out.println("conectado");
				_salida = new ObjectOutputStream(_socket.getOutputStream());
				_entrada = new ObjectInputStream(_socket.getInputStream());

				// Comienza el protocolo
				_salida.writeObject(new Mensaje(Mensaje.IDENTIFICACION_USUARIO, _tfUsuario.getText(), null));
				Mensaje mensaje = (Mensaje) _entrada.readObject();
				if (mensaje.getTipo() == Mensaje.USUARIO_YA_EXISTE) {
					escribeConsola("Usuario ya existe.");
				} else if (mensaje.getTipo() == Mensaje.CONECTADO_AL_SERVIDOR) {
					estadoConectado();
					escribeConsola("Conectado al servidor.");
					mensaje = (Mensaje) _entrada.readObject();
					if (mensaje.getTipo() == Mensaje.LISTA_USUARIOS_CONECTADOS) {
						_tsUsuarios = (TreeSet<String>) mensaje.getContenido();
						rellenarUsuarios();
						// bucle infinito que lee todos los mensajes que envien los hilso servidores de otros clienrtes
						while (true) {
							mensaje = (Mensaje) _entrada.readObject();
							switch (mensaje.getTipo()) {
							case Mensaje.CLIENTE_ENTRA:
								escribeConsola("Ha entrado " + mensaje.getNombreCliente() + ".");
								_tsUsuarios.add(mensaje.getNombreCliente());
								rellenarUsuarios();
								break;
							case Mensaje.CLIENTE_SALE:
								escribeConsola("Ha salido " + mensaje.getNombreCliente() + ".");
								_tsUsuarios.remove(mensaje.getNombreCliente());
								rellenarUsuarios();
								break;
							case Mensaje.MENSAJE:
								escribeConsola(mensaje.getNombreCliente() + ">" + mensaje.getContenido());
								break;
							}
						}

					}
				}

			} catch (UnknownHostException e) {
				escribeConsola("Host desconocido.");
				// e.printStackTrace();
			} catch (IOException e) {
				escribeConsola("Conexion interrumpida");
				// e.printStackTrace();
			} catch (ClassNotFoundException e) {
				escribeConsola("Error de protocolo.");
				// e.printStackTrace();
			}
			escribeConsola("Desconectado.");
			cerrarRecursos();
		}

	}

	private void rellenarUsuarios() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				_taUsuarios.clear();
				Iterator<String> iterator = _tsUsuarios.iterator();
				while (iterator.hasNext()) {
					_taUsuarios.appendText(iterator.next() + "\n");
				}
				// // idem con for each
				// for(String cadausuario:_tsUsuarios) {
				// _taUsuarios.appendText(cadausuario + "\n");
				// }

			}
		});
	}

	private void escribeConsola(String mensaje) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				_taConsola.appendText(mensaje + "\n");

			}
		});
	}

	private void estadoConectado() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				_btConectar.setDisable(true);
				_btDesconectar.setDisable(false);
				_btEnviar.setDisable(false);

			}
		});
	}

	private void estadoDesconectado() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				_btConectar.setDisable(false);
				_btDesconectar.setDisable(true);
				_btEnviar.setDisable(true);
				_taUsuarios.clear();

			}
		});
	}

}
