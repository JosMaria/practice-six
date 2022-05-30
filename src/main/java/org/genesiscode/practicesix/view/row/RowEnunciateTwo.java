package org.genesiscode.practicesix.view.row;

public class RowEnunciateTwo {

    private final int information;
    private final double probability;
    private int sales;

    public RowEnunciateTwo(int information, double probability) {
        this.information = information;
        this.probability = probability;
    }

    public int getInformation() {
        return information;
    }

    public double getProbability() {
        return probability;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
