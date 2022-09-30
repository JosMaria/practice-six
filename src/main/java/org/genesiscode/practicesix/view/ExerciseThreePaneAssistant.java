package org.genesiscode.practicesix.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.genesiscode.practicesix.view.row.exerciseFour.RowDataProcessed;
import org.genesiscode.practicesix.view.row.exerciseFour.RowResult;

public class ExerciseThreePaneAssistant {

    public static void show(TableView<RowDataProcessed> tableOne, TableView<RowDataProcessed> tableTwo,
                            TableView<RowResult> tableResult) {
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Resultados");

        HBox topPane = new HBox(20,
                new VBox(10, new Label("Datos del Tiempo de Servicio"),tableOne),
                new VBox(10, new Label("Datos de la llegada de los clientes"), tableTwo));
        topPane.setAlignment(Pos.CENTER);
        VBox pane = new VBox(20, topPane, tableResult);
        pane.setPadding(new Insets(20));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
