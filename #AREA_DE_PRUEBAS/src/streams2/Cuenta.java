package streams2;

import java.util.List;

public class Cuenta {

	private int n_cuenta;
	private List<Cliente> clientes;
	private double saldo;
	
	public Cuenta() {
	
	}
	
	public Cuenta(int n_cuenta,List<Cliente>clientes,double saldo) {
		this.n_cuenta=n_cuenta;
		this.clientes=clientes;
		this.saldo=saldo;
	}

	public int getN_cuenta() {
		return n_cuenta;
	}

	public void setN_cuenta(int n_cuenta) {
		this.n_cuenta = n_cuenta;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String toString() {
		String res = "";
		
		res="Cuenta: "+n_cuenta+" Saldo: "+saldo+" Clientes: "+clientes;
		
		return res;
	}

}
