package p1_intro;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Pet cat = new Cat("cat", 10, "White");
        Pet dog = new Dog("dog", 11, "Dachshund");
        System.out.println("cat: " + cat);
        System.out.println("dog: " + dog);

        /*
        once more we see polymorphism allows us to store subclasses of Pet
        into a Pet[] array, however, we *cannot* store Cat objects inside an array
        of Dog's:
            will not compile:
                Dog[] dogs = new Dog[1];
                dogs[0] = new Cat("cat1", 10)";
         */
        Pet[] pets = new Pet[2];
        pets[0] = cat;
        pets[1] = dog;
        cat.move();
        dog.move();

        /*
        we know as programmers that dog.getBreed() *should* be available, however since we
        defined dog to be of type Pet, java doesn't know implicitly that dog has a method
        called getBreed(). In order to use dog.getBreed(), we have to let java know that
        this object does indeed have this method available via casting
         */
        System.out.println("cat: " + ((Cat) cat).getColour());
        System.out.println("dog: " + ((Dog) dog).getBreed());


        Pet d1 = new Dog("C2", 5, "Golden");
        Pet d2 = new Dog("D2", 6, "Black");
        Pet c1 = new Cat("C1", 7, "Golden");
        Pet c2 = new Cat("C2", 8, "White");
        PetBag petBag = new PetBag(10);
        petBag.insert(d1);
        petBag.insert(d2);
        petBag.insert(c1);
        petBag.insert(c2);
        petBag.display();

        Pet[] matchedByName = petBag.searchBy(c2.getName());
        System.out.printf("matched by name of [%s]:%n", c2.getName());
        System.out.println(Arrays.toString(matchedByName));

        Pet[] matchedByWeight = petBag.searchBy(d2.getWeight());
        System.out.printf("matched by weight of [%s]:%n", d2.getWeight());
        System.out.println(Arrays.toString(matchedByWeight));

        Pet[] matchedByColour = petBag.searchByColour(((Cat) c1).getColour());
        System.out.printf("matched by colour of [%s]:%n", ((Cat) c1).getColour());
        System.out.println(Arrays.toString(matchedByColour));

        Pet[] removedByName = petBag.removeBy(c2.getName());
        System.out.printf("removed by name of [%s]:%n", c2.getName());
        petBag.display();
    }
}
