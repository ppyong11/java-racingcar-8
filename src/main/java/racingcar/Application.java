package racingcar;

import controller.RacingcarContoller;
import service.RacingcarService;
import service.util.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingcarService racingcarService = new RacingcarService();
        RacingcarContoller racingcarContoller = new RacingcarContoller(racingcarService);

        racingcarContoller.run();
    }
}