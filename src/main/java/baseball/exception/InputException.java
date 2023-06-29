package baseball.exception;

import java.util.Objects;

public class InputException extends Exception {

    public static final String INVALID_INPUT_LENGTH = "숫자를 3개 입력해야 합니다.";
    public static final String INVALID_INPUT_TYPE = "숫자만 입력해야 합니다.";
    public static final String DUPLICATE_INPUT_NUMBER = "중복된 수를 입력할 수 없습니다.";
    public static final String INVALID_EXIT_NUMBER = "1 또는 2만 입력해야 합니다.";

    public static void isValidInputLength(String numbers) {
        if (numbers == null || numbers.length() != 3) {
            throw new IllegalArgumentException(INVALID_INPUT_LENGTH);
        }
    }

    public static void isValidInputType(String numbers) {
        try {
            Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE);
        }
    }

    public static void isNotDuplicate(String numbers) {
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_NUMBER);
        }
    }

    private static boolean hasDuplicateNumber(String numbers) {
        return numbers.charAt(0) == numbers.charAt(1) || numbers.charAt(1) == numbers.charAt(2)
            || numbers.charAt(0) == numbers.charAt(2);
    }

    public static void isValidExitNumber(String numbers) {
        if (!Objects.equals(numbers, "1") && !Objects.equals(numbers, "2")) {
            throw new IllegalArgumentException(INVALID_EXIT_NUMBER);
        }
    }
}
