package handler;

import collection.Cars;
import util.NumberUtil;

import java.util.ArrayList;
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
        String[] arr = input.split("\\s*,\\s*");
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
        for (int i = 0; i < carSize; i++) {
            moveCarByRandomNum(randomNumList.get(i), cars.getCarNameByIndex(i));
            UILogicHandler.printCarCurIndex(cars.getCarNameByIndex(i), cars.getCarIndexByIndex(i));
        }
        UILogicHandler.printNewLine();
    }

    public List<String> startGame() {
        for (int i = 0; i < racingCount; i++) {
            moveAllCars();
        }
        return findWinner();
    }

    private List<String> findWinner() {
        List<String> result = new ArrayList<>();
        int maxIndex = Integer.MIN_VALUE;

        for (int i = 0; i < cars.getSize(); i++) {
            int targetIndex = cars.getCarIndexByIndex(i);
            result = getWinners(result, maxIndex, cars.getCarNameByIndex(i), targetIndex);
            maxIndex = maxIndex < targetIndex ? targetIndex : maxIndex;
        }
        return result;
    }

    private List<String> getWinners(List<String> result, int sourceIndex, String targetName, int targetIndex) {
        if (sourceIndex == Integer.MIN_VALUE) {
            result.add(targetName);
            return result;
        }
        return compareAndGetWinner(result, sourceIndex, targetName, targetIndex);
    }

    private List<String> compareAndGetWinner(List<String> result, int sourceIndex, String targetName, int targetIndex) {
        if (sourceIndex == targetIndex) {
            result.add(targetName);
            return result;
        }
        return returnBigger(result, sourceIndex, targetName, targetIndex);
    }

    private List<String> returnBigger(List<String> result, int sourceIndex, String targetName, int targetIndex) {
        if (sourceIndex > targetIndex) {
            return result;
        }

        ArrayList<String> newResult = new ArrayList<>();
        newResult.add(targetName);
        return newResult;
    }
}
