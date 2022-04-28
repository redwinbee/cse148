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
import model.Instructor;
import model.Name;
import model.Person;

import java.util.Arrays;


public class InstructorView {
    private final VBox root;
    private ListView<String> instructorListView;
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
        for (Person person : App.getPersonBag().asArray()) {
            if (person instanceof Instructor instructor) {
                textbooksList.add(instructor.toString());
            }
        }

        instructorListView = new ListView<>(textbooksList);
        instructorListView.setPrefSize(600, 300);
        MultipleSelectionModel<String> selectionModel = instructorListView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            Person found = App.getPersonBag().search(person -> {
                if (person instanceof Instructor ins) {
                    return ins.toString().equals(newValue);
                }

                return false;
            })[0]; // there will only ever be one person in this result since we compare toString()

            Instructor instructor = (Instructor) found;
            nameField.setText(instructor.getName().toString());
            rankField.setText(instructor.getRank());
            salaryField.setText(String.format("%.2f", instructor.getSalary()));
        });

        return instructorListView;
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

    private void search() {
        Person[] found = App.getPersonBag().search(this::isPartialOrFullMatch);
        if (found.length > 0) {
            // show the output in a new window
            Stage stage = new Stage();
            ObservableList<Person> people = FXCollections.observableArrayList(found);
            people.addAll(Arrays.asList(found));
            ListView<Person> listView = new ListView<>(people);
            listView.setPrefSize(500, 600);


            stage.setTitle("Instructors found");
            stage.setResizable(false);
            stage.setScene(new Scene(listView));
            stage.show();
        }
    }

    private void update() {
        Person updating = App.getPersonBag().search(this::isPartialOrFullMatch)[0];
        Instructor instructor = (Instructor) updating;
        if (!nameField.getText().isEmpty()) {
            String[] fullName = nameField.getText().split(" ");
            instructor.setName(new Name(fullName[0], fullName[1]));
        }
        if (!rankField.getText().isEmpty()) {
            instructor.setRank(rankField.getText());
        }
        if (!salaryField.getText().isEmpty()) {
            instructor.setSalary(Double.parseDouble(salaryField.getText()));
        }

        updateOutput();
        clearFields();
    }

    private void remove() {
        Person[] deleted = App.getPersonBag().delete(this::isPartialOrFullMatch);
        for (Person person : deleted) {
            instructorListView.getItems().remove(person.toString());
        }

        updateOutput();
        clearFields();
    }

    private boolean isPartialOrFullMatch(Person person) {
        if (person instanceof Instructor instructor) {
            boolean matchName = nameField.getText().equals(instructor.getName().toString());
            boolean matchRank = rankField.getText().equals(instructor.getRank());
            boolean matchSalary = false;
            if (!salaryField.getText().isEmpty()) {
                double delta = Math.abs(Double.parseDouble(salaryField.getText()) - instructor.getSalary());
                matchSalary = delta < 0.01;
            }

            return (!nameField.getText().isEmpty() && !rankField.getText().isEmpty() && !salaryField.getText().isEmpty())
                    ? (matchName && matchRank && matchSalary)
                    : (matchName || matchRank || matchSalary);
        }

        return false;
    }

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

    private void clearFields() {
        nameField.clear();
        rankField.clear();
        salaryField.clear();
    }

    public VBox getRoot() {
        return root;
    }
}
