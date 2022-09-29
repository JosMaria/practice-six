package org.genesiscode.practicesix.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practicesix.service.utils.Decimal;
import org.genesiscode.practicesix.view.row.RowEnunciateTwo;
import org.genesiscode.practicesix.view.row.exerciseThree.RowInfoExerciseThree;
import org.genesiscode.practicesix.view.row.exerciseThree.RowResultExerciseThree;

import java.util.List;
import java.util.function.Consumer;

public class ExerciseThree {

    private final ObservableList<RowInfoExerciseThree> listToTableInfoStart;
    private int total, resultTotal;

    public ExerciseThree() {
        listToTableInfoStart = FXCollections.observableArrayList();
    }

    public int getResultTotal() {
        return resultTotal;
    }

    public ObservableList<RowEnunciateTwo> buildTableEnunciateThree(List<Double> data) {
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

    public ObservableList<RowResultExerciseThree> buildTableResult() {
        ObservableList<RowResultExerciseThree> list = FXCollections.observableArrayList();
        double accumulated = 0.0;
        for (RowInfoExerciseThree row : listToTableInfoStart) {
            double probability = row.getProbability();
            double rangeStart = accumulated;
            accumulated += probability;
            accumulated = Decimal.getDecimal(2, accumulated);
            double rangeEnd = accumulated;
            String range = String.format("[%s - %s)", rangeStart, rangeEnd);
            RowResultExerciseThree rowToAdded =
                    new RowResultExerciseThree(probability, accumulated, range, row.getSalesPerWeek());
            rowToAdded.setStartRange(rangeStart);
            rowToAdded.setEndRange(rangeEnd);
            list.add(rowToAdded);
        }
        return list;
    }

    public void addSalesTableEnunciateThree(ObservableList<RowEnunciateTwo> items, ObservableList<RowResultExerciseThree> listRange) {
        int total = 0;
        for (RowEnunciateTwo item : items) {
            RowResultExerciseThree element = listRange.stream()
                    .filter(row -> {
                        double probability = item.getProbability();
                        return row.getStartRange() <= probability && probability < row.getEndRange();
                    })
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Not found"));
            item.setSales(element.getSales());
            total += element.getSales();
        }
        resultTotal = total;
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
            row.setTxtProbability(String.valueOf(probability));
        };
        listToTableInfoStart.forEach(consumer);
    }
}
