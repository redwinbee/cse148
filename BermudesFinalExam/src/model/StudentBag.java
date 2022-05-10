package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.function.Predicate;

@SuppressWarnings("serial")
public class StudentBag implements Serializable {
	private Student[] students;
	private int elements;
	
	public StudentBag(int initialSize) {
		students = new Student[initialSize];
	}
	
	public void insert(Student student) {
		if (elements >= students.length) {
			students = resize();
		}
		students[elements++] = student;
	}
	
	public Student[] search(Predicate<Student> predicate) {
		Student[] out = new Student[elements];
		int count = 0;
		for (int i = 0; i < elements; i++) {
			if (predicate.test(students[i])) {
				out[count++] = students[i];
			}
		}
		
		return Arrays.copyOf(out, count);
	}
	
	public Student[] remove(Predicate<Student> predicate) {
		Student[] out = new Student[elements];
		int count = 0;
		for (int i = 0; i < elements; i++) {
			if (predicate.test(students[i])) {
				out[count++] = students[i];
				for (int j = i; j < elements - 1; j++) {
					students[j] = students[j + 1];
				}
				
				if (i == elements - 1) {
					students[i] = null;
				}
				
				elements--;
				i--;
			}
		}
		
		return Arrays.copyOf(out, count);
	}
	
	public void displayBag() {
		for (int i = 0; i < elements; i++) {
			System.out.printf("[%d]: %s%n", i, students[i]);
		}
	}

	public int getElementCount() {
		return elements;
	}

	public void setElementCount(int peopleElementCount) {
		elements = peopleElementCount;
	}

	public Student[] currentPeople() {
		Student[] out = new Student[elements];
		System.arraycopy(students, 0, out, 0, elements);
		return out;
	}
	
    private Student[] resize() {
        Student[] out = new Student[students.length + 10];
        for (int i = 0; i < students.length; i++) {
        	out[i] = students[i];
        }
        return out;
    }
}
