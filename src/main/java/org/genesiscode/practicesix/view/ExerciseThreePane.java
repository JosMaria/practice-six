package org.genesiscode.practicesix.view;

import javafx.scene.layout.VBox;

public class ExerciseThreePane extends MyPane {

    private static ExerciseThreePane exerciseThreePane;

    private ExerciseThreePane() {
        super("EJERCICIO 3");
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseThreePane getInstance() {
        return exerciseThreePane == null ? new ExerciseThreePane() : exerciseThreePane;
    }

    private void loadControls() {
    }

    private void buildPane() {
        mainPane = new VBox(10, title);
    }
}
