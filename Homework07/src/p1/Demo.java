package p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        // Q1
        ArrayList<Integer> listA = generateRandomIntegerList((int) (Math.random() * 20));
        ArrayList<Integer> listB = generateRandomIntegerList((int) (Math.random() * 20));
        ArrayList<Integer> merged = merge(listA, listB);

        System.out.println("listA: " + listA);
        System.out.println("listB: " + listB);
        System.out.println("merged: " + merged);

        // Q2
        ArrayList<Integer> listC = generateRandomIntegerList((int) (Math.random() * 20));
        listC.sort(Integer::compareTo);
        ArrayList<Integer> listD = generateRandomIntegerList((int) (Math.random() * 20));
        listD.sort(Integer::compareTo);
        ArrayList<Integer> mergeSorted = mergeSorted(listC, listD);

        System.out.println("listC: " + listD);
        System.out.println("listD: " + listC);
        System.out.println("mergeSorted: " + mergeSorted);

        // Q3
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a command-separated list of sales: ");
        String[] lineSales = scanner.nextLine().split(",");
        ArrayList<Double> sales = new ArrayList<>();
        for (String lineSale : lineSales) {
            try {
                sales.add(Double.valueOf(lineSale));
            } catch (NumberFormatException ex) {
                System.err.println("failed to parse sale value!");
            }
        }

        System.out.print("enter a command-separated list of customer names: ");
        String[] lineCustomers = scanner.nextLine().split(",");
        ArrayList<String> customers = new ArrayList<>(Arrays.asList(lineCustomers));

        System.out.printf("best customer: %s%n", nameOfBestCustomer(sales, customers));
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

    public static String nameOfBestCustomer(ArrayList<Double> sales, ArrayList<String> customers) {
        double highestSale = sales.get(0);
        String correspondingCustomer = customers.get(0);

        if (sales.size() == 1 || customers.size() == 1) {
            //only 1 person in the list
            return correspondingCustomer;
        } else {
            for (int i = 0; i < customers.size(); i++) {
                try {
                    if (sales.get(i) > highestSale) {
                        correspondingCustomer = customers.get(i);
                        highestSale = sales.get(i);
                    }
                } catch (IndexOutOfBoundsException ex) {
                    // no more sales, return the latest
                    return correspondingCustomer;
                }
            }
        }

        return correspondingCustomer;
    }

    private static ArrayList<Integer> generateRandomIntegerList(int size) {
        ArrayList<Integer> out = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            out.add(i, (int)(Math.random() * 20));
        }

        return out;
    }
}
