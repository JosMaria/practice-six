package org.genesiscode.practicesix.view.row.four;

public class RowResult {

    private int day;
    private double randomNumber;
    private int demand;
    private int revenue;

    public RowResult(int day, double randomNumber, int demand, int revenue) {
        this.day = day;
        this.randomNumber = randomNumber;
        this.demand = demand;
        this.revenue = revenue;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(double randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }
}
