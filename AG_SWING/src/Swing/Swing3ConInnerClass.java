package Swing;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class Swing3ConInnerClass {
	public static void main (String[] args) {
		JMiVentana24 miVentana = new JMiVentana24 ("Mi Ventana", 500, 500, 500, 500);
	}
}

//class EscuchadorBoton1 implements ActionListener {
//	@Override
//	public void actionPerformed (ActionEvent ev) {
//		// AQUI VIENE EL CÓDIGO A EJECUTAR CUANDO SE PINCHE EN EL BOTON
//		JOptionPane.showMessageDialog (null, "Ha pulsado un boton !", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
//	}
//}

class JMiVentana24 extends JFrame {
	// Constructor
	public JMiVentana24 (String titulo, int x, int y, int ancho, int alto) {
		super (titulo);
		this.setBounds (x, y, ancho, alto);
		this.setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout (null);

		// Creo un boton1
		JButton miBoton17 = new JButton ("Pulse desde el JFrame tranquilamente");
		miBoton17.setBounds (2, 2, 200, 40);
		miBoton17.addActionListener (new EscuchadorBoton1 () {
			@Override
			public void actionPerformed (ActionEvent ev) {
				// AQUI VIENE EL CÓDIGO A EJECUTAR CUANDO SE PINCHE EN EL BOTON
				JOptionPane.showMessageDialog (null, "Cuidado, ha pulsado un boton !", "Cuidado", JOptionPane.INFORMATION_MESSAGE);
			}
		}


		);


		final JRadioButton radViolin = new JRadioButton ("Violín", true);
		final JRadioButton radViola = new JRadioButton ("Viola");
		final JRadioButton radCello = new JRadioButton ("Violoncello");


		ButtonGroup grInstrumentos = new ButtonGroup ();
		grInstrumentos.add (radViolin);
		grInstrumentos.add (radViola);
		grInstrumentos.add (radCello);

		this.getContentPane ().add (radViolin);
		this.getContentPane ().add (radViola);
		this.getContentPane ().add (radCello);


		radViolin.addItemListener (new ItemListener () {
			@Override
			public void itemStateChanged (ItemEvent e) {
				miBoton17.setText ("Asi esta el check:: " + (e.getStateChange () == 1 ? "Pulsado" : "No pulsado"));
			}
		});
		radViolin.setMnemonic (KeyEvent.VK_C);

		radViolin.addItemListener (new ItemListener () {
			@Override
			public void itemStateChanged (ItemEvent e) {
				miBoton17.setText ("Asi esta el check:: " + (e.getStateChange () == 1 ? "Pulsado" : "No pulsado"));
			}
		});

		// Añadimos elementos
		// Puedo añadir elementos directamente en la Frame, con getContentPane
		this.getContentPane ().add (miBoton17); // añado el boton1

		// Hacemos visible la ventana. No hace falta hacer visibles sus elementos
		this.setVisible (true);
	}
}