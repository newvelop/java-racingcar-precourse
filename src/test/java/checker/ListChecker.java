package checker;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListChecker {
    public static void checkListItemRange(List<Integer> list, int lowerBound, int upperBound) {
        for (int i : list) {
            assertThat(i).isBetween(lowerBound, upperBound);
        }
    }
}
