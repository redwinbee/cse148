package view.person;

import app.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.person.Person;

abstract class PersonView {
    private final VBox root;

    public PersonView(int spacing) {
        root = new VBox(spacing);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(createInputs(), createButtons(), createOutput());
    }

    protected abstract HBox createInputs();

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

    protected abstract ListView<String> createOutput();

    protected abstract void insert();

    private void search() {
        Person[] found = App.getPersonBag().search(this::isPartialOrFullMatch);
        if (found.length > 0) {
            // show the output in a new window
            ObservableList<Person> people = FXCollections.observableArrayList(found);
            ListView<Person> listView = new ListView<>(people);
            listView.setPrefSize(500, 600);


            Stage stage = new Stage();
            stage.setScene(new Scene(listView));
            stage.setTitle("People found");
            stage.setResizable(false);
            stage.show();
        }
    }

    protected abstract void update();

    protected abstract void remove();

    protected abstract boolean isPartialOrFullMatch(Person person);

    public VBox getRoot() {
        return root;
    }
}
