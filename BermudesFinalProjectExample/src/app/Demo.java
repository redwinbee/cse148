package app;

import model.Person;
import model.PersonBag;
import util.Backup;
import util.Restore;

public class Demo {
    public static void main(String[] args) {
        PersonBag personBag = new PersonBag(1_000);
        personBag.insert(new Person("A", 2.5));
        personBag.insert(new Person("B", 3.5));
        personBag.insert(new Person("C", 3.9));
        Backup.backupPersonBag(personBag);
        PersonBag restoredBag = Restore.restorePersonBag();
        personBag.display();
        restoredBag.display();
    }
}
