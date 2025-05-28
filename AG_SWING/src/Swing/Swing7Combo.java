package Swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Swing7Combo {
	public static void main (String[] args) {
		JMiVentanaConCombos miVentana = new JMiVentanaConCombos ("Mi Ventana", 300, 300, 300, 300);
	}
}

class JMiVentanaConCombos extends JFrame {
	// Constructor
	@SuppressWarnings ("unchecked")
	public JMiVentanaConCombos (String titulo, int x, int y, int ancho, int alto) {
		super (titulo);
		this.setBounds (x, y, ancho, alto);
		this.setDefaultCloseOperation (WindowConstants.DISPOSE_ON_CLOSE);
		this.setLayout (new FlowLayout ());



		@SuppressWarnings ("rawtypes")

//		DefaultComboBoxModel cbmodel = new DefaultComboBoxModel ();// Creamos el modelo y añadimos elementos
//		cbmodel.addElement ("Violin");
//		cbmodel.addElement ("Viola");
//		cbmodel.addElement ("Cello");
//		cbmodel.addElement ("ContraBajo");
//
//		@SuppressWarnings ("rawtypes")
//
//		final JComboBox cbInstrumentos = new JComboBox (cbmodel);// Creamos el comboBox con el modelo, y decidimos el valor inicial seleccionado
//		cbInstrumentos.setSelectedIndex (0);
//
//
//		JScrollPane scrollCbInstrumentos = new JScrollPane (cbInstrumentos);// Creamos el contenedor con scroll y añadimos el comboBox
//
//
//		JButton boton1 = new JButton ("Elegir");// Creamos un boton para gestionar una accion
//		boton1.addActionListener (new ActionListener () {
//			@Override
//			public void actionPerformed (ActionEvent e) {
//				String data = "";
//				if (cbInstrumentos.getSelectedIndex () != -1) {
//
//					String res = (String) cbInstrumentos.getSelectedItem ();// sacamos el valor seleccionado en el combo
//					etiqueta.setText (res);
//				}
//			}
//		});




//		JLabel etiqueta = new JLabel ();
//
//		final JCheckBox chkAzul = new JCheckBox ("Azul");
//		final JCheckBox chkRojo = new JCheckBox ("Rojo");
//		final JCheckBox chkVerde = new JCheckBox ("Verde");
//
//		chkAzul.setMnemonic (KeyEvent.VK_C);
//
//		chkAzul.addItemListener (new ItemListener () {
//			@Override
//			public void itemStateChanged (ItemEvent e) {
//				etiqueta.setText ("Azul elegido como: " + (e.getStateChange () == 1 ? "seleccionado" : "no seleccionado"));
//			}
//		});
//
//
//		// Añadimos elementos al contexto
//		this.getContentPane ().add (chkAzul);
//		this.getContentPane ().add (chkRojo);
//		this.getContentPane ().add (chkVerde);
//		this.getContentPane ().add (etiqueta);

		JLabel etiqueta = new JLabel ("CONTENIDO;", JLabel.RIGHT);
		final JTextArea txaArea = new JTextArea ("En un lugar de la Mancha ... ", 5, 20);
		JScrollPane scrollArea = new JScrollPane (txaArea);
		JButton btCambiar = new JButton ("Cambiar");
		btCambiar.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				etiqueta.setText (txaArea.getText ());
			}
		});

		this.getContentPane ().add (scrollArea);
		this.getContentPane ().add (btCambiar);
		this.getContentPane ().add (etiqueta);

		// Hacemos visible la ventana. No hace falta hacer visibles sus elementos
		this.setVisible (true);

	}
}