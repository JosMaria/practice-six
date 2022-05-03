package org.genesiscode.practicesix.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practicesix.service.ExerciseOne;
import org.genesiscode.practicesix.view.row.RowInformation;
import org.genesiscode.practicesix.view.row.RowResult;

import java.util.List;

public class ExerciseOnePane extends MyPane {

    private static ExerciseOnePane exerciseOnePane;
    private final ExerciseOne exerciseOne;

    private TableView<RowResult> tableResult;
    private TableView<RowInformation> tableInformation;
    private Button btnStart, btnShow;

    private ExerciseOnePane() {
        super("EJERCICIO 1");
        exerciseOne = new ExerciseOne();
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseOnePane getInstance() {
        return exerciseOnePane == null ? new ExerciseOnePane() : exerciseOnePane;
    }

    private void loadControls() {
        btnStart = new Button("Empezar");
        btnStart.setOnAction(actionEvent -> click_on_start());
        btnShow = new Button("Mostrar Mensaje");
        btnShow.setOnAction(actionEvent -> MessageBox.show(exerciseOne.buildMessage(), "CONCLUSIÓN"));

        tableResult = new TableView<>();
        tableInformation = new TableView<>();
        buildTableResult();
        buildTableInformation();
    }

    private void click_on_start() {
        tableInformation.setItems(exerciseOne.buildDataToInformationTable());
        exerciseOne.buildDataToResultTable();
    }

    private void buildPane() {
        VBox resultPane = new VBox(20, tableResult, new HBox(20, btnStart, btnShow));
        resultPane.setAlignment(Pos.CENTER);

        HBox tablePane = new HBox(10, resultPane, tableInformation);
        tablePane.setAlignment(Pos.CENTER);
        mainPane = new VBox(10, title, tablePane);
        mainPane.setPadding(new Insets(10));
        mainPane.setAlignment(Pos.CENTER);
    }

    private void buildTableResult() {
        TableColumn<RowResult, String> colThree = new TableColumn<>("Color");
        colThree.setCellValueFactory(new PropertyValueFactory<>("color"));
        colThree.setPrefWidth(90);

        tableResult.getColumns().addAll(List.of(getColOne(), getColTwo(), colThree));
        tableResult.setMaxWidth(280);
        tableResult.setMaxHeight(300);
        tableResult.setItems(exerciseOne.buildRowsToStart());
    }

    private void buildTableInformation() {
        TableColumn<RowInformation, String> colOne = new TableColumn<>("Color");
        colOne.setCellValueFactory(new PropertyValueFactory<>("color"));
        colOne.setPrefWidth(100);

        TableColumn<RowInformation, Double> colTwo = new TableColumn<>("Distribucion\nprobabilidad");
        colTwo.setCellValueFactory(new PropertyValueFactory<>("probability"));
        colTwo.setPrefWidth(110);

        TableColumn<RowInformation, Double> colThree = new TableColumn<>("Distribucion\nacumulada");
        colThree.setCellValueFactory(new PropertyValueFactory<>("accumulated"));
        colThree.setPrefWidth(110);

        TableColumn<RowInformation, String> colFour = new TableColumn<>("Rango");
        colFour.setCellValueFactory(new PropertyValueFactory<>("range"));
        colFour.setPrefWidth(120);

        tableInformation.getColumns().addAll(List.of(colOne, colTwo, colThree, colFour));
        tableInformation.setMaxWidth(490);
        tableInformation.setMaxHeight(150);
    }
}
