package bingo;


public class Carton implements ICarton {

	private int[][] cartonArray;

	public Carton(int[][] cartonArray) {
		this.cartonArray = cartonArray;
	}

	public static boolean esValido(int[][] carton) {
		boolean valido = true;
		// son 3 filas y 3 columnas

		if (carton.length != 3) {
			valido = false;
		} else if (carton[0].length != 9) {
			valido = false;
		}

		// podria haber puesto todo en el mismo for anidado
		// pero queda asi para mejor legibilidad
		int[] existentes = new int[91];

		for (int fila = 0; fila < 3; fila++) {
			for (int col = 0; col < 9; col++) {
				int valor = carton[fila][col];
				if (valor != 0) {
					if (existentes[valor] == 1) {
						valido = false;
					}
					existentes[valor] = 1;
				}
			}
		}

		for (int fila = 0; fila < 3; fila++) {
			for (int col = 0; col < 9; col++) {
				int valor = carton[fila][col];
				if (valor < 0 || valor > 90) {
					valido = false;
				}
			}
		}

		for (int fila = 0; fila < 3; fila++) {

			int contador = 0;
			for (int col = 0; col < 9; col++) {
				int valor = carton[fila][col];
				if (valor == 0) {
					contador++;
				}
			}

			if (contador != 4) {
				valido = false;
			}

		}

		for (int fila = 0; fila < 3; fila++) {
			int aux = 0;
			for (int col = 0; col < 9; col++) {
				int valor = carton[fila][col];
				if (valor != 0 && aux > valor) {
					valido = false;
				}
				aux = valor;
			}
		}

		return valido;
	}

	/**
	 * Busca el número en el cartón y lo tacha si existe
	 * 
	 * @param numero
	 *            es el número que hay que comprobar en el cartón y tacharlo en caso de que esté
	 * @return true si se ha tachado el número, false si no
	 */
	@Override
	public boolean tacharNumero(int numero) {
		boolean estaba = false;

		for (int fila = 0; fila < 3; fila++) {

			for (int col = 0; col < 9; col++) {
				int valor = cartonArray[fila][col];
				if (valor == numero) {
					estaba = true;
					cartonArray[fila][col] = -1;
				}
			}

		}
		return estaba;
	}

	/**
	 * Comprueba si hay alguna línea hecha en el cartón
	 * 
	 * @return true si hay alguna línea, false en caso contrario
	 */
	@Override
	public boolean hayLinea() {
		boolean haylineaenalgunlado = false, unalinea = true;

		for (int fila = 0; fila < 3; fila++) {

			unalinea = true;
			for (int col = 0; col < 9; col++) {
				int valor = cartonArray[fila][col];
				if (valor > 0) {
					unalinea = false;
				}
			}
			if (unalinea) {
				haylineaenalgunlado = true;
			}
		}
		return haylineaenalgunlado;
	}

	/**
	 * Comprueba si el cartón tiene un bingo * @return true si hay bingo, false si no
	 */
	@Override
	public boolean hayBingo() {
		boolean esbingo = true;
		for (int fila = 0; fila < 3; fila++) {
			for (int col = 0; col < 9; col++) {
				int valor = cartonArray[fila][col];
				if (valor > 0) {
					esbingo = false;
				}
			}
		}
		return esbingo;
	}

	/**
	 * Comprueba si el cartón tiene un bingo * @return true si hay bingo, false si no
	 */
	public void pintarCarton() {
		for (int fila = 0; fila < 3; fila++) {
			for (int col = 0; col < 9; col++) {
				int valor = cartonArray[fila][col];
				System.out.print(valor + "\t");
			}
			System.out.print("\n");
		}
	}

	public int[][] getCartonArray() {
		return cartonArray;
	}

	public void setCartonArray(int[][] cartonArray) {
		this.cartonArray = cartonArray;
	}

}
