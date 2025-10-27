package service.validator;

import exception.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static void validateName (List<String> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NAME.getMessage());
        }
        for(String name : names) {
            if (name.isBlank()) {
                throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME.getMessage());
            }
            if (!isAlpha(name)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CHARACTER.getMessage());
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
            }
        }
    }

    private static boolean isAlpha (String name) {
        for (int i = 0; i < name.length(); i++) {
            if(!Character.isAlphabetic(name.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static int countValidator(String count) {
        if (count == null || count.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getMessage());
        }

        int countInt;
        try {
            countInt = Integer.parseInt(count);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getMessage());
        }

        if (countInt <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getMessage());
        }

        return countInt;
    }
}
