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
import view.InstructorView;
import view.StudentView;
import view.TextbookView;

public class App extends Application {
    private static final int MAX_TEXTBOOKS = 1_000;
    private static final int MAX_STUDENTS = 1_000;
    private static final int MAX_INSTRUCTORS = 500;

    private static TextbookBag textbookBag;
    private static PersonBag personBag;
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
    public void start(Stage primaryStage) throws Exception {
        textbookBag = Utilities.importTextbooks(MAX_TEXTBOOKS);
        personBag = Utilities.importPeople(MAX_STUDENTS, MAX_INSTRUCTORS);

        root = new BorderPane();
        root.setTop(createMenu());
        root.setCenter(new StudentView(20).getRoot());
        Scene scene = new Scene(root, 700, 500);

        primaryStage.setTitle("Bermudes Final Project");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(event -> Storage.backup(textbookBag, personBag));
        primaryStage.show();
    }

    private MenuBar createMenu() {
        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");

        MenuItem saveItem = new MenuItem("Save");
        MenuItem importItem = new MenuItem("Import");
        MenuItem exportItem = new MenuItem("Export");
        file.getItems().addAll(saveItem, importItem, exportItem);

        MenuItem student = new MenuItem("Student");
        MenuItem instructor = new MenuItem("Instructor");
        MenuItem textbook = new MenuItem("Textbook");
        edit.getItems().addAll(student, instructor, textbook);

        student.setOnAction(event -> root.setCenter(new StudentView(20).getRoot()));
        instructor.setOnAction(event -> root.setCenter(new InstructorView(20).getRoot()));
        textbook.setOnAction(event -> root.setCenter(new TextbookView(20).getRoot()));

        menuBar.getMenus().addAll(file, edit);

        return menuBar;
    }
}
