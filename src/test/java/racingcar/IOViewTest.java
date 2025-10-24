package racingcar;


import camp.nextstep.edu.missionutils.test.NsTest;
import domain.Cars;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.IOView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class IOViewTest extends NsTest {
    // 실제 출력을 가로채서 내용을 메모리에 저장
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() { // 테스트 시작 전
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() { // 테스트 종료 후
        System.setOut(originalOut);
    }

    @Test
    void 전진_출력_테스트() {
        List<String> list = List.of("pobi", "woni");
        Cars cars = new Cars(list);
        cars.getCars().get(0).move(4);
        cars.getCars().get(1).move(3);

        IOView.outputCars(cars.getCars());

        String result = outputStream.toString();
        String[] lines = result.split(System.lineSeparator());

        assertThat(lines[0]).isEqualTo("pobi : -");
        assertThat(lines[1]).isEqualTo("woni : ");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
