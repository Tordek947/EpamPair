package car_task.model;

import java.util.ArrayList;
import car_task.filter.*;
import car_task.filter.stub.*;

public class CarRunner {

	public static void main(String[] args) {
		int operationTime = 5; 
		int releaseYear = 2003;
		int minPrice = 15_000;
		String make = "Ford"; 
		String model = "Focus";
		
		ArrayList<Car> carList = CarFactory.generateCars();
		var filter = new CarFilter(carList);
		
		System.out.println("Model " +">"+ make +"<" + " cars:" +"\n");
		CarDisplayer.displayCarsInfo(filter.makeFilter(make));
		
		System.out.println("Models " +">"+ model +"<"+" cars with operation time more than " +">"+ operationTime +"<"+ " years:" +"\n");
		CarDisplayer.displayCarsInfo(filter.ageModelFilter(model, operationTime));
		
		System.out.println("Cars with release year "+">" + releaseYear +"<"+ " and price higher than "+">$"+ minPrice +"<:" +"\n");
		CarDisplayer.displayCarsInfo(filter.releaseYearMinPriceFilter(releaseYear, minPrice));
	}
}
