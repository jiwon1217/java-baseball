package baseball;

import static baseball.domain.constant.ExceptionMessage.DUPLICATE_INPUT_NUMBER;
import static baseball.domain.constant.ExceptionMessage.INVALID_INPUT_LENGTH;
import static baseball.domain.constant.ExceptionMessage.INVALID_INPUT_TYPE;
import static baseball.exception.InputException.isDuplicate;
import static baseball.exception.InputException.isValidInputLength;
import static baseball.exception.InputException.isValidInputType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputNumberValidateTest {

    @ParameterizedTest
    @ValueSource(strings = {" ", "1", "12", "1234"})
    void INVALID_INPUT_LENGTH_숫자를_3개만_입력(String input) {
        assertThatThrownBy(() -> isValidInputLength(input))
            .hasMessage(INVALID_INPUT_LENGTH.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "숫자만"})
    void INVALID_INPUT_TYPE_숫자만_입력(String input) {
        assertThatThrownBy(() -> isValidInputType(input))
            .hasMessage(INVALID_INPUT_TYPE.toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "222", "333"})
    void DUPLICATE_INPUT_NUMBER_중복된_수를_입력_할_수_없음(String input) {
        assertThatThrownBy(() -> isDuplicate(input))
            .hasMessage(DUPLICATE_INPUT_NUMBER.toString());
    }
}
