package view.person;

import app.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model.person.Instructor;
import model.person.Name;
import model.person.Person;
import model.person.Rank;
import util.Storage;

public class InstructorView extends PersonView {
    private ListView<String> instructorListView;
    private TextField nameField;
    private ComboBox<Rank> rankComboBox;
    private TextField salaryField;

    public InstructorView(int spacing) {
        super(spacing);
    }

    protected HBox createInputs() {
        HBox inputBox = new HBox(15);
        inputBox.setAlignment(Pos.CENTER);
        nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.setPrefSize(150, 30);
        rankComboBox = new ComboBox<>();
        rankComboBox.getItems().addAll(Rank.values());
        rankComboBox.setPromptText("Select Rank");
        rankComboBox.setPrefSize(160, 30);
        salaryField = new TextField();
        salaryField.setPromptText("Salary");
        salaryField.setPrefSize(150, 30);

        inputBox.getChildren().addAll(nameField, rankComboBox, salaryField);
        return inputBox;
    }

    protected ListView<String> createOutput() {
        ObservableList<String> textbooksList = FXCollections.observableArrayList();
        for (Person person : App.getPersonBag().currentPeople()) {
            if (person instanceof Instructor instructor) {
                textbooksList.add(instructor.toString());
            }
        }

        instructorListView = new ListView<>(textbooksList);
        instructorListView.setPrefSize(600, 300);
        MultipleSelectionModel<String> selectionModel = instructorListView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // might've already been removed
            if (newValue == null) {
                return;
            }

            Person found = App.getPersonBag().search(person -> {
                if (person instanceof Instructor ins) {
                    return ins.toString().equals(newValue);
                }

                return false;
            })[0]; // there will only ever be one person in this result since we compare toString()

            Instructor instructor = (Instructor) found;
            nameField.setText(instructor.getName().toString());
            rankComboBox.getSelectionModel().select(instructor.getRank());
            salaryField.setText(String.format("%.2f", instructor.getSalary()));
        });

        return instructorListView;
    }

    protected void insert() {
        String[] fullName = nameField.getText().split(" ");
        Name name = new Name(fullName[0], fullName[1]);
        Rank rank = rankComboBox.getValue();
        double salary = Double.parseDouble(salaryField.getText());
        Instructor instructor = new Instructor(name, rank, salary);
        App.getPersonBag().insert(instructor);
        Storage.backup(App.getPersonBag());
        instructorListView.getItems().add(instructor.toString());
        updateOutput();
        clearFields();
    }

    protected void update() {
        String focusedItem = instructorListView.getFocusModel().getFocusedItem();
        if (!focusedItem.isEmpty()) {
            Person updating = App.getPersonBag().search(person -> person.toString().equals(focusedItem))[0];
            Instructor instructor = (Instructor) updating;
            if (!nameField.getText().isEmpty()) {
                String[] fullName = nameField.getText().split(" ");
                instructor.setName(new Name(fullName[0], fullName[1]));
            }
            if (!rankComboBox.getValue().toString().isEmpty()) {
                instructor.setRank(rankComboBox.getValue());
            }
            if (!salaryField.getText().isEmpty()) {
                instructor.setSalary(Double.parseDouble(salaryField.getText()));
            }

            updateOutput();
            clearFields();
        }
    }

    protected void remove() {
        Person[] deleted = App.getPersonBag().delete(this::isPartialOrFullMatch);
        for (Person person : deleted) {
            instructorListView.getItems().remove(person.toString());
        }

        updateOutput();
        clearFields();
    }

    protected boolean isPartialOrFullMatch(Person person) {
        if (person instanceof Instructor instructor) {
            boolean matchName = nameField.getText().equals(instructor.getName().toString());
            boolean matchRank = rankComboBox.getValue().equals(instructor.getRank());
            boolean matchSalary = false;
            if (!salaryField.getText().isEmpty()) {
                double delta = Math.abs(Double.parseDouble(salaryField.getText()) - instructor.getSalary());
                matchSalary = delta < 0.01;
            }

            return (!nameField.getText().isEmpty() && !rankComboBox.getValue().toString().isEmpty() && !salaryField.getText().isEmpty())
                    ? (matchName && matchRank && matchSalary)
                    : (matchName || matchRank || matchSalary);
        }

        return false;
    }

    private void updateOutput() {
        if (!instructorListView.getItems().isEmpty()) {
            instructorListView.getItems().clear();
        }

        for (Person person : App.getPersonBag().currentPeople()) {
            if (person instanceof Instructor instructor) {
                instructorListView.getItems().add(instructor.toString());
            }
        }

        Storage.backup(App.getPersonBag());
    }

    private void clearFields() {
        nameField.clear();
        rankComboBox.getSelectionModel().clearSelection();
        salaryField.clear();
    }
}
