package org.genesiscode.practicesix.view;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.genesiscode.practicesix.view.row.exerciseFour.RowDataProcessed;
import org.genesiscode.practicesix.view.row.exerciseFour.RowRandomNumbers;

import java.util.List;

public class MyNewPane {

    protected VBox mainPane;
    protected Label title;
    protected TableView<RowRandomNumbers> tableRandomNumbers;
    protected TextField txtRandomNumbers;
    protected Button btnAdd;
    protected VBox inputPane;

    protected MyNewPane(String titleHeader) {
        title = new Label(titleHeader);
        title.setFont(new Font("Gargi", 20));
        tableRandomNumbers = new TableView<>();

        txtRandomNumbers = new TextField();
        txtRandomNumbers.setPrefColumnCount(20);
        btnAdd = new Button("Agregar");
        inputPane = new VBox(10, new Label("Numeros Aleatorios"), txtRandomNumbers, btnAdd);
    }

    protected TableView<RowDataProcessed> buildDataProcessedTable(String ultTitle) {
        TableView<RowDataProcessed> table = new TableView<>();
        TableColumn<RowDataProcessed, Double> colProbability = column("Probabilidad", "probability", 100);
        TableColumn<RowDataProcessed, Double> colAccumulated = column("Distribucion\nAcumulada", "accumulatedDistribution", 100);
        TableColumn<RowDataProcessed, String> colRange = column("Rangos de\n# aleatorios", "range", 100);
        TableColumn<RowDataProcessed, Integer> colData = column(ultTitle, "data", 100);

        table.getColumns().addAll(List.of(colProbability, colAccumulated, colRange, colData));
        table.setPrefHeight(170);
        return table;
    }

    protected void buildTableRandomNumbers() {
        TableColumn<RowRandomNumbers, Integer> colRow = column("Fila", "data", 50);
        TableColumn<RowRandomNumbers, Double> colRandomNumbers = column("Numeros\nAletorios", "value", 110);
        tableRandomNumbers.getColumns().addAll(List.of(colRow, colRandomNumbers));
        tableRandomNumbers.setPrefWidth(180);
        tableRandomNumbers.setPrefHeight(300);
    }

    protected <U, T> TableColumn<U, T> column(String titleColumn, String property, double prefSize) {
        TableColumn<U, T> column = new TableColumn<>(titleColumn);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setPrefWidth(prefSize);
        return column;
    }
}
