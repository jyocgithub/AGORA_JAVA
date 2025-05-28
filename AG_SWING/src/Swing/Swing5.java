package Swing;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Swing5 {
	public static void main (String[] args) {
		JMiVentanaConLayouts miVentana = new JMiVentanaConLayouts ("Mi Ventana", 300, 300, 300, 300);
	}
}

class JMiVentanaConLayouts extends JFrame {
	// Constructor
	public JMiVentanaConLayouts (String titulo, int x, int y, int ancho, int alto) {
		super (titulo);
		this.setBounds (x, y, ancho, alto);
		this.setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout (new BorderLayout ());


		// Creo botones
		JButton miBoton1 = new JButton ("UNO");
		miBoton1.setPreferredSize (new Dimension (80, 40));
		JButton miBoton2 = new JButton ("DOS");
		miBoton2.setPreferredSize (new Dimension (80, 40));
		JButton miBoton3 = new JButton ("TRES");
		miBoton3.setPreferredSize (new Dimension (80, 40));
		JButton miBoton4 = new JButton ("CUATRO");
		miBoton4.setPreferredSize (new Dimension (80, 40));
		JButton miBoton5 = new JButton ("CINCO");
		miBoton5.setPreferredSize (new Dimension (80, 40));

		// Añadimos elementos
		this.getContentPane ().add (miBoton1, BorderLayout.PAGE_START);
		this.getContentPane ().add (miBoton2, BorderLayout.LINE_START);
		this.getContentPane ().add (miBoton3, BorderLayout.CENTER);
		this.getContentPane ().add (miBoton4, BorderLayout.LINE_END);
		this.getContentPane ().add (miBoton5, BorderLayout.PAGE_END);

		// Hacemos visible la ventana. No hace falta hacer visibles sus elementos
		this.setVisible (true);

	}
}