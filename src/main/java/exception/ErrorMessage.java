package exception;

public enum ErrorMessage {
    UNSUPPORTED_DELIMITER("구분자는 쉼표(,)여야 합니다."),
    DUPLICATED_NAME("자동차 이름은 중복될 수 없습니다."),
    INVALID_NAME_LENGTH("자동차 이름이 5자 이하여야 합니다."),
    EMPTY_NAME("자동차 이름은 비어 있을 수 없습니다."),
    INVALID_CHARACTER("자동차 이름은 알파벳만 입력해야 합니다."),
    INVALID_COUNT("시도 횟수는 1 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
