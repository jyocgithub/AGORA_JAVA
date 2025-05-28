package juego_4_en_raya;

import java.util.ArrayList;

public class Tablero {

	// Creamos el tablero como array de objetos Posicion.
	Posicion[][] tablero;

	public Tablero() {
		tablero = new Posicion[6][7];
		inicilalizarTablero();
	}

	// Metodo para inicializar el tablero con posiciones con COLOR_SINCOLOR
	public void inicilalizarTablero() {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				tablero[i][j] = new Posicion(i, j, 0);

			}
		}
	}

	public Posicion[][] getTablero() {
		return tablero;
	}

	public void setTablero(Posicion[][] tablero) {
		this.tablero = tablero;
	}

	public void imprimirTablero() {

		for (int x = 0; x < tablero.length; x++) {
			System.out.print("|");
			for (int y = 0; y < tablero[x].length; y++) {
				System.out.print(tablero[x][y].toString());
				if (y != tablero[x].length - 1) System.out.print("\t");
			}
			System.out.println("|");
		}
	}

	// Creamos un arraylist para almacenar la siguiente posicion donde se puede
	// jugar cada columna
	ArrayList<Posicion> OpcionesAJugar = new ArrayList<>();

	// Metodo para actualizar estas posiciones cada vez que se produzca un turno.

	public void actualizarPosiciones() {

		int columnaactual = 0;
		OpcionesAJugar.clear();

		for (int f = 5; f >= 0 && columnaactual < 7; f--) {

			if (f > 0) {
				if (tablero[f][columnaactual].getMicolor() == 0) {

					Posicion pos = new Posicion(f, columnaactual, 0);
					OpcionesAJugar.add(pos);
					columnaactual++;
					f = 6;

				}
			} else {

				if (tablero[f][columnaactual].getMicolor() == 0) {

					Posicion pos = new Posicion(f, columnaactual, 0);
					OpcionesAJugar.add(pos);
					columnaactual++;

				} else {
					f = 5;
					columnaactual++;
				}

			}
		}
		System.out.println(OpcionesAJugar);
	}

	// Metodos para los chequeos horizontal/ vertical y de las dos verticales.
	public int chequeoHorizontal(Posicion posactual, int colordeficha) {

		// miramos a la derecha e izquierda
		int contador = 1;
		boolean vanseguidas = true;

		int columnaactual = posactual.getY();
		int filaactual = posactual.getX();

		for (int c = columnaactual + 1; vanseguidas && c < 7; c++) {

			if (tablero[filaactual][c].getMicolor() == colordeficha) {
				contador++;
				// System.out.println(tablero[filaactual][c]+"contador:"+ contador);
			} else {
				vanseguidas = false;
			}

		}

		vanseguidas = true;
		for (int c = columnaactual - 1; vanseguidas && c >= 0; c--) {

			if (tablero[filaactual][c].getMicolor() == colordeficha) {
				contador++;
				// System.out.println(tablero[filaactual][c]+"contador:"+ contador);
			} else {
				vanseguidas = false;
			}

		}
		// System.out.println("Numero de filas seguidas en horizontal = "+contador);
		return contador;
	}

	public int chequeoVertical(Posicion posactual, int colordeficha) {

		// miramos a arriba y abajo
		int contador = 1;
		boolean vanseguidas = true;

		int columnaactual = posactual.getY();
		int filaactual = posactual.getX();

		for (int f = filaactual - 1; vanseguidas && f >= 0; f--) {

			if (tablero[f][columnaactual].getMicolor() == colordeficha) {
				contador++;
				// System.out.println(tablero[f][columnaactual]+"contador = "+contador);
			} else {
				vanseguidas = false;
			}

		}

		vanseguidas = true;
		for (int f = filaactual + 1; vanseguidas && f < 6; f++) {

			if (tablero[f][columnaactual].getMicolor() == colordeficha) {
				contador++;
				// System.out.println(tablero[f][columnaactual]+"contador = "+contador);
			} else {
				vanseguidas = false;
			}

		}
		// System.out.println("Numero de filas seguidas en vertical = "+contador);
		return contador;
	}

	// ChequeoDiagonal1

	public int chequeoDiagonal1(Posicion posactual, int colordeficha) {

		// miramos a la derecha e izquierda
		int contador = 1;
		boolean vanseguidas = true;

		int columnaactual = posactual.getY();
		int filaactual = posactual.getX();

		// DIAGONAL SO - NE
		vanseguidas = true;
		for (int c = columnaactual + 1, f = filaactual - 1; vanseguidas && c < 7 && f >= 0; f--, c++) {

			if (tablero[f][c].getMicolor() == colordeficha) {
				contador++;
			} else {
				vanseguidas = false;
			}

		}
		vanseguidas = true;
		for (int c = columnaactual - 1, f = filaactual + 1; vanseguidas && c >= 0 && f < 6; f++, c--) {

			if (tablero[f][c].getMicolor() == colordeficha) {
				contador++;
			} else {
				vanseguidas = false;
			}

		}
		// System.out.println("Numero de filas seguidas en diagonal1 = "+contador);
		return contador;
	}

	public int chequeoDiagonal2(Posicion posactual, int colordeficha) {

		// miramos a la derecha e izquierda
		int contador = 1;
		boolean vanseguidas = true;

		int columnaactual = posactual.getY();
		int filaactual = posactual.getX();

		// DIAGONAL NO - SE
		vanseguidas = true;
		for (int c = columnaactual - 1, f = filaactual - 1; vanseguidas && c >= 0 && f >= 0; f--, c--) {

			if (tablero[f][c].getMicolor() == colordeficha) {
				contador++;
			} else {
				vanseguidas = false;
			}

		}
		vanseguidas = true;
		for (int c = columnaactual + 1, f = filaactual + 1; vanseguidas && c < 7 && f < 6; f++, c++) {

			if (tablero[f][c].getMicolor() == colordeficha) {
				contador++;
			} else {
				vanseguidas = false;
			}

		}
		// System.out.println("Numero de filas seguidas en diagonal2 = "+contador);
		return contador;
	}

	// Metodo para saber la casilla donde juega el jugador

	public Posicion jugarPersona(int columnaseleccionada, int colorJugador) {

		Posicion posJuego = null;

		for (int i = 0; i < OpcionesAJugar.size(); i++) {
			if (OpcionesAJugar.get(i).getY() == columnaseleccionada) {

				posJuego = tablero[OpcionesAJugar.get(i).getX()][columnaseleccionada];
				posJuego.setMicolor(colorJugador);

			}

		}

		// mira si ha ganado y avisa en tal caso

		// juega la maquina

		// cambia la matriz de tablero

		// pintaFIcha(posicion)

		// mira si ha ganado y avisa en tal caso

		return posJuego;

	}

	public boolean chequeoGanador(Posicion ultimomovimiento) {

		boolean hayganador = false;

		if (chequeoHorizontal(ultimomovimiento, ultimomovimiento.getMicolor()) >= 4) {

			hayganador = true;
			System.out.println("Has ganado");

		} else if (chequeoVertical(ultimomovimiento, ultimomovimiento.getMicolor()) >= 4) {

			hayganador = true;
			System.out.println("Has ganado");

		} else if (chequeoDiagonal2(ultimomovimiento, ultimomovimiento.getMicolor()) >= 4) {

			hayganador = true;
			System.out.println("Has ganado");

		}
		return hayganador;
	}

}
