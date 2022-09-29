package org.genesiscode.practicesix.view;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practicesix.service.ExerciseThree;
import org.genesiscode.practicesix.service.utils.Util;
import org.genesiscode.practicesix.view.row.RowEnunciateTwo;
import org.genesiscode.practicesix.view.row.exerciseThree.RowInfoExerciseThree;
import org.genesiscode.practicesix.view.row.exerciseThree.RowResultExerciseThree;

import java.util.List;

public class ExerciseThreePane extends MyPane {

    private static ExerciseThreePane exerciseThreePane;
    private final ExerciseThree exerciseThree;
    private TableView<RowInfoExerciseThree> tableInfoStart;
    private TableView<RowEnunciateTwo> tableEnunciateThree;
    private TableView<RowResultExerciseThree> tableResultThree;

    private Label lblSalesPerWeek, lblNumberOfWeek, lblTotalNumberOfWeek, lblNumbers, lblResultTotal;
    private TextField txtSalesPerWeek, txtNumberOfWeek, txtRandomNumbers;
    private Button btnLoadData, btnClear, btnLoadNumbers, btnStart;

    private ExerciseThreePane() {
        super("EJERCICIO 2");
        exerciseThree = new ExerciseThree();
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseThreePane getInstance() {
        return exerciseThreePane == null ? new ExerciseThreePane() : exerciseThreePane;
    }

    private void loadControls() {
        // input data to table info pane
        lblSalesPerWeek = new Label("Ventas por semana");
        lblNumberOfWeek = new Label("Numero de semanas");
        txtSalesPerWeek = new TextField();
        txtSalesPerWeek.setPrefColumnCount(4);
        txtNumberOfWeek = new TextField();
        txtNumberOfWeek.setPrefColumnCount(4);
        btnLoadData = new Button("Cargar");
        btnLoadData.setOnAction(actionEvent -> click_btn_load_data());
        btnClear = new Button("Limpiar");
        btnClear.setOnAction(actionEvent -> click_btn_clear());
        lblTotalNumberOfWeek = new Label("Total: ");
        // table
        tableInfoStart = new TableView<>();
        tableInfoStart.setEditable(true);
        // 60 to first row, "increment 30 for each row"
        tableInfoStart.setPrefHeight(210);

        /*tableInfoStart.setMaxHeight(250);
        tableInfoStart.setPrefWidth(310);*/
        buildTableInfoStart();

        // table of random numbers
        tableEnunciateThree = new TableView<>();
        tableEnunciateThree.setPrefHeight(210);
        tableEnunciateThree.setPrefWidth(290);
        buildTableEnunciateThree();

        lblNumbers = new Label("Introducir números");
        txtRandomNumbers = new TextField();
        txtRandomNumbers.setPrefColumnCount(20);
        btnLoadNumbers = new Button("Cargar Números");
        btnLoadNumbers.setOnAction(actionEvent -> click_on_load_numbers());

        btnStart = new Button("Empezar");
        btnStart.setOnAction(actionEvent -> click_btn_start());

        tableResultThree = new TableView<>();
        buildTableResultThree();
        lblResultTotal = new Label("TOTAL ");
    }

    private void click_btn_start() {
        exerciseThree.addProbabilityToTableInfoStart();
        tableResultThree.setItems(exerciseThree.buildTableResult());
        ObservableList<RowEnunciateTwo> items = tableEnunciateThree.getItems();
        exerciseThree.addSalesTableEnunciateThree(items, tableResultThree.getItems());
        lblResultTotal.setText("TOTAL " + exerciseThree.getResultTotal());
        ExerciseThreePaneAssistant.show(tableResultThree, tableEnunciateThree, lblResultTotal);
    }

    private void click_on_load_numbers() {
        try {
            List<Double> data = Util.convertToList(txtRandomNumbers.getText());
            tableEnunciateThree.setItems(exerciseThree.buildTableEnunciateThree(data));
        } catch (NumberFormatException e) {
            MessageBox.show("Introducir numeros", "Entrada no valida");
        }
    }

    private void click_btn_clear() {
        exerciseThree.clearItemsOfListToTableInfoStart();
    }

    private void click_btn_load_data() {
        int salesPerWeek = Integer.parseInt(txtSalesPerWeek.getText());
        int numberOfWeek = Integer.parseInt(txtNumberOfWeek.getText());
        exerciseThree.addItemToListToTableInfoStart(salesPerWeek, numberOfWeek);
        txtSalesPerWeek.clear();
        txtNumberOfWeek.clear();
        lblTotalNumberOfWeek.setText(lblTotalNumberOfWeek.getText().substring(0, 7) + exerciseThree.totalNumberOfWeeks());
    }

    private void buildTableInfoStart() {
        TableColumn<RowInfoExerciseThree, Integer> colNumberOfWeek =
                column("Ventas por\nsemana", "salesPerWeek", 100);
        TableColumn<RowInfoExerciseThree, Integer> colSalesPerWeek =
                column("Numero de\nsemanas", "numberOfWeek", 100);
        TableColumn<RowInfoExerciseThree, String> colTxtProbability =
                column("Probabilidad", "txtProbability", 100);
        tableInfoStart.getColumns().addAll(List.of(colNumberOfWeek, colSalesPerWeek, colTxtProbability));
        tableInfoStart.setItems(exerciseThree.getListToTableInfoStart());

    }

    private void buildTableEnunciateThree() {
        TableColumn<RowEnunciateTwo, Integer> colNumberRow =
                column("Fila", "information", 60);
        TableColumn<RowEnunciateTwo, Double> colProbability =
                column("Numeros\nAleatorios", "probability", 100);
        TableColumn<RowEnunciateTwo, Integer> colSales =
                column("Ventas de\nCalentadores", "sales", 110);

        tableEnunciateThree.getColumns().addAll(List.of(colNumberRow, colProbability, colSales));
    }

    private void buildTableResultThree() {
        TableColumn<RowResultExerciseThree, Double> colProbability =
                column("Probabilidad", "probability", 100);
        TableColumn<RowResultExerciseThree, Double> colAccumulatedDistribution =
                column("Distribucion\nAcumulada", "accumulatedDistribution", 100);
        TableColumn<RowResultExerciseThree, String> colRangeRandomNumbers =
                column("Rango de #s\naleatorios", "rangeRandomNumbers", 120);
        TableColumn<RowResultExerciseThree, Integer> colSales =
                column("Ventas", "sales", 90);

        tableResultThree.getColumns().addAll(
                List.of(colProbability, colAccumulatedDistribution, colRangeRandomNumbers, colSales));
        tableResultThree.setMaxHeight(500);
    }

    private void buildPane() {
        /*tableEnunciateThree, new HBox(50, btnStart, lblResultTotal));*/
        VBox numbersRandomPane = new VBox(20, new VBox(10, lblNumbers, txtRandomNumbers, new HBox(20, btnLoadNumbers, btnStart)));
        numbersRandomPane.setFillWidth(false);

        HBox inputDataPane = new HBox(100,
            new VBox(10,
                    new HBox(10, lblSalesPerWeek, txtSalesPerWeek),
                    new HBox(10, lblNumberOfWeek, txtNumberOfWeek),
                    new HBox(10, btnLoadData, btnClear)),
            numbersRandomPane);
        inputDataPane.setAlignment(Pos.CENTER);

        VBox paneTemp = new VBox(10, inputDataPane, tableInfoStart, lblTotalNumberOfWeek);
        paneTemp.setAlignment(Pos.CENTER);
        paneTemp.setFillWidth(false);

        VBox pane = new VBox(10, title, paneTemp);
        pane.setAlignment(Pos.CENTER);

        mainPane = new VBox(10, pane);
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setPadding(new Insets(20));
    }

    private <U, T> TableColumn<U, T> column(String titleColumn, String property, double prefSize) {
        TableColumn<U, T> column = new TableColumn<>(titleColumn);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setPrefWidth(prefSize);
        return column;
    }
}
