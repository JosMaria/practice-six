package org.genesiscode.practicesix.view.row.four;

public class RowInputData {

    private int numberOfPrograms;
    private double probability;

    public RowInputData(int numberOfPrograms, double probability) {
        this.numberOfPrograms = numberOfPrograms;
        this.probability = probability;
    }

    public int getNumberOfPrograms() {
        return numberOfPrograms;
    }

    public void setNumberOfPrograms(int numberOfPrograms) {
        this.numberOfPrograms = numberOfPrograms;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}
