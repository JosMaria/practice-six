package org.genesiscode.practicesix.service;

import org.genesiscode.practicesix.service.utils.Ball;

import java.util.List;

public class ExerciseOne {


    public ExerciseOne() {
        Ball green = Ball.GREEN;
        Ball red = Ball.RED;
        Ball yellow = Ball.YELLOW;

    }


    public List<Double> randomNumbersEntered() {
        return List.of(0.26, 0.42, 0.95, 0.95, 0.66, 0.17, 0.03, 0.56, 0.83, 0.55);
    }



//    private static final Random random = new Random();

//    private static final double LIMIT = 1.0;

//    private final List<Double> randomNumbers = new ArrayList<>();
//    public List<Double> generateRandomNumbers(int countNumbers) {
//        randomNumbers.clear();
//        for (int i = 0; i < countNumbers; i++) {
//            double randomNumber = random.nextDouble(LIMIT);
//            randomNumbers.add(Decimal.getDecimal(2, randomNumber));
//        }
//
//        return randomNumbers;

//    }

    public static void main(String[] args) {
        ExerciseOne one = new ExerciseOne();
        one.randomNumbersEntered().forEach(System.out::println);
    }
}
