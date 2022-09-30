package org.genesiscode.practicesix.view.row.two;

public class RowInfoExerciseThree {

    private int salesPerWeek;
    private int numberOfWeek;
    private String txtProbability;
    private double probability;

    public RowInfoExerciseThree(int salesPerWeek, int numberOfWeek) {
        this.salesPerWeek = salesPerWeek;
        this.numberOfWeek = numberOfWeek;
    }

    public RowInfoExerciseThree(int salesPerWeek, int numberOfWeek,
                                String txtProbability, double probability) {
        this.salesPerWeek = salesPerWeek;
        this.numberOfWeek = numberOfWeek;
        this.txtProbability = txtProbability;
        this.probability = probability;
    }

    public int getSalesPerWeek() {
        return salesPerWeek;
    }

    public void setSalesPerWeek(int salesPerWeek) {
        this.salesPerWeek = salesPerWeek;
    }

    public int getNumberOfWeek() {
        return numberOfWeek;
    }

    public void setNumberOfWeek(int numberOfWeek) {
        this.numberOfWeek = numberOfWeek;
    }

    public String getTxtProbability() {
        return txtProbability;
    }

    public void setTxtProbability(String txtProbability) {
        this.txtProbability = txtProbability;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}
