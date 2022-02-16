package p1.helpers;

public class Util {

    private Util() {
    }

    static String getRandomString(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= size; i++) {
            char ch = (char) ((Math.random() * size) + 'A');
            sb.append(ch);
        }

        return sb.toString();
    }
}
