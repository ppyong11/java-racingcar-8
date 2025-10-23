package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import exception.ErrorMessage;
import org.junit.jupiter.api.Test;
import service.util.NameParser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameParserTest extends NsTest {
    @Test
    void 정상_파싱_테스트() {
        String input = "pobi,woni";

        List<String> result = NameParser.nameParse(input);

        assertThat(result).containsExactly("pobi", "woni");
    }

    @Test
    void 공백_포함_파싱_테스트() {
        String input = "pobi, woni, jun";

        List<String> result = NameParser.nameParse(input);

        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    void 빈_문자열_예외_테스트() {
        String input = "";

        assertThatThrownBy(() -> NameParser.nameParse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_NAME.getMessage());
    }

    @Test
    void null_예외_테스트() {
        String input = null;

        assertThatThrownBy(() -> NameParser.nameParse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_NAME.getMessage());
    }

    @Test
    void 이름_하나만_입력_테스트() {
        String input = "pobi";

        assertThatThrownBy(() -> NameParser.nameParse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNSUPPORTED_DELIMITER.getMessage());
    }

    @Test
    void 다른_구분자_입력_테스트() {
        String input = "pobi:woni";

        assertThatThrownBy(() -> NameParser.nameParse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.UNSUPPORTED_DELIMITER.getMessage());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
