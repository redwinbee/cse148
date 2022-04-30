package model.bag;

import model.Person;
import model.Textbook;

import java.io.Serializable;
import java.util.Arrays;
import java.util.function.Predicate;

public class TextbookBag implements Serializable {
    private Textbook[] textbooks;
    private int elements;

    public TextbookBag(int initialCapacity) {
        this.textbooks = new Textbook[initialCapacity];
    }

    /**
     * Inserts a textbook into the array. If the backing array is at max
     * capacity it will automatically be expanded by 10; this is done by
     * copying the array to a new array with the capacity set to:
     * <p>
     * newArray[oldArray + 10]
     * <p>
     * with all contents being copied over to the new array and the textbook
     * to be inserted at the end.
     *
     * @param textbook The textbook to add to the bag.
     */
    public void insert(Textbook textbook) {
        if (elements >= textbooks.length) {
            textbooks = resize();
        }

        textbooks[elements++] = textbook;
    }

    /**
     * Searches the backing array for a textbook that returns true for the
     * given predicate. If the array does not contain any such textbook objects,
     * the result is an empty array, otherwise the results.
     *
     * @param predicate The predicate to test each textbook with.
     * @return An array list of textbooks found, if any.
     */
    public Textbook[] search(Predicate<Textbook> predicate) {
        Textbook[] out = new Textbook[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (predicate.test(textbooks[i])) {
                out[count++] = textbooks[i];
            }
        }

        return Arrays.copyOf(out, count);
    }

    /**
     * Deletes all textbook objects from the backing array that match
     * the given predicate. The array is modified after each removal to
     * avoid nulls in between data and truncated. The result is returned
     * as an array of Textbook objects that can potentially contain zero values
     * if the predicate returned false for all elements in the array.
     *
     * @param predicate The predicate to test each element with.
     * @return The textbooks deleted from the bag, if any.
     */
    @SuppressWarnings("ManualArrayCopy")
    public Textbook[] delete(Predicate<Textbook> predicate) {
        Textbook[] out = new Textbook[elements];
        int count = 0;
        for (int i = 0; i < elements; i++) {
            if (predicate.test(textbooks[i])) {
                out[count++] = textbooks[i];
                for (int j = i; j < elements - 1; j++) {
                    textbooks[j] = textbooks[j + 1];
                }

                // make sure we remove the last element
                if (i == elements - 1) {
                    textbooks[i] = null;
                }

                elements--;
                i--;
            }
        }

        return Arrays.copyOf(out, count);
    }

    /**
     * Display the contents of the bag.
     */
    public void display() {
        for (int i = 0; i < elements; i++) {
            System.out.printf("[%d]: %s%n", i, textbooks[i]);
        }
    }

    public Textbook[] currentTextbooks() {
        Textbook[] out = new Textbook[elements];
        System.arraycopy(textbooks, 0, out, 0, elements);
        return out;
    }


    private Textbook[] resize() {
        Textbook[] out = new Textbook[textbooks.length + 10];
        System.arraycopy(textbooks, 0, out, 0, textbooks.length);
        return out;
    }

    public int getElementCount() {
        return elements;
    }

    public void setElementCount(int elementCount) {
        this.elements = elementCount;
    }

    public int capacity() {
        return textbooks.length;
    }
}
