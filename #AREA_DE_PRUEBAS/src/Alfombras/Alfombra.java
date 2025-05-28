package Alfombras;

abstract public class Alfombra {
	private String color;
	private int precioMetro;

	Alfombra(String color, int precioMetro) {
		this.color = color;
		this.precioMetro = precioMetro;
	}
		
	abstract public double calcularSuperficie();
	abstract public double calcularPrecio();

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrecioMetro() {
		return precioMetro;
	}

	public void setPrecioMetro(int precioMetro) {
		this.precioMetro = precioMetro;
	}
	
}
