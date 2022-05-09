package org.genesiscode.practicesix.view.row;

public class RowInfoExerciseTwo {

    private final double probability;
    private final double accumulated;
    private final String range;
    private double rangeStart;
    private double rangeEnd;
    private final int data;

    public RowInfoExerciseTwo(double probability, double accumulated, String range, int data) {
        this.probability = probability;
        this.accumulated = accumulated;
        this.range = range;
        this.data = data;
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

    public int getData() {
        return data;
    }

    public void setRangeStart(double rangeStart) {
        this.rangeStart = rangeStart;
    }

    public void setRangeEnd(double rangeEnd) {
        this.rangeEnd = rangeEnd;
    }
}
