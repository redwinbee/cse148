package p1.helpers;

import p1.models.Name;

public class NameHelper {
    public Name generateName(int size) {
        return new Name(Util.getRandomString(size), Util.getRandomString(size));
    }
}
