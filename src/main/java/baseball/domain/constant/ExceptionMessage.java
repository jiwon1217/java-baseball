package baseball.domain.constant;

public enum ExceptionMessage {
    INVALID_INPUT_LENGTH("숫자를 3개 입력해야 합니다."),
    INVALID_INPUT_TYPE("숫자만 입력해야 합니다."),
    DUPLICATE_INPUT_NUMBER("중복된 수를 입력할 수 없습니다."),
    INVALID_EXIT_NUMBER("1 또는 2만 입력해야 합니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
