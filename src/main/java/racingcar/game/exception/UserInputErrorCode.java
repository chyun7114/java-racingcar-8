package racingcar.game.exception;

import racingcar.core.exception.BaseErrorCode;

public enum UserInputErrorCode implements BaseErrorCode<IllegalArgumentException> {

    MAX_CAR_LENGTH_ERROR("자동차 이름은 5자 이하로만 가능합니다."),
    CAR_NAME_EMPTY_ERROR("자동차 이름은 공백일 수 없습니다."),
    COUNT_IS_NOT_NUMBER_ERROR("시도 횟수는 숫자로 입력해야 합니다."),
    COUNT_IS_NOT_POSITIVE_NUMBER_ERROR("시도 횟수는 양수여야 합니다.");

    private final String message;

    UserInputErrorCode(String message) {
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
