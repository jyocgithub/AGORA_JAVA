package ej_psp_04_a_15_pingpong;

public class EscribePong implements Runnable
{
	EscribePingPong epp;

	public EscribePong(EscribePingPong epp)
	{
		this.epp = epp;
	}

	@Override
	public void run()
	{
		while (true)
		{
			epp.escribePong();
		}
	}
}
