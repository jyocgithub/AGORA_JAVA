package juliaMensajeria;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * PROGRAMA VENTANACHAT.java
 * 
 * Contiene dos clases:
 * - class HiloEscuchadorDeCadaCliente : para crear hilo, uno por cada cliente, que se ejecutan en
 * paralelo y se comunican con el servidor
 * - class VentanaChat: que crea la ventana con las cajas de texto para que cada hilo pueda escribir y leer
 * 
 */

/**
 * Clase para crear hilos escuchador de cada cliente
 * 
 * En el constructor recibe un InputStream que lee líneas contínuamente.
 * Cada vez que lee una línea, la envía a la ventana del chat, recibida en el constructor,
 * Para el envio usa el metodo TextoIntroducido().
 */
class HiloEscuchadorDeCadaCliente implements Runnable {

	BufferedReader	lector;
	VentanaChat		ventanaChat;

	/**
	 * Constructor
	 * 
	 */
	HiloEscuchadorDeCadaCliente(InputStream is, VentanaChat ventanaChat) {
		lector = new BufferedReader(new InputStreamReader(is));
		this.ventanaChat = ventanaChat;
	}

	/**
	 * Método run ()
	 * 
	 */
	@Override
	public void run() {

		String leido;

		while (true) {
			try {
				leido = lector.readLine();
				ventanaChat.textoRecibido(leido + "\n");
			}
			catch (IOException e) {
				break;
			}
		}

		// Cerramos el canal de entrada. El socket se da cuenta, y ve que el canal de salida
		// está también cerrado (por el otro extremo) y da error en el próximo intento de escritura.
		try {
			lector.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		ventanaChat.textoRecibido("* El servidor cerró la entrada *");
	}
}

/**
 * Ventana de chat
 * Recibe en el constructor un socket ya conectado con el servidor
 * Tiene la ventana un área de texto donde mostrar los mensajes del servidor, y un
 * cuadro de texto donde el usuario escribe las instrucciones.
 * 
 * Se usa un objeto de HiloCliente que se lanza en un hilo secundario para leer líneas
 * contínuamente del socket.
 * Cada vez que el hilo detecta una entrada, llama al método textoRecibido()
 * de esta clase para que se le envie al servidor
 * 
 */
public class VentanaChat extends JFrame {

	// Caja donde vemos mensajes entrantes
	JTextArea	txTextoMensajes;
	// Caja donde escribimos mensajes
	JTextField	tfEntradaMensaje;
	String		nombreUsuario;
	// Canal de salida del socket por donde escribimos lo que enviamos al servidor
	PrintWriter	escritor;

	/**
	 * Constructor.
	 * 
	 */
	public VentanaChat(Socket socket, String nombreUsuario) {

		super(nombreUsuario + " - Ventana de chat");
		this.nombreUsuario = nombreUsuario;

		inicializarVentana();

		// Obtenemos el canal de salida donde mandaremos los textos al servidor
		// (que lo haremos con el enviarServidor(String) ).
		try {
			escritor = new PrintWriter(socket.getOutputStream());
		}
		catch (IOException e) {
			escribeEnPanelMensajes("*Error de conexión*");
			return;
		}

		// Creamos el hilo que se mantendrá a la escucha
		// del canal de entrada del socket y mandará todas las
		// líneas a nuestro método textoRecibido().
		HiloEscuchadorDeCadaCliente obHiloCliente;
		try {
			obHiloCliente = new HiloEscuchadorDeCadaCliente(socket.getInputStream(), this);
		}
		catch (IOException e) {
			escribeEnPanelMensajes("  [Error de conexión]");
			return;
		}
		new Thread(obHiloCliente).start();
	}

