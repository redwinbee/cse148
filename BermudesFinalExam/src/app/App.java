package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Student;
import model.StudentBag;
import util.Storage;
import util.Utilities;
import view.StudentView;

public class App extends Application {
	private static final int STUDENT_COUNT = 50;
	private static StudentBag studentBag;
	private StudentView studentView;
	private BorderPane root;
	
	public static void main(String[] args) {
		testBag();
		launch(args);
	}
	
	@Override
	public void init() throws Exception {
		// initialize data
		studentBag = Utilities.importStudents(50);
		System.out.println("=== STUDENTS ===");
		studentBag.displayBag();
		
		// initialize view
		studentView = new StudentView(20);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();
        root.setCenter(studentView.getRoot());
        Scene scene = new Scene(root, 700, 500);
        
		primaryStage.setTitle("Bermudes Final Exam");
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(event -> Storage.backup(studentBag));
		primaryStage.show();
	}

	private static void testBag() {
		StudentBag testBag = new StudentBag(3);
		testBag.insert(new Student("John Doe", 3.2));
		testBag.insert(new Student("Jane Doe", 3.5));
		testBag.insert(new Student("Edwin Bermudes", 3.8));
		
		// display
		System.out.println("=== ORIGINAL TEST ARRAY === ");
		testBag.displayBag();
		
		// test search
		System.out.println("=== TEST SEARCH BY GPA ===");
		Student[] gpa39OrHigher = testBag.search(s -> s.getGpa() >= 3.5);
		display(gpa39OrHigher);
		
		// test remove
		System.out.println("=== TEST REMOVE BY ID=0 ===");
		Student[] removeById = testBag.remove(s -> s.getId().equals("0"));
		display(removeById);
		
		// show modified test bag
		System.out.println("=== MODIFIED TEST ARRAY ===");
		testBag.displayBag();
	}

	private static void display(Student... students) {
		for (int i = 0; i < students.length; i++) {
			System.out.printf("[%d]: %s%n", i, students[i]);
		}
	}

	public static StudentBag getStudentBag() {
		return studentBag;
	}
}