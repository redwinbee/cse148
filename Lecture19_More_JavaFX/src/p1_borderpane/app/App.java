package p1_borderpane.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        PersonView personView = new PersonView(new ArrayList<>());

        // create a menu bar
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");

        MenuItem exit = new MenuItem("Exit");
        MenuItem importStudents = new MenuItem("Import Students");
        MenuItem importInstructors = new MenuItem("Import Instructors");

        exit.setOnAction(event -> Platform.exit());

        fileMenu.getItems().addAll(exit);
        editMenu.getItems().addAll(importStudents, importInstructors);

        menuBar.getMenus().add(fileMenu);
        menuBar.getMenus().add(editMenu);

        // set the root up with our menus
        root.setTop(menuBar);
        root.setCenter(personView.getRoot());

        Scene scene = new Scene(root, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
