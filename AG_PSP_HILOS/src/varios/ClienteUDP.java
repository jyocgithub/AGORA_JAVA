package varios;

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

public class ClienteUDP extends JFrame {

	private JPanel contentPane;
	private JLabel lblTexto;
	private JLabel lblTipo;
	private JTextField ipNo;
	private JTextField puerto;
	private JTextField tipo;
	private JTextField texto;
	private JTextField tipoRec;
	private JTextField textoRec;
	private JTextField rem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ClienteUDP frame = new ClienteUDP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClienteUDP() {
		setTitle("UDP CLIENTE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ipNo = new JTextField();
		ipNo.setBounds(126, 21, 145, 20);
		contentPane.add(ipNo);
		ipNo.setColumns(10);

		JLabel lblNewLabel = new JLabel("Ip o No...");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(37, 24, 89, 14);
		contentPane.add(lblNewLabel);

		JLabel lblPuerto = new JLabel("Puerto");
		lblPuerto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPuerto.setBounds(37, 64, 89, 14);
		contentPane.add(lblPuerto);

		puerto = new JTextField();
		puerto.setColumns(10);
		puerto.setBounds(126, 62, 145, 20);
		contentPane.add(puerto);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "A Enviar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(30, 117, 340, 72);
		contentPane.add(panel);
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

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(126, 189, 89, 23);
		contentPane.add(btnEnviar);
		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				enviarYrecibirMensaje();
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Recibido", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(37, 223, 333, 115);
		contentPane.add(panel_1);
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

	public void enviarYrecibirMensaje() {
		try {
			// coger tipo y texto
			int tipoD = Integer.parseInt(tipo.getText());
			String textoD = texto.getText();

			// coger el ip y puerto
			InetAddress ipD = InetAddress.getByName(ipNo.getText());
			int puertoD = Integer.parseInt(puerto.getText());

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

			///// Recibir

			// crear otro DATAGRAMPACKET para guardar lo que ha recibido
			byte[] mensaje = new byte[50000];
			DatagramPacket rec = new DatagramPacket(mensaje, mensaje.length);
			ds.receive(rec);

			// convertir y leer el byteArray en objeto mensaje
			ByteArrayInputStream bai = new ByteArrayInputStream(rec.getData());
			ObjectInputStream ois = new ObjectInputStream(bai);

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
