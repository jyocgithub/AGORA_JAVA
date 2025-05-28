package socketsUDP_conSwing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Clase ClienteUDP Contiene métodos para gestionar el envii de mensajes desde
 * un cliente a un servidor, y recibir de el una respuesta
 *
 * @author Mark A. Lagasca
 */
public class ClienteUDP extends JFrame {

	private JPanel		obPanel1;
	private JLabel		lblTexto;
	private JLabel		lblTipo;
	private JTextField	ipNo;
	private JTextField	puerto;
	private JTextField	tipo;
	private JTextField	texto;
	private JTextField	tipoRec;
	private JTextField	textoRec;
	private JTextField	rem;

	/**
	 * method main() Arranca la aplicacion desde el lado servidor.
	 *
	 * @param args
	 *            Unused.
	 * @return Nothing.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ClienteUDP frame = new ClienteUDP();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor ClienteDP Crea la interfaz para la comunicacion de el envio y
	 * recepcion de mensajes
	 *
	 * @param: Ninguno;
	 * @return: Ninguno
	 */
	public ClienteUDP() {

		// Se crean los objetos swing necesarios para pintar la interfaz
		// y se añaden a un JFrame donde nos comunicaremos con el usuario
		setTitle("UDP CLIENTE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 377);

		obPanel1 = new JPanel();
		obPanel1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(obPanel1);
		obPanel1.setLayout(null);

		ipNo = new JTextField();
		ipNo.setBounds(126, 21, 145, 20);
		obPanel1.add(ipNo);
		ipNo.setColumns(10);

		JLabel lblNewLabel = new JLabel("Ip o No...");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(37, 24, 89, 14);
		obPanel1.add(lblNewLabel);

		JLabel lblPuerto = new JLabel("Puerto");
		lblPuerto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPuerto.setBounds(37, 64, 89, 14);
		obPanel1.add(lblPuerto);

		puerto = new JTextField();
		puerto.setColumns(10);
		puerto.setBounds(126, 62, 145, 20);
		obPanel1.add(puerto);

		JPanel panel = new JPanel();
		panel.setBorder(
		        new TitledBorder(null, "A Enviar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(30, 117, 340, 72);
		obPanel1.add(panel);
		panel.setLayout(null);

		lblTexto = new JLabel("Texto");
		lblTexto.setBounds(25, 43, 38, 14);
		panel.add(lblTexto);

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(25, 18, 28, 14);
		panel.add(lblTipo);

		tipo = new JTextField();
		tipo.setColumns(10);
		tipo.setBounds(73, 15, 72, 20);
		panel.add(tipo);

		texto = new JTextField();
		texto.setColumns(10);
		texto.setBounds(73, 40, 238, 20);
		panel.add(texto);

		// se prepara el escuchador del boton
		// que permite el envio del mensaje
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(126, 189, 89, 23);
		obPanel1.add(btnEnviar);
		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				enviarYrecibirMensaje();
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
		        new TitledBorder(null, "Recibido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(37, 223, 333, 115);
		obPanel1.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("Tipo");
		label.setBounds(10, 23, 28, 14);
		panel_1.add(label);

		JLabel label_1 = new JLabel("Texto");
		label_1.setBounds(10, 48, 39, 14);
		panel_1.add(label_1);

		JLabel lblRemit = new JLabel("Remit...");
		lblRemit.setBounds(10, 76, 39, 14);
		panel_1.add(lblRemit);

		tipoRec = new JTextField();
		tipoRec.setEditable(false);
		tipoRec.setColumns(10);
		tipoRec.setBounds(66, 20, 72, 20);
		panel_1.add(tipoRec);

		textoRec = new JTextField();
		textoRec.setEditable(false);
		textoRec.setColumns(10);
		textoRec.setBounds(66, 45, 238, 20);
		panel_1.add(textoRec);

		rem = new JTextField();
		rem.setEditable(false);
		rem.setColumns(10);
		rem.setBounds(66, 73, 238, 20);
		panel_1.add(rem);
	}

	/**
	 * method enviarYrecibirMensaje() Gestiona los metodos necesarios para el
	 * envio de mensajes y procesa el envio y la recepcion de respuestas
	 *
	 * @param Ninguno.
	 * @return Ninguno.
	 */
	public void enviarYrecibirMensaje() {
		try {
			// coger tipo y texto
			int tipoD = Integer.parseInt(tipo.getText());
			String textoD = texto.getText();

			// coger el ip y puerto
			InetAddress ipD = InetAddress.getByName(ipNo.getText());
			int puertoD = Integer.parseInt(puerto.getText());

			// ******** ENVIO DE MENSAJE
			// Crear objeto para enviar
			Mensaje mensajes = new Mensaje(tipoD, textoD);

			// Convertir el objeto en ByteArray
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(baos);
			os.writeObject(mensajes);
			os.flush();
			os.close();
			byte[] datos = baos.toByteArray();

			DatagramSocket ds = new DatagramSocket();
			// guardar mensaje
			DatagramPacket dp = new DatagramPacket(datos, datos.length, ipD, puertoD);
			// enviar mensaje
			ds.send(dp);

			// ******** RECIBIR MENSAJE
			// crear otro DATAGRAMPACKET para guardar lo que ha recibido
			byte[] mensaje = new byte[50000];
			DatagramPacket rec = new DatagramPacket(mensaje, mensaje.length);
			ds.receive(rec);

			// convertir y leer el byteArray en objeto mensaje
			ByteArrayInputStream bai = new ByteArrayInputStream(rec.getData());
			ObjectInputStream ois = new ObjectInputStream(bai);

			// crear objeto donde recibie el mensaje, y leerlo
			Mensaje mensajeObj;
			mensajeObj = (Mensaje) ois.readObject();

			// coger los datos para visualizar luego en la pantalla
			String ipYport = rec.getAddress() + " (" + rec.getPort() + ")";
			String textoR = mensajeObj.texto;
			int tipoR = mensajeObj.tipo;

			// visualizar en la pantalla los datos
			tipoRec.setText(String.valueOf(tipoR));
			textoRec.setText(textoR);
			rem.setText(ipYport);

			ois.close();
			ds.close();

		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SocketException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
