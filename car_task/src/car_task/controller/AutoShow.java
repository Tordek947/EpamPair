package car_task.controller;

import java.util.List;

import car_task.filter.CarFilter;
import car_task.model.Car;
import car_task.model.CarFactory;

public class AutoShow {
	private List<Car> cars;
	private CarFilter carFilter;
	private String name;
	
	public static AutoShow[] getAllAutoShows() {
		var autoshowTypes = AutoShowType.values();
		var autoshows = new AutoShow[autoshowTypes.length];
		for(int i = 0;i<autoshows.length;i++) {
			autoshows[i] = getAutoShow(autoshowTypes[i]);
		}
		return autoshows;
	}
	
	public static AutoShow getAutoShow(AutoShowType type) {
		return new AutoShow(CarFactory.generateCars(type.getCarCount()), type.toString());
	}
	
	private AutoShow(List<Car> cars, String name) {
		this.cars = cars;
		this.name = name;
		this.carFilter = new CarFilter(cars);
	}
	
	public 
	
	enum AutoShowType{
		PARIS("Paris Auto Show",30), NEW_YORK("New York Auto Show",35),
			CHICAGO("Chicago Auto Show",25);
		private String name;
		private int carCount;
		private AutoShowType(String name, int carCount) {
			this.name = name;
			this.carCount = carCount;
		}
		public int getCarCount() {
			return carCount;
		}
		@Override
		public String toString() {
			return name;
		}
	}
}
