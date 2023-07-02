package baseball.view;

import static baseball.exception.InputException.isDuplicate;
import static baseball.exception.InputException.isValidRestartOrExit;
import static baseball.exception.InputException.isValidInputLength;
import static baseball.exception.InputException.isValidInputType;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputNumbers() {
        String numbers = Console.readLine();
        isValidInputLength(numbers);
        isValidInputType(numbers);
        isDuplicate(numbers);
        return numbers;
    }

    public static String inputRestartOrExit() {
        String number = Console.readLine();
        isValidRestartOrExit(number);
        return number;
    }
}
