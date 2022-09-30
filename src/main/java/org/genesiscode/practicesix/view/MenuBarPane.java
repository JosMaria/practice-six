package org.genesiscode.practicesix.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MenuBarPane implements EventHandler<ActionEvent> {

    private final VBox mainPane;
    private static final String EXERCISE_ONE = "Ejercicio 1";
    private static final String EXERCISE_TWO = "Ejercicio 2";
    private static final String EXERCISE_THREE = "Ejercicio 3";
    private static final String EXERCISE_FOUR = "Ejercicio 4";

    public MenuBarPane() {
        Label title = new Label("Practica 7 - PROYECTO");
        title.setFont(new Font("Gargi", 30));

        VBox informationPane = new VBox(10,
                new Label("ESTUDIANTE: Jose Maria Aguilar Chambi"),
                new Label("DOCENTE: Jose Richard Ayoroa Cardozo"));
        informationPane.setAlignment(Pos.CENTER);

        VBox paneDefault = new VBox(30, title, informationPane);
        paneDefault.setAlignment(Pos.CENTER);
        paneDefault.setPadding(new Insets(20));

        mainPane = new VBox(10, getMenuBar(), paneDefault);
        mainPane.setMinWidth(850);
        mainPane.setMinHeight(500);
    }

    public VBox getMainPane() {
        return mainPane;
    }

    private MenuBar getMenuBar() {
        return new MenuBar(createMenu(EXERCISE_ONE), createMenu(EXERCISE_TWO),
                            createMenu(EXERCISE_THREE), createMenu(EXERCISE_FOUR));
    }

    private Menu createMenu(String title) {
        Menu menu = new Menu(title);
        MenuItem menuItem = new MenuItem(title);
        menu.getItems().add(menuItem);
        menuItem.setOnAction(this);
        return menu;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        MenuItem source = (MenuItem) actionEvent.getSource();
        VBox pane = switch (source.getText()) {
            case EXERCISE_ONE -> ExerciseOnePane.getInstance().mainPane;
            case EXERCISE_TWO -> ExerciseTwoPane.getInstance().mainPane;
            case EXERCISE_THREE -> ExerciseThreePane.getInstance().mainPane;
            case EXERCISE_FOUR -> ExerciseFourPane.getInstance().mainPane;
            default -> new VBox(new Label("Empty"));
        };
        changePane(new VBox(pane));
    }

    private void changePane(Pane pane) {
        mainPane.getChildren().remove(1);
        mainPane.getChildren().add(pane);
    }
}
