package baseball;

import static baseball.domain.constant.GameMessage.BALL;
import static baseball.domain.constant.GameMessage.BLANK;
import static baseball.domain.constant.GameMessage.GAME_OVER;
import static baseball.domain.constant.GameMessage.NEW_LINE;
import static baseball.domain.constant.GameMessage.NOTHING;
import static baseball.domain.constant.GameMessage.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrintResultTest {

    Game game;

    @BeforeEach
    void init() {
        game = new Game();
    }

    @ParameterizedTest
    @CsvSource("0, 0")
    void NOTHING_결과_출력(int strikeCount, int ballCount) {
        assertThat(game.printResult(strikeCount, ballCount)).isEqualTo(
            NOTHING.toString());
    }

    @ParameterizedTest
    @CsvSource("3, 0")
    void _3_STRIKE_결과_출력(int strikeCount, int ballCount) {
        assertThat(game.printResult(strikeCount, ballCount)).isEqualTo(
            strikeCount + STRIKE.toString() + NEW_LINE
                + GAME_OVER);
    }

    @ParameterizedTest
    @CsvSource({
        "2, 1",
        "1, 1",
        "1, 3",
    })
    void BALL_STRIKE_결과_출력(int strikeCount, int ballCount) {
        assertThat(game.printResult(strikeCount, ballCount)).isEqualTo(
            ballCount + BALL.toString() + BLANK + strikeCount
                + STRIKE);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "0, 2",
        "0, 3",
    })
    void BALL만_있을_경우_결과_출력(int strikeCount, int ballCount) {
        assertThat(game.printResult(strikeCount, ballCount)).isEqualTo(
            ballCount + BALL.toString());
    }

    @ParameterizedTest
    @CsvSource({
        "1, 0",
        "2, 0",
    })
    void STRIKE만_있을_경우_결과_출력(int strikeCount, int ballCount) {
        assertThat(game.printResult(strikeCount, ballCount)).isEqualTo(
            strikeCount + STRIKE.toString());
    }
}
