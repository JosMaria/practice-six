package org.genesiscode.practicesix.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practicesix.service.utils.Decimal;
import org.genesiscode.practicesix.view.row.RowEnunciateTwo;
import org.genesiscode.practicesix.view.row.exerciseThree.RowInfoExerciseThree;
import org.genesiscode.practicesix.view.row.exerciseThree.RowResultExerciseThree;

import java.util.List;
import java.util.function.Consumer;

public class ExerciseTwo {

    private final ObservableList<RowInfoExerciseThree> listToTableInfoStart;
    private int total, resultTotal;

    private int times;
    private int weeks;
    private final StringBuilder weeksSpecific = new StringBuilder();
    private double averageTotal;
    private double functionSales;

    public int getTimes() {
        return times;
    }

    public int getWeeks() {
        return weeks;
    }

    public String getWeeksSpecific() {
        return weeksSpecific.toString().trim();
    }

    public double getAverageTotal() {
        return averageTotal;
    }

    public double getFunctionSales() {
        return Decimal.getDecimal(2, functionSales);
    }

    public ExerciseTwo() {
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
        functionSales = 0;

        for (RowInfoExerciseThree row : listToTableInfoStart) {
            double probability = row.getProbability();
            double rangeStart = accumulated;
            accumulated += probability;
            accumulated = Decimal.getDecimal(2, accumulated);
            double rangeEnd = accumulated;
            String range = String.format("[%s - %s)", rangeStart, rangeEnd);
            RowResultExerciseThree rowToAdded =
                    new RowResultExerciseThree(probability, accumulated, range, row.getSalesPerWeek());
            functionSales += probability * row.getSalesPerWeek();
            rowToAdded.setStartRange(rangeStart);
            rowToAdded.setEndRange(rangeEnd);
            list.add(rowToAdded);
        }
        return list;
    }

    public void addSalesTableEnunciateThree(ObservableList<RowEnunciateTwo> items, ObservableList<RowResultExerciseThree> listRange) {
        int total = 0;
        int counter = 1;
        times = 0;
        if (!weeksSpecific.isEmpty()) {
            weeksSpecific.delete(0, weeksSpecific.length()-1);
        }
        for (RowEnunciateTwo item : items) {
            RowResultExerciseThree element = listRange.stream()
                    .filter(row -> {
                        double probability = item.getProbability();
                        return row.getStartRange() <= probability && probability < row.getEndRange();
                    })
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Not found"));
            item.setSales(element.getSales());
            if (element.getSales() >= 10) {
                weeksSpecific.append(counter).append(" ");
                times++;
            }
            total += element.getSales();
            counter++;
        }
        resultTotal = total;
        averageTotal =  Decimal.getDecimal(2, (double) resultTotal / items.size());
        weeks = items.size();
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
