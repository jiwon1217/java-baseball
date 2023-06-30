package baseball.controller;

import static baseball.domain.constant.GameMessage.RESTART_NUMBER;
import static baseball.view.InputView.inputNumbers;
import static baseball.view.InputView.inputRestartOrExit;
import static baseball.view.OutputView.printExitMessage;
import static baseball.view.OutputView.printInputGuide;
import static baseball.view.OutputView.printResult;

import baseball.domain.Game;
import baseball.util.NumberGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameController {

    private final Game game;
    private String result;

    public GameController() {
        game = new Game();
        result = "";
    }

    public void init() {
        do {
            start();
            printExitMessage();
        } while (isRestart());
    }

    public boolean isRestart() {
        String number = inputRestartOrExit();
        return Objects.equals(number, RESTART_NUMBER.toString());
    }

    public void start() {
        List<Integer> randomNumbers = NumberGenerator.generateRandomNumber();
        do {
            printInputGuide();
            result = game.calculateResult(convertToList(inputNumbers()), randomNumbers);
            printResult(result);
        } while (!result.equals(game.getExitCondition()));
    }

    private List<Integer> convertToList(final String numbers) {
        return Arrays.stream(numbers.split(""))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }
}
