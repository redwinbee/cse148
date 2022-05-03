package view;

import app.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Textbook;
import model.person.Name;
import util.Storage;

public class TextbookView {
    private final VBox root;
    private ListView<String> textbooksListView;
    private TextField titleField;
    private TextField isbnField;
    private TextField authorField;
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
        authorField = new TextField();
        authorField.setPromptText("Author");
        authorField.setPrefSize(150, 30);
        priceField = new TextField();
        priceField.setPromptText("Price");
        priceField.setPrefSize(150, 30);

        inputBox.getChildren().addAll(titleField, isbnField, authorField, priceField);
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
        searchButton.setOnAction(event -> search());
        Button updateButton = new Button("Update");
        updateButton.setPrefSize(100, 30);
        updateButton.setOnAction(event -> update());
        Button removeButton = new Button("Remove");
        removeButton.setPrefSize(100, 30);
        removeButton.setOnAction(event -> remove());

        box.getChildren().addAll(insertButton, searchButton, updateButton, removeButton);
        return box;
    }

    private ListView<String> createOutput() {
        ObservableList<String> textbooksList = FXCollections.observableArrayList();
        for (Textbook textbook : App.getTextbookBag().currentTextbooks()) {
            textbooksList.add(textbook.toString());
        }

        textbooksListView = new ListView<>(textbooksList);
        textbooksListView.setPrefSize(600, 300);
        MultipleSelectionModel<String> selectionModel = textbooksListView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // might've already been removed
            if (newValue == null) {
                return;
            }

            Textbook found = App.getTextbookBag().search(textbook -> textbook.toString().equals(newValue))[0];
            titleField.setText(found.getTitle());
            isbnField.setText(found.getIsbn());
            authorField.setText(found.getAuthor().toString());
            priceField.setText(String.format("%.2f", found.getPrice()));
        });

        return textbooksListView;
    }

    private void insert() {
        String title = titleField.getText();
        String isbn = isbnField.getText();
        String[] fullName = authorField.getText().split(" ");
        Name author = new Name(fullName[0], fullName[1]);
        double price = Double.parseDouble(priceField.getText());
        Textbook textbook = new Textbook(title, isbn, author, price);
        App.getTextbookBag().insert(textbook);
        Storage.backup(App.getTextbookBag());
        textbooksListView.getItems().add(textbook.toString());
        updateOutput();
        clearFields();
    }

    private void search() {
        Textbook[] found = App.getTextbookBag().search(this::isPartialOrFullMatch);
        if (found.length > 0) {
            // show the output in a new window
            Stage stage = new Stage();
            ObservableList<Textbook> textbooks = FXCollections.observableArrayList(found);
            ListView<Textbook> listView = new ListView<>(textbooks);
            listView.setPrefSize(500, 600);


            stage.setTitle("Textbooks found");
            stage.setResizable(false);
            stage.setScene(new Scene(listView));
            stage.show();
        }
    }

    private void update() {
        String focusedItem = textbooksListView.getFocusModel().getFocusedItem();
        if (!focusedItem.isEmpty()) {
            Textbook updating = App.getTextbookBag().search(textbook -> textbook.toString().equals(focusedItem))[0];
            if (!titleField.getText().isEmpty()) {
                updating.setTitle(titleField.getText());
            }
            if (!isbnField.getText().isEmpty()) {
                updating.setIsbn(isbnField.getText());
            }
            if (!authorField.getText().isEmpty()) {
                String[] fullName = authorField.getText().split(" ");
                updating.setAuthor(new Name(fullName[0], fullName[1]));
            }
            if (!priceField.getText().isEmpty()) {
                updating.setPrice(Double.parseDouble(priceField.getText()));
            }

            updateOutput();
            clearFields();
        }
    }

    private void remove() {
        Textbook[] deleted = App.getTextbookBag().delete(this::isPartialOrFullMatch);
        for (Textbook textbook : deleted) {
            textbooksListView.getItems().remove(textbook.toString());
        }

        updateOutput();
        clearFields();
    }

    private boolean isPartialOrFullMatch(Textbook textbook) {
        boolean matchTitle = titleField.getText().equals(textbook.getTitle());
        boolean matchIsbn = isbnField.getText().equals(textbook.getIsbn());
        boolean matchAuthor = authorField.getText().equals(textbook.getAuthor().toString());
        boolean matchPrice = false;
        if (!priceField.getText().isEmpty()) {
            double delta = Math.abs(Double.parseDouble(priceField.getText()) - textbook.getPrice());
            matchPrice = delta < 0.01;
        }

        return (!titleField.getText().isEmpty() && !isbnField.getText().isEmpty() && !authorField.getText().isEmpty() && !priceField.getText().isEmpty())
                ? (matchTitle && matchIsbn && matchAuthor && matchPrice)
                : (matchTitle || matchIsbn || matchAuthor || matchPrice);
    }

    private void updateOutput() {
        if (!textbooksListView.getItems().isEmpty()) {
            textbooksListView.getItems().clear();
        }

        for (Textbook textbook : App.getTextbookBag().currentTextbooks()) {
            textbooksListView.getItems().add(textbook.toString());
        }

        Storage.backup(App.getTextbookBag());
    }

    private void clearFields() {
        titleField.clear();
        isbnField.clear();
        authorField.clear();
        priceField.clear();
    }

    public VBox getRoot() {
        return root;
    }
}
