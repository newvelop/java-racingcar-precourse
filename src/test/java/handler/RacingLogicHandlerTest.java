package handler;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.NumberUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingLogicHandlerTest {
    private final int MINIMUM_TO_MOVE = 4;

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

    @ParameterizedTest
    @ValueSource(strings = {"car1"})
    public void moveCarByRandomNumTest(String input) {
        RacingLogicHandler racingLogicHandler = new RacingLogicHandler();
        racingLogicHandler.makeCarByInput(input);
        int randomNum = NumberUtil.makeRandomNumberList(1, 1, 9).get(0);
        int result = racingLogicHandler.moveCarByRandomNum(randomNum, input);

        if (randomNum < MINIMUM_TO_MOVE) {
            assertThat(randomNum < MINIMUM_TO_MOVE ? result == 0 : result == 1);
        }
    }
}
