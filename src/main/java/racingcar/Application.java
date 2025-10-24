package racingcar;

import controller.RacingcarContoller;
import service.RacingcarService;
import view.IOView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingcarService racingcarService = new RacingcarService();
        RacingcarContoller racingcarContoller = new RacingcarContoller(racingcarService);

        try {
            racingcarContoller.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException(e);
        } finally {
            IOView.close();
        }

    }
}