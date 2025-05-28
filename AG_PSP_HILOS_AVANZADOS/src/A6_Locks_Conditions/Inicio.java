package A6_Locks_Conditions;

public class Inicio {
	public static void main(String args[])  {
		
		Monitor<String> miMonitor = new Monitor<>();
		Consumidor conMen1 = new Consumidor("con_juan", miMonitor);
		Consumidor conMen2 = new Consumidor("con_luis", miMonitor);
		Productor proMen1 = new Productor("pro_eva", miMonitor);
		Productor proMen2 = new Productor("pro_ana", miMonitor);

		conMen1.start();
		conMen2.start();
		proMen1.start();
		proMen2.start();

	}
}
