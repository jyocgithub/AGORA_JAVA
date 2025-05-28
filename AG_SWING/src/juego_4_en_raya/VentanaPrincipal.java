package juego_4_en_raya;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaPrincipal {
	int matrizprueba[][] = new int[6][7];
	static VentanaPrincipal window;
	static String nombreusuario;
	static int colorusuario;
	static int colormaquina;
	static int numeroDelPrimero;
	JugadorMaquina maquina;
	JugadorPersona persona;
	Tablero tablero;
	// ------------------ ATRIBUTOS
	// ----------------------------------------
	public JFrame frmPrincipal;
	int colactual = 0;
	int numeroFichasPuestas;
	JLabel[] arrFichasPuestas;
	JLabel[] arrFichasCabeceras;
	JButton btnAyuda;
	JButton[] arrBtnTransp;
	int anchoVentana;
	int altoVentana;
	ImageIcon imagenDeInfo;
	ImageIcon imagenDefichaRoja;
	ImageIcon imagenDefichaAzul;
	ImageIcon imagenDefichaDeMiColorCabecera;
	JButton btnSeguir;

	public void reiniciar() {

		try {
			frmPrincipal.dispose();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					// nombreusuario = pedirNombreUsuario();
					// colorusuario = pedirColorUsuario();
					// if (colorusuario == 1)
					// {
					// colormaquina = 2;
					// } else
					// {
					// colormaquina = 1;
					// }
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// CONSTRUCTOR
	public VentanaPrincipal() {

		persona = new JugadorPersona(colorusuario, colormaquina);
		maquina = new JugadorMaquina(colormaquina, colorusuario);
		tablero = new Tablero();

		imagenDefichaRoja = new ImageIcon(leeImagen("FichaRoja.png"));
		imagenDefichaAzul = new ImageIcon(leeImagen("FichaAzul.png"));

		if (colorusuario == 2) {
			imagenDefichaDeMiColorCabecera = new ImageIcon(leeImagen("FichaAzulCabecera.png"));
		} else {
			imagenDefichaDeMiColorCabecera = new ImageIcon(leeImagen("FichaRojaCabecera.png"));
		}
		initialize();
		crearListeners();
	}

	// main
	// ----------------------------------------
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					nombreusuario = pedirNombreUsuario();
					colorusuario = pedirColorUsuario();
					numeroDelPrimero = quienEmpieza();
					if (colorusuario == 1) {
						colormaquina = 2;
					} else {
						colormaquina = 1;
					}
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// COÌ�DIGO A EJECUTAR CUANDO SE PINCHE EN EL BOTON
	public void pintarFicha(Posicion pos) {

		numeroFichasPuestas++;

		if (pos.getMicolor() == 1) {
			arrFichasPuestas[numeroFichasPuestas] = new JLabel(imagenDefichaRoja);
		} else {
			arrFichasPuestas[numeroFichasPuestas] = new JLabel(imagenDefichaAzul);

		}

		int posxSuperior = 220;
		int posySuperior = 130;

		int posy = posySuperior + (pos.getX() * 40);
		int posx = posxSuperior + (pos.getY() * 40);

		arrFichasPuestas[numeroFichasPuestas].setBounds(posx, posy, 33, 33);
		frmPrincipal.getContentPane().add(arrFichasPuestas[numeroFichasPuestas]);
		frmPrincipal.repaint();
	}

	/**
	 * Crea una BufferedImage desde un nombre de fichero de disco (en string)
	 * 
	 * @param nombre
	 * @return
	 */

	public static BufferedImage leeImagen(String nombre) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(nombre));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	private void initialize() {

		// Crear arrays e inicializar variables
		arrFichasCabeceras = new JLabel[7];
		arrFichasPuestas = new JLabel[100];
		arrBtnTransp = new JButton[7];
		anchoVentana = 800;
		altoVentana = 600;
		numeroFichasPuestas = 0;

		// ------------------ FRAME VENTANATABLERO
		// ----------------------------------------
		frmPrincipal = new JFrame();
		frmPrincipal.setBounds(100, 100, 800, 600);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.setResizable(false);
		frmPrincipal.setContentPane(new JLabel(new ImageIcon("FondoConSilla.png")));
		frmPrincipal.setLayout(null);

		// ------------------ BOTON AYUDA
		// ----------------------------------------
		imagenDeInfo = new ImageIcon("info.png");
		ImageIcon im = new ImageIcon(imagenDeInfo.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_DEFAULT));
		btnAyuda = new JButton("");
		btnAyuda.setBounds(10, 10, 20, 20);
		// btnAyuda.setOpaque(false);
		btnAyuda.setContentAreaFilled(false);
		btnAyuda.setBorderPainted(false);
		btnAyuda.setIcon(im);

		frmPrincipal.getContentPane().add(btnAyuda);

		// ------------------ BOTON SEGUIR
		// ----------------------------------------
		btnSeguir = new JButton("Reiniciar");
		btnSeguir.setBounds(700, 10, 70, 40);
		frmPrincipal.getContentPane().add(btnSeguir);

		// ------------------ IMAGENES TRANSPARENTES DE CABEZAS DE FICHA
		// ----------------------------------------
		for (int i = 0; i < 7; i++) {
			JLabel lblFichaCab = new JLabel(imagenDefichaDeMiColorCabecera);
			arrFichasCabeceras[i] = lblFichaCab;
			arrFichasCabeceras[i].setBounds(220 + (i * 40), 95, 33, 33);
			arrFichasCabeceras[i].setVisible(false);
			frmPrincipal.getContentPane().add(arrFichasCabeceras[i]);
			frmPrincipal.repaint();
		}

		// ------------------ BOTONES TRANSPARENTES DE DELANTE DE TABLERO
		// ----------------------------------------
		JButton cadab;
		for (colactual = 0; colactual < 7; colactual++) {
			colactual = colactual;
			cadab = new JButton("");
			arrBtnTransp[colactual] = cadab;
			arrBtnTransp[colactual].setBounds(220 + (40 * colactual), 130, 40, 250);
			arrBtnTransp[colactual].setOpaque(false);
			arrBtnTransp[colactual].setContentAreaFilled(false);
			arrBtnTransp[colactual].setBorderPainted(false);

			frmPrincipal.getContentPane().add(arrBtnTransp[colactual]);

		}

		if (numeroDelPrimero == 1) {
			movimientoMaquina();
		}

	}

	void ganar(int colorganador) {
		String ganador = (colorganador == colorusuario) ? nombreusuario : "MAQUINA";
		JOptionPane.showMessageDialog(null, " HA GANADO " + ganador);

		if (seguir1dejar0() == 0) {

			try {
				frmPrincipal.dispose();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					try {
						nombreusuario = pedirNombreUsuario();
						colorusuario = pedirColorUsuario();
						if (colorusuario == 1) {
							colormaquina = 2;
						} else {
							colormaquina = 1;
						}
						VentanaPrincipal window = new VentanaPrincipal();
						window.frmPrincipal.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else {
			System.exit(0);

		}

	}

	void movimientoUsuario(int col) {
		// movimiento del usuario
		tablero.actualizarPosiciones();
		Posicion apintar = tablero.jugarPersona(col, VentanaPrincipal.colorusuario);
		pintarFicha(apintar);
		if (tablero.chequeoGanador(apintar)) {
			ganar(colorusuario);
		}

	}

	void movimientoMaquina() {

		// movimineto de maquina
		tablero.actualizarPosiciones();
		Posicion apintar = maquina.JugarMaquina(tablero);
		pintarFicha(apintar);
		if (tablero.chequeoGanador(apintar)) {
			ganar(colormaquina);
		}
	}

	void crearListeners() {

		btnAyuda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				String textoAyuda = "AYUDA DE ESTE JUEGO";
				JOptionPane.showMessageDialog(null, textoAyuda, "AYUDA", JOptionPane.PLAIN_MESSAGE);

			}
		});

		arrBtnTransp[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				movimientoUsuario(0);
				movimientoMaquina();

			}
		});
		arrBtnTransp[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				movimientoUsuario(1);

				movimientoMaquina();
			}
		});
		arrBtnTransp[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				movimientoUsuario(2);

				movimientoMaquina();

			}
		});
		arrBtnTransp[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				movimientoUsuario(3);

				movimientoMaquina();

			}
		});
		arrBtnTransp[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				movimientoUsuario(4);

				movimientoMaquina();

			}
		});
		arrBtnTransp[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				movimientoUsuario(5);

				movimientoMaquina();

			}
		});
		arrBtnTransp[6].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				movimientoUsuario(6);

				movimientoMaquina();

			}
		});

		arrBtnTransp[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				arrFichasCabeceras[0].setVisible(true);
				// mostrarFichaCabeza(arrBotones[i], i);
			}

			@Override
			public void mouseExited(MouseEvent me) {
				arrFichasCabeceras[0].setVisible(false);
				// ocultarFichaCabeza(arrBotones[i], i);
			}

		});
		arrBtnTransp[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				arrFichasCabeceras[1].setVisible(true);
				// mostrarFichaCabeza(arrBotones[i], i);
			}

			@Override
			public void mouseExited(MouseEvent me) {
				arrFichasCabeceras[1].setVisible(false);
				// ocultarFichaCabeza(arrBotones[i], i);
			}

		});
		arrBtnTransp[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				arrFichasCabeceras[2].setVisible(true);
				// mostrarFichaCabeza(arrBotones[i], i);
			}

			@Override
			public void mouseExited(MouseEvent me) {
				arrFichasCabeceras[2].setVisible(false);
				// ocultarFichaCabeza(arrBotones[i], i);
			}

		});
		arrBtnTransp[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				arrFichasCabeceras[3].setVisible(true);
				// mostrarFichaCabeza(arrBotones[i], i);
			}

			@Override
			public void mouseExited(MouseEvent me) {
				arrFichasCabeceras[3].setVisible(false);
				// ocultarFichaCabeza(arrBotones[i], i);
			}

		});
		arrBtnTransp[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				arrFichasCabeceras[4].setVisible(true);
				// mostrarFichaCabeza(arrBotones[i], i);
			}

			@Override
			public void mouseExited(MouseEvent me) {
				arrFichasCabeceras[4].setVisible(false);
				// ocultarFichaCabeza(arrBotones[i], i);
			}

		});
		arrBtnTransp[5].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				arrFichasCabeceras[5].setVisible(true);
				// mostrarFichaCabeza(arrBotones[i], i);
			}

			@Override
			public void mouseExited(MouseEvent me) {
				arrFichasCabeceras[5].setVisible(false);
				// ocultarFichaCabeza(arrBotones[i], i);
			}

		});
		arrBtnTransp[6].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent me) {
				arrFichasCabeceras[6].setVisible(true);
				// mostrarFichaCabeza(arrBotones[i], i);
			}

			@Override
			public void mouseExited(MouseEvent me) {
				arrFichasCabeceras[6].setVisible(false);
				// ocultarFichaCabeza(arrBotones[i], i);
			}

		});

		// ******************************************** para ver las posiciones del
		// // nouse en pantalla
		// frmPrincipal.addMouseMotionListener(new MouseAdapter()
		// {
		// @Override
		// public void mouseMoved(MouseEvent me)
		// {
		// btnSeguir.setText(me.getX() + ":" + me.getY());
		// }
		// });

		btnSeguir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ev) {
				reiniciar();
			}
		});
	}

	public static String pedirNombreUsuario() {
		String nom = JOptionPane.showInputDialog(null, "Introduzca nombre de usuario:", "Introducir nombre:",
				JOptionPane.PLAIN_MESSAGE);
		return nom;
	}

	public static int pedirColorUsuario() {
		Object[] colores = { "Rojo", "Azul" };
		int valorElegido = JOptionPane.showOptionDialog(null, // parentComponent, basta con null
				"Escoja un color de la lista", // mensaje
				"Ventana para elegir un color", // titulo de ventana
				JOptionPane.YES_NO_CANCEL_OPTION, // opciones de acciones
				JOptionPane.QUESTION_MESSAGE, // tipo de mensaje
				null, // icono. null para icono por defecto
				colores, // opciones de texto
				colores[1]); // opcion por defecto
		return valorElegido + 1;
	}

	public static int seguir1dejar0() {
		Object[] opciones = { "SI", "NO" };
		int valorElegido = JOptionPane.showOptionDialog(null, // parentComponent, basta con null
				"¿Otra partida?", // mensaje
				"CONFIRMACION", // titulo de ventana
				JOptionPane.YES_NO_CANCEL_OPTION, // opciones de acciones
				JOptionPane.QUESTION_MESSAGE, // tipo de mensaje
				null, // icono. null para icono por defecto
				opciones, // opciones de texto
				opciones[0]); // opcion por defecto
		return valorElegido;
	}

	public static int quienEmpieza() {
		Object[] opciones = { "USUARIO", "MAQUINA", "AZAR" };
		int valorElegido = JOptionPane.showOptionDialog(null, // parentComponent, basta con null
				"¿Quien quieres que empiece?", // mensaje
				"EMPEZAR", // titulo de ventana
				JOptionPane.YES_NO_CANCEL_OPTION, // opciones de acciones
				JOptionPane.QUESTION_MESSAGE, // tipo de mensaje
				null, // icono. null para icono por defecto
				opciones, // opciones de texto
				opciones[0]); // opcion por defecto

		if (valorElegido == 2) {
			Random r = new Random();
			valorElegido = r.nextInt(2);
		}
		return valorElegido;
	}

}
