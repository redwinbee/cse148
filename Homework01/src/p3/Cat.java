package p3;

public class Cat {
	public String name;
	public double weight = 15.0;

	/**
	 * creates a new cat with the specified name
	 *
	 * @param name the name of the cat
	 */
	public Cat(String name) {
		this.name = name;
	}

	/**
	 * feeds the cat a specified amount of food. each time the cat is fed more
	 * than 10 ounces of food, it gains 1 ounce of weight.
	 *
	 * @param foodAmount the amount to feed the cat
	 */
	public void feed(double foodAmount) {
		weight += (int) (foodAmount / 10);
	}

	// getters/setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
