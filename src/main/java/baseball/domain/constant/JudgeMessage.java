package baseball.domain.constant;

public enum JudgeMessage {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    NEW_LINE("\n"),
    BLANK(" ");

    private final String message;

    JudgeMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
