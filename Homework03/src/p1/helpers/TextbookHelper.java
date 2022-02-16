package p1.helpers;

import p1.objects.Textbook;

public class TextbookHelper {
    private static final int MAX_ISBN_NUM = 1_000_000;
    private static final double MAX_PRICE = 300.0;
    private static final double MIN_PRICE = 50.0;

    public static Textbook generateRandomTextbook(int size) {
        return new Textbook(Util.getRandomString(size), NameHelper.generateName(size), getRandomIsbn(),
                getRandomPrice());
    }

    static double getRandomPrice() {
        return (Math.random() * MAX_PRICE) + MIN_PRICE;
    }

    static int getRandomIsbn() {
        return (int) ((Math.random() * MAX_ISBN_NUM) + 1);
    }
}
