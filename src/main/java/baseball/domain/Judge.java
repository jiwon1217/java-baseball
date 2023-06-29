package baseball.domain;

import static baseball.domain.constant.JudgeMessage.BALL;
import static baseball.domain.constant.JudgeMessage.BLANK;
import static baseball.domain.constant.JudgeMessage.STRIKE;

import baseball.domain.constant.JudgeMessage;
import java.util.List;

public class Judge {

    public String judgeGameResult(String inputNumbers, List<Integer> randomNumbers) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int index = 0; index < inputNumbers.length(); index++) {
            char number = inputNumbers.charAt(index);

            if (isStrike(number, randomNumbers, index)) {
                strikeCount++;
            } else if (isBall(number, randomNumbers)) {
                ballCount++;
            }
        }
        return getResult(strikeCount, ballCount);
    }

    public boolean isStrike(char number, List<Integer> randomNumbers, int index) {
        return Character.getNumericValue(number) == randomNumbers.get(index);
    }

    public boolean isBall(char number, List<Integer> randomNumbers) {
        return randomNumbers.contains(Character.getNumericValue(number));
    }

    public String getResult(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            return JudgeMessage.NOTHING.toString();
        } else if (strikeCount == 3) {
            return strikeCount + STRIKE.toString() + JudgeMessage.NEW_LINE
                + JudgeMessage.GAME_OVER;
        } else if (strikeCount == 0) {
            return ballCount + BALL.toString();
        } else if (ballCount == 0) {
            return strikeCount + STRIKE.toString();
        }
        return ballCount + BALL.toString() + BLANK + strikeCount + STRIKE;
    }

    public String getExitCondition() {
        return 3 + STRIKE.toString() + JudgeMessage.NEW_LINE + JudgeMessage.GAME_OVER;
    }
}
