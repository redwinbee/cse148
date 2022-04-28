package view;

import app.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Name;
import model.Person;
import model.Student;

import java.util.Arrays;

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
        ObservableList<String> studentsList = FXCollections.observableArrayList();
        for (Person person : App.getPersonBag().asArray()) {
            if (person instanceof Student student) {
                studentsList.add(student.toString());
            }
        }

        studentsListView = new ListView<>(studentsList);
        studentsListView.setPrefSize(600, 300);
        MultipleSelectionModel<String> selectionModel = studentsListView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            Person found = App.getPersonBag().search(person -> {
                if (person instanceof Student st) {
                    return st.toString().equals(newValue);
                }

                return false;
            })[0]; // there will only ever be one person in this result since we compare toString()

            Student student = (Student) found;
            nameField.setText(student.getName().toString());
            majorField.setText(student.getMajor());
            gpaField.setText(String.format("%.2f", student.getGpa()));
        });

        return studentsListView;
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

    private void search() {
        Person[] found = App.getPersonBag().search(this::isPartialMatch);
        if (found.length > 0) {
            // show the output in a new window
            Stage stage = new Stage();
            ObservableList<Person> people = FXCollections.observableArrayList(found);
            people.addAll(Arrays.asList(found));
            ListView<Person> listView = new ListView<>(people);
            listView.setPrefSize(500, 600);


            stage.setTitle("Students found");
            stage.setResizable(false);
            stage.setScene(new Scene(listView));
            stage.show();
        }
    }

    private void update() {
        Person updating = App.getPersonBag().search(this::isPartialMatch)[0];
        Student student = (Student) updating;
        if (!nameField.getText().isEmpty()) {
            String[] fullName = nameField.getText().split(" ");
            student.setName(new Name(fullName[0], fullName[1]));
        }
        if (!majorField.getText().isEmpty()) {
            student.setMajor(majorField.getText());
        }
        if (!gpaField.getText().isEmpty()) {
            student.setGpa(Double.parseDouble(gpaField.getText()));
        }

        updateOutput();
        clearFields();
    }

    private void remove() {
        Person[] deleted = App.getPersonBag().delete(this::isPartialMatch);
        for (Person person : deleted) {
            studentsListView.getItems().remove(person.toString());
        }

        updateOutput();
        clearFields();
        response.setText("Removed " + deleted.length + " students");
    }

    private boolean isPartialMatch(Person person) {
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
    }

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

    private void clearFields() {
        nameField.clear();
        majorField.clear();
        gpaField.clear();
    }

    public VBox getRoot() {
        return root;
    }
}
