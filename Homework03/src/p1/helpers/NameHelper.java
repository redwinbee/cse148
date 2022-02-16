package p1.helpers;

import p1.objects.Name;

public class NameHelper {
    public static Name generateName(int nameLength) {
        return new Name(Util.getRandomString(nameLength), Util.getRandomString(nameLength));
    }
}
