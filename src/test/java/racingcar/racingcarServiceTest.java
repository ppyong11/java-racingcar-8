package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.Car;
import domain.Cars;
import exception.ErrorMessage;
import org.junit.jupiter.api.Test;
import service.RacingcarService;
import service.util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class racingcarServiceTest extends NsTest {
    private final RacingcarService service = new RacingcarService();

    @Test
    void 객체_생성_테스트() {
        String names= "pobi,jun";
        int count = 1;

        Cars cars = service.makeCars(names, count);
        assertThat(cars.getCars().size()).isEqualTo(2);
    }

    @Test
    void 객체_생성_예외_테스트() {
        String names= "pobi,jun";
        int count = 0;

        assertThatThrownBy(() -> service.makeCars(names, count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_COUNT.getMessage());
    }

    @Test
    void 자동차_전진_테스트() {
        List<Car> cars = Stream.of("pobi", "jun") //Stream 객체 생성
                        .map(Car::new)
                        .toList();

        assertThatNoException()
                .isThrownBy(() -> {
                    for (int i = 0; i < 50; i++) {
                        service.startRace(cars);
                    }
                });
    }

    @Test
    void 서비스_전체_흐름_테스트() {
        Cars cars = service.makeCars("pobi, woni, jun", 5);

        service.startRace(cars.getCars());

        assertThatNoException()
                .isThrownBy(() -> cars.getWinner(cars.getCars()));

        String winner = cars.getWinner(cars.getCars());
        // position이 모두 0이면 공동 우승 -> 빌 일이 없음
        assertThat(winner).containsAnyOf("pobi", "woni", "jun");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
