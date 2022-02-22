package p1_intro;

public class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * the default constructor created by java for any given class
     * that doesn't supply a constructor of its own. this can also be called a
     * "no-arg constructor" since it has no arguments.
     *
     * super() is always, *always*, the first method that is called in a
     * constructor-- whether it was explicitly written or not.
     */
    public Name() {
        super();
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
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
