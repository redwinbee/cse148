package p1;

public class Name {
	private String firstName;
	private String lastName;

	/**
	 * represents a persons name
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("name={%s, %s}", firstName, lastName);
	}
}
