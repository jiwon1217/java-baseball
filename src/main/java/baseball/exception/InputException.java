package baseball.exception;

import static baseball.domain.constant.ExceptionMessage.DUPLICATE_INPUT_NUMBER;
import static baseball.domain.constant.ExceptionMessage.INVALID_EXIT_NUMBER;
import static baseball.domain.constant.ExceptionMessage.INVALID_INPUT_LENGTH;
import static baseball.domain.constant.ExceptionMessage.INVALID_INPUT_TYPE;
import static baseball.domain.constant.GameMessage.EXIT_NUMBER;
import static baseball.domain.constant.GameMessage.RESTART_NUMBER;

import java.util.Objects;

public class InputException extends Exception {

    public static final Integer MAX_LENGTH = 3;

    public static void isValidInputLength(final String numbers) {
        if (numbers.length() != MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_INPUT_LENGTH.toString());
        }
    }

    public static void isValidInputType(final String numbers) {
        try {
            Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE.toString());
        }
    }

    public static void isDuplicate(final String numbers) {
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_NUMBER.toString());
        }
    }

    private static boolean hasDuplicateNumber(final String numbers) {
        return numbers.charAt(0) == numbers.charAt(1)
            || numbers.charAt(1) == numbers.charAt(2)
            || numbers.charAt(0) == numbers.charAt(2);
    }

    public static void isValidExitNumber(final String numbers) {
        if (!Objects.equals(numbers, RESTART_NUMBER.toString()) && !Objects.equals(numbers, EXIT_NUMBER.toString())) {
            throw new IllegalArgumentException(INVALID_EXIT_NUMBER.toString());
        }
    }
}
