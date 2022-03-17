package p2;

import p1.Name;

@SuppressWarnings("unused")
public abstract class Person {
    private static int count;
    private final String id;
    private Name name;

    public Person(Name name) {
        this.name = name;
        this.id = String.valueOf(count++);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", id='" + id + '\'' +
                '}';
    }
}
