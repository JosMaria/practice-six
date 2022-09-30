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

public class ExerciseOnePaneAssistant {

    public static void show(TableView<RowResultToExerciseTwo> table, TableView<RowInfoExerciseTwo> tableOne,
                            TableView<RowInfoExerciseTwo> tableTwo, TableView<RowInfoExerciseTwo> tableThree) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Tabla de resultados");
        stage.setMinWidth(1000);
        stage.setMaxHeight(1000);

        HBox infoTablePane = new HBox(10,
                new VBox(10, new Label("Cantidad Suministradas / Entrega"), tableOne),
                new VBox(10, new Label("Distribución de pacientes / Número de pacientes"), tableTwo),
                new VBox(10, new Label("Demanda por pacientes"), tableThree));
        VBox assistPane = new VBox(20, infoTablePane, table);
        assistPane.setPadding(new Insets(20));
        assistPane.setAlignment(Pos.CENTER);

        VBox pane = new VBox(10, assistPane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
