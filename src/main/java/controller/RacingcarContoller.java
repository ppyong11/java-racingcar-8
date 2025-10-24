package controller;

import domain.Cars;
import service.RacingcarService;
import view.IOView;

public class RacingcarContoller {
    private final RacingcarService racingcarService;

    public RacingcarContoller(RacingcarService service) {
        this.racingcarService = service;
    }

    public void run() {
        String inputNames = IOView.inputNames();
        String inputCount = IOView.inputCount();

        // Car 객체 모아둔 Cars 객체 생성
        Cars cars= racingcarService.makeCars(inputNames.trim());

        int count = racingcarService.stringToIntCount(inputCount.trim());

        IOView.outputResultTitle();

        for (int i = 0; i < count; i++) {
            racingcarService.startRace(cars.getCars());
            IOView.outputCars(cars.getCars());
        }

        IOView.outputWinner(racingcarService.getWinner(cars));
    }
}
