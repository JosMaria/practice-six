package org.genesiscode.practicesix.service.utils;

import java.text.DecimalFormat;

public class Decimal {

    public static double getDecimal(int count, double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#." + getHash(count));
        String numberString = decimalFormat.format(number);
        return Double.parseDouble(numberString.replace(',', '.'));
    }

    private static String getHash(int count) {
        return "#".repeat(Math.max(0, count));
    }
}
