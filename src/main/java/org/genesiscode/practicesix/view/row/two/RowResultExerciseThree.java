package org.genesiscode.practicesix.view.row.two;

public class RowResultExerciseThree {

    private double probability;
    private double accumulatedDistribution;
    private String rangeRandomNumbers;
    private int sales;
    private double startRange;
    private double endRange;

    public RowResultExerciseThree(double probability, double accumulatedDistribution,
                                  String rangeRandomNumbers, int sales) {
        this.probability = probability;
        this.accumulatedDistribution = accumulatedDistribution;
        this.rangeRandomNumbers = rangeRandomNumbers;
        this.sales = sales;
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

    public String getRangeRandomNumbers() {
        return rangeRandomNumbers;
    }

    public void setRangeRandomNumbers(String rangeRandomNumbers) {
        this.rangeRandomNumbers = rangeRandomNumbers;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
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
