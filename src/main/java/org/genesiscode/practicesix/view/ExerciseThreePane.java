package org.genesiscode.practicesix.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practicesix.service.ExerciseThree;
import org.genesiscode.practicesix.service.utils.Util;
import org.genesiscode.practicesix.view.row.exerciseFour.RowDataProcessed;
import org.genesiscode.practicesix.view.row.exerciseFour.RowRandomNumbers;
import org.genesiscode.practicesix.view.row.exerciseFour.RowResult;

import java.util.List;

public class ExerciseThreePane extends MyNewPane {

    private static ExerciseThreePane exerciseThreePane;
    private final ExerciseThree exerciseThree;
    private TableView<RowRandomNumbers> tableOfTime, tableOfCustomerArrival;
    private TableView<RowDataProcessed> tableDataOfTime, tableDataOfCustomerArrival;
    private TableView<RowResult> tableResult;
    private Button btnStart;

    private ExerciseThreePane() {
        super("EJERCICIO 3");
        exerciseThree = new ExerciseThree();
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseThreePane getInstance() {
        return exerciseThreePane == null ? new ExerciseThreePane() : exerciseThreePane;
    }

    private void loadControls() {
        btnAdd.setOnAction(actionEvent -> click_btn_add());

        buildTableRandomNumbers();
        tableOfTime = new TableView<>();
        buildTableOfTime();
        tableOfCustomerArrival = new TableView<>();
        buildTableOfCustomerArrival();

        btnStart = new Button("Empezar");
        btnStart.setOnAction(actionEvent -> click_btn_start());

        tableDataOfTime = new TableView<>();
        buildTableDataOfTime("Tiempo\nServicio", tableDataOfTime);
        tableDataOfCustomerArrival = new TableView<>();
        buildTableDataOfTime("T entre\nllegadas", tableDataOfCustomerArrival);

        tableResult = new TableView<>();
        buildTableResult();
    }

    private void click_btn_add() {
        List<Double> randomNumbers = Util.convertToList(txtRandomNumbers.getText());
        tableRandomNumbers.setItems(exerciseThree.loadRandomNumbers(randomNumbers));
    }

    private void click_btn_start() {
        tableDataOfTime.setItems(exerciseThree.getListToTableOf(exerciseThree.getListToTableOfTime()));
        tableDataOfCustomerArrival.setItems(exerciseThree.getListToTableOf(exerciseThree.getListToTableOfCustomerArrival()));
        tableResult.setItems(exerciseThree.getListResult(tableDataOfTime.getItems(), tableDataOfCustomerArrival.getItems()));
        ExerciseThreePaneAssistant.show(tableDataOfTime, tableDataOfCustomerArrival, tableResult);
    }

    private void buildPane() {
        VBox randomNumbersPane = new VBox(10, inputPane, tableRandomNumbers, btnStart);
        randomNumbersPane.setFillWidth(false);
        randomNumbersPane.setAlignment(Pos.CENTER);
        VBox timePane = new VBox(10, new Label("Datos del tiempo de servicio"), tableOfTime);
        timePane.setFillWidth(false);
        VBox customerArrivalPane = new VBox(10, new Label("Datos de la llegada de los clientes"), tableOfCustomerArrival);
        customerArrivalPane.setFillWidth(false);
        VBox informationPane = new VBox(20, timePane, customerArrivalPane);
        HBox pane = new HBox(30, randomNumbersPane, informationPane);
        pane.setAlignment(Pos.CENTER);
        mainPane = new VBox(10, title, pane);
        mainPane.setPadding(new Insets(10));
        mainPane.setAlignment(Pos.CENTER);
    }

    private void buildTableOfTime() {
        TableColumn<RowRandomNumbers, Integer> colRow = column("Tiempo de\nservicio", "data", 80);
        TableColumn<RowRandomNumbers, Double> colRandomNumbers = column("Probabilidad\n(Frecuencia)", "value", 110);
        tableOfTime.getColumns().addAll(List.of(colRow, colRandomNumbers));
        tableOfTime.setPrefHeight(160);
        tableOfTime.setPrefWidth(220);
        tableOfTime.setItems(exerciseThree.getListToTableOfTime());
    }

    private void buildTableOfCustomerArrival() {
        TableColumn<RowRandomNumbers, Integer> colRow = column("Tiempo entre\nlas llegadas", "data", 120);
        TableColumn<RowRandomNumbers, Double> colRandomNumbers = column("Probabilidad\n(Frecuencia)", "value", 120);
        tableOfCustomerArrival.getColumns().addAll(List.of(colRow, colRandomNumbers));
        tableOfCustomerArrival.setPrefHeight(160);
        tableOfCustomerArrival.setPrefWidth(260);
        tableOfCustomerArrival.setItems(exerciseThree.getListToTableOfCustomerArrival());
    }

    private void buildTableDataOfTime(String ultColTitle, TableView<RowDataProcessed> table) {
        TableColumn<RowDataProcessed, Double> colProbability =
                column("Probabilidad", "probability", 100);
        TableColumn<RowDataProcessed, Double> colAccumulated =
                column("Distribucion\nAcumulada", "accumulatedDistribution", 100);
        TableColumn<RowDataProcessed, String> colRange =
                column("Rango de\n#s aleatorios", "range", 120);
        TableColumn<RowDataProcessed, Integer> colData =
                column(ultColTitle, "data", 110);
        table.getColumns().addAll(List.of(colProbability, colAccumulated, colRange, colData));
        table.setPrefWidth(450);
        table.setPrefHeight(150);
    }

    private void buildTableResult() {
        TableColumn<RowResult, Integer> colClient = column("client", "client", 80);
        TableColumn<RowResult, Double> colRandomNumberOne = column("#aleatorio", "randomNumberOne", 100);
        TableColumn<RowResult, Integer> colIntervalArrival = column("Intervalo\nLlegada", "intervalArrival", 100);
        TableColumn<RowResult, String> colTimeArrival = column("hora de\nllegada", "timeArrival", 100);
        TableColumn<RowResult, Double> colRandomNumberTwo = column("#aleatorio", "randomNumberTwo", 100);
        TableColumn<RowResult, Integer> colTService = column("t servicio", "timeOfService", 100);
        TableColumn<RowResult, String> colStartService = column("Inicio de\nServicio", "startService", 100);
        TableColumn<RowResult, String> colEndService = column("fin de\nservicio", "endService", 100);
        TableColumn<RowResult, Integer> colTimeWait = column("Tiempo de\nespera", "timeWait", 100);
        TableColumn<RowResult, Integer> colTimeLeisure = column("Tiempo de\nocio", "timeLeisure", 100);

        tableResult.getColumns().addAll(List.of(colClient, colRandomNumberOne, colIntervalArrival,
                colTimeArrival, colRandomNumberTwo, colTService, colStartService, colEndService,
                colTimeWait, colTimeLeisure));
        tableResult.setPrefHeight(200);
    }
}
