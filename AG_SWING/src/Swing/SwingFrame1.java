package Swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class SwingFrame1 {

	public static void main (String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater (new Runnable () {
			@Override
			public void run () {
				// lanzarVentana1();
				MiVentana miVentana = new MiVentana ("HOLA");
				miVentana.setVisible (true);
			}
		});
	}

	/**
	 * Create the GUI and show it. For thread safety,
	 * this method should be invoked from the
	 * event-dispatching thread.
	 */
	private static void lanzarVentana1 () {
		// Creamos una venata
		JFrame frame = new JFrame ("Una ventana frame");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		// // Create the menu bar. Make it have a green background.
		// JMenuBar greenMenuBar = new JMenuBar();
		// greenMenuBar.setOpaque(true);
		// greenMenuBar.setBackground(new Color(154, 165, 127));
		// greenMenuBar.setPreferredSize(new Dimension(200, 20));


		// Set the menu bar and add the label to the content pane.
		// // frame.setJMenuBar(greenMenuBar);
		// JLabel etColorCyan = new JLabel ();
		// etColorCyan.setOpaque (true);
		// etColorCyan.setBackground (Color.GREEN);
		// etColorCyan.setPreferredSize (new Dimension (200, 180));
		// etColorCyan.setText ("Texto del label");
		// Content con = (Content) frame.getContentPane ();
		// frame.getContentPane ().add (etColorCyan, BorderLayout.CENTER);

		// Display the window.
		frame.pack ();
		frame.setVisible (true);
	}

}

class EscuchadorBoton implements ActionListener { // creo escuchador que implementa de actionlistener
	@Override
	public void actionPerformed (ActionEvent arg0) { // sobreescribo método actionperformed
		JButton jb = (JButton) arg0.getSource (); // arg0 representa el objeto sobre el que se actuó
		JOptionPane.showMessageDialog (null, "! Ha pulsado !", "Aviso", JOptionPane.WARNING_MESSAGE);
	}
}

class MiVentana extends JFrame { // Creo una clase que sera mi contenedor principal
	public MiVentana (String titulo) { // Constructor de la clase
		super (titulo); // llamo al constructor del superclase
		// valores de la MiVentana
		this.setBounds (2, 2, 400, 400); // doy tamaño a la ventana
		this.setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);

		// Valores del panel contenedor
		JPanel jp = new JPanel ();

		// Valores de un boton
		JButton jb = new JButton ("Pulsar aqui");
		jb.setPreferredSize (new Dimension (100, 40));
		jb.addActionListener (new EscuchadorBoton ()); // añadimos el escuchador al botón


		// Create a yellow label to put in the content pane.
		JLabel etColorCyan = new JLabel ();
		etColorCyan.setOpaque (true);
		etColorCyan.setBackground (Color.GREEN);
		etColorCyan.setPreferredSize (new Dimension (200, 40));
		etColorCyan.setText ("Texto del label");


		// añadimos todo a la ventana
		this.add (jp);
		jp.add (etColorCyan);
		jp.add (jb);

		// hacemos visible la ventana contenedora
		this.setVisible (true);




	}
}
