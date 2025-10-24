package racingcar.domain;

import java.math.BigInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("TestCar");
    }

    @Test
    @DisplayName("자동차 이름이 정상적으로 출력된다.")
    void success_get_car_name() {
        // when & then
        assertThat(car.getName()).isEqualTo("TestCar");
    }

    @Test
    @DisplayName("자동차는 한번에 1칸씩 앞으로 전진한다.")
    void success_car_move() {
        // given
        int expectedPosition = 1;

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}