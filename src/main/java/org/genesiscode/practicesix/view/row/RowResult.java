package org.genesiscode.practicesix.view.row;

public class RowResult {

    private final int numberBall;
    private final double numberRandom;
    private String color;

    public RowResult(int numberBall, double numberRandom, String color) {
        this.numberBall = numberBall;
        this.numberRandom = numberRandom;
        this.color = color;
    }

    public int getNumberBall() {
        return numberBall;
    }

    public double getNumberRandom() {
        return numberRandom;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}