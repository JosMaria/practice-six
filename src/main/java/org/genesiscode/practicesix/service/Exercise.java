package org.genesiscode.practicesix.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practicesix.view.row.exerciseFour.RowRandomNumbers;

import java.util.List;

public class Exercise {

    protected List<Double> randomNumbers;

    public ObservableList<RowRandomNumbers> loadRandomNumbers(List<Double> randomNumbers) {
        this.randomNumbers = randomNumbers;
        ObservableList<RowRandomNumbers> list = FXCollections.observableArrayList();
        int counter = 1;
        for (double randomNumber : this.randomNumbers) {
            list.add(new RowRandomNumbers(counter, randomNumber));
            counter++;
        }
        return list;
    }
}
