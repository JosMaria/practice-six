package org.genesiscode.practicesix.view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MyPane {

    protected VBox mainPane;
    protected Label title;

    protected MyPane(String titleHeader) {
        title = new Label(titleHeader);
        title.setFont(new Font("Gargi", 20));
    }

    protected VBox getMainPane() {
        return mainPane;
    }
}
