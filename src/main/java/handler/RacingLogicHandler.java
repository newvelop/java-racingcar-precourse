package handler;

import collection.Cars;

public class RacingLogicHandler {
    private final Cars cars;

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
}
