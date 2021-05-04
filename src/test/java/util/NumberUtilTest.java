package util;

import checker.ListChecker;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilTest {
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    public void makeRandomNumberList(int input) {
        List<Integer> randomList = NumberUtil.makeRandomNumberList(input, LOWER_BOUND, UPPER_BOUND);
        assertThat(randomList)
                .hasSize(input);
        ListChecker.checkListItemRange(randomList, LOWER_BOUND, UPPER_BOUND);
    }
}
