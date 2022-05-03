package org.genesiscode.practicesix.service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practicesix.service.utils.Ball;
import org.genesiscode.practicesix.view.row.RowInformation;
import org.genesiscode.practicesix.view.row.RowResult;

import java.util.List;

import static org.genesiscode.practicesix.service.utils.Ball.*;

public class ExerciseOne {

    private static final List<Double> RANDOM_NUMBERS = List.of(0.26, 0.42, 0.95, 0.95, 0.66, 0.17, 0.03, 0.56, 0.83, 0.55);
    private static final List<Ball> BALLS = List.of(GREEN, RED, YELLOW);

    private final ObservableList<RowResult> rowsToResult = FXCollections.observableArrayList();
    private final ObservableList<RowInformation> rowsToInformation = FXCollections.observableArrayList();

    public ObservableList<RowResult> buildRowsToStart() {
        rowsToResult.clear();
        int counter = 0;
        for (double randomNumber : RANDOM_NUMBERS) {
            rowsToResult.add(new RowResult(++counter, randomNumber, ""));
        }
        return rowsToResult;
    }

    public ObservableList<RowInformation> buildDataToInformationTable() {
        rowsToInformation.clear();
        double accumulated = 0.0;

        for (Ball ball : BALLS) {
            double probability = ball.getProbability();
            double rangeStart = accumulated;
            accumulated += probability;
            double rangeEnd = accumulated;
            String range = String.format("[%s - %s)", rangeStart, rangeEnd);
            RowInformation row = new RowInformation(ball.getName(), probability, accumulated, range);
            row.setRangeStart(rangeStart);
            row.setRangeEnd(rangeEnd);
            rowsToInformation.add(row);
        }
        return rowsToInformation;
    }

    public void buildDataToResultTable() {
        for (RowResult rowResult : rowsToResult) {
            rowResult.setColor(getColor(rowResult.getNumberRandom()));
        }
    }

    private String getColor(double probability) {
        return rowsToInformation.stream()
                .filter(rowInformation -> isInRange(rowInformation, probability))
                .map(RowInformation::getColor)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("This value does not in of any range"));
    }

    private boolean isInRange(RowInformation rowInformation, double probability) {
        return rowInformation.getRangeStart() <= probability && probability < rowInformation.getRangeEnd();
    }
}
