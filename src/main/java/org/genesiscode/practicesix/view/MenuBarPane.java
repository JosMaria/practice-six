package org.genesiscode.practicesix.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MenuBarPane implements EventHandler<ActionEvent> {

    private final VBox mainPane;
    private static final String EXERCISE_ONE = "Ejercicio 1";
    private static final String EXERCISE_TWO = "Ejercicio 2";
    private static final String EXERCISE_THREE = "Ejercicio 3";

    public MenuBarPane() {
        this.mainPane = new VBox(10, getMenuBar(), new VBox());
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

        Label pane = switch (source.getText()) {
            case EXERCISE_ONE -> new Label(EXERCISE_ONE);
            case EXERCISE_TWO -> new Label(EXERCISE_TWO);
            case EXERCISE_THREE -> new Label(EXERCISE_THREE);
            default -> new Label("Empty");
        };

        changePane(new VBox(pane));
    }

    private void changePane(Pane pane) {
        mainPane.getChildren().remove(1);
        mainPane.getChildren().add(pane);
    }
}
