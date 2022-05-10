package view;

import app.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Student;
import util.Storage;

public class StudentView {
	private ListView<Student> studentListView;
	private final VBox root;
	private TextField nameField;
	private TextField gpaField;
	private TextField idField;
	private Label results;
	
	public StudentView(int spacing) {
		root = new VBox(spacing);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(createButtons(), createInputs(), createOutput(), results);
	}
	
    private HBox createButtons() {
        HBox box = new HBox(15);
        box.setAlignment(Pos.CENTER);

        Button insertButton = new Button("Insert");
        insertButton.setPrefSize(100, 30);
        insertButton.setOnAction(event -> insert());
        Button removeButton = new Button("Remove");
        removeButton.setPrefSize(100, 30);
        removeButton.setOnAction(event -> remove());

        box.getChildren().addAll(insertButton, removeButton);
        return box;
    }
    

    protected HBox createInputs() {
        HBox inputBox = new HBox(15);
        inputBox.setAlignment(Pos.CENTER);
        nameField = new TextField();
        nameField.setPromptText("Name");
        nameField.setPrefSize(150, 30);
        gpaField = new TextField();
        gpaField.setPromptText("GPA");
        gpaField.setPrefSize(150, 30);
        idField = new TextField();
        idField.setPromptText("ID");
        idField.setPrefSize(150, 30);
        results = new Label("Please choose an option!");

        inputBox.getChildren().addAll(nameField, gpaField, idField);
        return inputBox;
    }
    
    private ListView<Student> createOutput() {
        ObservableList<Student> studentsList = FXCollections.observableArrayList();
        studentsList.addAll(App.getStudentBag().currentPeople());

        studentListView = new ListView<>(studentsList);
        studentListView.setPrefSize(600, 300);
        MultipleSelectionModel<Student> selectionModel = studentListView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // might've already been removed
            if (newValue == null) {
                return;
            }

            Student found = App.getStudentBag().search(student -> student.equals(newValue))[0];
            Student student = (Student) found;
            nameField.setText(student.getName());
            gpaField.setText(String.format("%.2f", student.getGpa()));
            idField.setText(student.getId());
        });

        return studentListView;
    }
    
    private void insert() {
    	String name = nameField.getText();
    	double gpa = Double.parseDouble(gpaField.getText());
    	Student student = new Student(name, gpa);
    	App.getStudentBag().insert(student);
    	updateOutput();
    	clearFields();
    }

    private void remove() {
        Student[] deleted = App.getStudentBag().remove(this::isPartialOrFullMatch);
        for (Student student : deleted) {
            studentListView.getItems().remove(student);
        }
    	updateOutput();
    	clearFields();
    }

	public VBox getRoot() {
		return root;
	}
	

    private boolean isPartialOrFullMatch(Student student) {
    	boolean matchName = nameField.getText().equals(student.getName().toString());
    	boolean matchGpa = false;
    	boolean matchId = idField.getText().equals(student.getId());
    	if (!gpaField.getText().isEmpty()) {
    		try {
    			double delta = Math.abs(Double.parseDouble(gpaField.getText()) - student.getGpa());
    			matchGpa = delta <= 0.01;
    			} catch (NumberFormatException ignored) {
                }
            }

            return (!nameField.getText().isEmpty() && !gpaField.getText().isEmpty() && !idField.getText().isEmpty())
                    ? (matchName && matchGpa && matchId)
                    : (matchName || matchGpa || matchId);
        }
	
    private void updateOutput() {
        if (!studentListView.getItems().isEmpty()) {
            studentListView.getItems().clear();
        }

        for (Student student : App.getStudentBag().currentPeople()) {
        	studentListView.getItems().add(student);
        }

        Storage.backup(App.getStudentBag());
    }
    
    private void clearFields() {
    	nameField.clear();
    	gpaField.clear();
    	idField.clear();
    }
}
