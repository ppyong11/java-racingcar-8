package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import exception.ErrorMessage;
import org.junit.jupiter.api.Test;
import service.util.NameParser;
import service.validator.InputValidator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest extends NsTest {
    @Test
    void 정상_검증_테스트() {
        String input = "pobi, woni";

        List<String> nameList = NameParser.nameParse(input);

        assertThatNoException()
                .isThrownBy(() -> InputValidator.validateName(nameList));
    }

    @Test
    void 알파벳_외_문자_예외_테스트() {
        String input = "pob1, wo_ni";

        List<String> nameList = NameParser.nameParse(input);

        assertThatThrownBy(() -> InputValidator.validateName(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CHARACTER.getMessage());
    }

    @Test
    void 공백_문자열_예외_테스트() {
        String input = "woni, ,jun";

        List<String> nameList = NameParser.nameParse(input);

        assertThatThrownBy(() -> InputValidator.validateName(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_NAME.getMessage());
    }

    @Test
    void 이름_길이_5자_초과_예외_테스트() {
        String input = "sandra, woni";

        List<String> nameList = NameParser.nameParse(input);

        assertThatThrownBy(() -> InputValidator.validateName(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
    }

    @Test
    void 중복_이름_예외_테스트() {
        String input = "pobi,pobi";

        List<String> nameList = NameParser.nameParse(input);

        assertThatThrownBy(() -> InputValidator.validateName(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_NAME.getMessage());
    }

    @Test
    void 정상_시도_횟수_테스트() {
        assertThatNoException()
                .isThrownBy(() -> InputValidator.countValidator(5));
    }

    @Test
    void 음수_시도_횟수_예외_테스트() {
        assertThatThrownBy(() -> InputValidator.countValidator(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_COUNT.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
