package org.genesiscode.practicesix.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practicesix.view.row.exerciseThree.RowInfoExerciseThree;

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
}
