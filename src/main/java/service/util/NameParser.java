package service.util;

import exception.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class NameParser {
    public static List<String> nameParse(String inputNames) {
        if (inputNames == null || inputNames.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME.getMessage());
        }

        if (!inputNames.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.UNSUPPORTED_DELIMITER.getMessage());
        }

        return Arrays.stream(inputNames.split(","))
                .map(String::trim) // 공백 제거
                .toList();
    }
}
