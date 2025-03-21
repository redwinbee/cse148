package model.person;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * Represents a person in the most general meaning of what it means
 * to be a person. Each person has a name and ID, where the ID is unique to
 * each new person created.
 */
public abstract class Person implements Serializable {
    private static int idCount;
    private final String id;
    private Name name;

    /**
     * Creates a new person with the given name.
     *
     * @param name The name to give this person.
     */
    public Person(Name name) {
        this.id = String.valueOf(idCount++);
        this.name = name;
    }

    /**
     * Sets the ID count. This should only be called internally,
     * unfortunately this is the best solution I have so far, maybe there is
     * a way to make this more internal (private)
     * <p>
     * I can't just use the same variable from the deserialization process because
     * it needs to be static for counting instances and static variables aren't serialized.
     *
     * @param idCount The new ID count
     */
    public static void setIdCount(int idCount) {
        Person.idCount = idCount;
    }

    /**
     * Gets the person's ID number.
     *
     * @return The ID number.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets this person's name.
     *
     * @return The name.
     */
    public Name getName() {
        return name;
    }

    /**
     * Sets this person's name.
     *
     * @param name The new name.
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * Returns a string representation of this person. Contains both their name and ID number.
     *
     * @return This person in string format.
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name=" + name)
                .toString();
    }
}
