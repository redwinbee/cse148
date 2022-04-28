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


public class InstructorView {
    private final VBox root;
    private final Label response = new Label("Select an instructor");
    private ListView<String> instructorListView;
    private TextField nameField;
    private TextField rankField;
    private TextField salaryField;

    public InstructorView(int spacing) {
        root = new VBox(spacing);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(createInputs(), createButtons(), createOutput(), response);
    }

    private HBox createInputs() {
        HBox inputBox = new HBox(15);
        inputBox.setAlignment(Pos.CENTER);
        nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.setPrefSize(150, 30);
        rankField = new TextField();
        rankField.setPromptText("Rank");
        rankField.setPrefSize(150, 30);
        salaryField = new TextField();
        salaryField.setPromptText("Salary");
        salaryField.setPrefSize(150, 30);

        inputBox.getChildren().addAll(nameField, rankField, salaryField);
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
        for (Person person : App.getPersonBag().asArray()) {
            if (person instanceof Instructor instructor) {
                textbooksList.add(instructor.toString());
            }
        }

        instructorListView = new ListView<>(textbooksList);
        instructorListView.setPrefSize(600, 300);
        MultipleSelectionModel<String> selectionModel = instructorListView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> response.setText(newValue));

        return instructorListView;
    }

    // TODO: 4/26/22 this is really slow, maybe only update what changed.
    private void updateOutput() {
        if (!instructorListView.getItems().isEmpty()) {
            instructorListView.getItems().clear();
        }

        for (Person person : App.getPersonBag().asArray()) {
            if (person instanceof Instructor instructor) {
                instructorListView.getItems().add(instructor.toString());
            }
        }
    }

    private void insert() {
        String[] fullName = nameField.getText().split(" ");
        Name name = new Name(fullName[0], fullName[1]);
        String rank = rankField.getText();
        double salary = Double.parseDouble(salaryField.getText());
        Instructor instructor = new Instructor(name, rank, salary);
        App.getPersonBag().insert(instructor);
        instructorListView.getItems().add(instructor.toString());
    }

    private void remove() {
        Person[] deleted = App.getPersonBag().delete(person -> {
            if (person instanceof Instructor instructor) {
                boolean matchName = nameField.getText().trim().equals(instructor.getName().toString().trim());
                boolean matchRank = rankField.getText().trim().equals(instructor.getRank().trim());
                boolean matchSalary = false;
                if (!salaryField.getText().isEmpty()) {
                    double delta = Math.abs(Double.parseDouble(salaryField.getText()) - instructor.getSalary());
                    matchSalary = delta < 0.01;
                }

                return matchName || matchRank || matchSalary;
            }

            return false;
        });

        for (Person person : deleted) {
            System.out.println(person);
            instructorListView.getItems().remove(person.toString());
        }

        updateOutput();
        nameField.clear();
        rankField.clear();
        salaryField.clear();
        response.setText("Removed " + deleted.length + " students");
    }

    public VBox getRoot() {
        return root;
    }
}
