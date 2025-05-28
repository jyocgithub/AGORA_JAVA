package proyectoVictorTemperaturas.forecast;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		// it can be the same, but we'll use one different object  
		Forecast forecastReaded, forecastOfNation, forecastOfRegion, forecastOfMuni;
	

		//-----------------------------------------------------------------------------------
		// READING DATA 
		//-----------------------------------------------------------------------------------
		// The Nation
		//-----------------------------------------------------------------------------------
		System.out.println("Give me a name of the nation:");
		String nameOfNation=sc.nextLine();
				
		String textReaded="" ;
		System.out.println("Give me a name of the regions (finish with an empty line):");
		
		// read list of regions
		textReaded = stringWithComas();
		
		//Build a array of string with the names of the regions. 
		String [] regionsNameByKeyboard  = textReaded.split(",");
		//The number of regions is defined by the lenght of the array of names
		int howManyRegions = regionsNameByKeyboard.length;
		// Build the array of regions, without regions
		Region [] arrayOfRegions  = new Region[howManyRegions];

		// Each Region
		//-----------------------------------------------------------------------------------
		for (int i=0; i < howManyRegions; i++){
			
			System.out.println("Give me a name of the municipalities of "+ regionsNameByKeyboard[i]+" (finish with an empty line):");
			// read list of munis
			String listOfMunis = stringWithComas();
			String [] munisNameByKeyboard  = listOfMunis.split(",");
			int howManyMunis = munisNameByKeyboard.length;
			Municipality [] arrayOfMunicipalities = new Municipality[howManyMunis];

			// Each Muni in a region
			//-----------------------------------------------------------------------------------
			for (int j = 0; j < howManyMunis ;  j++) {
				forecastReaded = new Forecast();
				Municipality oneMuni = new Municipality(munisNameByKeyboard[j],forecastReaded );
				arrayOfMunicipalities[j] = oneMuni;
			}	
			
			// filled the arrayOfMunicipalities, we add it to the array of regions 
			forecastReaded = new Forecast();
			Region oneRegion = new Region(	regionsNameByKeyboard[i], arrayOfMunicipalities, forecastReaded)	;	
			arrayOfRegions[i] = oneRegion;
		}

		// finally here the Nation is created
		forecastReaded = new Forecast();
		Nation myNation = new Nation(nameOfNation, arrayOfRegions, forecastReaded); 
			
		
		//-----------------------------------------------------------------------------------
		// SHOWING DATA 
		//-----------------------------------------------------------------------------------
		// DATA OF NATION 
		//-----------------------------------------------------------------------------------
		System.out.println( "	==========================================") ; 
		System.out.println( "		NATION " + myNation.getName());
		System.out.println( "	------------------------------------------") ; 
		
		// get the forecast data of the Nation
		forecastOfNation = myNation.getaForecast();
			
		// paint the results
		forecastOfNation.paintForecast();
		
		// get data of array or regions
		Region [] arrayOfRegions2  = myNation.getRegions();
		
		// loop for each region
		for (int i=0; i < howManyRegions; i++){
			// DATA OF EACH REGION   
			//-----------------------------------------------------------------------------------
			
			// get one region information (different in every turn of loop)
			Region oneRegion2 = arrayOfRegions[i];
			
			// paint header of region
			System.out.println( "	==========================================") ; 
			System.out.println( "		REGION  "+oneRegion2.getName()+" forecast:" );
			System.out.println( "	------------------------------------------") ;

			// get the forecast data of the region
			forecastOfRegion = oneRegion2.getaForecast();

			// paint the results
			forecastOfRegion.paintForecast();

			// get data of array or munis
			Municipality [] arrayOfMunicipalities2 = oneRegion2.getMunicipalities();
			int numberOfMunis = oneRegion2.getMunicipalities().length; 
			
			// loop for each muni
			for (int j = 0; j < numberOfMunis; j++) {
				// DATA OF EACH MUNI
				//-----------------------------------------------------------------------------------
			
				// get one muni information (different in every turn of loop)
				Municipality oneMuni2 = arrayOfMunicipalities2[j];

				// paint header of muni
				System.out.println( "	==========================================") ; 
				System.out.println( "		Municipality "+oneMuni2.getName()+" forecast:" );
				System.out.println( "	------------------------------------------") ; 
				
				// get the forecast data of the municipality
				forecastOfMuni = oneMuni2.getaForecast();
				
				// paint the results
				forecastOfMuni.paintForecast();
			}
		}
	}
		
	
	// Method for reading a string of inputs separated with comas, 
	// Don't allow spaces or numbers
	//-----------------------------------------------------------------------------------
	public static String stringWithComas (){
		String textReaded="" ;
		String aPieceOfText="" ;
		boolean needAnotherText = true;
		Scanner input = new Scanner(System.in);
		
		// we will read words repeatedly
		while  (needAnotherText){
			aPieceOfText = input.nextLine();
			
			// if user introduce Enter only, change the boolean that controls the loop
			if (aPieceOfText.equals("") ){
				// it is not valid if there is not a entity at least introduced
				if (textReaded!="")	{
					needAnotherText = false;
				}else{
					System.out.println("ERROR: Needed al lest one entity before an empty line");
				}
			}
			else{
				// check if there is spaces at beginning or end, or any number
				if (aPieceOfText.substring(0,1).equals(" ") ||
					aPieceOfText.substring(aPieceOfText.length()-1,aPieceOfText.length()).equals(" ") ||
					aPieceOfText.contains("0") || 
					aPieceOfText.contains("1") || 
					aPieceOfText.contains("2") || 
					aPieceOfText.contains("3") || 
					aPieceOfText.contains("4") || 
					aPieceOfText.contains("5") || 
					aPieceOfText.contains("6") || 
					aPieceOfText.contains("7") || 
					aPieceOfText.contains("8") || 
					aPieceOfText.contains("9") ) {
					System.out.println("ERROR: Please don't include numbers, or spaces at the beginning or end of the line");
				}
				else{
					textReaded = textReaded +","+ aPieceOfText;
				}
			}
		}

		// the text now begins with a comma, here we separate it
		textReaded = textReaded.substring(1,textReaded.length());
		return textReaded;
	}
}
	
	
	