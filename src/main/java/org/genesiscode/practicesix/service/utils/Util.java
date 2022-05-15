package org.genesiscode.practicesix.service.utils;

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
}
