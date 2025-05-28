package proyectoVictorTemperaturas.forecast;

public class Region {

	// attributes
	//-----------------------------------------------------------------------------------
	private String name ;
	private Municipality [] municipalities;
	private Forecast aForecast;
	
	// constructor
	//-----------------------------------------------------------------------------------
	public Region(String name, Municipality[] municipalities, Forecast pForecast) {
		super();
		this.name = name;
		this.aForecast = pForecast;
		this.municipalities = municipalities;
	}
	
	// setters-getters
	//-----------------------------------------------------------------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Municipality[] getMunicipalities() {
		return municipalities;
	}
	public void setMunicipalities(Municipality[] municipalities) {
		this.municipalities = municipalities;
	}
	public Forecast getaForecast() {
		return aForecast;
	}
	public void setaForecast(Forecast aForecast) {
		this.aForecast = aForecast;
	}
	
}
