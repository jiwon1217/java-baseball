package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    private static final int RANDOM_LOWER_INCLUSIVE = 1;
    private static final int RANDOM_UPPER_INCLUSIVE = 9;
    private static final int MAX_SIZE = 3;

    private NumberGenerator() {

    }

    public static List<Integer> generateRandomNumber() {
        List<Integer> numbers = new ArrayList<>();
        do {
            int number = Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
            addUniqueNumber(numbers, number);
        } while (numbers.size() < MAX_SIZE);
        return numbers;
    }

    private static void addUniqueNumber(final List<Integer> numbers, final int number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
