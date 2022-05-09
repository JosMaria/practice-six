package org.genesiscode.practicesix.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practicesix.service.ExerciseTwo;
import org.genesiscode.practicesix.view.row.RowEnunciateTwo;
import org.genesiscode.practicesix.view.row.RowInfoExerciseTwo;
import org.genesiscode.practicesix.view.row.RowResult;

import java.util.List;

public class ExerciseTwoPane extends MyPane {

    private static ExerciseTwoPane exerciseTwoPane;
    private final ExerciseTwo exerciseTwo;

    private TableView<RowResult> tableResult;
    private TableView<RowEnunciateTwo> dataTableOne, dataTableTwo, dataTableThree;
    private TableView<RowInfoExerciseTwo> infoTableOne, infoTableTwo, infoTableThree;

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

        dataTableOne = buildTableToData("Pintas\nSemana");
        dataTableOne.setItems(exerciseTwo.getDataTableOne());

        dataTableTwo = buildTableToData("Pacientes\nSemana");
        dataTableTwo.setItems(exerciseTwo.getDataTableTwo());

        dataTableThree = buildTableToData("Pintas");
        dataTableThree.setItems(exerciseTwo.getDataTableThree());

        infoTableOne = buildTableToInformation("Pintas");
        infoTableTwo = buildTableToInformation("Sangre");
        infoTableThree = buildTableToInformation("Pintas");
        infoTableOne.setItems(exerciseTwo.getInfoTable(exerciseTwo.getDataToTableOne()));
        infoTableTwo.setItems(exerciseTwo.getInfoTable(exerciseTwo.getDataToTableTwo()));
        infoTableThree.setItems(exerciseTwo.getInfoTable(exerciseTwo.getDataToTableThree()));
    }

    private void buildPane() {
        HBox firstTablesPane = new HBox(20, new VBox(10, new Label("Cantidades Suministradas"), dataTableOne),
                new VBox(10, new Label("Cantidad Suministradas / Entrega"), infoTableOne));

        HBox secondTablesPane = new HBox(20, new VBox(10, new Label("Distribución de pacientes"), dataTableTwo),
                new VBox(10, new Label("Distribución de pacientes / Número de pacientes"), infoTableTwo));

        HBox thirdTablesPane = new HBox(20, new VBox(10, new Label("Demanda por pacientes"), dataTableThree),
                new VBox(10, new Label("Demanda por pacientes"), infoTableThree));

        VBox informationTablesPane = new VBox(10, firstTablesPane, secondTablesPane, thirdTablesPane);
        mainPane = new VBox(10, title, new HBox(10, tableResult, informationTablesPane));
        mainPane.setPadding(new Insets(10));
    }

    public void buildTableResult() {
        tableResult.getColumns().addAll(List.of(getColOne(), getColTwo()));
        tableResult.setMaxWidth(200);
        tableResult.setMaxHeight(320);
        tableResult.setItems(exerciseTwo.buildRowsToStart());
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
        table.setMaxHeight(170);

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
        table.setMaxHeight(170);
        return table;
    }

    private <T> TableColumn<RowInfoExerciseTwo, T> column(String titleColumn, String property, double prefSize) {
        TableColumn<RowInfoExerciseTwo, T> column = new TableColumn<>(titleColumn);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setPrefWidth(prefSize);
        return column;
    }
}
