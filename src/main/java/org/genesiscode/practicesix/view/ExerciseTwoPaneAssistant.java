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
import org.genesiscode.practicesix.view.row.RowInfoExerciseTwo;
import org.genesiscode.practicesix.view.row.RowResultToExerciseTwo;

public class ExerciseTwoPaneAssistant {

    public static void show(TableView<RowResultToExerciseTwo> table, TableView<RowInfoExerciseTwo> tableInfoOne,
                            TableView<RowInfoExerciseTwo> tableInfoTwo, TableView<RowInfoExerciseTwo> tableInfoThree) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Tabla de resultados");
        stage.setMinWidth(1000);
        stage.setMaxHeight(1000);

        VBox paneInfoOne = new VBox(10, new Label("Cantidad Suministradas / Entrega"), tableInfoOne);
        VBox paneInfoTwo = new VBox(10, new Label("Distribución de pacientes / Número de pacientes"), tableInfoTwo);
        VBox paneInfoThree = new VBox(10, new Label("Demanda por pacientes"), tableInfoThree);
        HBox tablePane = new HBox(table);
        tablePane.setFillHeight(false);
        tablePane.setAlignment(Pos.CENTER);
        VBox pane = new VBox(30, new HBox(10, paneInfoOne, paneInfoTwo, paneInfoThree), tablePane);
        pane.setPadding(new Insets(20));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
