package org.genesiscode.practicesix.view;

import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.util.List;

public class ExerciseOnePane extends MyPane {

    private static ExerciseOnePane exerciseOnePane;

    private TableView<RowResult> table;
    private ExerciseOnePane() {
        super("EJERCICIO 1");
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseOnePane getInstance() {
        return exerciseOnePane == null ? new ExerciseOnePane() : exerciseOnePane;
    }

    private void loadControls() {
        table = new TableView<>();
        buildTableResult();
    }

    private void buildPane() {
        mainPane = new VBox(10, title, table);
        mainPane.setPadding(new Insets(10));
    }

    private void buildTableResult() {
        TableColumn<RowResult, Integer> colOne = new TableColumn<>("Número");
        colOne.setCellValueFactory(new PropertyValueFactory<>("numberBall"));
        colOne.setPrefWidth(80);

        TableColumn<RowResult, Integer> colTwo = new TableColumn<>("Número\nAleatorio");
        colTwo.setCellValueFactory(new PropertyValueFactory<>("numberRandom"));
        colTwo.setPrefWidth(80);

        TableColumn<RowResult, Integer> colThree = new TableColumn<>("Color");
        colThree.setCellValueFactory(new PropertyValueFactory<>("color"));
        colThree.setPrefWidth(100);

        table.getColumns().addAll(List.of(colOne, colTwo, colThree));
        table.setMaxWidth(260);
    }
}

record RowResult(int numberBall, double numberRandom, String color) {

}
