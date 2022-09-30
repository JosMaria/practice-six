package org.genesiscode.practicesix.view.row.exerciseFour;

public class RowDataProcessed {

    private double probability;
    private double accumulatedDistribution;
    private String range;
    private int data;
    private double startRange, endRange;

    public RowDataProcessed(double probability, double accumulatedDistribution, String range, int data) {
        this.probability = probability;
        this.accumulatedDistribution = accumulatedDistribution;
        this.range = range;
        this.data = data;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public double getAccumulatedDistribution() {
        return accumulatedDistribution;
    }

    public void setAccumulatedDistribution(double accumulatedDistribution) {
        this.accumulatedDistribution = accumulatedDistribution;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public double getStartRange() {
        return startRange;
    }

    public void setStartRange(double startRange) {
        this.startRange = startRange;
    }

    public double getEndRange() {
        return endRange;
    }

    public void setEndRange(double endRange) {
        this.endRange = endRange;
    }
}
