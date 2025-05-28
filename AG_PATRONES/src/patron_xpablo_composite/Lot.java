package patron_pablo_composite;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Lot implements Composite {
	private Set<Component> elements;
	
	public Lot() {
		super();
		elements = new HashSet<>();
	}
	
	public void addComponent(Component c) {
		elements.add(c);
	}
	
	public void removeComponent(Component c) {
		elements.remove(c);
	}

	public BigDecimal getFee() {
		BigDecimal result = BigDecimal.ZERO;;
		for (Component zone: elements) {
			result = result.add(zone.getFee());
		}
		return result;
	}
}
