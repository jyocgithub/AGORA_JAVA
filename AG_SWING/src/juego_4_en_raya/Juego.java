package juego_4_en_raya;

import java.awt.EventQueue;

public class Juego {

	static VentanaPrincipal window;
	static String nombreusuario;
	static int colorusuario;
	static int colormaquina;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					window = new VentanaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
