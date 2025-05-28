package proyectoVictorTemperaturas.forecast;

public class Forecast {
	
	// attributes
	//-----------------------------------------------------------------------------------
	private int windSpeed;
	private int windPrediction2;
	private int windPrediction24;
	private int windPrediction48;
	private int windPredictionAweek;
	private int windDirection;
	
	private int sunSpeed;
	private int sunPrediction2;
	private int sunPrediction24;
	private int sunPrediction48;
	private int sunPredictionAweek;
	
	private int rainSpeed;
	private int rainPrediction2;
	private int rainPrediction24;
	private int rainPrediction48;
	private int rainPredictionAweek;
	
	// constructor
	//-----------------------------------------------------------------------------------
	public Forecast() {

		this.windSpeed = (int) (Math.random()*150+1);
		this.windPrediction2 = (int) (Math.random()*100+95);
		this.windPrediction24 = (int) (Math.random()*95+1);
		this.windPrediction48 = (int) (Math.random()*80+1);
		this.windPredictionAweek = (int) (Math.random()*50+1);
		this.windDirection = (int) (Math.random()*3+1);
		
		this.sunSpeed = (int) (Math.random()*10+1);
		this.sunPrediction2 = (int) (Math.random()*100+95);
		this.sunPrediction24 = (int) (Math.random()*95+1);
		this.sunPrediction48 = (int) (Math.random()*80+1);
		this.sunPredictionAweek = (int) (Math.random()*50+1);
		
		this.rainSpeed = (int) (Math.random()*100+1);
		this.rainPrediction2 = (int) (Math.random()*100+95);
		this.rainPrediction24 = (int) (Math.random()*95+1);
		this.rainPrediction48 = (int) (Math.random()*80+1);
		this.rainPredictionAweek = (int) (Math.random()*50+1);
	}

	// paint the results of every forecast
	//-----------------------------------------------------------------------------------
	public void paintForecast() {
			
		System.out.println( "WIND  " );	
		// this method paint a graphic of wind with a different size,depending on the win speed 
		paintWindGraphics(this.getWindSpeed());
		System.out.println( "   Speed: "+ this.getWindSpeed()+ " km/h");
		System.out.println( "2 hours prediction: "+ this.getWindPrediction2()+"%");
		System.out.println( "24 hours          : "+ this.getWindPrediction24()+"%");
		System.out.println( "48 hours          : "+ this.getWindPrediction48()+"%");
		System.out.println( "a week            : "+ this.getWindPredictionAweek()+"%") ; 
		
		// analysis of the wind direction
		switch (this.getWindDirection()){
		case 1:
			System.out.println( " Direction: --> (East)"); break;
		case 2:
			System.out.println( " Direction: <-- (West)");break;
		case 3:
			System.out.println( " Direction: ^ (North)");break;
		case 4:
			System.out.println( " Direction: v (South)");break;
		}
		System.out.println( "------------------------------------------") ; 
		
		System.out.println( "SUN  " );	
		// this method paint a graphic of sun with a different size,depending on the sun UV 
		paintSunGraphics(this.getSunSpeed());
		System.out.println( "   UV: "+ this.getSunSpeed() );	
		System.out.println( "2 hours prediction: "+ this.getSunPrediction2()+"%");
		System.out.println( "24 hours          : "+ this.getSunPrediction24()+"%");
		System.out.println( "48 hours          : "+ this.getSunPrediction48()+"%");
		System.out.println( "a week            : "+ this.getSunPredictionAweek()+"%") ; 
		System.out.println( "-----------------------------------------") ; 
		
		System.out.println( "RAIN  " );
		// this method paint a graphic of rain with a different size,depending on the rain liters 
		paintRainGraphics(this.getRainSpeed());
		System.out.println( "   Precipitation: "+this.getRainSpeed()+ " mm.");
		System.out.println( "2 hours prediction: "+ this.getRainPrediction2()+"%");
		System.out.println( "24 hours          : "+ this.getRainPrediction24()+"%");
		System.out.println( "48 hours          : "+ this.getRainPrediction48()+"%");
		System.out.println( "a week            : "+ this.getRainPredictionAweek()+"%") ; 
		System.out.println("");
	}
	
	
	// paints the graphic of the rain with different size depending upon the value of indice, 
	// that is, the magnitude of the phenomenon
	//-----------------------------------------------------------------------------------
	static public void paintRainGraphics(int indice ){
		if (indice < 30){
			System.out.println("///");
			System.out.println("///");
			System.out.println("///");
		} else if (indice >= 30 && indice < 66){
			System.out.println("//////");
			System.out.println("//////");
			System.out.println("//////");
		} else {
			System.out.println("/////////");
			System.out.println("/////////");
			System.out.println("/////////"); 
		}
		if (indice > 89){
			System.out.println("              WARNING !!!!: RED ALARM !!!!"); 
		}else if (indice > 50) {
			System.out.println("              WARNING !!: ORANGE ALARM !!");
		}	
	}
		
