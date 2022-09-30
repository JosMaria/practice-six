package org.genesiscode.practicesix.view;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.genesiscode.practicesix.service.ExerciseOneAux;
import org.genesiscode.practicesix.service.utils.Util;
import org.genesiscode.practicesix.view.row.RowInformation;
import org.genesiscode.practicesix.view.row.RowResult;

import java.util.List;

public class ExerciseOnePaneAux extends MyPane {

    private static ExerciseOnePaneAux exerciseOnePane;
    private final ExerciseOneAux exerciseOne;

    private TableView<RowResult> tableResult;
    private TableView<RowInformation> tableInformation;
    private Button btnStart, btnShow, btnLoadData, btnClear;
    private TextField txtNumbers;
    private Label lblNumbers;

    private ExerciseOnePaneAux() {
        super("EJERCICIO 1");
        exerciseOne = new ExerciseOneAux();
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseOnePaneAux getInstance() {
        return exerciseOnePane == null ? new ExerciseOnePaneAux() : exerciseOnePane;
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
        tableInformation.setItems(exerciseOne.buildDataToInformationTable());

        lblNumbers = new Label("Introducir números");
        txtNumbers = new TextField();
        txtNumbers.setPrefColumnCount(20);
        btnLoadData = new Button("Cargar Datos");
        btnLoadData.setOnAction(actionEvent -> click_on_loadData());

        btnClear = new Button("Limpiar");
        btnClear.setOnAction(actionEvent -> click_btn_clear());
    }

    private void click_btn_clear() {
        txtNumbers.setText("");
        tableResult.setItems(null);
    }

    private void click_on_loadData() {
        List<Double> randomNumbers = Util.convertToList(txtNumbers.getText());
        tableResult.setItems(exerciseOne.buildRowsToStart(randomNumbers));
    }

    private void click_on_start() {
        exerciseOne.buildDataToResultTable();
    }

    private void buildPane() {
        VBox resultPane = new VBox(20, tableResult, new HBox(20, btnStart, btnShow));
        resultPane.setAlignment(Pos.CENTER);

        VBox inputPane = new VBox(10, lblNumbers, txtNumbers, new HBox(20, btnLoadData, btnClear));
        HBox tablePane = new HBox(10, resultPane, new VBox(40, inputPane, tableInformation));
        tablePane.setAlignment(Pos.CENTER);

        mainPane = new VBox(10, title, tablePane);
        mainPane.setAlignment(Pos.CENTER);
    }

    private void buildTableResult() {
        TableColumn<RowResult, String> colThree = new TableColumn<>("Color");
        colThree.setCellValueFactory(new PropertyValueFactory<>("color"));
        colThree.setPrefWidth(90);

        tableResult.getColumns().addAll(List.of(getColOne(), getColTwo(), colThree));
        tableResult.setMaxWidth(280);
        tableResult.setMaxHeight(300);
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
        tableInformation.setMaxHeight(110);
    }
}
