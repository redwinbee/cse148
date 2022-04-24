package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class TextbookView {
    private final VBox root;

    public TextbookView(int spacing) {
        root = new VBox(spacing);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(createInputs(), createButtons(), createOutput());
    }

    private HBox createInputs() {
        HBox inputBox = new HBox(15);
        inputBox.setAlignment(Pos.CENTER);
        TextField nameField = new TextField();
        nameField.setPromptText("Title");
        nameField.setPrefSize(150, 30);
        TextField gpaField = new TextField();
        gpaField.setPromptText("ISBN");
        gpaField.setPrefSize(150, 30);

        inputBox.getChildren().addAll(nameField, gpaField);
        return inputBox;
    }

    private HBox createButtons() {
        HBox box = new HBox(15);
        box.setAlignment(Pos.CENTER);
        Button insertButton = new Button("Insert");
        insertButton.setPrefSize(100, 30);
        Button searchButton = new Button("Search");
        searchButton.setPrefSize(100, 30);
        Button updateButton = new Button("Update");
        updateButton.setPrefSize(100, 30);
        Button removeButton = new Button("Remove");
        removeButton.setPrefSize(100, 30);

        box.getChildren().addAll(insertButton, searchButton, updateButton, removeButton);
        return box;
    }

    private VBox createOutput() {
        VBox outputBox = new VBox(20);
        outputBox.setAlignment(Pos.CENTER);
        TextArea outputArea = new TextArea();
        outputArea.setMaxSize(600, 300);

        outputBox.getChildren().addAll(outputArea);
        return outputBox;
    }

    public VBox getRoot() {
        return root;
    }
}
