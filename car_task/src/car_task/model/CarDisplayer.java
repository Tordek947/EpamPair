package car_task.model;

import java.util.List;

public class CarDisplayer {
	static void displayCarsInfo(List<Car> carList) {
		for(Car car:carList)
			System.out.println(car);
		System.out.println();
	}

}
