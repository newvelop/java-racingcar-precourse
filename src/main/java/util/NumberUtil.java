package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberUtil {
    public static List<Integer> makeRandomNumberList(int size, int lowerBound, int upperBound) {
        List<Integer> randomNumList = new ArrayList<>();
        while (randomNumList.size() < size) {
            addRandomNumber(randomNumList, lowerBound, upperBound);
        }
        return randomNumList;
    }

    private static void addRandomNumber(List<Integer> randomNumList, int lowerBound, int upperBound) {
        Random random = new Random();
        int num = random.nextInt(upperBound - lowerBound) + lowerBound;
        randomNumList.add(num);
    }
}
