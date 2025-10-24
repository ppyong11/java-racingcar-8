package service;

import domain.Car;
import domain.Cars;
import service.util.NameParser;
import service.util.RandomNumberGenerator;
import service.validator.InputValidator;

import java.util.List;

public class RacingcarService {

    public Cars makeCars(String inputName) {
        List<String> names = parseAndValidate(inputName);

        return new Cars(names); // cars 객체 생성
    }

    public int stringToIntCount(String count) {
        return InputValidator.countValidator(count);
    }

    private List<String> parseAndValidate(String inputName) {
        List<String> nameList = NameParser.nameParse(inputName);

        InputValidator.validateName(nameList);

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
