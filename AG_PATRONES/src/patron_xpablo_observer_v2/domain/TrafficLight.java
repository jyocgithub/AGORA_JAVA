package patron_xpablo_observer_v2.domain;


import patron_xpablo_observer_v2.util.Observada;

public class TrafficLight extends Observada {
	private Color color;
	private final int trafficLightNumber;
	private volatile boolean running = true;
	private Thread innerThread;
	
	public TrafficLight(int trafficLightNumber) {
		// The following construct is so the traffic lights will keep running the loop while the 
		// constructor return. Ignore the mechanism, focus on what happens in the doWork() method.
		
		this.trafficLightNumber = trafficLightNumber;
		innerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				doWork();
			}
		});
		innerThread.setDaemon(false);
		innerThread.start();
	}
	
	
	public int getTrafficLightNumber() {
		return trafficLightNumber;
	}


	public Color getColor() {
		return color;
	}
	
	public void stop() {
		running = false;
	}

	private void doWork() {
		while (running) {
			try {
				color = Color.GREEN;
				setChanged();
				notifyObservers();
				Thread.sleep((long) (2000 + Math.random() * 3000));
				color = Color.YELLOW;
				setChanged();
				notifyObservers();
				Thread.sleep(500);
				color = Color.RED;
				setChanged();
				notifyObservers();
				Thread.sleep((long) (1000 + Math.random() * 1000));
			} catch (InterruptedException e) {
	
			}
		}
	}
	
	public enum Color { RED, YELLOW, GREEN
		
	}

}
