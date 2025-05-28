package Swing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Swing6_JList {
	public static void main (String[] args) {
		EjemploJLIst obEjemploList = new EjemploJLIst ();
		obEjemploList.inicializarGUI ();
		obEjemploList.mostrarJList ();
	}
}

class EjemploJLIst {
	private JFrame	jfMiVentana;
	private JLabel	lblCabecera, lblPie;
	private JPanel	jpMiPanel;

	public void inicializarGUI () {
		jfMiVentana = new JFrame ("Ejemplo de JList");
		jfMiVentana.setSize (300, 300);
		jfMiVentana.setLayout (new GridLayout (3, 1));
		lblCabecera = new JLabel ("", JLabel.CENTER);
		lblPie = new JLabel ("", JLabel.CENTER);
		lblPie.setSize (250, 100);
		jpMiPanel = new JPanel ();
		jpMiPanel.setLayout (new FlowLayout ());
		jfMiVentana.add (lblCabecera);
		jfMiVentana.add (jpMiPanel);
		jfMiVentana.add (lblPie);
		jfMiVentana.setVisible (true);
	}

	@SuppressWarnings ({ "unchecked", "rawtypes" })
	public void mostrarJList () {
		lblCabecera.setText ("Seleccione una fruta del JList");

		final DefaultListModel frutas = new DefaultListModel ();
		frutas.addElement ("Manzana");
		frutas.addElement ("Pera");
		frutas.addElement ("Naranja");
		frutas.addElement ("Sandia");

		final JList listaFrutas = new JList (frutas);
		listaFrutas.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
		listaFrutas.setSelectedIndex (0);
		listaFrutas.setVisibleRowCount (3);

		JScrollPane frutasScrollPane = new JScrollPane (listaFrutas);
		JButton boton1 = new JButton ("Elegir");

		boton1.addActionListener (new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				String data = "";
				if (listaFrutas.getSelectedIndex () != -1) {
					data = "Fruta elegida: " + listaFrutas.getSelectedValue ();
				}
				lblPie.setText (data);
			}
		});

		jpMiPanel.add (frutasScrollPane);
		jpMiPanel.add (boton1);
		jfMiVentana.setVisible (true);
	}
}

