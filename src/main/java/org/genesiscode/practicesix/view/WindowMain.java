package org.genesiscode.practicesix.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WindowMain extends Application {

    @Override
    public void start(Stage stage) {
        MenuBarPane menuBar = new MenuBarPane();
        Scene scene = new Scene(menuBar.getMainPane());
        stage.setTitle("Practica 6");
        stage.setMinWidth(800);
        stage.setMinHeight(500);
        stage.setMaxHeight(500);
        stage.setScene(scene);
        stage.show();
    }
}
