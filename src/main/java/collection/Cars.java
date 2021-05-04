package collection;

import enums.ErrorCode;
import model.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int SUCCESS = 0;

    private List<Car> carList;

    public int addCar(String name) {
        int validateResult = validateCarName(name);

        if (validateResult == SUCCESS) {
            addCarInList(name);
        }

        return validateResult;
    }

    private int validateCarName(String name) {
        if (name.length() > CAR_NAME_MAX_LENGTH) {
            return ErrorCode.CAR_NAME_LENGTH_OVER.getCode();
        }
        return SUCCESS;
    }

    private void addCarInList(String name) {
        if (carList == null) {
            carList = new ArrayList<>();
        }

        Car car = new Car(name);

        carList.add(car);
    }

    public int getSize() {
        if (carList == null) {
            return 0;
        }
        return carList.size();
    }

    public int moveCar(String carName, int offSet) {
        Car car = findByCarName(carName);
        car.setCurIndex(car.getCurIndex() + offSet);
        return car.getCurIndex();
    }

    public Car findByCarName(String name) {
        Car result = null;
        for (Car car : carList) {
            result = compareCarName(result, car, name);
        }
        return result;
    }

    private Car compareCarName(Car result, Car source, String target) {
        if (result != null) {
            return result;
        }
        if (source.getName().equals(target)) {
            return source;
        }
        return null;
    }
}
