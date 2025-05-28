           import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class ServidorTrivial {

	private final int numPuerto = 10001;
	private ServerSocket serverSocket = null;
	private ArrayList<String> clientesConectados;
	private ArrayList<Pregunta> listaPreguntas;

	public ServidorTrivial() {

		listaPreguntas = new ArrayList<>();
		clientesConectados = new ArrayList<>();
		leerPreguntas();

		try {
			serverSocket = new ServerSocket(numPuerto);
			System.out.println("Servidor arrancado......");

			int cont = 0;

			while (true) {
				Socket socket = serverSocket.accept();

				Thread thCliente = new Thread(new HiloDeCadaCliente(socket, cont));
				thCliente.start();
				cont++;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	class HiloDeCadaCliente implements Runnable {
		private Socket elsocket;
		private int contador;
		private ObjectInputStream entrada;
		private ObjectOutputStream salida;
		Random ran;
		int contadorPreguntas;
		Pregunta pregActual;
		Mensaje menrecibido;
		boolean seguir;

		public HiloDeCadaCliente(Socket elsocket, int contador) {
			this.elsocket = elsocket;
			this.contador = contador;

		}

		@Override
		public void run() {

			try {
				entrada = new ObjectInputStream(elsocket.getInputStream());
				salida = new ObjectOutputStream(elsocket.getOutputStream());

				menrecibido = (Mensaje) entrada.readObject();
				if (clientesConectados.contains(menrecibido.getMensaje())) {
					System.out.println("Cliente rechazado, ya esta jugando !!");
					salida.writeObject(new Mensaje("Ya existe el cliente", Mensaje.CLIENTEYAEXISTE));
					elsocket.close();
				} else {
					salida.writeObject(new Mensaje("Hola " + menrecibido.getMensaje(), Mensaje.SALUDOINICIAL));
					contadorPreguntas = 1;
					seguir = true;
					while (seguir) {
						ran = new Random();
						int numpreg = ran.nextInt(listaPreguntas.size());
						pregActual = listaPreguntas.get(numpreg);
						salida.writeObject(new Mensaje("Pregunta " + contadorPreguntas + ":" + pregActual.getPregunta(),
								Mensaje.PREGUNTAR));
						menrecibido = (Mensaje) entrada.readObject();
						if (menrecibido.getMensaje().trim().equals(pregActual.getRespuesta().trim())) {
							salida.writeObject(new Mensaje("CORRECTO !", Mensaje.CORRECTO));
						} else {
							salida.writeObject(new Mensaje("INCORRECTO ! ADIOS !", Mensaje.INCORRECTO));
							elsocket.close();
							seguir = false;
						}
						contadorPreguntas++;
					}

				}

			} catch (IOException e) {
				System.out.println("Problemas de comunicacion");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}

	}

	private void leerPreguntas() {

		BufferedReader br = null;
		Pregunta preg;
		String[] trozos;
		String linea;

		try {
			br = new BufferedReader(new FileReader("preguntas.txt"));

			linea = br.readLine();
			while (linea != null) {
				trozos = linea.split("@@@");
				preg = new Pregunta(trozos[0], trozos[1]);
				listaPreguntas.add(preg);
				linea = br.readLine();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
