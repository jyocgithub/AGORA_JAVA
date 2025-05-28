package Semaforos;

public class CopyOfContador {
	private int _c =0;
	public final int NUMVECES = 10;
	public CopyOfContador (int c){
		_c = c;
	}
	public void incrementa(){
		++this._c;
	}
	public void decrementa () {
		--this._c;
	}
	public int getValue(){
		return _c;
	}

}
