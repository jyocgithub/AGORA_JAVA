package Swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Swing4 {
	public static void main (String[] args) {
		JMiVentana2 miVentana = new JMiVentana2 ("Mi Ventana", 300, 300, 300, 300);
	}
}

class EscuchadorBoton4 implements ActionListener {
	@Override
	public void actionPerformed (ActionEvent ev) {
		// AQUI VIENE EL CÓDIGO A EJECUTAR CUANDO SE PINCHE EN EL BOTON
		JOptionPane.showMessageDialog (null, "Ha pulsado un boton !", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
	}
}

class JMiVentana4 extends JFrame {
	// Constructor
	public JMiVentana4 (String titulo, int x, int y, int ancho, int alto) {
		super (titulo);
		this.setBounds (x, y, ancho, alto);
		this.setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout (null);

		// Creo un JPanel
		JPanel jp = new JPanel ();
		jp.setBounds (50, 50, 290, 290);

		// Creo un boton1
		JButton miBoton1 = new JButton ("Pulse desde el JFrame");
		miBoton1.setBounds (2, 2, 200, 40);
		miBoton1.addActionListener (new EscuchadorBoton4 ());
		// Creo un boton2
		JButton miBoton2 = new JButton ("Pulse aqui desde el JPanel");
		miBoton2.setPreferredSize (new Dimension (200, 40));
		miBoton2.addActionListener (new EscuchadorBoton4 ());

		// Añadimos elementos
		// Puedo añadir elementos directamente en la Frame, con getContentPane
		this.getContentPane ().add (miBoton1); // añado el boton1
		this.add (jp); // añado el JPanel
		// o añadir elementos en el JPanel creado
		jp.add (miBoton2); // añado el boton2

		// Hacemos visible la ventana. No hace falta hacer visibles sus elementos
		this.setVisible (true);
		// miBoton1.setVisible (true);
		// miBoton2.setVisible (true);
	}
}