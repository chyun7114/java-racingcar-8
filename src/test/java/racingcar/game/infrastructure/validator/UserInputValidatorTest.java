package racingcar.game.infrastructure.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.game.infrastructure.validator.UserInputValidator;

import static org.assertj.core.api.Assertions.*;

class UserInputValidatorTest {

    private final UserInputValidator userInputValidator = new UserInputValidator();

    @Test
    @DisplayName("자동차 이름이 5자가 넘은 경우 오류를 반환한다.")
    void fail_exceed_max_length() {

        // given
        String wrongCarName = "testcar";

        // when & then
        assertThatThrownBy(() -> userInputValidator.carNameLengthValidator(wrongCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자 이하로만 가능합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 공백인 경우 오류를 반환한다.")
    void fail_empty_car_name() {

        // given
        String emptyCarName = "";

        // when & then
        assertThatThrownBy(() -> userInputValidator.carNameEmptyValidator(emptyCarName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 공백일 수 없습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 음수인 경우 오류를 반환한다.")
    void fail_count_is_negative() {

        // given
        String negativeCount = "-1";

        // when & then
        assertThatThrownBy(() -> userInputValidator.tryCountValidator(negativeCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양수여야 합니다.");
    }

    @Test
    @DisplayName("시도 횟수를 숫자가 아닌 문자로 입력한 경우 오류를 반환한다.")
    void fail_count_is_letter() {

        // given
        String testCount = "abc";

        // when & then
        assertThatThrownBy(() -> userInputValidator.tryCountValidator(testCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자로 입력해야 합니다.");
    }
}