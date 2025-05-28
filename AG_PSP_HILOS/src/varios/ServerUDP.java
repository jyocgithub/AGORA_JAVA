package varios;

import java.awt.EventQueue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ServerUDP extends JFrame {

	private JPanel contentPane;
	private static JTextArea mensajesRec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ServerUDP frame = new ServerUDP();
					frame.setVisible(true);
					recibiryYenviarDatos();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerUDP() {
		setTitle(" UDP Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMensajesRecibidos = new JLabel("Mensajes Recibidos");
		lblMensajesRecibidos.setBounds(10, 11, 127, 14);
		contentPane.add(lblMensajesRecibidos);

		mensajesRec = new JTextArea();
		mensajesRec.setBounds(10, 36, 414, 214);
		contentPane.add(mensajesRec);
	}

	public static void recibiryYenviarDatos() {
		try {
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			DatagramSocket ds = new DatagramSocket(addr);

			// guardar el mensaje recibido en datagrampacket
			byte[] mensaje = new byte[50000];
			DatagramPacket dp1 = new DatagramPacket(mensaje, mensaje.length);
			ds.receive(dp1);

			// convertir el BYTEARRAY en objeto mensaje y luego leer
			ByteArrayInputStream bai = new ByteArrayInputStream(dp1.getData());
			ObjectInputStream ois = new ObjectInputStream(bai);

			Mensaje mensajeObj;
			mensajeObj = (Mensaje) ois.readObject();

			// visualizar en la pantalla
			String textMenRec = dp1.getAddress() + " " + "(" + dp1.getPort() + ")" + ": " + mensajeObj.tipo + "- "
					+ mensajeObj.texto;
			mensajesRec.setText(textMenRec);
			ois.close();

			// modifcar el mensaje
			Mensaje responder = new Mensaje(mensajeObj.tipo + 100, mensajeObj.texto.toUpperCase());

			// convertir el mensaje en bytearray
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(baos);
			os.writeObject(responder);
			os.flush();
			os.close();
			byte[] datosRes = baos.toByteArray();

			// crear otro datagrampacket para mandar el mensaje
			DatagramPacket dp2 = new DatagramPacket(datosRes, datosRes.length, dp1.getAddress(), dp1.getPort());
			ds.send(dp2);
			ds.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
