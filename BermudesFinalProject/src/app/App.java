package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.bag.PersonBag;
import model.bag.TextbookBag;
import util.Storage;
import util.Utilities;
import view.TextbookView;
import view.person.InstructorView;
import view.person.StudentView;

public class App extends Application {
    private static final int MAX_TEXTBOOKS = 1_000;
    private static final int MAX_STUDENTS = 1_000;
    private static final int MAX_INSTRUCTORS = 500;

    private static TextbookBag textbookBag;
    private static PersonBag personBag;
    private StudentView studentView;
    private InstructorView instructorView;
    private TextbookView textbookView;
    private BorderPane root;

    public static void main(String[] args) {
        launch(args);
    }

    public static PersonBag getPersonBag() {
        return personBag;
    }

    public static TextbookBag getTextbookBag() {
        return textbookBag;
    }

    @Override
    public void init() {
        // initialize data
        textbookBag = Utilities.importTextbooks(MAX_TEXTBOOKS);
        personBag = Utilities.importPeople(MAX_STUDENTS, MAX_INSTRUCTORS);

        // initialize views
        studentView = new StudentView(20);
        instructorView = new InstructorView(20);
        textbookView = new TextbookView(20);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();
        root.setTop(createMenu());
        root.setCenter(studentView.getRoot());
        Scene scene = new Scene(root, 700, 500);

        primaryStage.setTitle("Bermudes Final Project");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> Storage.backup(textbookBag, personBag));
        primaryStage.show();
    }

    private MenuBar createMenu() {
        MenuBar menuBar = new MenuBar();

        Menu edit = new Menu("Edit");
        MenuItem student = new MenuItem("Student");
        MenuItem instructor = new MenuItem("Instructor");
        MenuItem textbook = new MenuItem("Textbook");
        edit.getItems().addAll(student, instructor, textbook);

        student.setOnAction(event -> root.setCenter(studentView.getRoot()));
        instructor.setOnAction(event -> root.setCenter(instructorView.getRoot()));
        textbook.setOnAction(event -> root.setCenter(textbookView.getRoot()));

        menuBar.getMenus().addAll(edit);
        return menuBar;
    }
}
