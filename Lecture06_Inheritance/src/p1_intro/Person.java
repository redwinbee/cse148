package p1_intro;

/*
abstract here means that we're telling java that this
class should *never* be instantiated directly, it is only used
as a sort of base for other classes to extend.
 */
public abstract class Person {
    private static int count = 0;

    private Name name;
    private String id;

    public Person(Name name) {
        super();
        this.name = name;
        this.id = String.valueOf(count++);
    }

    /*
    protected access modifier states that this method is available to only
    subclasses of this class. In other words, any class that "... extends Person"
    and is another way of allowing more public access with finer control over
    who can actually use the method.
     */
    protected Name getName() {
        return name;
    }

    protected void setName(Name name) {
        this.name = name;
    }

    protected String getId() {
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
