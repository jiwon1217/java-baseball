package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {
    private static final int RANDOM_LOWER_INCLUSIVE = 1;
    private static final int RANDOM_UPPER_INCLUSIVE = 9;
    private static final int MAX_SIZE = 3;

    public static List<Integer> generateRandomNumber() {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < MAX_SIZE) {
            int number = Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
            numberSet.add(number);
        }
        return new ArrayList<>(numberSet);
    }
}