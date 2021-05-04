package collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.NumberUtil;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    static Stream<Arguments> successStringArrayProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"car1", "car2", "car3"})
        );
    }

    static Stream<Arguments> failStringArrayProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"failcar1", "car1", "failcar2", "car3"})
        );
    }

    @ParameterizedTest
    @MethodSource("successStringArrayProvider")
    public void makeCar_3success(String[] arr) {
        Cars cars = new Cars();
        for (String s : arr) {
            cars.addCar(s);
        }
        assertThat(cars.getSize()).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource("failStringArrayProvider")
    public void makeCar_2success(String[] arr) {
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
        }
        assertThat(expectedValue).isEqualTo(curIndex);
    }
}
