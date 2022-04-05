package p1;

import java.util.StringJoiner;

public class Instructor extends Person {
    private String rank;

    public Instructor(Name name, String rank) {
        super(name);
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Instructor.class.getSimpleName() + "[", "]")
                .add("name='" + this.getName().toString() + "'")
                .add("rank='" + rank + "'")
                .toString();
    }
}
