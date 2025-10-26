package racingcar.game.infrastructure.validator;

import racingcar.game.exception.UserInputErrorCode;

public class UserInputValidator {

    private static final int MAX_CAR_LENGTH = 5;

    public void carNameLengthValidator(String carName) {
        if (carName.length() > MAX_CAR_LENGTH) {
            throw UserInputErrorCode.MAX_CAR_LENGTH_ERROR.toException();
        }
    }

    public void carNameEmptyValidator(String carName) {
        if (carName.trim().isEmpty()) {
            throw UserInputErrorCode.CAR_NAME_EMPTY_ERROR.toException();
        }
    }

    public void tryCountValidator(String tryCount) {
        try {
            int count = Integer.parseInt(tryCount);
            if (count <= 0) {
                throw UserInputErrorCode.COUNT_IS_NOT_POSITIVE_NUMBER_ERROR.toException();
            }
        } catch (NumberFormatException e) {
            throw UserInputErrorCode.COUNT_IS_NOT_NUMBER_ERROR.toException();
        }
    }
}