	// paints the graphic of the sun with different size depending upon the value of indice, 
	// that is, the magnitude of the phenomenon
	//-----------------------------------------------------------------------------------
	static public void paintSunGraphics(int indice ){
		if (indice < 4){
			System.out.println(" \\  |  / ");
			System.out.println("-­‐-­‐O-­‐-­‐");
			System.out.println(" /  |  \\"); 	
		} else if (indice >= 4 && indice < 7){
			System.out.println(" \\  |||  / ");
			System.out.println("-­‐-­‐oOo-­‐-­‐");
			System.out.println(" /  |||  \\");
		} else {
			System.out.println(" \\  |||||  / ");
			System.out.println("-­‐-­‐oOOOo-­‐-­‐");
			System.out.println(" /  |||||  \\"); 
		}
		if (indice > 8){
			System.out.println("              WARNING !!!!: RED ALARM !!!!"); 
		}else if (indice > 5) {
			System.out.println("              WARNING !!: ORANGE ALARM !!");
		}
	}
	
	// paints the graphic of the wind with different size depending upon the value of indice, 
	// that is, the magnitude of the phenomenon
	//-----------------------------------------------------------------------------------
	static public void paintWindGraphics(int indice ){
			if (indice < 45){
			System.out.println("-­‐-  >");
			System.out.println("-­‐-  >");
			System.out.println("-­‐-  >"); 	
		} else if (indice >= 45 && indice < 100){
			System.out.println("-­‐ -­‐  >");
			System.out.println("-­‐ -­‐  >");
			System.out.println("-­‐ -­‐  >"); 
		} else {
			System.out.println("-­‐ -­‐- -- >");
			System.out.println("-­‐ -­‐- -- >");
			System.out.println("-­‐ -­‐- -- >"); 
		}
		if (indice > 134){
			System.out.println("              WARNING !!!!: RED ALARM !!!!"); 
		}else if (indice > 75) {
			System.out.println("              WARNING !!: ORANGE ALARM !!");
		}
	}
	
	
	
	// setters-getters
	//-----------------------------------------------------------------------------------
	public int getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(int windSpeed) {
		this.windSpeed = windSpeed;
	}
	public int getWindPrediction2() {
		return windPrediction2;
	}
	public void setWindPrediction2(int windPrediction2) {
		this.windPrediction2 = windPrediction2;
	}
	public int getWindPrediction24() {
		return windPrediction24;
	}
	public void setWindPrediction24(int windPrediction24) {
		this.windPrediction24 = windPrediction24;
	}
	public int getWindPrediction48() {
		return windPrediction48;
	}
	public void setWindPrediction48(int windPrediction48) {
		this.windPrediction48 = windPrediction48;
	}
	public int getWindPredictionAweek() {
		return windPredictionAweek;
	}
	public void setWindPredictionAweek(int windPredictionAweek) {
		this.windPredictionAweek = windPredictionAweek;
	}
	public int getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(int windDirection) {
		this.windDirection = windDirection;
	}
	public int getSunSpeed() {
		return sunSpeed;
	}
	public void setSunSpeed(int sunSpeed) {
		this.sunSpeed = sunSpeed;
	}
	public int getSunPrediction2() {
		return sunPrediction2;
	}
	public void setSunPrediction2(int sunPrediction2) {
		this.sunPrediction2 = sunPrediction2;
	}
	public int getSunPrediction24() {
		return sunPrediction24;
	}
	public void setSunPrediction24(int sunPrediction24) {
		this.sunPrediction24 = sunPrediction24;
	}
	public int getSunPrediction48() {
		return sunPrediction48;
	}
	public void setSunPrediction48(int sunPrediction48) {
		this.sunPrediction48 = sunPrediction48;
	}
	public int getSunPredictionAweek() {
		return sunPredictionAweek;
	}
	public void setSunPredictionAweek(int sunPredictionAweek) {
		this.sunPredictionAweek = sunPredictionAweek;
	}
	public int getRainSpeed() {
		return rainSpeed;
	}
	public void setRainSpeed(int rainSpeed) {
		this.rainSpeed = rainSpeed;
	}
	public int getRainPrediction2() {
		return rainPrediction2;
	}
	public void setRainPrediction2(int rainPrediction2) {
		this.rainPrediction2 = rainPrediction2;
	}
	public int getRainPrediction24() {
		return rainPrediction24;
	}
	public void setRainPrediction24(int rainPrediction24) {
		this.rainPrediction24 = rainPrediction24;
	}
	public int getRainPrediction48() {
		return rainPrediction48;
	}
	public void setRainPrediction48(int rainPrediction48) {
		this.rainPrediction48 = rainPrediction48;
	}
	public int getRainPredictionAweek() {
		return rainPredictionAweek;
	}
	public void setRainPredictionAweek(int rainPredictionAweek) {
		this.rainPredictionAweek = rainPredictionAweek;
	}

}
