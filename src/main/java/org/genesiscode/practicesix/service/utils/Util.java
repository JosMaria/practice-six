package org.genesiscode.practicesix.service.utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.genesiscode.practicesix.view.row.four.RowInputData;
import org.genesiscode.practicesix.view.row.three.RowDataProcessed;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<Double> convertToList(String numbers) throws NumberFormatException {
        StringBuilder builder = new StringBuilder();
        List<Double> list = new ArrayList<>();
        for (int i = 0; i <= numbers.length(); i++) {
            if (i == numbers.length()) {
                list.add(Double.parseDouble(builder.toString()));
            } else {
                if (numbers.charAt(i) == ' ') {
                    double number = Double.parseDouble(builder.toString());
                    list.add(number);
                    builder.delete(0, builder.length());
                } else {
                    builder.append(numbers.charAt(i));
                }
            }
        }
        return list;
    }

    public static ObservableList<RowDataProcessed> listOfIntervals(List<RowInputData> listToTableInputData) {
        ObservableList<RowDataProcessed> list = FXCollections.observableArrayList();
        double accumulated = 0, startRange, endRange;
        for (RowInputData row : listToTableInputData) {
            double probability = row.getProbability();
            startRange = accumulated;
            accumulated += probability;
            accumulated = Decimal.getDecimal(2, accumulated);
            endRange = accumulated;

            RowDataProcessed rowToAdd = new RowDataProcessed(probability, accumulated,
                    String.format("[%s - %s)", startRange, endRange), row.getNumberOfPrograms());
            rowToAdd.setStartRange(startRange);
            rowToAdd.setEndRange(endRange);
            list.add(rowToAdd);
        }
        return list;
    }
}
