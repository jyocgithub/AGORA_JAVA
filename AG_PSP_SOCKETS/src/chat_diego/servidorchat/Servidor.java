package chat_diego.servidorchat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.TreeSet;

import chat_diego.servidor.Mensaje;

public class Servidor {
	private int _numPuerto;

	private UsuariosConectados _usuarios;

	public Servidor(int numPuerto) {
		_numPuerto = numPuerto;
		_usuarios = new UsuariosConectados();
	}

	public void arrancar() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(_numPuerto);
			Socket socket;
			while (true) {
				// queda en espera de que alguien le llame, y cuando le llama,
				// el canal que comunica a ambos se gaurda en socket
				socket = serverSocket.accept();
				// lanza un hilo qiue estara en conexion con el hilo cliente
				// comparten los dos hilos el objeto socket, que es el canal de conexion
				Thread thCliente = new Thread(new RnCliente(socket));
				thCliente.setDaemon(true);
				thCliente.start();
			}
		} catch (IOException e) {
			System.out.println("Error de conexión.");
			e.printStackTrace();
		}
		if (serverSocket != null) {
			try {
				serverSocket.close();
			} catch (IOException e) {
			}
		}

	}

	private class RnCliente implements Runnable {

		private Socket socket;
		private ObjectOutputStream salida;
		private ObjectInputStream entrada;

		public RnCliente(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			String nombre = "";
			try {

				entrada = new ObjectInputStream(socket.getInputStream());
				salida = new ObjectOutputStream(socket.getOutputStream());

				Mensaje mensaje = (Mensaje) entrada.readObject();
				if (mensaje.getTipo() == Mensaje.IDENTIFICACION_USUARIO) {
					if (_usuarios.existeUsuario(mensaje.getNombreCliente())) {
						// El usuario ya está conectado
						salida.writeObject(new Mensaje(Mensaje.USUARIO_YA_EXISTE, null, null));
					} else // El usuario no existe
					{
						nombre = mensaje.getNombreCliente();
						// Mandamos mensaje conectado
						salida.writeObject(new Mensaje(Mensaje.CONECTADO_AL_SERVIDOR, null, null));
						// Añadimos el cliente al treeMap
						_usuarios.anadirUsuario(nombre, salida);
						TreeSet<String> tsClientes = _usuarios.getTreeSetUsuarios();

						// Enviamos la lista de conectados
						salida.writeObject(new Mensaje(Mensaje.LISTA_USUARIOS_CONECTADOS, null, tsClientes));
						//
						broadcastMensaje(new Mensaje(Mensaje.CLIENTE_ENTRA, mensaje.getNombreCliente(), null));

						while (true) {
							mensaje = (Mensaje) entrada.readObject();
							if (mensaje.getTipo() == Mensaje.MENSAJE) {
								broadcastMensaje(mensaje);
							}
						}

					}

				}

			} catch (IOException e) {
				// Se ha perdido la conexión y se había registrado
				if (nombre.length() > 0) {
					_usuarios.eliminarUsuario(nombre);
					broadcastMensaje(new Mensaje(Mensaje.CLIENTE_SALE, nombre, null));
				} else {

					System.out.println("Error de conexión en el cliente.");
					// e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				System.out.println("Error en el protocolo del cliente.");
				e.printStackTrace();
			}
			try {
				if (entrada != null) {
					entrada.close();
				}
				if (salida != null) {
					salida.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {

			}

		}

		private void broadcastMensaje(Mensaje mensaje) {

			ObjectOutputStream salidas[] = _usuarios.getSalidas();
			for (int i = 0; i < salidas.length; i++) {

				try {
					salidas[i].writeObject(mensaje);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
