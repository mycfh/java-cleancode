package cfh.simple2.pizza;

public class Pizza {
	private final int  PERSON_PIZZA = 0;
	private final int  FAMILY_PIZZA = 1;
	//private int selectedPizzaType;
	private String pizzaInfo;
	private double ratio;
	private int pizzaNum;
	
	private int persons= 9;
	private double priceOfPP= 3.0;
	private double priceOfFP= 5.3;
	private double diameterOfPP= 7.0;
	private double diameterOfFP= 10.0;
	
	
	/***************************************************************
	 * 
	 ***************************************************************/
	public void process() {
		
		if(costSurfaceRatio(PERSON_PIZZA, persons) > costSurfaceRatio(FAMILY_PIZZA, persons)) {
			//selectedPizzaType= FAMILY_PIZZA;
			ratio= costSurfaceRatio(FAMILY_PIZZA, persons);
			pizzaInfo= "family pizzas";
			pizzaNum= (persons+1)/2;
		}else{
			//selectedPizzaType= PERSON_PIZZA;
			ratio= costSurfaceRatio(PERSON_PIZZA, persons);
			pizzaInfo= "person pizzas";
			pizzaNum= persons;
		}
	}
	

	public double costSurfaceRatio(int pizzaType, int pizzaNum) {
		double ratio=0;
		ratio= totalCost(pizzaType, pizzaNum)/totalEatenSurface(pizzaType, pizzaNum);
		return ratio;
	}
	
	public double totalCost(int pizzaType, int pizzaNum) {
		double cost=0;
		if(pizzaType == PERSON_PIZZA) {
			cost= pizzaNum*priceOfPP;
		}else if(pizzaType == FAMILY_PIZZA) {
			cost= ((pizzaNum+1)/2)*priceOfFP;
		}		
		return cost;
	}
	
	public double totalEatenSurface(int pizzaType, int pizzaNum) {
		double eatenSurface=0;
		if(pizzaType == PERSON_PIZZA) {
			eatenSurface= pizzaNum*pizzaSurface(diameterOfPP);
		}else if(pizzaType == FAMILY_PIZZA) {
			eatenSurface= pizzaNum*pizzaSurface(diameterOfFP)/2;
		}
		return eatenSurface;
	}
	
	public double pizzaSurface(double d) {
		return Math.PI*(d/2)*(d/2);
	}

		
	/***************************************************************
	 * Accessors
	 ***************************************************************/
	public int getPersons() {
		return persons;
	}

	public void setPersons(int persons) {
		this.persons = persons;
	}

	public double getPriceOfPP() {
		return priceOfPP;
	}

	public void setPriceOfPP(double priceOfPP) {
		this.priceOfPP = priceOfPP;
	}

	public double getPriceOfFP() {
		return priceOfFP;
	}

	public void setPriceOfFP(double priceOfFP) {
		this.priceOfFP = priceOfFP;
	}

	public double getDiameterOfPP() {
		return diameterOfPP;
	}

	public void setDiameterOfPP(double diameterOfPP) {
		this.diameterOfPP = diameterOfPP;
	}

	public double getDiameterOfFP() {
		return diameterOfFP;
	}

	public void setDiameterOfFP(double diameterOfFP) {
		this.diameterOfFP = diameterOfFP;
	}

	public String results() {
		return String.format("\norder %d %s for %d persons, the price/surface rate is %8.5f", pizzaNum, pizzaInfo, persons, ratio);
	}
}
