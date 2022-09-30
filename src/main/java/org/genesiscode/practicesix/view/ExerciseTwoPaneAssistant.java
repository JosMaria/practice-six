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
import org.genesiscode.practicesix.view.row.RowEnunciateTwo;
import org.genesiscode.practicesix.view.row.two.RowResultExerciseThree;

public class ExerciseTwoPaneAssistant {

    public static void show(TableView<RowResultExerciseThree> table, TableView<RowEnunciateTwo> tableIncise, Label lblResultTotal,
                            int times, int weeks, String weeksSpecific, double averageTotal, double functionSales) {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Tabla de resultados");
        table.setMaxHeight(210);

        VBox inciseResultPane = new VBox(10, tableIncise, lblResultTotal);
        inciseResultPane.setAlignment(Pos.CENTER_RIGHT);

        VBox resultsPane = new VBox(10,
                new Label("\t===== RESULTADOS DE LOS INCISOS ====="),
                new Label(String.format("Faltantes %s veces durante las %s semanas (semana: %s)", times, weeks, weeksSpecific)),
                new Label(String.format("Venta promedio  %s calentadores/semana", averageTotal)),
                new Label(String.format("E(ventas)  %s calentadores/semana", functionSales)));

        VBox pane = new VBox(10, new Label("VENTA DE CALENTADORES"), new HBox(10, table, inciseResultPane), resultsPane);

        pane.setPadding(new Insets(20));
        pane.setAlignment(Pos.CENTER);
        pane.setFillWidth(false);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
