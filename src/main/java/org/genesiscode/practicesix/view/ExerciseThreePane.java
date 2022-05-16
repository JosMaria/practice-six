package org.genesiscode.practicesix.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practicesix.service.ExerciseThree;
import org.genesiscode.practicesix.view.row.exerciseThree.RowInfoExerciseThree;

import java.util.List;

public class ExerciseThreePane extends MyPane {

    private static ExerciseThreePane exerciseThreePane;
    private final ExerciseThree exerciseThree;
    private TableView<RowInfoExerciseThree> tableInfoStart;

    private Label lblSalesPerWeek, lblNumberOfWeek, lblTotalNumberOfWeek;
    private TextField txtSalesPerWeek, txtNumberOfWeek;
    private Button btnLoadData, btnClear;

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

    private void buildPane() {
        VBox inputDataPane = new VBox(10, new HBox(10, lblSalesPerWeek, txtSalesPerWeek),
                new HBox(10, lblNumberOfWeek, txtNumberOfWeek),
                new HBox(10, btnLoadData, btnClear),
                tableInfoStart, lblTotalNumberOfWeek);
        inputDataPane.setFillWidth(false);
        //inputDataPane.setAlignment(Pos.CENTER);

        mainPane = new VBox(10, new VBox(title, inputDataPane));
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
