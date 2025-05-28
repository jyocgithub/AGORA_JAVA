package Alfombras;

public class Habitacion {
	private String nombre;
	Alfombra[] alfombras;

	Habitacion(String nombre) {
		this.alfombras = new Alfombra[10];
		this.nombre = nombre;
	}

	public void setalfombras(Alfombra[] alfombras) {
		this.alfombras = alfombras;
	}

	public Alfombra[] getalfombras() {
		return this.alfombras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean agregarAlfombra(Alfombra alf) {
		boolean x = false;
		for (int i = 0; i < alfombras.length && !x; i++) {
			if (alfombras[i] == null) {
				alfombras[i] = alf;
				x = true;
			}
		}
		return x;

	}

	public void calcularpreciototal() {
		double x = 0;
		for (int i = 0; i < alfombras.length; i++) {
			if (alfombras[i] != null) {
				double z = alfombras[i].calcularPrecio();
				x = x + z;
			}
		}
		System.out.println("el precio total de las alfombras en esta habitacion es " + x);
	}

	public void calcularpreciototalcuadradas() {
		double x = 0;
		for (int i = 0; i < alfombras.length; i++) {
			if (alfombras[i] != null) {
				if (alfombras[i] instanceof Alfombra_Cuadrada) {
					double z = alfombras[i].calcularPrecio();
					x = x + z;
				}
			}
		}
		System.out.println("el precio total de las alfombras cuadradas en esta habitacion es " + x);
	}
}
