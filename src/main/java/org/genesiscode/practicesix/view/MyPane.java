package org.genesiscode.practicesix.view;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.genesiscode.practicesix.view.row.RowResult;

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

    protected TableColumn<RowResult, Integer> getColOne() {
        TableColumn<RowResult, Integer> colOne = new TableColumn<>("Número");
        colOne.setCellValueFactory(new PropertyValueFactory<>("numberBall"));
        colOne.setPrefWidth(90);
        return colOne;
    }

    protected TableColumn<RowResult, Double> getColTwo() {
        TableColumn<RowResult, Double> colTwo = new TableColumn<>("Número\nAleatorio");
        colTwo.setCellValueFactory(new PropertyValueFactory<>("numberRandom"));
        colTwo.setPrefWidth(90);
        return colTwo;
    }
}
