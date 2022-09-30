package org.genesiscode.practicesix.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practicesix.service.utils.Util;
import org.genesiscode.practicesix.view.row.four.RowInputData;
import org.genesiscode.practicesix.view.row.four.RowResult;
import org.genesiscode.practicesix.view.row.three.RowDataProcessed;

import java.util.List;

public class ExerciseFour extends Exercise {

    private ObservableList<RowInputData> listToTableInputData;
    private ObservableList<RowDataProcessed> listToTableDataProcessed;
    private ObservableList<RowResult> listToResult;

    public ExerciseFour() {
        load();
    }

    private void load() {
        List<RowInputData> listToTableInputData = List.of(
                new RowInputData(2300, 0.15),
                new RowInputData(2400, 0.22),
                new RowInputData(2500, 0.24),
                new RowInputData(2600, 0.21),
                new RowInputData(2700, 0.18));
        this.listToTableInputData = FXCollections.observableList(listToTableInputData);
    }

    public ObservableList<RowInputData> getListToTableInputData() {
        return listToTableInputData;
    }


    public ObservableList<RowDataProcessed> listOfIntervals() {
        listToTableDataProcessed = Util.listOfIntervals(listToTableInputData);
        return listToTableDataProcessed;
    }

    public ObservableList<RowResult> getListResult(double produce, double sell, int quantity, int simulatedGames) {
        ObservableList<RowResult> list = FXCollections.observableArrayList();
        int day, demand, revenue;
        double randomNumber;
        for (int i = 0; i < simulatedGames; i++) {
            day = i + 1;
            randomNumber = randomNumbers.get(i);
            demand = getProgramSalesGiven(randomNumber);
            revenue = (int) (demand < quantity ? (sell * demand) - (produce * quantity) : (sell * quantity) - (produce * quantity));
            list.add(new RowResult(day, randomNumber, demand, revenue));
        }
        listToResult = list;
        return list;
    }

    private int getProgramSalesGiven(double randomNumber) {
        return listToTableDataProcessed.stream()
                .filter(row -> row.getStartRange() <= randomNumber && randomNumber < row.getEndRange())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Doesn't exists"))
                .getData();
    }

    public int getTotal() {
        List<Integer> collect = listToResult.stream().map(RowResult::getRevenue).toList();
        int total = 0;
        for (int number : collect) {
            total += number;
        }
        return total;
    }
}
