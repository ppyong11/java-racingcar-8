package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest extends NsTest {

    @Test
    void Cars_객체_생성_테스트() {
        List<String> list = List.of("pobi", "woni");

        Cars cars = new Cars(list);

        assertThat(cars.getCars()).hasSize(2);
    }

    @Test
    void 우승자_테스트() {
        List<String> list = List.of("pobi", "woni", "jun");
        Cars cars = new Cars(list);

        List<Car> carList = cars.getCars();

        for (int i = 0; i < 4; i++) {
            carList.get(0).move(5); // position = 4
            carList.get(1).move(3); // position = 0
            carList.get(2).move(4); // position = 4
        }

        assertThat(cars.getWinner(carList)).isEqualTo("pobi, jun");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
