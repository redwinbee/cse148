package p2_gridpane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(50));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(20);
        gridPane.setHgap(20);

        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        TextField tf3 = new TextField();
        TextField tf4 = new TextField();
        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");
        Button btn4 = new Button("Button 4");
        TextArea ta = new TextArea();

        gridPane.add(tf1, 0, 0);
        gridPane.add(tf2, 1, 0);
        gridPane.add(tf3, 2, 0);
        gridPane.add(tf4, 3, 0);

        gridPane.add(btn1, 0, 1);
        gridPane.add(btn2, 1, 1);
        gridPane.add(btn3, 2, 1);
        gridPane.add(btn4, 3, 1);

        gridPane.add(ta, 1, 2, 2, 3);

        MenuBar menuBar = new MenuBar();
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");
        Menu quit = new Menu("Quit");
        menuBar.getMenus().addAll(file, edit, help, quit);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(gridPane);
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.setResizable(false);
        primaryStage.setTitle("GridPane Demo");
        primaryStage.show();
    }
}
