package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import persistence.Storage;
import view.PersonView;

import java.util.ArrayList;

public class Demo extends Application {
    private ArrayList<String> results = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        runRestore();

        // load views
        PersonView personView = new PersonView(results);
        VBox root = personView.getRoot();

        // set the stage
        primaryStage.setTitle("First Window");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setOnCloseRequest(event -> runBackup());
        primaryStage.show();

        // for debug purposes
        display(results);
    }

    private void display(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("\t[%d]: %s", i, list.get(i));
        }
    }

    private void runBackup() {
        System.out.printf("[backup]: backing up %d objects...%n", results.size());
        Storage.backup(results);
    }

    private void runRestore() {
        results = Storage.restore();
        System.out.printf("[restore]: restoring %d objects to memory...%n", results.size());
    }
}
