package view;

import app.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Name;
import model.Person;
import model.Student;

public class StudentView {
    private final VBox root;
    private final Label response = new Label("Select a student");
    private ListView<String> studentsListView;
    private TextField nameField;
    private TextField majorField;
    private TextField gpaField;

    public StudentView(int spacing) {
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
        majorField = new TextField();
        majorField.setPromptText("Major");
        majorField.setPrefSize(150, 30);
        gpaField = new TextField();
        gpaField.setPromptText("GPA");
        gpaField.setPrefSize(150, 30);

        inputBox.getChildren().addAll(nameField, majorField, gpaField);
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
        ObservableList<String> studentsList = FXCollections.observableArrayList();
        for (Person person : App.getPersonBag().asArray()) {
            if (person instanceof Student student) {
                studentsList.add(student.toString());
            }
        }

        studentsListView = new ListView<>(studentsList);
        studentsListView.setPrefSize(600, 300);
        MultipleSelectionModel<String> selectionModel = studentsListView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> response.setText(newValue));

        return studentsListView;
    }

    // TODO: 4/26/22 this is really slow, maybe only update what changed.
    private void updateOutput() {
        if (!studentsListView.getItems().isEmpty()) {
            studentsListView.getItems().clear();
        }

        for (Person person : App.getPersonBag().asArray()) {
            if (person instanceof Student student) {
                studentsListView.getItems().add(student.toString());
            }
        }
    }

    private void insert() {
        String[] fullName = nameField.getText().split(" ");
        Name name = new Name(fullName[0], fullName[1]);
        double gpa = Double.parseDouble(gpaField.getText());
        String major = majorField.getText();
        Student student = new Student(name, gpa, major);
        App.getPersonBag().insert(student);
        studentsListView.getItems().add(student.toString());
    }

    private void remove() {
        Person[] deleted = App.getPersonBag().delete(person -> {
            if (person instanceof Student student) {
                boolean matchName = nameField.getText().trim().equals(student.getName().toString().trim());
                boolean matchMajor = majorField.getText().trim().equals(student.getMajor().trim());
                boolean matchGpa = false;
                if (!gpaField.getText().isEmpty()) {
                    try {
                        double delta = Math.abs(Double.parseDouble(gpaField.getText()) - student.getGpa());
                        matchGpa = delta < 0.01; // ex: for our purposes, 2.23 == 2.24
                    } catch (NumberFormatException ignored) {
                    }
                }

                return (matchName || matchMajor || matchGpa);
            }

            return false;
        });

        for (Person person : deleted) {
            studentsListView.getItems().remove(person.toString());
        }

        updateOutput();
        nameField.clear();
        majorField.clear();
        gpaField.clear();
        response.setText("Removed " + deleted.length + " students");
    }

    public VBox getRoot() {
        return root;
    }
}
