package baseball.controller;

import baseball.domain.Game;
import baseball.util.NumberGenerator;
import baseball.domain.constant.GameMessage;
import baseball.view.InputView;
import baseball.view.OutputView;

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
            OutputView.printExitMessage();
        } while (isRestart());
    }

    public boolean isRestart() {
        String number = InputView.inputRestartOrExit();
        return Objects.equals(number, GameMessage.RESTART_NUMBER.toString());
    }

    public void start() {
        List<Integer> randomNumbers = NumberGenerator.generateRandomNumber();
        do {
            OutputView.printInputGuide();
            result = game.calculateResult(convertToList(InputView.inputNumbers()), randomNumbers);
            OutputView.printResult(result);
        } while (!result.equals(game.getExitCondition()));
    }

    private List<Integer> convertToList(String numbers) {
        return Arrays.stream(numbers.split(""))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }
}
