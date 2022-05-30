package org.genesiscode.practicesix.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.genesiscode.practicesix.view.row.exerciseThree.RowResultExerciseThree;

public class ExerciseThreePaneAssistant {

    public static void show(TableView<RowResultExerciseThree> table) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Tabla de resultados");
        table.setMaxHeight(250);
        VBox pane = new VBox(10, new Label("VENTA DE CALENTADORES"), table);
        pane.setPadding(new Insets(20));
        pane.setAlignment(Pos.CENTER);
        pane.setFillWidth(false);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
