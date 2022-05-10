package org.genesiscode.practicesix.view.row;

import java.util.List;

public class RowResultToExerciseTwo {

    private final int week;
    private final int initialInventory;
    private final double randomNumberOne;
    private final int pintsOne;
    private final int totalAvailableBlood;
    private final double randomNumberTwo;
    private final int numberOfPatients;
    private final List<Integer> numberOfPatient;
    private final List<Double> randomNumberThree;
    private final List<Integer> pintsTwo;
    private final List<Integer> numberOfPintsRemaining;

    public RowResultToExerciseTwo(int week, int initialInventory, double randomNumberOne, int pintsOne,
                                  int totalAvailableBlood, double randomNumberTwo, int numberOfPatients,
                                  List<Integer> numberOfPatient, List<Double> randomNumberThree,
                                  List<Integer> pintsTwo, List<Integer> numberOfPintsRemaining) {
        this.week = week;
        this.initialInventory = initialInventory;
        this.randomNumberOne = randomNumberOne;
        this.pintsOne = pintsOne;
        this.totalAvailableBlood = totalAvailableBlood;
        this.randomNumberTwo = randomNumberTwo;
        this.numberOfPatients = numberOfPatients;
        this.numberOfPatient = numberOfPatient;
        this.randomNumberThree = randomNumberThree;
        this.pintsTwo = pintsTwo;
        this.numberOfPintsRemaining = numberOfPintsRemaining;
    }

    public int getWeek() {
        return week;
    }

    public int getInitialInventory() {
        return initialInventory;
    }

    public double getRandomNumberOne() {
        return randomNumberOne;
    }

    public int getPintsOne() {
        return pintsOne;
    }

    public int getTotalAvailableBlood() {
        return totalAvailableBlood;
    }

    public double getRandomNumberTwo() {
        return randomNumberTwo;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }

    public List<Integer> getNumberOfPatient() {
        return numberOfPatient;
    }

    public List<Double> getRandomNumberThree() {
        return randomNumberThree;
    }

    public List<Integer> getPintsTwo() {
        return pintsTwo;
    }

    public List<Integer> getNumberOfPintsRemaining() {
        return numberOfPintsRemaining;
    }

    @Override
    public String toString() {
        return "RowResultToExerciseTwo{" +
                "week=" + week +
                ", initialInventory=" + initialInventory +
                ", randomNumberOne=" + randomNumberOne +
                ", pintsOne=" + pintsOne +
                ", totalAvailableBlood=" + totalAvailableBlood +
                ", randomNumberTwo=" + randomNumberTwo +
                ", numberOfPatients=" + numberOfPatients +
                ", numberOfPatient=" + numberOfPatient +
                ", randomNumberThree=" + randomNumberThree +
                ", pintsTwo=" + pintsTwo +
                ", numberOfPintsRemaining=" + numberOfPintsRemaining +
                '}';
    }
}
