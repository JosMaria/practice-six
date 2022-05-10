package org.genesiscode.practicesix.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practicesix.service.utils.Decimal;
import org.genesiscode.practicesix.view.row.RowEnunciateTwo;
import org.genesiscode.practicesix.view.row.RowInfoExerciseTwo;
import org.genesiscode.practicesix.view.row.RowResult;
import org.genesiscode.practicesix.view.row.RowResultToExerciseTwo;

import java.util.ArrayList;
import java.util.List;

public class ExerciseTwo {

    private List<Double> randomNumbers;
    private ObservableList<RowEnunciateTwo> dataTableOne, dataTableTwo, dataTableThree;
    private List<RowEnunciateTwo> dataToTableOne, dataToTableTwo, dataToTableThree;

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

    private ObservableList<RowInfoExerciseTwo> listInfoToTableOne;
    private ObservableList<RowInfoExerciseTwo> listInfoToTableTwo;
    private ObservableList<RowInfoExerciseTwo> listInfoToTableThree;

    public void loadTables() {
        listInfoToTableOne = getInfoTable(dataTableOne);
        listInfoToTableTwo = getInfoTable(dataTableTwo);
        listInfoToTableThree = getInfoTable(dataTableThree);
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

    public ObservableList<RowResultToExerciseTwo> buildRowToResult() {
        ObservableList<RowResultToExerciseTwo> rowsToResultFinal = FXCollections.observableArrayList();
        loadTables();
        int week = 1, initialInventory = 0, indexToNumber = 0;
        while (indexToNumber < randomNumbers.size()) {
            double randomNumberOne = randomNumbers.get(indexToNumber);
            int pintsOne = getValueInInterval(listInfoToTableOne, randomNumberOne);
            int totalAvailableBlood = initialInventory + pintsOne;
            indexToNumber++;
            double randomNumberTwo = randomNumbers.get(indexToNumber);
            int numberOfPatients = getValueInInterval(listInfoToTableTwo, randomNumberTwo);
            List<Integer> patients = sequenceNumber(numberOfPatients);
            indexToNumber++;
            List<Double> randomNumbersThree = getRandomNumbersByPatient(patients.size(), indexToNumber);
            indexToNumber = indexToNumber + patients.size();

            List<Integer> pints = new ArrayList<>();
            for (Double numberRandom : randomNumbersThree) {
                pints.add(getValueInInterval(listInfoToTableThree, numberRandom));
            }

            List<Integer> numberOfPintsRemaining = getNumberOfPintsRemaining(totalAvailableBlood, pints);
            RowResultToExerciseTwo row = new RowResultToExerciseTwo(week, initialInventory, randomNumberOne,
                                    pintsOne, totalAvailableBlood, randomNumberTwo, numberOfPatients, patients,
                                    randomNumbersThree, pints, numberOfPintsRemaining);
            rowsToResultFinal.add(row);
            initialInventory = numberOfPintsRemaining.get(numberOfPintsRemaining.size() - 1);
            week++;

        }
        return rowsToResultFinal;
    }

    private List<Integer> getNumberOfPintsRemaining(int totalAvailableBlood, List<Integer> pints) {
        ArrayList<Integer> pintsRemaining = new ArrayList<>();
        if (pints.isEmpty()) {
            pintsRemaining.add(totalAvailableBlood);
        } else {
            for (int pint : pints) {
                totalAvailableBlood -= pint;
                pintsRemaining.add(totalAvailableBlood);
            }
        }
        return pintsRemaining;
    }
    private List<Double> getRandomNumbersByPatient(int count, int index) {
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < count; i++, index++) {
            list.add(randomNumbers.get(index));
        }
        return list;
    }
    private int getValueInInterval(ObservableList<RowInfoExerciseTwo> list, double randomNumber) {
        return list.stream()
                .filter(row -> row.getRangeStart() <= randomNumber && randomNumber < row.getRangeEnd())
                .map(RowInfoExerciseTwo::getData)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("It does not exists in the interval"));
    }

    public List<Integer> sequenceNumber(int length) {
        List<Integer> list = new ArrayList<>();
        for (int number = 1; number <= length; number++) {
            list.add(number);
        }
        return list;
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
