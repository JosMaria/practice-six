package org.genesiscode.practicesix.view;

import javafx.scene.layout.VBox;

public class ExerciseOnePane extends MyPane {

    private static ExerciseOnePane exerciseOnePane;

    private ExerciseOnePane() {
        super("EJERCICIO 1");
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseOnePane getInstance() {
        return exerciseOnePane == null ? new ExerciseOnePane() : exerciseOnePane;
    }

    private void loadControls() {
    }

    private void buildPane() {
        mainPane = new VBox(10, title);
    }
}
