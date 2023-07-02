package baseball.view;

import baseball.domain.constant.InputMessage;

public class OutputView {
    public static void printInputGuide() {
        System.out.print(InputMessage.INPUT_GUIDE);
    }

    public static void printExitMessage() {
        System.out.println(InputMessage.RESTART_OR_EXIT);
    }

    public static void printResult(final String result) {
        System.out.println(result);
    }
}
