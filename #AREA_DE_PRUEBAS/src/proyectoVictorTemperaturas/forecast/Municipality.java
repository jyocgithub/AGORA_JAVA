package proyectoVictorTemperaturas.forecast;

public class Municipality {

	// attributes
	//-----------------------------------------------------------------------------------
	private String name;
	private Forecast aForecast;

	// constructor
	//-----------------------------------------------------------------------------------
	public Municipality(String name,  Forecast pForecast) {
		this.name = name;
		this.aForecast = pForecast;
	}
	
	// setters-getters
	//-----------------------------------------------------------------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Forecast getaForecast() {
		return aForecast;
	}
	public void setaForecast(Forecast aForecast) {
		this.aForecast = aForecast;
	}
}
