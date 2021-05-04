package handler;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacintLogicHandlerTest {
    @ParameterizedTest
    @ValueSource(strings = {"failcar1,car1,failcar2,car3"})
    public void makeCarByInput_2success(String input) {
        RacingLogicHandler racingLogicHandler = new RacingLogicHandler();
        int result = racingLogicHandler.makeCarByInput(input);
        assertThat(result).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3"})
    public void makeCarByInput_3success(String input) {
        RacingLogicHandler racingLogicHandler = new RacingLogicHandler();
        int result = racingLogicHandler.makeCarByInput(input);
        assertThat(result).isEqualTo(3);
    }
}
