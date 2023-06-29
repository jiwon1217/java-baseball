package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Judge;
import baseball.domain.constant.JudgeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrintResultTest {

    Judge judge;

    @BeforeEach
    void init() {
        judge = new Judge();
    }

    @ParameterizedTest
    @CsvSource("0, 0")
    void NOTHING_결과_출력(int strikeCount, int ballCount) {
        assertThat(judge.getResult(strikeCount, ballCount)).isEqualTo(
            JudgeMessage.NOTHING.toString());
    }

    @ParameterizedTest
    @CsvSource("3, 0")
    void _3_STRIKE_결과_출력(int strikeCount, int ballCount) {
        assertThat(judge.getResult(strikeCount, ballCount)).isEqualTo(
            strikeCount + JudgeMessage.STRIKE.toString() + JudgeMessage.NEW_LINE
                + JudgeMessage.GAME_OVER);
    }

    @ParameterizedTest
    @CsvSource({
        "2, 1",
        "1, 1",
        "1, 3",
    })
    void BALL_STRIKE_결과_출력(int strikeCount, int ballCount) {
        assertThat(judge.getResult(strikeCount, ballCount)).isEqualTo(
            ballCount + JudgeMessage.BALL.toString() + JudgeMessage.BLANK + strikeCount
                + JudgeMessage.STRIKE);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "0, 2",
        "0, 3",
    })
    void BALL만_있을_경우_결과_출력(int strikeCount, int ballCount) {
        assertThat(judge.getResult(strikeCount, ballCount)).isEqualTo(
            ballCount + JudgeMessage.BALL.toString());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 0",
        "2, 0",
    })
    void STRIKE만_있을_경우_결과_출력(int strikeCount, int ballCount) {
        assertThat(judge.getResult(strikeCount, ballCount)).isEqualTo(
            strikeCount + JudgeMessage.STRIKE.toString());
    }
}
