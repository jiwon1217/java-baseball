package baseball.exception;

import baseball.domain.constant.ExceptionMessage;
import baseball.domain.constant.GameMessage;

import java.util.Objects;

public class InputException extends Exception {
    private static final int MAX_LENGTH = 3;

    public static void isValidInputLength(String numbers) {
        if (numbers.length() != MAX_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_LENGTH.toString());
        }
    }

    public static void isValidInputType(String numbers) {
        try {
            Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_TYPE.toString());
        }
    }

    public static void isDuplicate(String numbers) {
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_INPUT_NUMBER.toString());
        }
    }

    private static boolean hasDuplicateNumber(String numbers) {
        return numbers.charAt(0) == numbers.charAt(1)
            || numbers.charAt(1) == numbers.charAt(2)
            || numbers.charAt(0) == numbers.charAt(2);
    }

    public static void isValidRestartOrExit(String numbers) {
        if (!isRestartOrExitNumber(numbers)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_EXIT_NUMBER.toString());
        }
    }

    private static boolean isRestartOrExitNumber(String number) {
        return Objects.equals(number, GameMessage.RESTART_NUMBER.toString())
            || Objects.equals(number, GameMessage.EXIT_NUMBER.toString());
    }
}
