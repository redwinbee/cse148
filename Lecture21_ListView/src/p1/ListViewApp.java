package p1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ListViewApp extends Application {
    private static final ArrayList<String> COLLEGES = new ArrayList<>();

    public static void main(String[] args) {
        COLLEGES.add("Stony Brook");
        COLLEGES.add("SCCC");
        COLLEGES.add("NCCC");
        COLLEGES.add("NYU");
        COLLEGES.add("Columbia");
        COLLEGES.add("School A");
        COLLEGES.add("School B");
        COLLEGES.add("School C");
        COLLEGES.add("School D");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        BorderPane.setAlignment(root, Pos.CENTER);

        Label response = new Label("Select college or university");
        Text title = new Text("NY Colleges and Universities");
        title.setFill(Color.web("#2A5058"));
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        ListViewPane lvColleges = new ListViewPane(COLLEGES, response);

        // add our views to a dynamic, flexible pane that adjusts automatically
        FlowPane flowPane = new FlowPane(10, 10);
        flowPane.getChildren().addAll(title, lvColleges.getListView(), response);

        root.setCenter(flowPane);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 500, 300);

        primaryStage.setOnCloseRequest(event -> { /* do stuff */});
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
