package service;

import domain.Car;
import domain.Cars;
import service.util.NameParser;
import service.util.RandomNumberGenerator;
import service.validator.InputValidator;

import java.util.List;

public class RacingcarService {

    public Cars makeCars(String inputName, int count) {
        List<String> names = parseAndValidate(inputName, count);

        return new Cars(names); // cars 객체 생성
    }

    private List<String> parseAndValidate(String inputName, int count) {
        List<String> nameList = NameParser.nameParse(inputName);

        InputValidator.validateName(nameList);
        InputValidator.countValidator(count);

        return nameList; // 검증에서 에러 안 터지면 반환
    }

    public void startRace(List<Car> cars) {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.randomNumber());
        }
    }

    public String getWinner(Cars cars) {
        return cars.getWinner(cars.getCars());
    }
}
