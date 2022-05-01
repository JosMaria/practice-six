package org.genesiscode.practicesix.service.utils;

import java.text.DecimalFormat;

public class Decimal {

    public static double getDecimal(int count, double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#." + getHash(count));
        return Double.parseDouble(decimalFormat.format(number));
    }

    private static String getHash(int count) {
        return "#".repeat(Math.max(0, count));
    }
}
