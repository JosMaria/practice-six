package org.genesiscode.practicesix.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practicesix.service.utils.Decimal;
import org.genesiscode.practicesix.view.row.RowEnunciateTwo;
import org.genesiscode.practicesix.view.row.RowInfoExerciseTwo;
import org.genesiscode.practicesix.view.row.RowResult;

import java.util.List;

public class ExerciseTwo {

    private List<RowEnunciateTwo> dataToTableOne, dataToTableTwo, dataToTableThree;

    private List<Double> randomNumbers;
    private ObservableList<RowEnunciateTwo> dataTableOne, dataTableTwo, dataTableThree;

    public ExerciseTwo() {
        load();
    }

    public ObservableList<RowResult> buildRowsToStart() {
        ObservableList<RowResult> rowsToResult = FXCollections.observableArrayList();
        int counter = 0;
        for (double randomNumber : randomNumbers) {
            rowsToResult.add(new RowResult(++counter, randomNumber));
        }
        return rowsToResult;
    }

    private void load() {
        randomNumbers = List.of(0.74, 0.85, 0.21, 0.06, 0.71, 0.31, 0.28, 0.96, 0.02,
                0.72, 0.12, 0.67, 0.53, 0.44, 0.23, 0.16, 0.16, 0.40, 0.83, 0.65, 0.34, 0.82);

        dataToTableOne = List.of(
                new RowEnunciateTwo(4, 0.15),
                new RowEnunciateTwo(5, 0.20),
                new RowEnunciateTwo(6, 0.25),
                new RowEnunciateTwo(7, 0.15),
                new RowEnunciateTwo(8, 0.15),
                new RowEnunciateTwo(9, 0.10));
        dataTableOne = loadInformation(dataToTableOne);

        dataToTableTwo = List.of(
                new RowEnunciateTwo(0, 0.25),
                new RowEnunciateTwo(1, 0.25),
                new RowEnunciateTwo(2, 0.30),
                new RowEnunciateTwo(3, 0.15),
                new RowEnunciateTwo(4, 0.05));
        dataTableTwo = loadInformation(dataToTableTwo);

        dataToTableThree = List.of(
                new RowEnunciateTwo(1, 0.40),
                new RowEnunciateTwo(2, 0.30),
                new RowEnunciateTwo(3, 0.20),
                new RowEnunciateTwo(4, 0.10));
        dataTableThree = loadInformation(dataToTableThree);
    }

    private ObservableList<RowEnunciateTwo> loadInformation(List<RowEnunciateTwo> informationToTableOne) {
        ObservableList<RowEnunciateTwo> observableList = FXCollections.observableArrayList();
        observableList.addAll(informationToTableOne);
        return observableList;
    }

    public ObservableList<RowInfoExerciseTwo> getInfoTable(List<RowEnunciateTwo> list) {
        ObservableList<RowInfoExerciseTwo> observableList = FXCollections.observableArrayList();
        double accumulated = 0.0;

        for (RowEnunciateTwo row : list) {
            double colProbability = row.getProbability();
            double startRange = Decimal.getDecimal(2, accumulated);
            accumulated += colProbability;
            accumulated = Decimal.getDecimal(2, accumulated);
            double endRange = Decimal.getDecimal(2, accumulated);

            RowInfoExerciseTwo rowToAdded = new RowInfoExerciseTwo(colProbability, accumulated,
                    String.format("[%s - %s)", startRange, endRange), row.getInformation());
            rowToAdded.setRangeStart(startRange);
            rowToAdded.setRangeEnd(endRange);
            observableList.add(rowToAdded);
        }
        return observableList;
    }

    public ObservableList<RowEnunciateTwo> getDataTableOne() {
        return dataTableOne;
    }

    public ObservableList<RowEnunciateTwo> getDataTableTwo() {
        return dataTableTwo;
    }

    public ObservableList<RowEnunciateTwo> getDataTableThree() {
        return dataTableThree;
    }

    public List<RowEnunciateTwo> getDataToTableOne() {
        return dataToTableOne;
    }

    public List<RowEnunciateTwo> getDataToTableTwo() {
        return dataToTableTwo;
    }

    public List<RowEnunciateTwo> getDataToTableThree() {
        return dataToTableThree;
    }
}
