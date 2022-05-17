package org.genesiscode.practicesix.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practicesix.service.utils.Decimal;
import org.genesiscode.practicesix.view.row.RowEnunciateTwo;
import org.genesiscode.practicesix.view.row.exerciseThree.RowInfoExerciseThree;

import java.util.List;
import java.util.function.Consumer;

public class ExerciseThree {

    private final ObservableList<RowInfoExerciseThree> listToTableInfoStart;
    private List<Double> randomNumbers;
    private int total;

    public ExerciseThree() {
        listToTableInfoStart = FXCollections.observableArrayList();
    }

    public ObservableList<RowEnunciateTwo> buildTableEnunciateThree(List<Double> data) {
        randomNumbers = data;
        ObservableList<RowEnunciateTwo> rows = FXCollections.observableArrayList();
        int counter = 1;
        for (double randomNumber : data) {
            rows.add(new RowEnunciateTwo(counter, randomNumber));
            counter++;
        }
        return rows;
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
        total = counter;
        return counter;
    }

    public void addProbabilityToTableInfoStart() {
        Consumer<RowInfoExerciseThree> consumer = row -> {
            double numberOfWeek = (double) row.getNumberOfWeek() / total;
            double probability = Decimal.getDecimal(2, numberOfWeek);
            row.setProbability(probability);
            row.setTxtProbability(String.format("%s/%s=%s", numberOfWeek, total, probability));

        };
        listToTableInfoStart.forEach(consumer);
    }
}
