package p1;

public class Student {
	/**
	 * private: only visible to this class
	 * none:    visible to all classes in the same package (package-private)
	 * public:  visible to everyone
	 *
	 * - for instance variables you can set an initial value but it's not necessary (and sometimes not recommended)
	 * as that would be the default value for any new instances of the class.
	 *
	 * - for reference types, if you don't assign a default value, java will assign it as "null" which means that
	 * the variable currently holds no value.
	 */

	// instance variables A.K.A "fields", "attributes", "properties", ...
	// holds the value for the object and is unique to each instance of the class
	private String name;
	private int age;
	private double gpa;

	// static variables A.K.A "class-level" variables
	// is not copied over to new instances of the class, all instances of the class will see one value
	private static String major = "Computer Science";

	/**
	 * constructor: this special method will allow us to initialize this class with values for the fields we care
	 * about at the time the object is created. note that the moment we create our own constructor, java will no longer provide
	 * the default constructor "public Student() { ... }" and existing code might fail to compile.
	 *
	 * @param name the name of the student
	 * @param age the age of the student
	 * @param gpa the gpa of the student
	 */
	public Student(String name, int age, double gpa) {
		this.name = name;
		this.age = age;
		this.gpa = gpa;
	}

	/**
	 * - methods of the class, A.K.A "behaviour" of this class, in other words, what this class is capable of.
	 *
	 * - we can have special methods called getters/setters that either access or update our private fields
	 * in this class in controlled way. note that when we want to update a field and the new variable has the
	 * same name of the field, we can refer to the instance of the field by using "this.(variable)".
	 *
	 * - setters are sometimes called "mutators" but that is mostly an older term.
	 *
	 */

	// getters/setters

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getGpa() {
		return gpa;
	}

	public static String getMajor() {
		return major;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public void setMajor(String major) {
		Student.major = major;
	}
}
