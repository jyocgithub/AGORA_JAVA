package Alfombras;

public class Alfombra_Cuadrada extends Alfombra implements IAlfombras{
	private int lado;

	Alfombra_Cuadrada(int lado, String color, int precioMetro) {
		super(color, precioMetro);
		this.lado = lado;
	}

	public void setlado(int lado) {
		this.lado = lado;
	}

	public int getlado() {
		return this.lado;
	}
	@Override
	public double calcularSuperficie() {
		double x = this.lado * this.lado;
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
