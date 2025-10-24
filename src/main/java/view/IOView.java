package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Car;

import java.util.List;

public class IOView {

    public static String inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        return Console.readLine();
    }
    public static int inputCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static void outputResultTitle() {
        System.out.println("실행 결과");
    }

    public static void outputCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    public static void outputWinner(String winner){
        System.out.println("최종 우승자 : " + winner);
    }
}
