package patron_xpablo_observer_v2.app;

import patron_xpablo_observer_v2.domain.Pedestrian;
import patron_xpablo_observer_v2.domain.TrafficLight;

import java.util.LinkedList;
import java.util.List;


public class CrossRoads {
	List<TrafficLight> lights;
	Pedestrian pedestrian;
	
	public static void main(String[] args) throws InterruptedException {
		new CrossRoads();
	}

	public List<TrafficLight> getLights() {
		return lights;
	}

	public CrossRoads() throws InterruptedException {
		lights = new LinkedList<>();
		pedestrian = new Pedestrian(this);
		
		for (int i=1; i<=4; i++) {
			TrafficLight light = new TrafficLight(i);
			light.addObserver(pedestrian);
			lights.add(light);
		}
		Thread.sleep(3600000);
	}
}
