package view;

import app.App;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Name;
import model.Person;
import model.Student;

public class StudentView {
    private final VBox root;
    private TextField nameField;
    private TextField majorField;
    private TextField gpaField;
    private TextArea outputArea;

    public StudentView(int spacing) {
        root = new VBox(spacing);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(createInputs(), createButtons(), createOutput());
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

    private VBox createOutput() {
        VBox outputBox = new VBox(20);
        outputBox.setAlignment(Pos.CENTER);
        outputArea = new TextArea();
        outputArea.setMaxSize(600, 300);
        for (Person person : App.getPersonBag().asArray()) {
            if (person instanceof Student student) {
                outputArea.appendText(student + "\n");
            }
        }

        outputBox.getChildren().addAll(outputArea);
        return outputBox;
    }

    private void insert() {
        String[] fullName = nameField.getText().split(" ");
        Name name = new Name(fullName[0], fullName[1]);
        double gpa = Double.parseDouble(gpaField.getText());
        String major = majorField.getText();
        Student student = new Student(name, gpa, major);
        App.getPersonBag().insert(student);
        outputArea.appendText(student.toString());
    }

    private void remove() {
        Person[] deleted = App.getPersonBag().delete(person -> {
            if (person instanceof Student student) {
                String name = nameField.getText();
                return student.getName().toString().equals(name);
            }

            return false;
        });
        for (int i = 0; i < deleted.length; i++) {
            System.out.printf("[%d]: %s%n", i, deleted[i]);
        }

        nameField.clear();
        majorField.clear();
        gpaField.clear();
    }

    public VBox getRoot() {
        return root;
    }
}
