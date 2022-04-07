package p4;

import java.io.Serializable;
import java.util.StringJoiner;

public class Name implements Serializable {
    private final String middleName;
    private String firstName;
    private String lastName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Name.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("middleName=" + middleName)
                .add("lastName='" + lastName + "'")
                .toString();
    }
}
