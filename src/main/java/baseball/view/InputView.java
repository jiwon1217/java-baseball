package baseball.view;

import static baseball.exception.InputException.isNotDuplicate;
import static baseball.exception.InputException.isValidExitNumber;
import static baseball.exception.InputException.isValidInputLength;
import static baseball.exception.InputException.isValidInputType;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {

    }

    public static String inputNumbers() {
        String inputNumbers = Console.readLine();
        isValidInputLength(inputNumbers);
        isValidInputType(inputNumbers);
        isNotDuplicate(inputNumbers);
        return inputNumbers;
    }

    public static String inputExitNumber() {
        String exitNumber = Console.readLine();
        isValidExitNumber(exitNumber);
        return exitNumber;
    }

}
