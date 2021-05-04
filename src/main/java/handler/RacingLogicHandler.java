package handler;

import collection.Cars;
import util.NumberUtil;

import java.util.List;

public class RacingLogicHandler {
    private final Cars cars;
    private final int MINIMUM_TO_MOVE = 4;
    private final int LOWER_BOUND = 0;
    private final int UPPER_BOUND = 9;
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

    public void moveAllCars() {
        int carSize = cars.getSize();
        List<Integer> randomNumList = NumberUtil.makeRandomNumberList(carSize, LOWER_BOUND, UPPER_BOUND);
        for (int i = 0 ; i < cars.getSize(); i++) {
            moveCarByRandomNum(randomNumList.get(i), cars.getCarNameByIndex(i));
        }
    }
}
