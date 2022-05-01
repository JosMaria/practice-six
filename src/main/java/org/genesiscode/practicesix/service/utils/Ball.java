package org.genesiscode.practicesix.service.utils;

public enum Ball {

    GREEN("verde", 0.10),
    RED("rojo", 0.40),
    YELLOW("amarrllo", 0.50);

    private final String name;
    private final double probability;

    Ball(String name, double value) {
        this.name = name;
        this.probability = value;
    }

    public String getName() {
        return name;
    }

    public double getProbability() {
        return probability;
    }
}
