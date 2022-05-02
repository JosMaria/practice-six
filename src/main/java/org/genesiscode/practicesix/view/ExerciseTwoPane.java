package org.genesiscode.practicesix.view;

import javafx.scene.layout.VBox;

public class ExerciseTwoPane extends MyPane {

    private static ExerciseTwoPane exerciseTwoPane;

    private ExerciseTwoPane() {
        super("EJERCICIO 2");
        loadControls();
        buildPane();
    }

    public synchronized static ExerciseTwoPane getInstance() {
        return exerciseTwoPane == null ? new ExerciseTwoPane() : exerciseTwoPane;
    }

    private void loadControls() {
    }

    private void buildPane() {
        mainPane = new VBox(10, title);
    }
}
