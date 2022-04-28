package p1;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Optional;

public class DemoAlerts extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        // anything before showing gui
    }

    @Override
    public void start(Stage primaryStage) {
        Alert alert1 = new Alert(Alert.AlertType.ERROR);
        alert1.setTitle("Error!");
        alert1.setHeaderText("Something went wrong...");
        alert1.setContentText("I'm not entirely sure what went wrong, you figure it out :)");
        alert1.showAndWait();

        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Information");
        alert2.setHeaderText("Some information");
        alert2.setContentText("This is just some information that might be relevant to you :P");
        alert2.showAndWait();

        TextInputDialog textInputDialog = new TextInputDialog("GPA");
        textInputDialog.setTitle("Incorrect GPA");
        textInputDialog.setHeaderText("Please enter a correct GPA value:");
        textInputDialog.setContentText("The value you entered is invalid, please enter a GPA in the range [0.0, 4.0]");
        Optional<String> result = textInputDialog.showAndWait();
        result.ifPresent(res -> {
            try {
                double gpa = Double.parseDouble(res);
                System.out.println("GPA: " + gpa);
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failed to parse GPA");
                alert.setHeaderText(ex.getMessage());
                alert.setContentText(Arrays.toString(ex.getStackTrace()));
                alert.showAndWait();
            }
        });

        primaryStage.show();
    }
}
