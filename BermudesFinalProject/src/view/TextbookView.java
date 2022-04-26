package view;

import app.App;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Instructor;
import model.Name;
import model.Person;
import model.Textbook;

public class TextbookView {
    private final VBox root;
    private TextArea outputArea;
    private TextField titleField;
    private TextField isbnField;
    private TextField nameField;
    private TextField priceField;

    public TextbookView(int spacing) {
        root = new VBox(spacing);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(createInputs(), createButtons(), createOutput());
    }

    private HBox createInputs() {
        HBox inputBox = new HBox(15);
        inputBox.setAlignment(Pos.CENTER);
        titleField = new TextField();
        titleField.setPromptText("Title");
        titleField.setPrefSize(150, 30);
        isbnField = new TextField();
        isbnField.setPromptText("ISBN");
        isbnField.setPrefSize(150, 30);
        nameField = new TextField();
        nameField.setPromptText("Author");
        nameField.setPrefSize(150, 30);
        priceField = new TextField();
        priceField.setPromptText("Price");
        priceField.setPrefSize(150, 30);

        inputBox.getChildren().addAll(titleField, isbnField, nameField, priceField);
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
        outputArea = new TextArea();
        outputArea.setMaxSize(600, 300);
        updateOutput();

        outputBox.getChildren().addAll(outputArea);
        return outputBox;
    }

    // TODO: 4/26/22 this is really slow, maybe only update what changed.
    private void updateOutput() {
        if (!outputArea.getText().isEmpty()) {
            outputArea.clear();
        }

        for (Textbook textbook : App.getTextbookBag().asArray()) {
            outputArea.appendText(textbook + "\n");
        }
    }

    private void insert() {
        String title = titleField.getText();
        String isbn = isbnField.getText();
        String[] fullName = nameField.getText().split(" ");
        Name author = new Name(fullName[0], fullName[1]);
        double price = Double.parseDouble(priceField.getText());
        Textbook textbook = new Textbook(title, isbn, author, price);
        App.getTextbookBag().insert(textbook);
        outputArea.appendText(textbook.toString());
    }

    private void remove() {
        Person[] deleted = App.getPersonBag().delete(person -> {
            if (person instanceof Instructor instructor) {
                String name = nameField.getText();
                return instructor.getName().toString().equals(name);
            }

            return false;
        });
        for (int i = 0; i < deleted.length; i++) {
            System.out.printf("[%d]: %s%n", i, deleted[i]);
        }

        updateOutput();
        nameField.clear();
    }

    public VBox getRoot() {
        return root;
    }
}
