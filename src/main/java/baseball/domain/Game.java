package baseball.domain;

import baseball.domain.constant.GameMessage;
import java.util.List;
import java.util.Objects;

public class Game {

    public String calculateResult(final List<Integer> inputNumbers, final List<Integer> randomNumbers) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int index = 0; index < inputNumbers.size(); index++) {
            Integer number = inputNumbers.get(index);

            if (isStrike(number, randomNumbers, index)) {
                strikeCount++;
            } else if (isBall(number, randomNumbers)) {
                ballCount++;
            }
        }
        return printResult(strikeCount, ballCount);
    }

    public boolean isStrike(final Integer number, final List<Integer> randomNumbers, final int index) {
        return Objects.equals(number, randomNumbers.get(index));
    }

    public boolean isBall(final Integer number, final List<Integer> randomNumbers) {
        return randomNumbers.contains(number);
    }

    public String printResult(final int strikeCount, final int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return GameMessage.NOTHING.toString();
        }
        if (strikeCount == 3) {
            return strikeCount + GameMessage.STRIKE.toString() + GameMessage.NEW_LINE
                + GameMessage.GAME_OVER;
        }
        if (strikeCount == 0) {
            return ballCount + GameMessage.BALL.toString();
        }
        if (ballCount == 0) {
            return strikeCount + GameMessage.STRIKE.toString();
        }
        return ballCount + GameMessage.BALL.toString() + GameMessage.BLANK + strikeCount
            + GameMessage.STRIKE;
    }

    public String getExitCondition() {
        return 3 + GameMessage.STRIKE.toString() + GameMessage.NEW_LINE + GameMessage.GAME_OVER;
    }
}
