package car_task.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class CarFactory {
	private static String[] makers = {"Toyota","Lexus","Ford","Lada","BMW","Tesla"};
	private static String[] models = {"Mini","Focus","Golf","Passat","Camry"};
	private static String[] colors = {"White","Blue","Black","Yellow","Grey"};
	private static int nextId = 0; 
	
	static ArrayList<Car> generateCars(){
		var carList = new ArrayList<Car>();
		for(int i = 0; i < 20; i++)
			carList.add(getCar());
		return carList;
	}
	static Car getCar() {
		nextId++;
		return new Car(generateMake(),generateModel(),generateColor(),nextId, generateYear(),generatePrice(),generateRegNumber());
	}
	private static String generateMake() {
		int i = (int) (Math.random()*(makers.length-1));
		return makers[i];
	}
	private static String generateModel() {
		int i = (int) (Math.random()*(models.length-1));
		return models[i];
	}
	private static String generateColor() {
		int i = (int) (Math.random()*(colors.length-1));
		return colors[i];
	}
	private static int generateYear() {
		return 2000 + (int) (Math.random()*18);
	}
	private static int generatePrice() {
		var random = new Random();
		return 10_000  + random.nextInt(20_000-10_000);
	}
	private static int generateRegNumber() {
		var random = new Random();
		return 500_000  + random.nextInt(1_000_000-500_000);
	}
}
