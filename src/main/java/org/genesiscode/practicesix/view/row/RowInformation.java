package org.genesiscode.practicesix.view.row;

public class RowInformation {

    private final String color;
    private final double probability;
    private final double accumulated;
    private final String range;

    public RowInformation(String color, double probability, double accumulated, String range) {
        this.color = color;
        this.probability = probability;
        this.accumulated = accumulated;
        this.range = range;
    }

    public String getColor() {
        return color;
    }

    public double getProbability() {
        return probability;
    }

    public double getAccumulated() {
        return accumulated;
    }

    public String getRange() {
        return range;
    }
}