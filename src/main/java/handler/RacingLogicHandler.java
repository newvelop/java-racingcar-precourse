package handler;

import collection.Cars;

public class RacingLogicHandler {
    private final Cars cars;
    private final int MINIMUM_TO_MOVE = 4;
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

    public int moveCarByRandomNum(int randomNum, String carName) {
        if (randomNum >= MINIMUM_TO_MOVE) {
            return cars.moveCar(carName, 1);
        }
        return 0;
    }
}
