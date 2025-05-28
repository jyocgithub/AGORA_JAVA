package juego_4_en_raya;

public class TestJuego {

	public static void main(String[] args) {

		JugadorMaquina J1 = new JugadorMaquina(1, 2);
		JugadorPersona J2 = new JugadorPersona(2, 1);
		Tablero tab1 = new Tablero();
		tab1.inicilalizarTablero();

		tab1.imprimirTablero();

		tab1.actualizarPosiciones();

		/*
		 * tab1.tablero[5][0].setMicolor(1); tab1.tablero[4][0].setMicolor(1); tab1.tablero[5][1].setMicolor(2);
		 * tab1.tablero[5][3].setMicolor(2); tab1.tablero[4][3].setMicolor(2); tab1.tablero[3][3].setMicolor(2);
		 * tab1.tablero[5][6].setMicolor(1); tab1.tablero[4][6].setMicolor(1); tab1.tablero[5][4].setMicolor(2);
		 * tab1.tablero[5][5].setMicolor(2); tab1.tablero[4][1].setMicolor(1); tab1.tablero[5][2].setMicolor(1);
		 * tab1.tablero[4][2].setMicolor(2); tab1.tablero[3][1].setMicolor(1); tab1.tablero[3][2].setMicolor(1);
		 */

		// tab1.imprimirTablero();

		// tab1.actualizarPosiciones();

		// tab1.jugarPersona(6, 1);
		// tab1.imprimirTablero();

		// tab1.actualizarPosiciones();

		// System.out.println(tab1.tablero[5][4]);
		// tab1.chequeoHorizontal(tab1.getTablero()[5][3], tab1.tablero[5][3].getMicolor());
		// tab1.chequeoVertical(tab1.getTablero()[5][3], tab1.tablero[5][3].getMicolor());
		// tab1.chequeoDiagonal1(tab1.getTablero()[4][1], tab1.tablero[4][1].getMicolor());
		// tab1.chequeoDiagonal2(tab1.getTablero()[4][4],2);

		// tab1.tablero[3][6].setMicolor(0);

		tab1.tablero[5][0].setMicolor(2);
		tab1.tablero[5][1].setMicolor(2);
		tab1.tablero[4][0].setMicolor(1);
		tab1.tablero[3][0].setMicolor(1);
		J1.JugarMaquina(tab1);
		tab1.imprimirTablero();

	}

}
