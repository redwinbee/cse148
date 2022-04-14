package app;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Demo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("First Window");

        // box with some buttons inside
        HBox buttonBox = new HBox(20);
        buttonBox.setAlignment(Pos.CENTER);
        Button insertButton = new Button("Insert");
        insertButton.setPrefSize(100, 30);
        Button searchButton = new Button("Search");
        searchButton.setPrefSize(100, 30);
        Button updateButton = new Button("Update");
        updateButton.setPrefSize(100, 30);
        Button removeButton = new Button("Remove");
        removeButton.setPrefSize(100, 30);

        buttonBox.getChildren().addAll(insertButton, searchButton, updateButton, removeButton);

        // box with text field to allow user to input data
        HBox inputBox = new HBox(20);
        inputBox.setAlignment(Pos.CENTER);
        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.setPrefSize(150, 30);
        TextField gpaField = new TextField();
        gpaField.setPromptText("GPA");
        gpaField.setPrefSize(150, 30);

        inputBox.getChildren().addAll(nameField, gpaField);

        // box with text field to show output
        VBox outputBox = new VBox(20);
        outputBox.setAlignment(Pos.CENTER);
        TextField outputField = new TextField();
        outputField.setMaxSize(300, 30);
        TextArea outputArea = new TextArea();
        outputArea.setMaxSize(600, 300);

        outputBox.getChildren().addAll(outputField, outputArea);

        // create a root to store our two other boxes
        VBox root = new VBox(50);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(inputBox, buttonBox, outputBox);

        // add some functionality to the buttons
        insertButton.setOnAction(event -> {
            String name = nameField.getText();
            double gpa = Double.parseDouble(gpaField.getText());
            nameField.clear();
            gpaField.clear();
            outputField.setText("Results");
            outputArea.appendText(String.format("hey %s, your curved gpa is %.1f%n", name, (gpa + 0.5)));
        });

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}
