package org.genesiscode.practicesix.view;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practicesix.service.ExerciseTwo;
import org.genesiscode.practicesix.view.row.RowEnunciateTwo;
import org.genesiscode.practicesix.view.row.RowResult;

import java.util.List;

public class ExerciseTwoPane extends MyPane {

    private static ExerciseTwoPane exerciseTwoPane;
    private final ExerciseTwo exerciseTwo;

    private TableView<RowResult> tableResult;
    private TableView<RowEnunciateTwo> informationTableOne, informationTableTwo, informationTableThree;

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

        informationTableOne = buildTableToInformation("Pintas\nSemana");
        informationTableOne.setItems(exerciseTwo.getInformationTableOne());

        informationTableTwo = buildTableToInformation("Pacientes\nSemana");
        informationTableTwo.setItems(exerciseTwo.getInformationTableTwo());

        informationTableThree = buildTableToInformation("Pintas");
        informationTableThree.setItems(exerciseTwo.getInformationTableThree());
    }

    private void buildPane() {
        VBox informationTablesPane = new VBox(10, new Label("Cantidades Suministradas"),informationTableOne,
                                                    new Label("Distribución de pacientes"), informationTableTwo,
                                                    new Label("Demanda por pacientes"), informationTableThree);
        mainPane = new VBox(10, title, new HBox(10,tableResult, informationTablesPane));
    }

    public void buildTableResult() {
        tableResult.getColumns().addAll(List.of(getColOne(), getColTwo()));
        tableResult.setMaxWidth(200);
        tableResult.setMaxHeight(320);
        tableResult.setItems(exerciseTwo.buildRowsToStart());
    }

    public TableView<RowEnunciateTwo> buildTableToInformation(String titleColumnOne) {
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
}