	/**
	 * Programa principal.
	 * 
	 */
	public static void main(String[] args) {

		Socket socket;
		String hostname = "localhost";
		String nombreUsuario;
		int port = new datos().port;

		// Intentamos conectarnos al servidor solicitado.
		try {
			socket = new Socket(hostname, port);
		}
		catch (UnknownHostException uhe) {
			System.err.println("Error al usar localhost");
			return;
		}
		catch (IOException ioe) {
			System.err.println("Error de E/S creando el socket: " + ioe.getLocalizedMessage());
			return;
		}

		// Creamos una ventana de chat para este cliente
		new VentanaChat(socket, "Ventana cliente");

	} // main

	/**
	 * textoRecibido
	 * 
	 */
	public void textoRecibido(final String texto) {

		// No podemos llamar a Swing alegremente desde
		// otra hebra. Le pedimos que nos invoque más
		// adelante a través de un Runnable.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				escribeEnPanelMensajes(texto);
			}
		});

	}

	/**
	 * escribeEnPanelMensajes
	 * 
	 */
	protected void escribeEnPanelMensajes(String texto) {

		txTextoMensajes.append(texto);
		txTextoMensajes.setCaretPosition(txTextoMensajes.getDocument().getLength());

	}

	/**
	 * textoEscrito
	 * 
	 * Metodo llamado cuando el usuario pulsa intro en el cuadro de texto
	 * para enviar lo que ha escrito.
	 */
	protected String textoEscrito() {

		String textoUsuario = tfEntradaMensaje.getText();
		if (textoUsuario != null) {
			// El usuario ha escrito texto.
			// - Lo añadimos al área de texto
			// - Lo borramos del cuadro de introduccion de texto
			// - Lo mandamos al servidor
			escribeEnPanelMensajes("->" + textoUsuario + "\n");
			tfEntradaMensaje.setText("");
			enviarServidor(textoUsuario);
		}
		return textoUsuario;

	}

	/**
	 * enviarServidor
	 * 
	 * Envía por el socket al servidor el texto recibido como parametro
	 */
	protected void enviarServidor(String texto) {
		escritor.println(texto);
		escritor.flush();
	}

	/**
	 * inicializarVentana
	 * Simplemente da tamaño y posicion a todos los elementos de la ventana
	 * y define los metodos listener de los textos que se introducen
	 * 
	 */
	protected void inicializarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Establecemos el tamaño predefinido.
		setSize(300, 420);

		// Creamos el área de texto de la ventana del
		// chat.
		txTextoMensajes = new JTextArea();
		// El área de texto no será editable...
		txTextoMensajes.setEditable(false);
		// ... queremos que el ancho de sus líneas se ajusten
		// al ancho de la ventana ...
		txTextoMensajes.setLineWrap(true);
		// ... y que en la medida de lo posible no se
		// corten palabras, sino que se utilice el espacio
		// como separador para el cambio de línea.
		txTextoMensajes.setWrapStyleWord(true);

		// El área de texto lo vamos a "decorar" en un
		// panel que muestre, cuando sea necesario, las
		// barras de desplazamiento.
		JScrollPane scrollPane = new JScrollPane(txTextoMensajes);

		// Creamos un cuadro de texto donde el usuario
		// escribirá lo que quiere mandar.
		tfEntradaMensaje = new JTextField();

		// Ponemos como disposición de los controles
		// del JFrame un BorderLayout...
		setLayout(new BorderLayout());
		// ... poniendo en el centro el área de texto
		// del chat ...
		add(scrollPane, BorderLayout.CENTER);
		// ... y en e sur el cuadro de texto donde el
		// usuario escribe.
		add(tfEntradaMensaje, BorderLayout.SOUTH);

		// Si el usuario pulsa intro en el cuadro
		// de texto, llamamos al método textoEscrito().
		tfEntradaMensaje.addActionListener(
		        new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
				        String x = textoEscrito();
				        if (x.equals("EXIT")) {
					        dispose();
				        }
			        }
		        });

		// Si se cierra la ventana:
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				enviarServidor("*DESCONECTADO*");
				escritor.close();
			}
		});

		// Mostramos la ventana y damos el foco al cuadro de texto.
		setVisible(true);
		tfEntradaMensaje.requestFocusInWindow();

	}
}
