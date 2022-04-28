package view;

import app.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Instructor;
import model.Name;
import model.Person;
import model.Textbook;

public class TextbookView {
    private final VBox root;
    private final Label response = new Label("Select a textbook");
    private ListView<String> textbooksListView;
    private TextField titleField;
    private TextField isbnField;
    private TextField nameField;
    private TextField priceField;

    public TextbookView(int spacing) {
        root = new VBox(spacing);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(createInputs(), createButtons(), createOutput(), response);
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
        insertButton.setOnAction(event -> insert());
        Button searchButton = new Button("Search");
        searchButton.setPrefSize(100, 30);
        Button updateButton = new Button("Update");
        updateButton.setPrefSize(100, 30);
        Button removeButton = new Button("Remove");
        removeButton.setPrefSize(100, 30);
        removeButton.setOnAction(event -> remove());

        box.getChildren().addAll(insertButton, searchButton, updateButton, removeButton);
        return box;
    }

    private ListView<String> createOutput() {
        ObservableList<String> textbooksList = FXCollections.observableArrayList();
        for (Textbook textbook : App.getTextbookBag().asArray()) {
            textbooksList.add(textbook.toString());
        }

        textbooksListView = new ListView<>(textbooksList);
        textbooksListView.setPrefSize(600, 300);
        MultipleSelectionModel<String> selectionModel = textbooksListView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> response.setText(newValue));

        return textbooksListView;
    }

    // TODO: 4/26/22 this is really slow, maybe only update what changed.
    private void updateOutput() {
        if (!textbooksListView.getItems().isEmpty()) {
            textbooksListView.getItems().clear();
        }

        for (Textbook textbook : App.getTextbookBag().asArray()) {
            textbooksListView.getItems().add(textbook.toString());
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
        textbooksListView.getItems().add(textbook.toString());
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
