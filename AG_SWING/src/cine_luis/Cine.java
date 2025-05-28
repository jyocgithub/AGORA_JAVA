package cine_luis;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class Cine {

	// Atributos de la clase
	static Double recaudacionCine = 0.0;
	static double recaudacionSala[];
	static double recaudacionSesion[][];
	static byte[][][][] matriz;
	static boolean[][] enCurso;
	static int numproyeccion[][];
	static byte[][] plantillaSala0 = { { 3, 0, 0, 0, 0, 0, 3, 3, 3 }, { 0, 0, 0, 0, 0, 0, 3, 3, 3 },
			{ 0, 0, 0, 0, 0, 3, 3, 3, 3 }, { 0, 0, 0, 0, 0, 3, 3, 3, 3 }, { 0, 0, 0, 0, 0, 3, 3, 3, 3 },
			{ 0, 0, 0, 0, 0, 3, 3, 3, 3 }, { 0, 0, 0, 0, 0, 3, 3, 3, 3 }, { 3, 0, 0, 0, 3, 3, 3, 3, 3 },
			{ 3, 3, 3, 3, 3, 3, 3, 3, 3 }, { 3, 3, 3, 3, 3, 3, 3, 3, 3 } };

	static byte[][] plantillaSala1 = { { 3, 0, 0, 0, 0, 0, 0, 0, 3 }, { 3, 0, 0, 0, 0, 0, 0, 0, 3 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 3 }, { 0, 0, 0, 0, 0, 0, 0, 0, 3 }, { 0, 0, 0, 0, 0, 0, 0, 3, 3 },
			{ 0, 0, 0, 0, 0, 0, 3, 3, 3 }, { 0, 0, 0, 0, 0, 0, 3, 3, 3 }, { 3, 0, 0, 0, 0, 0, 3, 3, 3 },
			{ 3, 3, 0, 0, 0, 0, 3, 3, 3 }, { 3, 3, 0, 0, 0, 3, 3, 3, 3 } };

	static byte[][] plantillaSala2 = { { 3, 3, 0, 0, 0, 3, 3, 3, 3 }, { 0, 0, 0, 0, 0, 0, 3, 3, 3 },
			{ 0, 0, 0, 0, 0, 0, 3, 3, 3 }, { 0, 0, 0, 0, 0, 0, 0, 3, 3 }, { 0, 0, 0, 0, 0, 0, 0, 3, 3 },
			{ 0, 0, 0, 0, 0, 0, 0, 3, 3 }, { 0, 0, 0, 0, 0, 0, 0, 3, 3 }, { 0, 0, 0, 0, 0, 0, 0, 3, 3 },
			{ 0, 0, 3, 3, 3, 3, 3, 3, 3 }, { 3, 3, 3, 3, 3, 3, 3, 3, 3 } };

	final int ENCURSO = 0;
	final int RESERVANDO = 1;
	final int VENDIENDO = 2;
	final int SELECCIONANDO = 3;
	final double PRECIOMANANA = 4.20;
	final double PRECIOTARDE = 5.80;

	int numSala;
	int numSesion;
	double precios[];
	int estado;
	int numEntradas;
	int filaActual;
	int columnaActual;

	public JFrame frame;
	public MiTabla tableSalaCine;
	JLabel labelSala;
	JLabel labelProyeccion;
	TextArea informacionDinero;
	ImageIcon sillaVerde = new ImageIcon("sillaverde.png");
	ImageIcon sillaRoja = new ImageIcon("sillaroja.png");
	ImageIcon sillaAmarilla = new ImageIcon("sillaamarilla.png");
	ImageIcon sillaVacia = new ImageIcon("sillavacia.png");
	ImageIcon[][] imagenesSesion = new ImageIcon[3][2];
	Object[][] contenidoSala;
	ModeloNoEditable miModelo;
	String[] cabeceras;
	JLabel fondoPelicula;
	JLabel textoEntrada;
	JLabel stickman;
	JLabel fondoEntrada;
	JLayeredPane layeredPaneFondoBillete;
	JCheckBox botonSesion;

	/**
	 * Constructor
	 * 
	 * @param numSala numero de la sala a crear
	 * @param matriz  matriz de butacas con todas las salas y sesiones 
	 */
	public Cine(int numSala, byte[][][][] matriz) {

		this.numSala = numSala;
		this.matriz = matriz;
		this.numproyeccion = new int[3][2];
		this.recaudacionSala = new double[3];
		this.recaudacionSesion = new double[3][2];
		this.precios = new double[2];
		precios[0] = PRECIOMANANA;
		precios[1] = PRECIOTARDE;

		imagenesSesion[0][0] = new ImageIcon("vdevendeta.jpg");
		imagenesSesion[0][1] = new ImageIcon("300.jpg");
		imagenesSesion[1][0] = new ImageIcon("vdevendeta.jpg");
		imagenesSesion[1][1] = new ImageIcon("300.jpg");
		imagenesSesion[2][0] = new ImageIcon("vdevendeta.jpg");
		imagenesSesion[2][1] = new ImageIcon("300.jpg");

		inicializarSala();

		initialize();

		pintarPlano();
	}

	/**
	 * initialize()
	 * 
	 * Inicializa los elementos del Frame
	 */
	private void initialize() {

		// ************************************************
		// ************************************* VENTANA
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 102, 0));
		frame.setBounds(100, 100, 885, 697);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// -- Centra el frame en la pantalla
		frame.setLocationRelativeTo(null);

		// ************************************************
		// ************************************* JTABLE DEL CINE
		// Datos de la tabla
		contenidoSala = new Object[10][9];
		for (int f = 0; f < 10; f++) {
			for (int c = 0; c < 9; c++) {
				contenidoSala[f][c] = " ";
			}
		}
		cabeceras = new String[] { "", "", "", "", "", "", "", "", "" };
		// -- Para hacer la celdas no editables, lo hago con una clase propia
		// -- que herede de DefaultTableModelo, o como en el codigo comentado despues,
		// -- crear una DefaultTableModel con una clase sobrescrita directamente
		miModelo = new ModeloNoEditable(contenidoSala, cabeceras);

		// -- Para añadir un modelo a la JTable que permita imagenes,
		// -- puedo crear una clase JTable propia, o como en el codigo comentado
		// despues,
		// -- crear una JTable con una clase sobrescrita directamente
		tableSalaCine = new MiTabla(miModelo);

		// Se debe sleccionar solo una celda en la tabla
		tableSalaCine.setRowSelectionAllowed(false);
		tableSalaCine.setCellSelectionEnabled(true);
		// -- Definir el ancho de cada columna
		for (int i = 0; i < 9; i++) {
			tableSalaCine.getColumnModel().getColumn(i).setMaxWidth(10);
		}
		// -- Definir el alto de todas las filas iguales
		tableSalaCine.setRowHeight(35);
		// // -- Damos tamaño a la tabla
		tableSalaCine.setPreferredScrollableViewportSize(new Dimension(200, 300));
		// -- Evitamos que las columnas se hagan resize y se adaptane al tamaño del contenedor
		tableSalaCine.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// -- Colores de la table
		tableSalaCine.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		tableSalaCine.setBackground(Color.YELLOW);

		JScrollPane scrollPaneFondoCine = new JScrollPane(tableSalaCine);
		// -- Estas lineas son para mostrar los scrollbars siempre
		scrollPaneFondoCine.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneFondoCine.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPaneFondoCine.setBounds(91, 104, 100, 163);
		scrollPaneFondoCine.setBackground(new Color(51, 102, 0));
		JPanel paneFondoCine = new JPanel();
		paneFondoCine.setBounds(91, 104, 223, 363);
		paneFondoCine.add(scrollPaneFondoCine);
		frame.getContentPane().add(paneFondoCine);
		paneFondoCine.setBackground(new Color(51, 102, 0));
		// ************************************* FIN DE JTABLE DEL CINE

		// ************************************************
		// ************************************* BOTONES

		// --- RESERVAR
		JButton botonReservar = new JButton("Reservar");
		botonReservar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (hayDisponibles()) {
					reservar();
				} else {
					JOptionPane.showMessageDialog(null, "No existen tantas entradas junstas disponibles", "Aviso",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonReservar.setBounds(352, 116, 97, 25);
		frame.getContentPane().add(botonReservar);

		// --- ACEPTAR
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vender();
				pintarInformacionRecaudacion();
				pintarPlano();
			}
		});
		botonAceptar.setBounds(352, 154, 97, 25);
		frame.getContentPane().add(botonAceptar);

		// --- DENEGAR
		JButton botonDenegar = new JButton("Denegar");
		botonDenegar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				denegar();
			}
		});
		botonDenegar.setBounds(352, 192, 97, 25);
		frame.getContentPane().add(botonDenegar);

		// --- EN CURSO
		JButton botonEnCurso = new JButton("En curso");
		botonEnCurso.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// estado = ENCURSO;
				enCurso[numSala][numSesion] = true;
				pintarPlano();
			}
		});
		botonEnCurso.setBounds(352, 292, 97, 25);
		frame.getContentPane().add(botonEnCurso);

		// --- SIGUIENTE
		JButton botonSiguiente = new JButton("Siguiente");
		botonSiguiente.setBounds(352, 330, 97, 25);
		frame.getContentPane().add(botonSiguiente);
		botonSiguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (estado == SELECCIONANDO || estado == VENDIENDO) {

					numproyeccion[numSala][0]++;
					numproyeccion[numSala][1]++;

					if (numSala == 0) {
						// copiamos plantilla en matriz[0][0]
						for (int i = 0; i < plantillaSala0.length; i++) {
							matriz[0][0][i] = Arrays.copyOf(plantillaSala0[i], plantillaSala0[i].length);
						}

						// copiamos plantilla en matriz[0][1]
						for (int i = 0; i < plantillaSala0.length; i++) {
							matriz[0][1][i] = Arrays.copyOf(plantillaSala0[i], plantillaSala0[i].length);
						}
						enCurso[0][0] = false;
						enCurso[0][1] = false;
					}
					if (numSala == 1) {
						// copiamos plantilla en matriz[1][0]
						for (int i = 0; i < plantillaSala1.length; i++) {
							matriz[1][0][i] = Arrays.copyOf(plantillaSala1[i], plantillaSala1[i].length);
						}

						// copiamos plantilla en matriz[1][1]
						for (int i = 0; i < plantillaSala1.length; i++) {
							matriz[1][1][i] = Arrays.copyOf(plantillaSala1[i], plantillaSala1[i].length);
						}
						enCurso[1][0] = false;
						enCurso[1][1] = false;
					}
					if (numSala == 2) {
						// copiamos plantilla en matriz[2][0]
						for (int i = 0; i < plantillaSala2.length; i++) {
							matriz[2][0][i] = Arrays.copyOf(plantillaSala2[i], plantillaSala2[i].length);
						}

						// copiamos plantilla en matriz[2][1]
						for (int i = 0; i < plantillaSala2.length; i++) {
							matriz[2][1][i] = Arrays.copyOf(plantillaSala2[i], plantillaSala2[i].length);
						}
						enCurso[2][0] = false;
						enCurso[2][1] = false;
					}

					numSesion = 0;
					botonSesion.setSelected(false);
					pintarPlano();
				} else {
					JOptionPane.showMessageDialog(null, "No se puede cambiar proyeccion en mitad de un venta", "Aviso",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// --- GUARDAR
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ObjectOutputStream oos = null;
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream("DATOSCINE.DAT");
					oos = new ObjectOutputStream(fos);

					oos.writeObject(recaudacionCine);
					oos.writeObject(recaudacionSala);
					oos.writeObject(recaudacionSesion);
					oos.writeObject(enCurso);
					oos.writeObject(numproyeccion);
					oos.writeObject(matriz);
				} catch (IOException ex) {
					ex.printStackTrace();
				} finally {
					try {
						if (oos != null) {
							oos.close();
						}
						if (fos != null) {
							fos.close();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		botonGuardar.setBounds(166, 540, 97, 25);
		frame.getContentPane().add(botonGuardar);

		// --- CARGAR
		JButton botonCargar = new JButton("Cargar");
		botonCargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				ObjectInputStream ois = null;
				FileInputStream fis = null;
				try {
					fis = new FileInputStream("DATOSCINE.DAT");
					ois = new ObjectInputStream(fis);

					recaudacionCine = (Double) ois.readObject();
					recaudacionSala = (double[]) ois.readObject();
					recaudacionSesion = (double[][]) ois.readObject();
					enCurso = (boolean[][]) ois.readObject();
					numproyeccion = (int[][]) ois.readObject();
					matriz = (byte[][][][]) ois.readObject();

				} catch (IOException | ClassNotFoundException ex) {
					ex.printStackTrace();
				} finally {
					try {
						if (ois != null) {
							ois.close();
						}
						if (fis != null) {
							fis.close();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				pintarPlano();
				pintarInformacionRecaudacion();
			}
		});

		botonCargar.setBounds(166, 580, 97, 25);
		frame.getContentPane().add(botonCargar);

		// --- SALIR
		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object valores[] = { "si", "no" };
				int valor = JOptionPane.showOptionDialog(null, "¿ Realmente quiere salir ?", "aviso",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, valores, valores[0]);
				if (valor == 0) {
					System.exit(0);
				}
			}
		});
		botonSalir.setBounds(36, 626, 97, 25);
		frame.getContentPane().add(botonSalir);

		// --- NUM ENTRADAS COMBOBOX
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				numEntradas = comboBox.getSelectedIndex() + 1;
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(352, 63, 97, 25);
		frame.getContentPane().add(comboBox);

		// --- SESION CHECKBOX
		botonSesion = new JCheckBox("Sesion de tarde");
		botonSesion.setForeground(new Color(255, 215, 0));

		tableSalaCine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (tableSalaCine.isEnabled() == true) {
					columnaActual = tableSalaCine.getSelectedColumn();
					filaActual = tableSalaCine.getSelectedRow();
					estado = SELECCIONANDO;
				}
			}
		});
		botonSesion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (estado == SELECCIONANDO || estado == VENDIENDO) {
					if (numSesion == 0) {
						numSesion = 1;
					} else {
						numSesion = 0;
					}
					pintarPlano();
					pintarInformacionRecaudacion();

				} else {
					boolean comoestoy = botonSesion.isSelected();
					botonSesion.setSelected(!comoestoy);
					JOptionPane.showMessageDialog(null, "No se puede cambiar de sesion en mitad de un venta", "Aviso",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		botonSesion.setBounds(147, 456, 158, 43);
		frame.getContentPane().add(botonSesion);

		// ************************************************
		// ***************************** OTROS ELEMENTOS
		informacionDinero = new TextArea("", 1, 1, TextArea.SCROLLBARS_NONE);
		informacionDinero.setEditable(false);
		informacionDinero.setBackground(new Color(102, 204, 153));
		informacionDinero.setBounds(480, 315, 375, 130);
		frame.getContentPane().add(informacionDinero);

		labelSala = new JLabel("SALA :");
		labelSala.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelSala.setForeground(new Color(255, 255, 224));
		labelSala.setBounds(182, 61, 131, 25);
		frame.getContentPane().add(labelSala);

		labelProyeccion = new JLabel("SALA :");
		labelProyeccion.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		labelProyeccion.setForeground(new Color(255, 255, 224));
		labelProyeccion.setBounds(148, 81, 131, 25);
		frame.getContentPane().add(labelProyeccion);

		fondoPelicula = new JLabel("");
		fondoPelicula.setBounds(522, 44, 267, 243);
		frame.getContentPane().add(fondoPelicula);

		stickman = new JLabel("");
		stickman.setIcon(new ImageIcon("300.png"));
		stickman.setVisible(true);
		stickman.setBounds(10, 500, 103, 129);
		frame.getContentPane().add(stickman);

		layeredPaneFondoBillete = new JLayeredPane();
		layeredPaneFondoBillete.setBounds(480, 451, 375, 186);
		frame.getContentPane().add(layeredPaneFondoBillete);

		textoEntrada = new JLabel("");
		textoEntrada.setBounds(65, 27, 212, 125);
		layeredPaneFondoBillete.add(textoEntrada);

		fondoEntrada = new JLabel("");
		fondoEntrada.setIcon(new ImageIcon("entrada.png"));
		fondoEntrada.setBackground(Color.YELLOW);
		fondoEntrada.setBounds(0, 13, 375, 160);
		layeredPaneFondoBillete.add(fondoEntrada);

		JLabel lblNumeroDeEntradas = new JLabel("Numero de entradas");
		lblNumeroDeEntradas.setForeground(new Color(255, 255, 224));
		lblNumeroDeEntradas.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblNumeroDeEntradas.setBounds(352, 44, 131, 25);
		frame.getContentPane().add(lblNumeroDeEntradas);

		JLabel lblCartelera = new JLabel("Cartelera");
		lblCartelera.setForeground(new Color(255, 204, 51));
		lblCartelera.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCartelera.setBounds(623, 13, 131, 25);
		frame.getContentPane().add(lblCartelera);

		JLabel lblCxineAlucine = new JLabel("CINE ALUCINE");
		lblCxineAlucine.setForeground(new Color(153, 204, 255));
		lblCxineAlucine.setFont(new Font("Courier New", Font.BOLD, 38));
		lblCxineAlucine.setBounds(66, 2, 406, 38);
		frame.getContentPane().add(lblCxineAlucine);

		JLabel lblRecaudacin = new JLabel("Recaudación");
		lblRecaudacin.setForeground(new Color(255, 204, 51));
		lblRecaudacin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblRecaudacin.setBounds(623, 290, 131, 25);
		frame.getContentPane().add(lblRecaudacin);

	}

	/**
	 * hayDisponibles
	 * 
	 * Calcula si desde la butaca seleccionada hay tantas bitacas libres como indice el nmumero de entradas solicitadas
	 */
	public boolean hayDisponibles() {
		boolean existen = true;
		for (int i = 0; i < numEntradas; i++) {
			if (columnaActual + i <= 8) {
				if (matriz[numSala][numSesion][filaActual][columnaActual + i] != 0) {
					existen = false;
				}
			}

		}
		return existen;
	}

	/**
	 * reservar
	 * 
	 */
	public void reservar() {
		if (estado == SELECCIONANDO) {
			for (int i = 0; i < numEntradas; i++) {
				matriz[numSala][numSesion][filaActual][columnaActual + i] = 1;
			}
			estado = RESERVANDO;
			tableSalaCine.setEnabled(false);
			tableSalaCine.setBackground(Color.cyan);
			pintarPlano();
		} else {
			JOptionPane.showMessageDialog(null, "No se puede reservar sin elegir butaca", "Aviso",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * denegar
	 * 
	 */
	public void denegar() {
		if (estado == RESERVANDO) {
			for (int i = 0; i < numEntradas; i++) {
				matriz[numSala][numSesion][filaActual][columnaActual + i] = 0;

			}
			estado = VENDIENDO;
			tableSalaCine.setEnabled(true);
			tableSalaCine.setBackground(Color.yellow);
			pintarPlano();

		} else {
			JOptionPane.showMessageDialog(null, "No se puede denegar sin reservar previamente", "Aviso",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * vender
	 * 
	 */
	public void vender() {
		if (estado == RESERVANDO) {
			for (int i = 0; i < numEntradas; i++) {
				matriz[numSala][numSesion][filaActual][columnaActual + i] = 2;
				recaudacionCine = recaudacionCine + precios[numSesion];
				recaudacionSala[numSala] = recaudacionSala[numSala] + precios[numSesion];
				recaudacionSesion[numSala][numSesion] = recaudacionSesion[numSala][numSesion] + precios[numSesion];
			}

			moverFigura();

			estado = VENDIENDO;
			tableSalaCine.setEnabled(true);
			tableSalaCine.setBackground(Color.yellow);
			String trozofinal = "";
			for (int i = 0; i < numEntradas; i++) {
				trozofinal = trozofinal + (columnaActual + i) + "-";
			}
			trozofinal = trozofinal.substring(0, trozofinal.length() - 1);

			String contenido = "<HTML> Sala: " + numSala + "<br/> Sesion: " + numSesion + "<br/> Numero de Proyecci�n: "
					+ numproyeccion[numSala][numSesion] + "<br/><br/> Fila: " + filaActual + "<br/> Butaca: "
					+ trozofinal + "</HTML>";
			textoEntrada.setText(contenido);

		} else {
			JOptionPane.showMessageDialog(null, "No se puede vender sin reservar previamente", "Aviso",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * moverFigura
	 * 
	 */
	public void moverFigura() {

		new Thread(new Runnable() {
			@Override
			public void run() {
				// el stickman
				for (int e = 0; e < 4; e++) {
					layeredPaneFondoBillete.setBounds(460, 451, 375, 186);
					esperar(60);
					layeredPaneFondoBillete.setBounds(480, 451, 375, 186);
					esperar(60);
				}
			}
		}).start();

	}

	/**
	 * inicializarSala
	 * 
	 */
	public void inicializarSala() {
		this.numSesion = 0;
		estado = VENDIENDO;
		numEntradas = 1;
		enCurso = new boolean[3][2];

		this.enCurso[0][0] = false;
		this.enCurso[0][1] = false;
		this.enCurso[1][0] = false;
		this.enCurso[1][1] = false;
		this.enCurso[2][0] = false;
		this.enCurso[2][1] = false;

		// Creamos copias de las plantillas de sala para cada nueva posicion de
		// matriz
		// no podemos asignar directamente por que se copian referencias, no
		// contenidos
		// matriz[0][0] = plantillaSala0; // no funciona, se copian referencias

		// copiamos plantilla en matriz[0][0]
		for (int i = 0; i < plantillaSala0.length; i++) {
			matriz[0][0][i] = Arrays.copyOf(plantillaSala0[i], plantillaSala0[i].length);
		}

		// copiamos plantilla en matriz[0][1]
		for (int i = 0; i < plantillaSala0.length; i++) {
			matriz[0][1][i] = Arrays.copyOf(plantillaSala0[i], plantillaSala0[i].length);
		}

		// copiamos plantilla en matriz[1][0]
		for (int i = 0; i < plantillaSala1.length; i++) {
			matriz[1][0][i] = Arrays.copyOf(plantillaSala1[i], plantillaSala1[i].length);
		}

		// copiamos plantilla en matriz[1][1]
		for (int i = 0; i < plantillaSala1.length; i++) {
			matriz[1][1][i] = Arrays.copyOf(plantillaSala1[i], plantillaSala1[i].length);
		}

		// copiamos plantilla en matriz[2][0]
		for (int i = 0; i < plantillaSala2.length; i++) {
			matriz[2][0][i] = Arrays.copyOf(plantillaSala2[i], plantillaSala2[i].length);
		}

		// copiamos plantilla en matriz[2][1]
		for (int i = 0; i < plantillaSala2.length; i++) {
			matriz[2][1][i] = Arrays.copyOf(plantillaSala2[i], plantillaSala2[i].length);
		}

	}

	/**
	 * pintarPlano
	 * 
	 */
	public void pintarPlano() {

		for (int i = 0; i < 10; i++) {
			for (int x = 0; x < 9; x++) {
				int estado = matriz[numSala][numSesion][i][x];
				switch (estado) {
				case 0:
					contenidoSala[i][x] = sillaVerde;
					break;
				case 1:
					contenidoSala[i][x] = sillaAmarilla;
					// tableSalaCine.setValueAt(sillaVerde, i, x);
					break;
				case 2:
					contenidoSala[i][x] = sillaRoja;
					// tableSalaCine.setValueAt(sillaVerde, i, x);
					break;
				case 3:
					contenidoSala[i][x] = sillaVacia;
					//

				}

			}
		}

		miModelo = new ModeloNoEditable(contenidoSala, cabeceras);

		// -- Para añadir un modelo a la JTable que permita imagenes,
		// -- puedo crear una clase JTable propia, o como en el codigo comentado
		// despues,
		// -- crear una JTable con una clase sobrescrita directamente
		tableSalaCine.setModel(miModelo);
		miModelo.fireTableDataChanged();
		tableSalaCine.setShowGrid(false);
		tableSalaCine.setIntercellSpacing(new Dimension(0, 0));

		if (enCurso[numSala][numSesion] == true) {
			tableSalaCine.setEnabled(false);
			tableSalaCine.setBackground(Color.red);

		} else {
			tableSalaCine.setEnabled(true);
			tableSalaCine.setBackground(Color.cyan);
		}

		fondoPelicula.setIcon(imagenesSesion[numSala][numSesion]);
		labelSala.setText("Sala: " + numSala);
		labelProyeccion.setText("Proyeccion: " + numproyeccion[numSala][numSesion]);

	}

	/**
	 * pintarInformacionRecaudacion
	 * 
	 * Muestra la informacion de la recaudacion obtenida
	 */
	public void pintarInformacionRecaudacion() {

		String texto = "Ingresos totales del cine: " + recaudacionCine + "�" + "\n" + "Ingresos de la sala " + numSala
				+ ";" + recaudacionSala[numSala] + "�" + "\n" + "Ingresos de esta sesion " + numSesion + ";"
				+ recaudacionSesion[numSala][numSesion] + "�";
		informacionDinero.setText(texto);
	}

	/**
	 * esperar
	 * 
	 * Pausa la ejecucion del programa
	 * 
	 * @param miliseg
	 *            el tiempo en miligeundos que se pausa el programa
	 */
	public void esperar(int miliseg) {
		try {
			Thread.sleep(miliseg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

/**
 * Clase que sustituye a JTable y que sobrescribe el metodo getColumnClass Asi se facilita que el contenido de la JTable sean
 * objetos, como imagenes
 * <p>
 */
class MiTabla extends JTable {

	/**
	 * getColumnClass
	 * 
	 * -- El constructor recibe el modelo a aplicar y lo envia a la superclase (JTable) -- Asi es igual que se usa el constructor
	 * normal de JTable, JTable tabla = new JTable(modelo);
	 */
	MiTabla(DefaultTableModel model) {
		super(model);
	}

	/**
	 * getColumnClass
	 * 
	 * Metodo que para cada columna devuelve la "Clase" que contiene -- Permite que se use por los "renderers" que se basen en
	 * tratar una clase
	 */
	@Override
	public Class getColumnClass(int column) {
		return getValueAt(0, column).getClass();
	}
}

/**
 * ModeloNoEditable
 * 
 * Clase modelo propia, que evita que las celdas sean editables
 * <p>
 */
class ModeloNoEditable extends DefaultTableModel {

	/**
	 * 90 Constructor
	 * 
	 * @param data
	 * @param columnNames
	 */
	ModeloNoEditable(Object[][] data, String[] columnNames) {
		super(data, columnNames);
	}

	/**
	 * isCellEditable
	 * 
	 * Evita que las celdas de la tabla se puedan editar
	 * 
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
