package racingcar.game.view;

import racingcar.car.domain.Car;
import racingcar.car.domain.Cars;

public class OutputView {

    public void printProcessOutput(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }
}
