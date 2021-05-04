package handler;

import collection.Cars;

public class RacingLogicHandler {
    private final Cars cars;
    private int racingCount;

    public RacingLogicHandler() {
        cars = new Cars();
    }

    public int makeCarByInput(String input) {
        String[] arr = input.split(",");
        for (String s : arr) {
            cars.addCar(s);
        }
        return cars.getSize();
    }

    public boolean updateRacingCount(String countStr) {
        try {
            racingCount = Integer.parseInt(countStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
