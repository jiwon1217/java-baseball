package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TextOutputTest {
    @Test
    void GAME_START_게임_시작_문구_출력() {
        assertThat(Game.GAME_START).isEqualTo("숫자 야구 게임을 시작합니다.");
    }
}
