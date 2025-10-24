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

    public void startRace(List<Car> cars, int count) {
        for (int i = 0; i < count; i++) {
            cars.get(i).move(RandomNumberGenerator.randomNumber());
        }
    }

    private List<String> parseAndValidate(String inputName, int count) {
        List<String> nameList = NameParser.nameParse(inputName);

        InputValidator.validateName(nameList);
        InputValidator.countValidator(count);

        return nameList; // 검증에서 에러 안 터지면 반환
    }

}
