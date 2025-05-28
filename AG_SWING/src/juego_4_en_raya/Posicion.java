package juego_4_en_raya;

public class Posicion {

	private int x;
	private int y;
	private static int COLOR_SINCOLOR = 0;
	private static int COLOR_ROJO = 1;
	private static int COLOR_AZUL = 2;

	private int micolor;

	public Posicion(int x, int y, int micolor) {
		this.x = x;
		this.y = y;

		this.micolor = micolor;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getMicolor() {
		return micolor;
	}

	public void setMicolor(int micolor) {
		this.micolor = micolor;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")- " + micolor;
		// return ""+micolor+"";
	}

}
