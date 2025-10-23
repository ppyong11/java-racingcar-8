package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest extends NsTest {

    @Test
    void 전진_테스트() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.move(5); // position = 1
        car2.move(3); // position = 0

        assertThat(car1.getPosition()).isEqualTo(1);
        assertThat(car2.getPosition()).isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
