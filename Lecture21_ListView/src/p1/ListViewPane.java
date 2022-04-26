package p1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;

import java.util.ArrayList;

public class ListViewPane {
    private final ListView<String> lvColleges;
    private String selectedString;

    public ListViewPane(ArrayList<String> list, Label response) {
        ObservableList<String> colleges = FXCollections.observableArrayList(list);
        lvColleges = new ListView<>(colleges);
        lvColleges.setPrefSize(300, 150);
        MultipleSelectionModel<String> lvSelectionModel = lvColleges.getSelectionModel();
        lvSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);
        lvSelectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            response.setText(newValue);
            selectedString = newValue;
        });
    }

    public ListView<String> getListView() {
        return lvColleges;
    }

    public String getSelectedString() {
        return selectedString;
    }
}
