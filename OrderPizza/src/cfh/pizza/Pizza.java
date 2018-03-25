package cfh.pizza;
import java.util.Scanner;

public class Pizza {
	private final int  PERSON_PIZZA = 0;
	private final int  FAMILY_PIZZA = 1;
	//private int selectedPizzaType;
	private String pizzaInfo;
	private double ratio;
	private int pizzaNum= 0;
	private int persons= 9;
	private double priceOfPersonPizza= 3.0;
	private double priceOfFamilyPizza= 5.3;
	private double diameterOfPersonPizza= 7.0;
	private double diameterOfFamilyPerson= 10.0;
	
	
	/***************************************************************
	 * Main Method
	 ***************************************************************/
	public static void main(String[] args) {
		System.out.println("Tasty Pizzas");
		Pizza pizza= new Pizza();
		//pizza.inData();
		pizza.process();
		pizza.printResults();
	}

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
	
	/***************************************************************
	 * costSurfaceRatio
	 * @param pizzaType
	 * @param persons
	 * @return
	 ***************************************************************/
	public double costSurfaceRatio(int pizzaType, int persons) {
		double ratio=0;
		ratio= totalCost(pizzaType, persons)/totalEatenSurface(pizzaType, persons);
		return ratio;
	}
	
	/***************************************************************
	 * totalCost
	 * @param pizzaType
	 * @param persons
	 * @return
	 ***************************************************************/
	public double totalCost(int pizzaType, int persons) {
		double cost=0;
		if(pizzaType == PERSON_PIZZA) {
			cost= persons * priceOfPersonPizza;
		}else if(pizzaType == FAMILY_PIZZA) {
			cost= ((persons+1)/2) * priceOfFamilyPizza;
		}		
		return cost;
	}
	
	
	/***************************************************************
	 * totalEatenSurface
	 * @param pizzaType
	 * @param pizzaNum
	 * @return
	 ***************************************************************/
	public double totalEatenSurface(int pizzaType, int pizzaNum) {
		double eatenSurface=0;
		if(pizzaType == PERSON_PIZZA) {
			eatenSurface= pizzaNum*pizzaSurface(diameterOfPersonPizza);
		}else if(pizzaType == FAMILY_PIZZA) {
			eatenSurface= pizzaNum*pizzaSurface(diameterOfFamilyPerson)/2;
		}
		return eatenSurface;
	}
	
	/***************************************************************
	 * pizzaSurface
	 * @param d
	 * @return
	 ***************************************************************/
	public double pizzaSurface(double d) {
		return Math.PI*(d/2)*(d/2);
	}

		
	/***************************************************************
	 * Input Data from Keyboard
	 ***************************************************************/
	public void inData() {
		Scanner input= new Scanner(System.in);
		
		System.out.print("pricePersonPizza=");		priceOfPersonPizza   = input.nextDouble();
		System.out.print("diameterPersonPizza=");	diameterOfPersonPizza= input.nextDouble();
		
		System.out.print("priceFamilyPizza=");		priceOfFamilyPizza= input.nextDouble();
		System.out.print("diameterFamilyPizza=");	diameterOfFamilyPerson= input.nextDouble();
		
		System.out.print("Number Of Persons=");		persons= input.nextInt();
		
		input.close();
	}
	
	/***************************************************************
	 * Output data on Display Console
	 ***************************************************************/
	public void printResults() {
		System.out.format("Person Pizza price is %8.2f only.", priceOfPersonPizza); 
		System.out.format("\nFamily Pizza price is %8.2f only.", priceOfFamilyPizza);
		
		System.out.format("\nOrder %d %s for %d persons, the price/surface rate is %8.5f", pizzaNum, pizzaInfo, persons, ratio);
	}
}
