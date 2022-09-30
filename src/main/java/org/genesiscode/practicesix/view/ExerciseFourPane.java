package org.genesiscode.practicesix.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practicesix.service.ExerciseFour;
import org.genesiscode.practicesix.service.utils.Util;
import org.genesiscode.practicesix.view.row.four.RowInputData;
import org.genesiscode.practicesix.view.row.four.RowResult;
import org.genesiscode.practicesix.view.row.three.RowDataProcessed;

import java.util.List;

public class ExerciseFourPane extends MyNewPane {

    private static ExerciseFourPane exerciseFourPane;
    private final ExerciseFour exerciseFour;

    private TableView<RowInputData> tableInputData;
    private TableView<RowDataProcessed> programsSalesTable;
    private TableView<RowResult> resultTable;
    private Button btnStart;
    private TextField txtProduce, txtSales, txtSimulatedGames, txtQuantity;

    public ExerciseFourPane() {
        super("EJERCICIO 4");
        exerciseFour = new ExerciseFour();
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseFourPane getInstance() {
        return exerciseFourPane == null ? new ExerciseFourPane() : exerciseFourPane;
    }

    public void loadControls() {
        tableInputData = new TableView<>();
        buildTableInputData();
        buildTableRandomNumbers();

        btnAdd.setOnAction(actionEvent -> click_btn_add());
        btnStart = new Button("Empezar");
        btnStart.setOnAction(actionEvent -> click_btn_start());

        programsSalesTable = buildDataProcessedTable("Programas\nVendidos");

        resultTable = new TableView<>();
        buildResultTable();

        txtProduce = getTextField();
        txtSales = getTextField();
        txtSimulatedGames = getTextField();
        txtQuantity = getTextField();
    }

    private TextField getTextField() {
        TextField textField = new TextField();
        textField.setPrefColumnCount(4);
        return textField;
    }

    private void click_btn_start() {
        programsSalesTable.setItems(exerciseFour.listOfIntervals());
        // 0.8, 2, 2600, 10
        double produce = Double.parseDouble(txtProduce.getText());
        double sell = Double.parseDouble(txtSales.getText());
        int quantity = Integer.parseInt(txtQuantity.getText());
        int simulatedGames = Integer.parseInt(txtSimulatedGames.getText());
        resultTable.setItems(exerciseFour.getListResult(produce, sell, quantity, simulatedGames));
        ExerciseFourPaneAssistant.show(programsSalesTable, resultTable, exerciseFour.getTotal());
    }

    private void click_btn_add() {
        List<Double> randomNumbers = Util.convertToList(txtRandomNumbers.getText());
        tableRandomNumbers.setItems(exerciseFour.loadRandomNumbers(randomNumbers));
    }

    public void buildPane() {
        VBox randomNumberAndInputPane = new VBox(20, inputPane, tableRandomNumbers, btnStart);
        randomNumberAndInputPane.setFillWidth(false);
        randomNumberAndInputPane.setAlignment(Pos.CENTER);
        randomNumberAndInputPane.setPadding(new Insets(0, 0, 20, 0));

        VBox inputDataPane = new VBox(10,
                inputRow("Produce", txtProduce),
                inputRow("Vende", txtSales),
                inputRow("Juegos Simulados", txtSimulatedGames),
                inputRow("Cantidad", txtQuantity));
        inputDataPane.setAlignment(Pos.TOP_CENTER);

        VBox inputDataTablePane = new VBox(30, inputDataPane, tableInputData);

        HBox pane = new HBox(50, randomNumberAndInputPane, inputDataTablePane);
        pane.setFillHeight(false);
        pane.setAlignment(Pos.TOP_CENTER);

        mainPane = new VBox(10, title, pane);
        mainPane.setAlignment(Pos.CENTER);
    }

    public HBox inputRow(String lblTitle, TextField field) {
        HBox box = new HBox(10, new Label(lblTitle), field);
        box.setAlignment(Pos.CENTER_RIGHT);
        return box;
    }

    private void buildResultTable() {
        TableColumn<RowResult, Integer> colDay = column("Dia", "day", 50);
        TableColumn<RowResult, Double> colRandomNumber = column("#Aleatorio", "randomNumber", 100);
        TableColumn<RowResult, Integer> colDemand = column("Demanda", "demand", 100);
        TableColumn<RowResult, Integer> colRevenue = column("Ganancia", "revenue", 100);
        resultTable.getColumns().addAll(List.of(colDay, colRandomNumber, colDemand, colRevenue));
        resultTable.setPrefHeight(210);
        resultTable.setPrefWidth(370);
    }

    private void buildTableInputData() {
        TableColumn<RowInputData, Integer> colNumberOfPrograms =
                column("Numero de\nprogramas\nvendidos", "numberOfPrograms", 100);
        TableColumn<RowInputData, Double> colProbability =
                column("Probabilidad", "probability", 100);
        tableInputData.getColumns().addAll(List.of(colNumberOfPrograms, colProbability));
        tableInputData.setMaxWidth(210);
        tableInputData.setPrefHeight(175);
        tableInputData.setItems(exerciseFour.getListToTableInputData());
    }
}
