package org.genesiscode.practicesix.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practicesix.service.utils.Decimal;
import org.genesiscode.practicesix.view.row.three.RowDataProcessed;
import org.genesiscode.practicesix.view.row.three.RowRandomNumbers;
import org.genesiscode.practicesix.view.row.three.RowResult;

import java.time.LocalTime;
import java.util.List;

public class ExerciseThree extends Exercise {

    private ObservableList<RowRandomNumbers> listToTableOfTime, listToTableOfCustomerArrival;

    public ExerciseThree() {
        load();
    }

    private void load() {
        List<RowRandomNumbers> listToTableOfTime = List.of(new RowRandomNumbers(0, 0.00),
                new RowRandomNumbers(1, 0.25),
                new RowRandomNumbers(2, 0.20),
                new RowRandomNumbers(3, 0.40),
                new RowRandomNumbers(4, 0.15));
        this.listToTableOfTime = FXCollections.observableList(listToTableOfTime);

        List<RowRandomNumbers> listToTableOfCustomerArrival = List.of(
                new RowRandomNumbers(0, 0.10), new RowRandomNumbers(1, 0.35),
                new RowRandomNumbers(2, 0.25), new RowRandomNumbers(3, 0.15),
                new RowRandomNumbers(4, 0.10), new RowRandomNumbers(5, 0.05));
        this.listToTableOfCustomerArrival = FXCollections.observableList(listToTableOfCustomerArrival);
    }

    public ObservableList<RowRandomNumbers> getListToTableOfTime() {
        return listToTableOfTime;
    }

    public ObservableList<RowRandomNumbers> getListToTableOfCustomerArrival() {
        return listToTableOfCustomerArrival;
    }

    public ObservableList<RowDataProcessed> getListToTableOf(ObservableList<RowRandomNumbers> listToTableOfTime) {
        ObservableList<RowDataProcessed> list = FXCollections.observableArrayList();
        double accumulated = 0.0;
        for (RowRandomNumbers row : listToTableOfTime) {
            if (row.getValue() != 0.0) {
                double probability = row.getValue();
                double startRange = accumulated;
                accumulated += probability;
                accumulated = Decimal.getDecimal(2, accumulated);
                double endRange = accumulated;
                String range = String.format("[%s - %s)", startRange, endRange);

                RowDataProcessed rowDataProcessed = new RowDataProcessed(probability, accumulated, range, row.getData());
                list.add(rowDataProcessed);
                rowDataProcessed.setStartRange(startRange);
                rowDataProcessed.setEndRange(endRange);
            }
        }
        return list;
    }

    public ObservableList<RowResult> getListResult(ObservableList<RowDataProcessed> tableDataOfTime,
                                                   ObservableList<RowDataProcessed> tableDataOfCustomerArrival) {
        ObservableList<RowResult> list = FXCollections.observableArrayList();
        LocalTime timeOfArrival = LocalTime.of(9, 0), startService, endService = null;
        for (int i = 0, client = 1; i < randomNumbers.size(); i++, client++) {
            double randomNumberOne = randomNumbers.get(i);  // print 2
            i++;
            int intervalBetweenArrival = getValueGivenInterval(randomNumberOne, tableDataOfCustomerArrival); // print 3
            timeOfArrival = timeOfArrival.plusMinutes(intervalBetweenArrival);
            double randomNumberTwo = randomNumbers.get(i);
            int tService = getValueGivenInterval(randomNumberTwo, tableDataOfTime);
            startService = endService == null ? timeOfArrival : endService;
            int timeOfLeisure = endService == null ? intervalBetweenArrival : endService.getMinute() - startService.getMinute();
            endService = startService.plusMinutes(tService);
            int timeOfWait = startService.getMinute() - timeOfArrival.getMinute();

            RowResult rowResult = new RowResult(client, randomNumberOne, intervalBetweenArrival,
                    timeOfArrival.toString(), randomNumberTwo, tService, startService.toString(),
                    endService.toString(), timeOfWait, timeOfLeisure);
            list.add(rowResult);
        }
        return list;
    }

    private int getValueGivenInterval(double randomNumber, ObservableList<RowDataProcessed> list) {
        return list.stream()
                .filter(row -> row.getStartRange() <= randomNumber && randomNumber < row.getEndRange())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Doesn't exists interval"))
                .getData();
    }
}
