package org.genesiscode.practicesix.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practicesix.view.row.exerciseThree.RowInfoExerciseThree;

import java.util.List;

public class ExerciseThree {

    private final ObservableList<RowInfoExerciseThree> listToTableInfoStart;

    public ExerciseThree() {
        listToTableInfoStart = FXCollections.observableArrayList();
    }

    public void addItemToListToTableInfoStart(int salesPerWeek, int numberOfWeek) {
        RowInfoExerciseThree row = new RowInfoExerciseThree(salesPerWeek, numberOfWeek);
        listToTableInfoStart.add(row);
    }

    public void clearItemsOfListToTableInfoStart() {
        listToTableInfoStart.clear();
    }

    public ObservableList<RowInfoExerciseThree> getListToTableInfoStart() {
        return listToTableInfoStart;
    }

    public int totalNumberOfWeeks() {
        List<Integer> list = listToTableInfoStart.stream()
                .map(RowInfoExerciseThree::getNumberOfWeek)
                .toList();

        int counter = 0;
        for (int number : list) {
            counter += number;
        }
        return counter;
    }
}
