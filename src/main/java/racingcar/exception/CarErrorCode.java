package racingcar.exception;

import racingcar.core.exception.BaseErrorCode;

public enum CarErrorCode implements BaseErrorCode<IllegalArgumentException> {

    DELIMITER_ERROR("잘못된 구분자입니다. 구분자는 쉼표(,)만 가능합니다.");

    private final String message;

    CarErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public IllegalArgumentException toException() {
        return new IllegalArgumentException(this.message);
    }
}
