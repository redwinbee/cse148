package model.person;

import util.Utilities;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * Represents a persons name.
 */
public class Name implements Serializable {
    private String firstName;
    private String lastName;

    /**
     * Create a new name object from a first and last name string.
     *
     * @param firstName The first name.
     * @param lastName  The last name.
     */
    public Name(String firstName, String lastName) {
        this.firstName = Utilities.capitalize(firstName);
        this.lastName = Utilities.capitalize(lastName);
    }

    /**
     * Returns this person's first name.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets this person's first name.
     *
     * @param firstName The new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns this person's last name.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets this person's last name.
     *
     * @param lastName The new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns a string representation of this person's name. More specifically,
     * in the form: "John Doe" if the name object is Name[firstName="John", lastName="Doe"]
     *
     * @return This person's full name.
     */
    @Override
    public String toString() {
        return new StringJoiner(" ")
                .add(firstName)
                .add(lastName)
                .toString();
    }
}
