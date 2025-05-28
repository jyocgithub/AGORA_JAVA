package Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Swing3 {
	public static void main (String[] args) {
		JMiVentana2 miVentana = new JMiVentana2 ("Mi Ventana", 300, 300, 300, 300);
	}
}

class EscuchadorBoton1 implements ActionListener {
	@Override
	public void actionPerformed (ActionEvent ev) {
		// AQUI VIENE EL CÓDIGO A EJECUTAR CUANDO SE PINCHE EN EL BOTON
		JOptionPane.showMessageDialog (null, "Ha pulsado un boton !", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
	}
}

class JMiVentana2 extends JFrame { 
	// Constructor
	public JMiVentana2 (String titulo, int x, int y, int ancho, int alto) {
		super (titulo);
		this.setBounds (x, y, ancho, alto);
		this.setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout (null);

		// Creo un boton1
		JButton miBoton1 = new JButton ("Pulse desde el JFrame");
		miBoton1.setBounds (2, 2, 200, 40);
		miBoton1.addActionListener (new EscuchadorBoton1 ());

		// Añadimos elementos
		// Puedo añadir elementos directamente en la Frame, con getContentPane
		this.getContentPane ().add (miBoton1); // añado el boton1

		// Hacemos visible la ventana. No hace falta hacer visibles sus elementos
		this.setVisible (true);
	}
}