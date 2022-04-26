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


public class InstructorView {
    private final VBox root;
    private TextArea outputArea;
    private TextField nameField;
    private TextField rankField;
    private TextField salaryField;

    public InstructorView(int spacing) {
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

        for (Person person : App.getPersonBag().asArray()) {
            if (person instanceof Instructor instructor) {
                outputArea.appendText(instructor + "\n");
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
        outputArea.appendText(instructor.toString());
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
        rankField.clear();
        salaryField.clear();
    }

    public VBox getRoot() {
        return root;
    }
}
