package car_task.filter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import car_task.model.Car;

public class CarFilter {
	private List<Car> carList;

	public CarFilter(List<Car> carList) {
		this.carList = carList;
	}
	
	public List<Car> makeFilter(String make){
		var filteredList = new ArrayList<Car>();
		for(Car car : carList) {
			if (car.getMake().compareTo(make) == 0) {
				filteredList.add(car);
			}
		}
		return filteredList;
	}
	
	public List<Car> ageModelFilter(String model, int minAge){
		var filteredList = new ArrayList<Car>();
		int currentYear = getCurrentYear();
		for(Car car : carList) {
			if ((car.getModel().compareTo(model) == 0) &&
					((currentYear - car.getReleaseYear()) > minAge)) {
				filteredList.add(car);
			}
		}
		return filteredList;
	}
	
	private int getCurrentYear() {
		Calendar c = new GregorianCalendar();
		return c.get(Calendar.YEAR);
	}

	public List<Car> releaseYearMinPriceFilter(int year, int minPrice){
		var filteredList = new ArrayList<Car>();
		for(Car car : carList) {
			if ((car.getReleaseYear() == year) &&
					(car.getPrice() > minPrice)) {
				filteredList.add(car);
			}
		}
		return filteredList;
	}
	
	enum FilterType{
		MAKE("by make"),
		AGE_MODEL("by model with minimum car age"),
		RELEASE_YEAR_MIN_PRICE("by release year with minimum car price");
		private String description;
		private FilterType(String description) {
			this.description = description;
		}
		public String getDescription() {
			return description;
		}
	}
}
