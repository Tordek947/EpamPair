package car_task.model;
public class Car {

	private final int id;
	private final String make;
	private final String model; 
	private String color; 
	private final int releaseYear;
	private int price;
	private final int registrationNumber;
	
	Car(String make, String model, String color, int id, int year, int price, int registrationNumber){
		this.id = id;
		this.make = make;
		this.model = model;
		this.color = color;
		this.releaseYear = year;
		this.price = price;
		this.registrationNumber = registrationNumber;
	}
	int getId() {
		return id;
	}
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public int getPrice() {
		return price;
	}
	public String toString() {
		super.toString();
		return  "Car:" + id + " \t Make: " + make + " / Model: " + model + " / Year: " + releaseYear + " / Price: $" + price;
	}
}
