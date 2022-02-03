package p2_car;

public class Car {
	private static int numberOfCars = 0;
	
	private String make;
	private int year;
	private String colour;
	private boolean isEv;
	private double price;
	
	/**
	 * creates a new car
	 * 
	 * @param make the make of the car
	 * @param year the year of the car
	 * @param colour the colour of the car
	 * @param isEv whether or not the car is an EV (electric vehicle)
	 * @param price the price of the car
	 */
	public Car(String make, int year, String colour, boolean isEv, double price) {
		super();
		this.make = make;
		this.year = year;
		this.colour = colour;
		this.isEv = isEv;
		this.price = price;
		
		numberOfCars++;
	}
	
	/**
	 * creates a new car
	 * 
	 * @param make the make of the car
	 * @param year the year of the car
	 * @param isEv whether or not the car is an EV (electric vehicle)
	 */
	public Car(String make, int year, boolean isEv) {
		super();
		this.make = make;
		this.year = year;
		this.isEv = isEv;
		
		numberOfCars++;
	}
	
	/**
	 * creates a new car
	 */
	public Car() {
		numberOfCars++;
	}

	public static int getNumberOfCars() {
		return numberOfCars;
	}

	public static void setNumberOfCars(int numberOfCars) {
		Car.numberOfCars = numberOfCars;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public boolean isEv() {
		return isEv;
	}

	public void setEv(boolean isEv) {
		this.isEv = isEv;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Car{make=%s,year=%s,colour=%s,isEv=%b,price=$%.2f}", make, year, colour, isEv, price);
	}
}
