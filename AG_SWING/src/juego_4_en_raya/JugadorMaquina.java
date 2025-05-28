package juego_4_en_raya;

public class JugadorMaquina {

	private int colorFicha;
	private int colorContrario;

	public JugadorMaquina(int colorFicha, int colorContrario) {
		super();
		this.colorFicha = colorFicha;
		this.colorContrario = colorContrario;
	}

	public Posicion JugarMaquina(Tablero tablero) {

		Posicion posicionajugar = null;
		int x;
		int y;

		tablero.actualizarPosiciones();

		Posicion p = PuedoGanarMaquina(tablero);
		if (p == null) {
			p = PuedeGanarContrario(tablero);
		}
		if (p == null) {
			p = PuedeJuntarDosdeTresMaquina(tablero);
		}
		if (p == null) {
			p = PuedeJuntarDosdeTresContrario(tablero);
		}

		if (p == null) {
			p = PuedeJuntar3Contrario(tablero);
		}
		if (p == null) {
			p = PuedeJuntar3Maquina(tablero);
		}
		if (p == null) {
			p = PuedeJuntar2Maquina(tablero);
		}
		if (p == null) {
			p = PuedeJuntar2Contrario(tablero);
		}
		if (p == null) {
			p = ponerAlAzar(tablero);
		}

		posicionajugar = tablero.tablero[p.getX()][p.getY()];

		posicionajugar.setMicolor(colorFicha);

		System.out.println(posicionajugar);

		return posicionajugar;

	}

	// ver si puedo acabar - puedoAcabar()

	public Posicion PuedoGanarMaquina(Tablero tablero) {

		Posicion posicionajugar = null;

		for (int i = 0; i < tablero.OpcionesAJugar.size(); i++) {

			if (tablero.chequeoHorizontal(tablero.OpcionesAJugar.get(i), colorFicha) == 4
					| tablero.chequeoVertical(tablero.OpcionesAJugar.get(i), colorFicha) == 4
					| tablero.chequeoDiagonal1(tablero.OpcionesAJugar.get(i), colorFicha) == 4
					| tablero.chequeoDiagonal2(tablero.OpcionesAJugar.get(i), colorFicha) == 4) {

				posicionajugar = tablero.OpcionesAJugar.get(i);

			} else {
				i++;
			}

		}
		System.out.println("Puede ganar maquina en posicion" + posicionajugar);
		return posicionajugar;

	}

	// ver si pueda acabar el otro - puedeAcabarElOtro()
	public Posicion PuedeGanarContrario(Tablero tablero) {

		Posicion posicionajugar = null;

		for (int i = 0; i < tablero.OpcionesAJugar.size(); i++) {

			if (tablero.chequeoHorizontal(tablero.OpcionesAJugar.get(i), colorContrario) == 4
					| tablero.chequeoVertical(tablero.OpcionesAJugar.get(i), colorContrario) == 4
					| tablero.chequeoDiagonal1(tablero.OpcionesAJugar.get(i), colorContrario) == 4
					| tablero.chequeoDiagonal2(tablero.OpcionesAJugar.get(i), colorContrario) == 4) {

				posicionajugar = tablero.OpcionesAJugar.get(i);

			} else {
				i++;
			}

		}

		System.out.println("Puede ganar persona en posicion" + posicionajugar);
		return posicionajugar;

	}

	// puedoCrearDosCondicionesGanadoras

	public Posicion PuedeJuntarDosdeTresMaquina(Tablero tablero) {

		Posicion posicionajugar = null;
		int sumaposibles = 0;

		for (int i = 0; i < tablero.OpcionesAJugar.size(); i++) {

			if (tablero.chequeoHorizontal(tablero.OpcionesAJugar.get(i), colorFicha) == 3) {
				sumaposibles++;
			} else if (tablero.chequeoVertical(tablero.OpcionesAJugar.get(i), colorFicha) == 3) {
				sumaposibles++;
			} else if (tablero.chequeoDiagonal1(tablero.OpcionesAJugar.get(i), colorFicha) == 3) {
				sumaposibles++;
			} else if (tablero.chequeoDiagonal2(tablero.OpcionesAJugar.get(i), colorFicha) == 3) {
				sumaposibles++;
			}

			if (sumaposibles > 1) {

				posicionajugar = tablero.OpcionesAJugar.get(i);

			} else {
				i++;
			}

		}
		System.out.println("Puede maquina juntar 2 de tres" + posicionajugar + "contador:" + sumaposibles);
		return posicionajugar;

	}

