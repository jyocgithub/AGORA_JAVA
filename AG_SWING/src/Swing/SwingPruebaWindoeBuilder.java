package Swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingPruebaWindoeBuilder extends JFrame {
	public SwingPruebaWindoeBuilder () {
		getContentPane ().setLayout (new FlowLayout (FlowLayout.CENTER, 5, 5));

		JPanel panel_1 = new JPanel ();
		getContentPane ().add (panel_1);

		JLabel lblNewLabel = new JLabel ("New label");
		panel_1.add (lblNewLabel);

		JButton btnNewButton = new JButton ("New button");
		panel_1.add (btnNewButton);

		JPanel panel = new JPanel ();
		getContentPane ().add (panel);
	}

}
