package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.util.NumberGenerator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGenerateTest {

    int maxSize = 3;
    int minRange = 1;
    int maxRange = 9;

    @RepeatedTest(10)
    void generateRandomNumber_숫자_3개_생성() {
        List<Integer> randomNumbers = NumberGenerator.generateRandomNumber();
        assertThat(randomNumbers).hasSize(maxSize);
    }

    @RepeatedTest(10)
    void pickNumberInRange_범위에_포함되는_숫자만_랜덤_생성() {
        int number = Randoms.pickNumberInRange(minRange, maxRange);
        assertThat(number)
            .isGreaterThanOrEqualTo(minRange)
            .isLessThanOrEqualTo(maxRange);
    }

    @RepeatedTest(10)
    void generateRandomNumber_중복되지_않은_숫자_생성() {
        List<Integer> randomNumbers = NumberGenerator.generateRandomNumber();
        assertThat(randomNumbers).doesNotHaveDuplicates();
    }
}
