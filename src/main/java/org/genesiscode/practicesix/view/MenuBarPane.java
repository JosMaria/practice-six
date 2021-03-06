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

    public MenuBarPane() {
        Label title = new Label("Practica 6");
        title.setFont(new Font("Gargi", 30));
        VBox paneDefault = new VBox(title);
        paneDefault.setAlignment(Pos.CENTER);
        paneDefault.setPadding(new Insets(20));
        mainPane = new VBox(10, getMenuBar(), paneDefault);
        mainPane.setMinWidth(800);
        mainPane.setMinHeight(500);
        /*mainPane.setMaxHeight(500);*/
    }

    public VBox getMainPane() {
        return mainPane;
    }

    private MenuBar getMenuBar() {
        Menu menuExerciseOne = new Menu(EXERCISE_ONE);
        MenuItem menuItemOne = new MenuItem(EXERCISE_ONE);
        menuExerciseOne.getItems().add(menuItemOne);
        menuItemOne.setOnAction(this);

        Menu menuExerciseTwo = new Menu(EXERCISE_TWO);
        MenuItem menuItemTwo = new MenuItem(EXERCISE_TWO);
        menuExerciseTwo.getItems().add(menuItemTwo);
        menuItemTwo.setOnAction(this);

        Menu menuExerciseThree = new Menu(EXERCISE_THREE);
        MenuItem menuItemThree = new MenuItem(EXERCISE_THREE);
        menuExerciseThree.getItems().add(menuItemThree);
        menuItemThree.setOnAction(this);

        return new MenuBar(menuExerciseOne, menuExerciseTwo, menuExerciseThree);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        MenuItem source = (MenuItem) actionEvent.getSource();

        VBox pane = switch (source.getText()) {
            case EXERCISE_ONE -> ExerciseOnePane.getInstance().mainPane;
            case EXERCISE_TWO -> ExerciseTwoPane.getInstance().mainPane;
            case EXERCISE_THREE -> ExerciseThreePane.getInstance().mainPane;
            default -> new VBox(new Label("Empty"));
        };

        changePane(new VBox(pane));
    }

    private void changePane(Pane pane) {
        mainPane.getChildren().remove(1);
        mainPane.getChildren().add(pane);
    }
}
