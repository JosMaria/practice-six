package org.genesiscode.practicesix.view;

import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.genesiscode.practicesix.view.row.RowResultToExerciseTwo;

public class ExerciseTwoPaneAssistant {

    public static void show(TableView<RowResultToExerciseTwo> table) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Tabla de resultados");
        stage.setMinWidth(1000);
        stage.setMaxHeight(1000);

        VBox pane = new VBox(10, table);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
