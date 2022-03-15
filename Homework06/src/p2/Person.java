package p2;

import p1.Name;

public abstract class Person {
    private final String id;
    private static int count;
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
