package view.person;

import app.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.Name;
import model.Person;
import model.Student;
import util.Storage;

public class StudentView extends PersonView {
    private ListView<String> studentsListView;
    private TextField nameField;
    private TextField majorField;
    private TextField gpaField;

    public StudentView(int spacing) {
        super(spacing);
    }

    protected HBox createInputs() {
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

    protected ListView<String> createOutput() {
        ObservableList<String> studentsList = FXCollections.observableArrayList();
        for (Person person : App.getPersonBag().currentPeople()) {
            if (person instanceof Student student) {
                studentsList.add(student.toString());
            }
        }

        studentsListView = new ListView<>(studentsList);
        studentsListView.setPrefSize(600, 300);
        MultipleSelectionModel<String> selectionModel = studentsListView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // might've already been removed
            if (newValue == null) {
                return;
            }

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

    protected void insert() {
        String[] fullName = nameField.getText().split(" ");
        Name name = new Name(fullName[0], fullName[1]);
        double gpa = Double.parseDouble(gpaField.getText());
        String major = majorField.getText();
        Student student = new Student(name, gpa, major);
        App.getPersonBag().insert(student);
        Storage.backup(App.getPersonBag());
        studentsListView.getItems().add(student.toString());
    }

    protected void update() {
        Person updating = App.getPersonBag().search(this::isPartialOrFullMatch)[0];
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

    protected void remove() {
        Person[] deleted = App.getPersonBag().delete(this::isPartialOrFullMatch);
        for (Person person : deleted) {
            studentsListView.getItems().remove(person.toString());
        }

        updateOutput();
        clearFields();
    }

    protected boolean isPartialOrFullMatch(Person person) {
        if (person instanceof Student student) {
            boolean matchName = nameField.getText().trim().equals(student.getName().toString().trim());
            boolean matchMajor = majorField.getText().equals(student.getMajor());
            boolean matchGpa = false;
            if (!gpaField.getText().isEmpty()) {
                try {
                    double delta = Math.abs(Double.parseDouble(gpaField.getText()) - student.getGpa());
                    matchGpa = delta < 0.01; // ex: for our purposes, 2.23 == 2.24
                } catch (NumberFormatException ignored) {
                }
            }

            return (!nameField.getText().isEmpty() && !majorField.getText().isEmpty() && !gpaField.getText().isEmpty())
                    ? (matchName && matchMajor && matchGpa)
                    : (matchName || matchMajor || matchGpa);
        }

        return false;
    }

    private void updateOutput() {
        if (!studentsListView.getItems().isEmpty()) {
            studentsListView.getItems().clear();
        }

        for (Person person : App.getPersonBag().currentPeople()) {
            if (person instanceof Student student) {
                studentsListView.getItems().add(student.toString());
            }
        }

        Storage.backup(App.getPersonBag());
    }

    private void clearFields() {
        nameField.clear();
        majorField.clear();
        gpaField.clear();
    }
}
