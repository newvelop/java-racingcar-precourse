package handler;

import enums.UIMessage;

import java.util.List;
import java.util.Scanner;

public class UILogicHandler {
    private static final String RESULT_SEPARATOR = ":";
    private static final String INDEX_DISPLAY = "-";
    private static final String WINNER_SEPARATOR = ",";

    public static String getCars() {
        printInputMessage(UIMessage.GET_CARS);

        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static void printInputMessage(UIMessage uiMessage) {
        System.out.println(uiMessage.getMessage());
    }

    public static String getRaceCount() {
        printInputMessage(UIMessage.GET_COUNT);

        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void printStartRace() {
        printInputMessage(UIMessage.START_RACE);
    }

    public static void printWinner(List<String> winners) {
        System.out.println(String.join(WINNER_SEPARATOR, winners) + UIMessage.PRINT_WINNER.getMessage());
    }

    public static void printCarCurIndex(String carName, int curIndex) {
        StringBuffer sb = new StringBuffer();
        sb.append(carName)
                .append(RESULT_SEPARATOR);
        for (int i = 0; i < curIndex; i++) {
            sb.append(INDEX_DISPLAY);
        }
        System.out.println(sb.toString());
    }

    public static void printNewLine() {
        System.out.println();
    }
}
