package ej_psp_04_a_15_pingpong;

public class EscribePing implements Runnable
{
	EscribePingPong epp;

	public EscribePing(EscribePingPong epp)
	{
		this.epp = epp;
	}

	@Override
	public void run()
	{
		while (true)
		{
			epp.escribePing();
		}
	}
}