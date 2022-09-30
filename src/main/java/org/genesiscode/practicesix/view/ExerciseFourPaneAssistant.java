package org.genesiscode.practicesix.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.genesiscode.practicesix.view.row.four.RowResult;
import org.genesiscode.practicesix.view.row.three.RowDataProcessed;

public class ExerciseFourPaneAssistant {

    public static void show(TableView<RowDataProcessed> table, TableView<RowResult> tableResult, int total) {
        Stage stage = new Stage(StageStyle.DECORATED);
        Label lblTotal = new Label("TOTAL " + total);
        VBox pane = new VBox(20, table, tableResult, new VBox(lblTotal));
        pane.setPadding(new Insets(10));
        pane.setFillWidth(false);
        stage.setScene(new Scene(pane));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Resultados");
        stage.showAndWait();
    }
}
