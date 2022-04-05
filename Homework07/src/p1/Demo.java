package p1;

import java.util.ArrayList;
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
        String choice;
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> sales = new ArrayList<>();
        ArrayList<Customer> customers = new ArrayList<>();
        while (true) {
            System.out.println("enter sale (form: 'name,sale_value') or 'done' to process: ");
            choice = scanner.nextLine();
            if (choice.equals("done")) {
                break;
            }
            String[] values = choice.split(",");
            names.add(values[0]);
            try {
                sales.add(Double.parseDouble(values[1]));
            } catch (NumberFormatException ex) {
                System.err.println("failed to parse double!");
                ex.printStackTrace();
            }

        }

        //Q4 - build the customers list from the values collected
        for (int i = 0; i < names.size(); i++) {
            customers.add(new Customer(names.get(i), sales.get(i)));
        }

        System.out.println("name of best customer: " + nameOfBestCustomer(sales, names));
        System.out.println("name of best customer: " + nameOfBestCustomer(customers));

        scanner.close();

        // Q5
        Person p1 = new Student(new Name("John", "Doe"), 4.0);
        Person p2 = new Student(new Name("Jane", "Doe"), 3.5);
        Person p3 = new Instructor(new Name("Alex", "Doe"), "Professor");
        Person p4 = new Instructor(new Name("Amy", "Doe"), "Assistant Professor");
        PersonBag bag = new PersonBag(4);
        bag.insert(p1);
        bag.insert(p2);
        bag.insert(p3);
        bag.insert(p4);

        System.out.println("=== DISPLAY BAG ===");
        bag.display();

        System.out.println("=== SEARCH BY RANK ===");
        ArrayList<Person> searchResults = bag.search(person -> {
            if (person instanceof Instructor instructor) {
                return instructor.getRank().equals("Professor");
            } else {
                return false;
            }
        });
        display(searchResults);

        System.out.println("=== REMOVE ===");
        bag.remove(searchResults.get(0));

        System.out.println("=== DISPLAY BAG (AFTER MODIFICATIONS ===");
        bag.display();
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

    public static String nameOfBestCustomer(ArrayList<Customer> customers) {
        double highestSale = customers.get(0).getSale();
        String mvpCustomer = customers.get(0).getName();

        for (Customer customer : customers) {
            if (customer.getSale() > highestSale) {
                highestSale = customer.getSale();
                mvpCustomer = customer.getName();
            }
        }

        return mvpCustomer;
    }

    private static ArrayList<Integer> generateRandomIntegerList(int size) {
        ArrayList<Integer> out = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            out.add(i, (int) (Math.random() * 20));
        }

        return out;
    }

    public static void display(ArrayList<Person> people) {
        for (int i = 0; i < people.size(); i++) {
            System.out.printf("[%d]: %s%n", i, people.get(i));
        }
    }
}
