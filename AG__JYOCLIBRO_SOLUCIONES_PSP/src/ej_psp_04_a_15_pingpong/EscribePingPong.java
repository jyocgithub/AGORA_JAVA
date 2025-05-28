package ej_psp_04_a_15_pingpong;

public class EscribePingPong
{
	int turno = 0;

	public synchronized void escribePing()
	{
		try
		{
			if (turno == 0)
				wait();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		System.out.println("ping");
		turno = 0;

		notifyAll();
	}

	public synchronized void escribePong()
	{
		try
		{
			if (turno == 1)
				wait();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		System.out.println("pong");
		turno = 1;

		notifyAll();
	}
}
