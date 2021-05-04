package collection;

import converter.CsvToStringArray;
import model.Car;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;
import util.NumberUtil;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @ParameterizedTest
    @ValueSource(strings = {"car1, car2, car3"})
    public void makeCar_3success(@ConvertWith(CsvToStringArray.class) String... arr) {
        Cars cars = new Cars();
        for (String s : arr) {
            cars.addCar(s);
        }
        assertThat(cars.getSize()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"failcar1, car1, failcar2, car3"})
    public void makeCar_2success(@ConvertWith(CsvToStringArray.class) String... arr) {
        Cars cars = new Cars();
        for (String s : arr) {
            cars.addCar(s);
        }
        assertThat(cars.getSize()).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1", "car2", "car3"})
    public void moveCarTest(String carName) {
        Cars cars = new Cars();
        cars.addCar(carName);
        List<Integer> randomNumberList = NumberUtil.makeRandomNumberList(5, 1, 9);
        int expectedValue = 0;
        int curIndex = 0;
        for (int i : randomNumberList) {
            curIndex = cars.moveCar(carName, i);
            expectedValue += i;
        }
        assertThat(expectedValue).isEqualTo(curIndex);
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1, car2, car3"})
    public void getCarByIndex(@ConvertWith(CsvToStringArray.class) String... arr) {
        Cars cars = new Cars();
        for (String s : arr) {
            cars.addCar(s);
        }
        Car car = cars.getCarByIndex(1);
        assertThat(car.getName()).isEqualTo("car2");
    }
}
