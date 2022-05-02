package org.genesiscode.practicesix.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class ExerciseOnePane extends MyPane {

    private static ExerciseOnePane exerciseOnePane;

    private TableView<RowResult> tableResult;
    private TableView<RowInformation> tableInformation;
    private Button btnStart;

    private ExerciseOnePane() {
        super("EJERCICIO 1");
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseOnePane getInstance() {
        return exerciseOnePane == null ? new ExerciseOnePane() : exerciseOnePane;
    }

    private void loadControls() {
        btnStart = new Button("Empezar");
        btnStart.setOnAction(actionEvent -> click_on_start());

        tableResult = new TableView<>();
        tableInformation = new TableView<>();
        buildTableResult();
        buildTableInformation();
    }

    private void click_on_start() {
    }

    private void buildPane() {
        VBox resultPane = new VBox(20, tableResult, btnStart);
        resultPane.setAlignment(Pos.CENTER);

        mainPane = new VBox(10, title, new HBox(10, resultPane, tableInformation));
        mainPane.setPadding(new Insets(10));
        mainPane.setAlignment(Pos.CENTER);
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

        tableResult.getColumns().addAll(List.of(colOne, colTwo, colThree));
        tableResult.setMaxWidth(260);
        tableResult.setMaxHeight(300);
    }

    private void buildTableInformation() {
        TableColumn<RowInformation, String> colOne = new TableColumn<>("Color");
        colOne.setCellValueFactory(new PropertyValueFactory<>("color"));
        colOne.setPrefWidth(100);

        TableColumn<RowInformation, Double> colTwo = new TableColumn<>("Distribucion\nprobabilidad");
        colTwo.setCellValueFactory(new PropertyValueFactory<>("dProbability"));
        colTwo.setPrefWidth(110);

        TableColumn<RowInformation, Double> colThree = new TableColumn<>("Distribucion\nacumulada");
        colThree.setCellValueFactory(new PropertyValueFactory<>("dAccumulated"));
        colThree.setPrefWidth(110);

        TableColumn<RowInformation, String> colFour = new TableColumn<>("Rango");
        colFour.setCellValueFactory(new PropertyValueFactory<>("range"));
        colFour.setPrefWidth(180);

        tableInformation.getColumns().addAll(List.of(colOne, colTwo, colThree, colFour));
        tableInformation.setMaxWidth(500);
        tableInformation.setMaxHeight(300);
    }
}

record RowResult(int numberBall, double numberRandom, String color) {

}

record RowInformation(String color, double dProbability, double dAccumulated, String range) {

}
