import handler.RacingLogicHandler;
import handler.UILogicHandler;

public class RacingMain {
    public static void main(String[] args) {
        RacingLogicHandler racingLogicHandler = new RacingLogicHandler();
        startRacing(racingLogicHandler);
    }

    public static void startRacing(RacingLogicHandler racingLogicHandler) {
        String cars = UILogicHandler.getCars();
        racingLogicHandler.makeCarByInput(cars);
        String raceCount = UILogicHandler.getRaceCount();
        racingLogicHandler.updateRacingCount(raceCount);
        UILogicHandler.printStartRace();
        UILogicHandler.printWinner(racingLogicHandler.startGame());
    }
}
