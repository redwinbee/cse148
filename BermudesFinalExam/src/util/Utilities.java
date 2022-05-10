package util;

import model.Student;
import model.StudentBag;

public class Utilities {
	
	public static StudentBag importStudents(int numStudents) {
		if (Storage.BACKUP_FILE.exists()) {
			return Storage.restore();
		}
		
		StudentBag studentBag = new StudentBag(numStudents);
		Student[] generated = generateStudents(numStudents);
		for (Student student : generated) {
			studentBag.insert(student);
		}
		
		return studentBag;
	}
	
	public static Student[] generateStudents(int count) {
		Student[] out = new Student[count];
		for (int i = 0; i < count; i++) {
			out[i] = new Student(randomName(), randomGpa());
		}
		
		return out;
	}
	
    public static String randomName() {
    	String[] lastNames = Importer.getLastNames();
    	return lastNames[(int) (Math.random() * lastNames.length)];
    }
    
    public static double randomGpa() {
    	return Math.random() * 4.0;
    }
}