	// puedeCrearElOtroDosCondicionesGanadoras
	public Posicion PuedeJuntarDosdeTresContrario(Tablero tablero) {

		Posicion posicionajugar = null;
		int sumaposibles = 0;

		for (int i = 0; i < tablero.OpcionesAJugar.size(); i++) {

			if (tablero.chequeoHorizontal(tablero.OpcionesAJugar.get(i), colorContrario) == 3) {
				sumaposibles++;
			} else if (tablero.chequeoVertical(tablero.OpcionesAJugar.get(i), colorContrario) == 3) {
				sumaposibles++;
			} else if (tablero.chequeoDiagonal1(tablero.OpcionesAJugar.get(i), colorContrario) == 3) {
				sumaposibles++;
			} else if (tablero.chequeoDiagonal2(tablero.OpcionesAJugar.get(i), colorContrario) == 3) {
				sumaposibles++;
			}

			if (sumaposibles > 1) {

				posicionajugar = tablero.OpcionesAJugar.get(i);

			} else {
				i++;
			}

		}
		System.out.println("Puede maquina juntar 2 de tres" + posicionajugar + "contador:" + sumaposibles);
		return posicionajugar;

	}

	// puedeCrearElOtroUnaCondicionGanadora
	public Posicion PuedeJuntar3Contrario(Tablero tablero) {

		Posicion posicionajugar = null;

		for (int i = 0; i < tablero.OpcionesAJugar.size(); i++) {

			if (tablero.chequeoHorizontal(tablero.OpcionesAJugar.get(i), colorContrario) == 3
					| tablero.chequeoVertical(tablero.OpcionesAJugar.get(i), colorContrario) == 3
					| tablero.chequeoDiagonal1(tablero.OpcionesAJugar.get(i), colorContrario) == 3
					| tablero.chequeoDiagonal2(tablero.OpcionesAJugar.get(i), colorContrario) == 3) {

				posicionajugar = tablero.OpcionesAJugar.get(i);

			} else {
				i++;
			}

		}
		System.out.println("Puede persona juntar 3 en posicion" + posicionajugar);
		return posicionajugar;

	}

	// puedoCrearYoUnaCondicionGanadora
	public Posicion PuedeJuntar3Maquina(Tablero tablero) {

		Posicion posicionajugar = null;

		for (int i = 0; i < tablero.OpcionesAJugar.size(); i++) {

			if (tablero.chequeoHorizontal(tablero.OpcionesAJugar.get(i), colorFicha) == 3
					| tablero.chequeoVertical(tablero.OpcionesAJugar.get(i), colorFicha) == 3
					| tablero.chequeoDiagonal1(tablero.OpcionesAJugar.get(i), colorFicha) == 3
					| tablero.chequeoDiagonal2(tablero.OpcionesAJugar.get(i), colorFicha) == 3) {

				posicionajugar = tablero.OpcionesAJugar.get(i);

			} else {
				i++;
			}

		}
		System.out.println("Puede persona juntar 3 en posicion" + posicionajugar);
		return posicionajugar;

	}

	// Intentar juntar 2

	public Posicion PuedeJuntar2Maquina(Tablero tablero) {

		Posicion posicionajugar = null;

		for (int i = 0; i < tablero.OpcionesAJugar.size(); i++) {

			if (tablero.chequeoHorizontal(tablero.OpcionesAJugar.get(i), colorFicha) == 2
					| tablero.chequeoVertical(tablero.OpcionesAJugar.get(i), colorFicha) == 2
					| tablero.chequeoDiagonal1(tablero.OpcionesAJugar.get(i), colorFicha) == 2
					| tablero.chequeoDiagonal2(tablero.OpcionesAJugar.get(i), colorFicha) == 2) {

				posicionajugar = tablero.OpcionesAJugar.get(i);

			} else {
				i++;
			}

		}
		System.out.println("Puede maquina juntar 2 en posicion" + posicionajugar);
		return posicionajugar;

	}

	// Intentar que no cree el otro 2

	public Posicion PuedeJuntar2Contrario(Tablero tablero) {

		Posicion posicionajugar = null;

		for (int i = 0; i < tablero.OpcionesAJugar.size(); i++) {

			if (tablero.chequeoHorizontal(tablero.OpcionesAJugar.get(i), colorContrario) == 2
					| tablero.chequeoVertical(tablero.OpcionesAJugar.get(i), colorContrario) == 2
					| tablero.chequeoDiagonal1(tablero.OpcionesAJugar.get(i), colorContrario) == 2
					| tablero.chequeoDiagonal2(tablero.OpcionesAJugar.get(i), colorContrario) == 2) {

				posicionajugar = tablero.OpcionesAJugar.get(i);

			} else {
				i++;
			}

		}
		System.out.println("Puede persona juntar 2 en posicion" + posicionajugar);
		return posicionajugar;

	}

	// azar

	public Posicion ponerAlAzar(Tablero tablero) {

		int i = (int) (Math.random() * tablero.OpcionesAJugar.size());

		return tablero.OpcionesAJugar.get(i);

	}

	// ver si puedo acabar - puedoAcabar()
	// ver si pueda acabar el otro - puedeAcabarElOtro()
	// puedoCrearDosCondicionesGanadoras
	// puedeCrearElOtroDosCondicionesGanadoras
	// puedeCrearElOtroUnaCondicionGanadora
	// puedoCrearYoUnaCondicionGanadora

	// Intentar juntar 2
	// Intentar que no cree el otro 2

	// azar

}
