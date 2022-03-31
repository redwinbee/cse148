package p1;

public class Demo2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};

        // this is not ideal, you always want to avoid this kind of exception instead of using try/catch
        for (int i = 0; i <= array.length; i++) {
            try {
                System.out.printf("[%d] %d%n", i, array[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.printf("[ex]: array idx out of bounds, [len=%d], [idx=%d]%n", array.length, i);
            }
        }
    }
}
