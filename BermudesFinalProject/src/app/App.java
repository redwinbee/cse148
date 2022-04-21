package app;

import javafx.application.Application;
import javafx.stage.Stage;
import model.bag.PersonBag;
import model.bag.TextbookBag;
import util.Storage;
import util.Utilities;

public class App extends Application {
    private static final int MAX_TEXTBOOKS = 1_000;
    private static final int MAX_STUDENTS = 1_000;
    private static final int MAX_INSTRUCTORS = 500;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextbookBag textbookBag = Utilities.importTextbooks(MAX_TEXTBOOKS);
        PersonBag personBag = Utilities.importPeople(MAX_STUDENTS, MAX_INSTRUCTORS);

        primaryStage.setOnCloseRequest(event -> Storage.backup(textbookBag, personBag));
        primaryStage.show();
    }
}
