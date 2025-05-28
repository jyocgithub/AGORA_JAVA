package Alfombras;

public class Alfombra_Redonda extends Alfombra implements IAlfombras{
	private int radio;

	Alfombra_Redonda(int radio, String color, int precioMetro) {
		super(color, precioMetro);
		this.radio = radio;

	}

	public int getradio() {
		return this.radio;
	}

	public void setradio(int radio) {
		this.radio = radio;
		
	
	}

	@Override
	public double calcularSuperficie() {
		double x = 3.14 * this.radio * this.radio;
		return x;
	}

	@Override
	public double calcularPrecio() {
	  double x =  calcularSuperficie();
	  double z = x * this.getPrecioMetro();
		return z;
	}

	@Override
	public double actualizarPrecio() {
		this.setPrecioMetro(this.getPrecioMetro()+1);
		return this.getPrecioMetro();
	}

	@Override
	public double ponerEnRebajas() {
		this.setPrecioMetro(this.getPrecioMetro()/2);
		return this.getPrecioMetro();
	}
}
