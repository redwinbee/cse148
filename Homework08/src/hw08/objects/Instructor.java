package hw08.objects;

import hw08.IncorrectRankException;

import java.util.StringJoiner;

public class Instructor extends Person {
    private static final String[] RANKS = {"Lecturer", "Assistant Professor", "Associate Professor", "Professor"};

    private String rank;

    public Instructor(Name name, String rank) throws IncorrectRankException {
        super(name);
        if (!checkRank(rank)) {
            throw new IncorrectRankException("Rank is invalid!");
        }
        this.rank = rank;
    }

    private static boolean checkRank(String rank) {
        boolean isValidRank = false;
        for (String s : RANKS) {
            if (rank.equals(s)) {
                isValidRank = true;
                break;
            }
        }

        return isValidRank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) throws IncorrectRankException {
        if (!checkRank(rank)) {
            throw new IncorrectRankException("Rank is invalid!");
        }
        this.rank = rank;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Instructor.class.getSimpleName() + "[", "]")
                .add("name='" + super.toString() + "'")
                .add("rank='" + rank + "'")
                .toString();
    }
}
