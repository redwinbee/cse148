package p1;

import java.util.StringJoiner;

public abstract class Person {
    private static int count;
    private final String id;
    private Name name;

    public Person(Name name) {
        super();
        this.id = String.valueOf(count++);
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("name=" + name)
                .add("id='" + id + "'")
                .toString();
    }
}
