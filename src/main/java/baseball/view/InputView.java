package baseball.view;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputNumbers() {
        String numbers = Console.readLine();
        validateInputNumbers(numbers);
        return numbers;
    }

    private static void validateInputNumbers(String numbers) {
        InputException.isValidInputLength(numbers);
        InputException.isValidInputType(numbers);
        InputException.isDuplicate(numbers);
    }

    public static String inputRestartOrExit() {
        String number = Console.readLine();
        validateRestartOrExitNumber(number);
        return number;
    }

    private static void validateRestartOrExitNumber(String number) {
        InputException.isValidRestartOrExit(number);
    }
}
