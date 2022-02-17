package p1;

import java.util.Arrays;

@SuppressWarnings("all")
public class DemoVariables {
    public static void main(String[] args) {
//        int n = 10;
//        display(n);

        // passing display into display() only passes the memory address of "array"
        // pass-by-value
        // "shallow copy"
        int[] array = {1, 2, 3, 4};
        display(array);
        System.out.println("Output from main(): " + Arrays.toString(array));
    }
//    private static void display(int n) {
//        System.out.println("Output from display(): " + n);
//    }

    private static void display(int[] array) {
        // this is how we make a "deep copy" of the data if we want changes to only affect this local array
        int[] copy = arrayCopy(array);
        copy[0] = 100;
        System.out.println("Output from display(): " + Arrays.toString(copy));
    }

    private static int[] arrayCopy(int[] in) {
        int[] out = new int[in.length];
        for (int i = 0; i < out.length; i++) {
            out[i] = in[i];
        }

        // this is how you would write the code above using the java built in classes
//        System.arraycopy(in, 0, out, 0, out.length);

        return out;
    }
}
