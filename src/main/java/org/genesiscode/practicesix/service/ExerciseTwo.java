package org.genesiscode.practicesix.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practicesix.view.row.RowEnunciateTwo;
import org.genesiscode.practicesix.view.row.RowResult;

import java.util.List;

public class ExerciseTwo {

    private static final List<Double> RANDOM_NUMBERS =
            List.of(0.74, 0.85, 0.21, 0.06, 0.71, 0.31, 0.28, 0.96, 0.02, 0.72, 0.12,
                                0.67, 0.53, 0.44, 0.23, 0.16, 0.16, 0.40, 0.83, 0.65, 0.34, 0.82);



    private final ObservableList<RowResult> rowsToResult = FXCollections.observableArrayList();
    private ObservableList<RowEnunciateTwo> informationTableOne, informationTableTwo, informationTableThree;

    public ObservableList<RowResult> buildRowsToStart() {
        rowsToResult.clear();
        int counter = 0;
        for (double randomNumber : RANDOM_NUMBERS) {
            rowsToResult.add(new RowResult(++counter, randomNumber));

        }
        load();
        return rowsToResult;
    }

    private void load() {
        List<RowEnunciateTwo> informationToTableOne = List.of(new RowEnunciateTwo(4, 0.15),
                                                            new RowEnunciateTwo(5, 0.20),
                                                            new RowEnunciateTwo(6, 0.25),
                                                            new RowEnunciateTwo(7, 0.15),
                                                            new RowEnunciateTwo(8, 0.15),
                                                            new RowEnunciateTwo(9, 0.10));
        informationTableOne = loadInformation(informationToTableOne);

        List<RowEnunciateTwo> informationToTableTwo = List.of(new RowEnunciateTwo(0, 0.25),
                                                            new RowEnunciateTwo(1, 0.25),
                                                            new RowEnunciateTwo(2, 0.30),
                                                            new RowEnunciateTwo(3, 0.15),
                                                            new RowEnunciateTwo(4, 0.05));
        informationTableTwo = loadInformation(informationToTableTwo);

        List<RowEnunciateTwo> informationToTableThree = List.of(new RowEnunciateTwo(1, 0.40),
                                                                new RowEnunciateTwo(2, 0.30),
                                                                new RowEnunciateTwo(3, 0.20),
                                                                new RowEnunciateTwo(4, 0.10));
        informationTableThree = loadInformation(informationToTableThree);
    }

    private ObservableList<RowEnunciateTwo> loadInformation(List<RowEnunciateTwo> informationToTableOne) {
        ObservableList<RowEnunciateTwo> observableList = FXCollections.observableArrayList();
        observableList.addAll(informationToTableOne);
        return observableList;
    }

    public ObservableList<RowEnunciateTwo> getInformationTableOne() {
        return informationTableOne;
    }

    public ObservableList<RowEnunciateTwo> getInformationTableTwo() {
        return informationTableTwo;
    }

    public ObservableList<RowEnunciateTwo> getInformationTableThree() {
        return informationTableThree;
    }

}
