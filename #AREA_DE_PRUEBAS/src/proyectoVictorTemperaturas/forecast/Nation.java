package proyectoVictorTemperaturas.forecast;

public class Nation {

	// attributes
	//-----------------------------------------------------------------------------------
	private String name; 
	private Region [] regions ;
	private Forecast aForecast;

	// constructor
	//-----------------------------------------------------------------------------------
	public Nation(String pname , Region[] regions, Forecast fore) {
		super();
		this.name = pname;
		this.regions = regions;
		this.aForecast = fore;
	}

	// setters-getters
	//-----------------------------------------------------------------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Region[] getRegions() {
		return regions;
	}
	public void setRegions(Region[] regions) {
		this.regions = regions;
	}
	public Forecast getaForecast() {
		return aForecast;
	}
	public void setaForecast(Forecast aForecast) {
		this.aForecast = aForecast;
	}
}
