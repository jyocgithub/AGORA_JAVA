package patron_pablo_composite;

import java.math.BigDecimal;

public class Car implements Component {
	private BigDecimal fee;
	
	public Car(BigDecimal fee) {
		super();
		this.fee = fee;
	}

	@Override
	public BigDecimal getFee() {
		return fee;
	}
}
