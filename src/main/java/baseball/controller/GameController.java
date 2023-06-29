package baseball.controller;

import static baseball.view.InputView.inputExitNumber;
import static baseball.view.InputView.inputNumbers;
import static baseball.view.OutputView.printExitMessage;
import static baseball.view.OutputView.printInputGuide;
import static baseball.view.OutputView.printResult;

import baseball.domain.Judge;
import baseball.util.NumberGenerator;
import java.util.List;
import java.util.Objects;

public class GameController {

    Judge judge;
    String result;

    public GameController() {
        judge = new Judge();
        result = "";
    }

    public void init() {
        do {
            start();
            printExitMessage();
        } while (isExit());
    }

    public boolean isExit() {
        String exitNumber = inputExitNumber();
        return Objects.equals(exitNumber, "1");
    }

    public void start() {
        List<Integer> randomNumbers = NumberGenerator.generateRandomNumber();
        do {
            printInputGuide();
            result = judge.judgeGameResult(inputNumbers(), randomNumbers);
            printResult(result);
        } while (!result.equals(judge.getExitCondition()));
    }
}
