package ej_psp_04_a_15_pingpong;

public class Main
{
	public static void main(String[] args)
	{
		EscribePingPong epp = new EscribePingPong();

		Thread thPing = new Thread(new EscribePing(epp));
		Thread thPong = new Thread(new EscribePong(epp));

		thPing.start();
		thPong.start();
	}
}