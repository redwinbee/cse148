package p1;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> listA = generateRandomIntegerList((int) (Math.random() * 20));
        ArrayList<Integer> listB = generateRandomIntegerList((int) (Math.random() * 20));
        ArrayList<Integer> merged = merge(listA, listB);

        System.out.println("listA: " + listA);
        System.out.println("listB: " + listB);
        System.out.println("merged: " + merged);

        ArrayList<Integer> listC = generateRandomIntegerList((int) (Math.random() * 20));
        listC.sort(Integer::compareTo);
        ArrayList<Integer> listD = generateRandomIntegerList((int) (Math.random() * 20));
        listD.sort(Integer::compareTo);
        ArrayList<Integer> mergeSorted = mergeSorted(listC, listD);

        System.out.println("listC: " + listD);
        System.out.println("listD: " + listC);
        System.out.println("mergeSorted: " + mergeSorted);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> out = new ArrayList<>();
        int minSize = Math.min(a.size(), b.size());
        int outIdx = 0;
        for (int i = 0; i < minSize; i++) {
            out.add(outIdx++, a.get(i));
            out.add(outIdx++, b.get(i));
        }

        if (a.size() > minSize) {
            for (int i = minSize; i < a.size(); i++) {
                out.add(outIdx++, a.get(i));
            }
        } else if (b.size() > minSize) {
            for (int i = minSize; i < b.size(); i++) {
                out.add(outIdx++, b.get(i));
            }
        }

        return out;
    }

    public static ArrayList<Integer> mergeSorted(ArrayList<Integer> a, ArrayList<Integer> b) {
        int size = a.size() + b.size();
        ArrayList<Integer> out = new ArrayList<>(size);

        int aIdx = 0;
        int bIdx = 0;
        for (int i = 0; i <= size; i++) {
            try {
                if (a.get(aIdx) <= b.get(bIdx)) {
                    out.add(a.get(aIdx++));
                }
            } catch (IndexOutOfBoundsException ex) {
                for (; i < b.size(); i++) {
                    out.add(b.get(bIdx++));
                }
            }

            try {
                if (b.get(bIdx) <= a.get(aIdx)) {
                    out.add(b.get(bIdx++));
                }
            } catch (IndexOutOfBoundsException ex) {
                for (; i < a.size(); i++) {
                    out.add(a.get(aIdx++));
                }
            }
        }

        return out;
    }

    private static ArrayList<Integer> generateRandomIntegerList(int size) {
        ArrayList<Integer> out = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            out.add(i, (int)(Math.random() * 20));
        }

        return out;
    }
}
