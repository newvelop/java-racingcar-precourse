package util;

import checker.ListChecker;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilTest {
    @RepeatedTest(10)
    @ValueSource(ints = {1, 2, 3})
    public void makeRandomNumberList(int size) {
        List<Integer> randomList = NumberUtil.makeRandomNumberList(size, 0, 9);
        assertThat(randomList)
                .hasSize(size);
        ListChecker.checkListItemRange(randomList, 0, 9);
    }
}
