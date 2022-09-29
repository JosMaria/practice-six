package org.genesiscode.practicesix.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practicesix.service.ExerciseTwo;
import org.genesiscode.practicesix.service.utils.Util;
import org.genesiscode.practicesix.view.row.RowEnunciateTwo;
import org.genesiscode.practicesix.view.row.RowInfoExerciseTwo;
import org.genesiscode.practicesix.view.row.RowResult;
import org.genesiscode.practicesix.view.row.RowResultToExerciseTwo;

import java.util.List;

public class ExerciseTwoPane extends MyPane {

    private static ExerciseTwoPane exerciseTwoPane;
    private final ExerciseTwo exerciseTwo;

    private TableView<RowResult> tableResult;
    private TableView<RowEnunciateTwo> dataTableOne, dataTableTwo, dataTableThree;
    private TableView<RowInfoExerciseTwo> infoTableOne, infoTableTwo, infoTableThree;
    private TableView<RowResultToExerciseTwo> tableFinal;
    private Button btnStart, btnLoadData, btnClear;
    private TextArea txtAreaNumbers;
    private Label lblNumbers;

    private ExerciseTwoPane() {
        super("EJERCICIO 2");
        exerciseTwo = new ExerciseTwo();
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseTwoPane getInstance() {
        return exerciseTwoPane == null ? new ExerciseTwoPane() : exerciseTwoPane;
    }

    private void loadControls() {
        tableResult = new TableView<>();
        buildTableResult();
        buildTableResultFinal();
        btnStart = new Button("Empezar");
        btnStart.setOnAction(actionEvent -> click_btn_start());

        lblNumbers = new Label("Introducir números");
        btnClear = new Button("Limpiar");
        btnClear.setOnAction(actionEvent -> click_btn_clear());

        txtAreaNumbers = new TextArea();
        txtAreaNumbers.setWrapText(true);
        txtAreaNumbers.setMaxHeight(45);
        txtAreaNumbers.setMaxWidth(450);

        btnLoadData = new Button("Cargar Datos");
        btnLoadData.setOnAction(actionEvent -> click_btn_loadData());

        dataTableOne = buildTableToData("Pintas\nSemana");
        dataTableOne.setItems(exerciseTwo.getDataTableOne());

        dataTableTwo = buildTableToData("Pacientes\nSemana");
        dataTableTwo.setItems(exerciseTwo.getDataTableTwo());

        dataTableThree = buildTableToData(" Pintas ");
        dataTableThree.setItems(exerciseTwo.getDataTableThree());

        infoTableOne = buildTableToInformation("Pintas");
        infoTableTwo = buildTableToInformation("Sangre");
        infoTableThree = buildTableToInformation("Pintas");

        infoTableOne.setItems(exerciseTwo.getInfoTable(exerciseTwo.getDataToTableOne()));
        infoTableTwo.setItems(exerciseTwo.getInfoTable(exerciseTwo.getDataToTableTwo()));
        infoTableThree.setItems(exerciseTwo.getInfoTable(exerciseTwo.getDataToTableThree()));
    }

    private void click_btn_clear() {
        txtAreaNumbers.clear();
        tableResult.setItems(null);
    }

    private void click_btn_loadData() {
        List<Double> randomNumbers = Util.convertToList(txtAreaNumbers.getText());
        tableResult.setItems(exerciseTwo.buildRowsToStart(randomNumbers));
    }

    private void click_btn_start() {
        tableFinal.setItems(exerciseTwo.buildRowToResult());
        ExerciseTwoPaneAssistant.show(tableFinal, infoTableOne, infoTableTwo, infoTableThree);
    }

    private void buildPane() {
        HBox informationTablesPane = new HBox(10,
                new VBox(10, new Label("Cantidades Suministradas"), dataTableOne),
                new VBox(10, new Label("Distribución de pacientes"), dataTableTwo),
                new VBox(10, new Label("Demanda por pacientes"), dataTableThree)
        );

        VBox inputPane = new VBox(10, lblNumbers, txtAreaNumbers, new HBox(20, btnLoadData, btnClear));
        VBox tableStartPane = new VBox(10, tableResult, btnStart);
        tableStartPane.setAlignment(Pos.CENTER);

        mainPane = new VBox(10, title, new HBox(10, tableStartPane, new VBox(20, inputPane, informationTablesPane)));
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setPadding(new Insets(10));
    }

    public void buildTableResult() {
        tableResult.getColumns().addAll(List.of(getColOne(), getColTwo()));
        tableResult.setMaxWidth(200);
        tableResult.setMaxHeight(320);
    }

    private TableView<RowEnunciateTwo> buildTableToData(String titleColumnOne) {
        TableColumn<RowEnunciateTwo, Integer> colOne = new TableColumn<>(titleColumnOne);
        colOne.setCellValueFactory(new PropertyValueFactory<>("information"));
        colOne.setPrefWidth(80);

        TableColumn<RowEnunciateTwo, Double> colTwo = new TableColumn<>("Probabilidad");
        colTwo.setCellValueFactory(new PropertyValueFactory<>("probability"));
        colTwo.setPrefWidth(80);

        TableView<RowEnunciateTwo> table = new TableView<>();
        table.getColumns().addAll(List.of(colOne, colTwo));
        table.setMaxWidth(200);
        table.setMaxHeight(185);

        return table;
    }

    private TableView<RowInfoExerciseTwo> buildTableToInformation(String ultColTitle) {
        TableColumn<RowInfoExerciseTwo, Double> columnOne = column("Probabilidad", "probability", 80);
        TableColumn<RowInfoExerciseTwo, Double> columnTwo = column("Distribución\nacumulada", "accumulated", 80);
        TableColumn<RowInfoExerciseTwo, String> columnThree = column("Rango de\nnúmeros", "range", 100);
        TableColumn<RowInfoExerciseTwo, Integer> columnFour = column(ultColTitle, "data", 60);

        TableView<RowInfoExerciseTwo> table = new TableView<>();
        table.getColumns().addAll(List.of(columnOne, columnTwo, columnThree, columnFour));
        table.setMinWidth(380);
        table.setMaxHeight(180);
        return table;
    }

    private void buildTableResultFinal() {
        TableColumn<RowResultToExerciseTwo, Integer> columnOne =
                column("Semena", "week", 90);

        TableColumn<RowResultToExerciseTwo, Integer> columnTwo =
                column("Inventario\nInicial", "initialInventory", 90);

        TableColumn<RowResultToExerciseTwo, Double> columnThree =
                column("#aletorio", "randomNumberOne", 90);
        columnThree.setStyle("-fx-background-color: yellow");

        TableColumn<RowResultToExerciseTwo, Integer> columnFour =
                column("Pintas", "pintsOne", 80);
        columnFour.setStyle("-fx-background-color: yellow");

        TableColumn<RowResultToExerciseTwo, Integer> columnFive =
                column("Sangre\ndisponible\ntotal", "totalAvailableBlood", 100);

        TableColumn<RowResultToExerciseTwo, Double> columnSix =
                column("#aletorio", "randomNumberTwo", 90);
        columnSix.setStyle("-fx-background-color: beige");

        TableColumn<RowResultToExerciseTwo, Integer> columnSeven =
                column("#Pacientes", "numberOfPatients", 90);
        columnSeven.setStyle("-fx-background-color: beige");

        TableColumn<RowResultToExerciseTwo, List<Integer>> columnEight =
                column("#Nro de\npaciente", "numberOfPatient", 90);

        TableColumn<RowResultToExerciseTwo, List<Double>> columnNine =
                column("#aleatorio", "randomNumberThree", 150);
        columnNine.setStyle("-fx-background-color: lightgreen");

        TableColumn<RowResultToExerciseTwo, List<Integer>> columnTen =
                column("Pintas", "pintsTwo", 90);
        columnTen.setStyle("-fx-background-color: lightgreen");

        TableColumn<RowResultToExerciseTwo, List<Integer>> columnEleven =
                column("#Pintas\nrestantes", "numberOfPintsRemaining", 100);

        tableFinal = new TableView<>();
        tableFinal.getColumns().addAll(List.of(columnOne, columnTwo, columnThree, columnFour,
                columnFive, columnSix, columnSeven, columnEight, columnNine, columnTen, columnEleven));
        tableFinal.setMinWidth(1050);
        tableFinal.setMaxWidth(1050);
        tableFinal.setMaxHeight(210);
    }

    private <U, T> TableColumn<U, T> column(String titleColumn, String property, double prefSize) {
        TableColumn<U, T> column = new TableColumn<>(titleColumn);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setPrefWidth(prefSize);
        return column;
    }
}
