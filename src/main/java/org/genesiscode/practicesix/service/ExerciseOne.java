package org.genesiscode.practicesix.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practicesix.service.utils.Ball;
import org.genesiscode.practicesix.view.row.RowResult;

import java.util.List;

public class ExerciseOne {

    private static final List<Double> randomNumbers =
            List.of(0.26, 0.42, 0.95, 0.95, 0.66, 0.17, 0.03, 0.56, 0.83, 0.55);

    private final ObservableList<RowResult> rowsToResult = FXCollections.observableArrayList();

    public ExerciseOne() {
        Ball green = Ball.GREEN;
        Ball red = Ball.RED;
        Ball yellow = Ball.YELLOW;

    }

    public ObservableList<RowResult> buildRowsToStart() {
        rowsToResult.clear();
        int counter = 0;
        for (double randomNumber : randomNumbers) {
            rowsToResult.add(new RowResult(counter++, randomNumber, ""));
        }
        return rowsToResult;
    }

//    private static final Random random = new Random();

//    private static final double LIMIT = 1.0;

//    private final List<Double> randomNumbers = new ArrayList<>();
//    public List<Double> generateRandomNumbers(int countNumbers) {
//        randomNumbers.clear();
//        for (int i = 0; i < countNumbers; i++) {
//            double randomNumber = random.nextDouble(LIMIT);
//            randomNumbers.add(Decimal.getDecimal(2, randomNumber));
//        }
//
//        return randomNumbers;

//    }

}
