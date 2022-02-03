package p4;

public class Book {
	private String title;
	private double price;
	
	/**
	 * creates a new book with the specified title and price
	 * 
	 * @param title name of the book
	 * @param price cost of the book
	 */
	public Book(String title, double price) {
		this.title = title;
		this.price = price;
	}
	
	public String getTitle() {
		return title;
	}
	
	public double getPrice() {
		return price;
	}
}
