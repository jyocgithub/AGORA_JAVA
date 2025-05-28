package patron_xpablo_observer_v2.domain;


import patron_xpablo_observer_v2.app.CrossRoads;
import patron_xpablo_observer_v2.util.IObservador;
import patron_xpablo_observer_v2.util.Observada;

import java.util.List;

public class Pedestrian implements IObservador {
	private CrossRoads place; // The pedestrian will need to know what lights to check
	
	public Pedestrian(CrossRoads place) {
		this.place = place;
	}

	@Override
	public void update(Observada o, Object arg) {
		// Any time the color of a traffic light changes, check whether they are all red. If so, walk.
		List<TrafficLight> lights = place.getLights();
		boolean result = true;
		for (TrafficLight light: lights) {
			if (light.getColor() != TrafficLight.Color.GREEN) {
				System.out.println("Cannot walk yet; light "  + light.getTrafficLightNumber() + " is still red.");
				result = false;
			}
		}
		if (result) {
			System.out.println("I can walk now.");
		}
	}
}
