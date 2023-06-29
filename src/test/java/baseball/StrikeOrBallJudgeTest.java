package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Judge;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StrikeOrBallJudgeTest {

    Judge judge;

    public static Stream<Arguments> getIsStrikeParameters() {
        return Stream.of(
            Arguments.of('1', Arrays.asList(1, 2, 3), 0),
            Arguments.of('2', Arrays.asList(1, 2, 3), 1),
            Arguments.of('3', Arrays.asList(1, 2, 3), 2)
        );
    }

    public static Stream<Arguments> getIsBallParameters() {
        return Stream.of(
            Arguments.of('1', Arrays.asList(2, 3, 1)),
            Arguments.of('2', Arrays.asList(2, 3, 1)),
            Arguments.of('3', Arrays.asList(2, 3, 1))
        );
    }

    @BeforeEach
    void init() {
        judge = new Judge();
    }

    @ParameterizedTest
    @MethodSource("getIsStrikeParameters")
    void isStrike_스트라이크인지_판단(char number, List<Integer> randomNumbers, int index) {
        assertThat(judge.isStrike(number, randomNumbers, index)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("getIsBallParameters")
    void isBall_볼인지_판단(char number, List<Integer> randomNumbers) {
        assertThat(judge.isBall(number, randomNumbers)).isTrue();
    }
}
