package streams2;

import java.util.List;

public class Banco {

	private String nombre;
	private List<Cuenta> cuentas;
	
	public Banco(String nombre, List<Cuenta> cuentas) {
		super();
		this.nombre = nombre;
		this.cuentas = cuentas;
	}
	
	public Banco() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}


	
	public String toString() {
		String res = "";
		
		res="Nombre: "+nombre+" Cuentas: "+cuentas;
		
		return res;
	}
	
	
}
