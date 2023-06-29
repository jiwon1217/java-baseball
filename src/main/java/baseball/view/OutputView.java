package baseball.view;

public class OutputView {

    public static final String INPUT_GUIDE = "숫자를 입력해주세요 : ";
    public static final String RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private OutputView() {

    }

    public static void printInputGuide() {
        System.out.print(INPUT_GUIDE);
    }

    public static void printExitMessage() {
        System.out.println(RESTART_OR_EXIT);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }
}
