package app;

import model.Person;
import model.PersonBagSingleton;
import util.Backup;
import util.Restore;

public class DemoSingleton {
    public static void main(String[] args) {
        PersonBagSingleton personBag = PersonBagSingleton.getInstance(1_000);
        personBag.insert(new Person("A", 2.5));
        personBag.insert(new Person("B", 3.5));
        personBag.insert(new Person("C", 3.9));

        Backup.backupPersonBagSingleton();
        PersonBagSingleton restoredPersonBag = Restore.restorePersonBagSingleton();

        System.out.println("=== PERSON BAG ==");
        personBag.display();

        System.out.println("=== RESTORED ===");
        restoredPersonBag.display();
    }
}
