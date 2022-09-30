package org.genesiscode.practicesix.view.row.three;

public class RowResult {

    private int client;
    private double randomNumberOne;
    private int intervalArrival;
    private String timeArrival;
    private double randomNumberTwo;
    private int timeOfService;
    private String startService;
    private String endService;
    private int timeWait;
    private int timeLeisure;

    public RowResult(int client, double randomNumberOne, int intervalArrival, String timeArrival,
                     double randomNumberTwo, int timeOfService, String startService, String endService,
                     int timeWait, int timeLeisure) {
        this.client = client;
        this.randomNumberOne = randomNumberOne;
        this.intervalArrival = intervalArrival;
        this.timeArrival = timeArrival;
        this.randomNumberTwo = randomNumberTwo;
        this.timeOfService = timeOfService;
        this.startService = startService;
        this.endService = endService;
        this.timeWait = timeWait;
        this.timeLeisure = timeLeisure;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public double getRandomNumberOne() {
        return randomNumberOne;
    }

    public void setRandomNumberOne(double randomNumberOne) {
        this.randomNumberOne = randomNumberOne;
    }

    public int getIntervalArrival() {
        return intervalArrival;
    }

    public void setIntervalArrival(int intervalArrival) {
        this.intervalArrival = intervalArrival;
    }

    public String getTimeArrival() {
        return timeArrival;
    }

    public void setTimeArrival(String timeArrival) {
        this.timeArrival = timeArrival;
    }

    public double getRandomNumberTwo() {
        return randomNumberTwo;
    }

    public void setRandomNumberTwo(double randomNumberTwo) {
        this.randomNumberTwo = randomNumberTwo;
    }

    public int getTimeOfService() {
        return timeOfService;
    }

    public void setTimeOfService(int timeOfService) {
        this.timeOfService = timeOfService;
    }

    public String getStartService() {
        return startService;
    }

    public void setStartService(String startService) {
        this.startService = startService;
    }

    public String getEndService() {
        return endService;
    }

    public void setEndService(String endService) {
        this.endService = endService;
    }

    public int getTimeWait() {
        return timeWait;
    }

    public void setTimeWait(int timeWait) {
        this.timeWait = timeWait;
    }

    public int getTimeLeisure() {
        return timeLeisure;
    }

    public void setTimeLeisure(int timeLeisure) {
        this.timeLeisure = timeLeisure;
    }
}

