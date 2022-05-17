package org.genesiscode.practicesix.view;

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

import java.util.List;

public class ExerciseThreePane extends MyPane {

    private static ExerciseThreePane exerciseThreePane;
    private final ExerciseThree exerciseThree;
    private TableView<RowInfoExerciseThree> tableInfoStart;
    private TableView<RowEnunciateTwo> tableEnunciateThree;

    private Label lblSalesPerWeek, lblNumberOfWeek, lblTotalNumberOfWeek, lblNumbers;
    private TextField txtSalesPerWeek, txtNumberOfWeek, txtRandomNumbers;
    private Button btnLoadData, btnClear, btnLoadNumbers;

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
        buildTableInfoStart();

        // table of random numbers
        tableEnunciateThree = new TableView<>();
        buildTableEnunciateThree();

        lblNumbers = new Label("Introducir números");
        txtRandomNumbers = new TextField();
        txtRandomNumbers.setPrefColumnCount(20);
        btnLoadNumbers = new Button("Cargar Números");
        btnLoadNumbers.setOnAction(actionEvent -> click_on_load_numbers());
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
        txtSalesPerWeek.setText("");
        txtNumberOfWeek.setText("");
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
                column("Fila", "information", 100);
        TableColumn<RowEnunciateTwo, Double> colProbability =
                column("Numeros\nAleatorios", "probability", 100);

        tableEnunciateThree.getColumns().addAll(List.of(colNumberRow, colProbability));
    }

    private void buildPane() {
        VBox inputDataPane = new VBox(10, new HBox(10, lblSalesPerWeek, txtSalesPerWeek),
                new HBox(10, lblNumberOfWeek, txtNumberOfWeek),
                new HBox(10, btnLoadData, btnClear),
                tableInfoStart, lblTotalNumberOfWeek);
        inputDataPane.setFillWidth(false);


        VBox numbersRandomPane = new VBox(20,
                new VBox(10, lblNumbers, txtRandomNumbers, btnLoadNumbers),
                tableEnunciateThree);
        numbersRandomPane.setFillWidth(false);

        mainPane = new VBox(10, new VBox(title, new HBox(20, inputDataPane, numbersRandomPane)));
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
